package com.xconst.vavatar.hook;

import static java.lang.String.format;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import dalvik.system.BaseDexClassLoader;
import dalvik.system.PathClassLoader;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookEntry implements IXposedHookLoadPackage {

    public static final String TAG = "vavatar";

    final static String packageName2 = "com.tencent.mm";


    static String version = null;


    final static String modelAvatarU0Classname = "modelAvatarU0Classname";      // f执行时候参数类型_运行时候
    final static String l70k1Classname = "l70k1Classname";     //f的调用者类型
    final static String modelBaseK1Classname = "modelBaseK1Classname";     //f方法的参数类型_多态

    final static Map<String, Map<String, String>> SETTING_SET = new HashMap<String, Map<String, String>>() {{
        put("2580", new HashMap<String, String>() {{
            put(modelAvatarU0Classname, "com.tencent.mm.modelavatar.u0");  //8.0.48
            put(l70k1Classname, "l70.k1");
            put(modelBaseK1Classname, "com.tencent.mm.modelbase.k1");
        }});
        put("2701", new HashMap<String, String>() {{    //8.0.50
            put(modelAvatarU0Classname, "com.tencent.mm.modelavatar.r");
            put(l70k1Classname, "v50.z");
            put(modelBaseK1Classname, "hd0.y");
        }});
    }};

    static Map<String, String> SETTING;


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

            Set<String> strings = SETTING_SET.keySet();
            for (String string : strings) {
                if (version.contains(string)) {
                    SETTING = SETTING_SET.get(string);
                    XposedBridge.log(TAG + SETTING);
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


        String classname = "v50.z";

        Class<?> classIfExists = XposedHelpers.findClassIfExists(classname, loadPackageParam.classLoader);

        XposedBridge.log(TAG+classIfExists);


        if (true) {
            return;
        }
        if (loadPackageParam.packageName.

                equals(packageName2)) {


            boolean isGotSetting = initSetting(loadPackageParam);


            if (!isGotSetting) {
                return;
            }


//            Hookers1.test(loadPackageParam);
//            Hookers1.hookLog(loadPackageParam);

//            Hookers1.hookProfileHdHeadImg(loadPackageParam);
//            Hookers1.hookProfileHdHeadImg(loadPackageParam);
//            Hookers1.hookFinderCropAvatarUI(loadPackageParam);
//            Hookers1.hookPlatformToolsL2(loadPackageParam);
//            Hookers1.hookModelAvatarU0(loadPackageParam);
//            Hookers1.hookModelbaseI2(loadPackageParam);

//            Hookers1.hookPreviewLastHdHeadImg(loadPackageParam);
//            Hookers1.hookS6(loadPackageParam);
//            Hookers1.hookYa2B(loadPackageParam);


//            Hookers1.hookPreviewHdHeadImg(loadPackageParam);

//            Hookers1.hookY(loadPackageParam);
//            Hookers1.hookModelAvatarV0(loadPackageParam);
//            Hookers1.hookPreviewHdHeadImgM6(loadPackageParam);
//            Hookers1.hookAllM6Relevant(loadPackageParam);
//            Hookers1.hookModelAvatarV0B(loadPackageParam);      // B方法是关键的

//            Hookers1.hookL70K1(loadPackageParam);
//            Hookers1.hookModelAvatarU0(loadPackageParam);


//            Hookers1.hookGetHdHeadImageGalleryView(loadPackageParam);

//            Hookers1.hookSetting(loadPackageParam);/// 可用
//            Hookers1.hookOnclick(loadPackageParam);/// 可用
//            Hookers1.hookSetText(loadPackageParam);/// 可用


//            Hookers1.avatarHook(loadPackageParam);/// 可用

//            Hookers1.hookAttach(loadPackageParam);


            Hookers1.

                    hookToInsertMySettingUI(loadPackageParam);

            Hookers1.

                    hookOnResume(loadPackageParam);            // 触发器


//            Hookers1.hookSettingCompatitive(loadPackageParam);


        }


    }

}