package com.xconst.vavatar.hook;

import static java.lang.String.format;


import com.xconst.vavatar.data.Configuration;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookEntry implements IXposedHookLoadPackage {

    public static final String TAG = "vvavatar";

    final static String packageName2 = "com.tencent.mm";


    static String version = null;




    public static boolean initSetting(XC_LoadPackage.LoadPackageParam lpparam) {
        if (version != null) {
            return true;
        }
        try {
            Class<?> parserCls = XposedHelpers.findClass("android.content.pm.PackageParser", lpparam.classLoader);
            Object parser = parserCls.newInstance();
            File apkPath = new File(lpparam.appInfo.sourceDir);
            Object pkg = XposedHelpers.callMethod(parser, "parsePackage", apkPath, 0);
            String versionName = (String) XposedHelpers.getObjectField(pkg, "mVersionName");
            int versionCode = XposedHelpers.getIntField(pkg, "mVersionCode");
            version = String.format("%s (%d)", versionName, versionCode);
            XposedBridge.log(TAG + "mm版本号" + version);

            Set<String> strings = Configuration.SETTING_SET.keySet();
            for (String string : strings) {
                if (version.contains(string)) {
                    Configuration.SETTING = Configuration.SETTING_SET.get(string);
                    XposedBridge.log(TAG + "查找到已此版本的配置" + version);

                    return true;

                }
            }


        } catch (Throwable e) {
            XposedBridge.log(TAG + "无法获取mm版本号");
        }
        return false;
    }

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {


        if (loadPackageParam.packageName.

                equals(packageName2)) {


            boolean isGotSetting = initSetting(loadPackageParam);

            if (!isGotSetting) {
                XposedBridge.log(TAG+"未适配此版本");
                return;
            }


            Hookers1.hookToInsertMySettingUI(loadPackageParam);

            Hookers1.hookOnResume(loadPackageParam);            // 触发器




        }


    }

}