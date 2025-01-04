package com.xconst.vavatar.hook;

import static com.xconst.vavatar.utils.FileUtil.getTargetPath;
import static java.lang.System.exit;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.xconst.vavatar.R;
import com.xconst.vavatar.data.Configuration;
import com.xconst.vavatar.data.Mp;
import com.xconst.vavatar.ui.Vui;
import com.xconst.vavatar.utils.FileDownloader;
import com.xconst.vavatar.utils.FileUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Hookers1 {

    static String Tag = HookEntry.TAG;


    public static void hookLog(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        String logClassname = "com.tencent.mm.sdk.platformtools.l2";
        String logClassname1 = "com.tencent.mm.sdk.platformtools.q2";
        String xlogClassname = "com.tencent.mars.xlog.Xlog";
        Class<?> xlogClass = XposedHelpers.findClass(xlogClassname, loadPackageParam.classLoader);
        XposedBridge.log(Tag + xlogClass + "fghn");

        XposedHelpers.findAndHookMethod(Application.class, "attach", Context.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        Context context = (Context) param.args[0];
                        ClassLoader classLoader = context.getClassLoader();// java.lang.BootClassLoader

                        Class<?> classIfExists = XposedHelpers.findClassIfExists(logClassname, classLoader);
//                        XposedBridge.log(tag + classIfExists + "fghn");

                        Class<?> clazz = XposedHelpers.findClassIfExists(logClassname1, classLoader);
//                        XposedBridge.log(tag + clazz + "qqqws");

                        for (Method declaredMethod : clazz.getDeclaredMethods()) {
                            XposedBridge.log(Tag + declaredMethod + "qqqws");

                        }
// long,java.lang.String,java.lang.String,java.lang.String,int,int,long,long,java.lang.String

                        XposedHelpers.findAndHookMethod(clazz, "a", int.class, long.class, String.class, String.class, String.class, int.class, int.class, long.class, long.class, String.class,

//                                XposedHelpers.findAndHookMethod(clazz, "logW", long.class, String.class, String.class, String.class, int.class, int.class, long.class, long.class, String.class,

                                new XC_MethodHook() {
                                    @Override
                                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                        super.beforeHookedMethod(param);
                                        StringBuilder stringBuilder = new StringBuilder();
                                        for (Object arg : param.args) {
                                            stringBuilder.append(arg);
                                        }
                                        XposedBridge.log(Tag + stringBuilder.toString() + "catch!!!!!");

                                    }
                                });

                    }
                });

    }

    public static void hookPlatformToolsL2(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        final String logPlatformName = "com.tencent.mm.sdk.platformtools.l2";

        ClassLoader classLoader = loadPackageParam.classLoader;
        String tag = " hookPlatformToolsL2 ";
        XposedBridge.log(tag + " try to hook");

        Class<?> clazz = XposedHelpers.findClassIfExists(logPlatformName, classLoader);

        XposedBridge.hookAllMethods(clazz, "j", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                StringBuilder stringBuilder = new StringBuilder();
                for (Object arg : param.args) {
                    stringBuilder.append(arg);
                    stringBuilder.append(" ");
                }
                XposedBridge.log(tag + stringBuilder.toString() + "params");

            }
        });

    }

    public static void hookPreviewLastHdHeadImg(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        // 有效

        String classname = "com.tencent.mm.plugin.setting.ui.setting.PreviewLastHdHeadImg";

        ClassLoader classLoader = loadPackageParam.classLoader;
        String tag = " hookPreviewLastHdHeadImg ";
        XposedBridge.log(tag + " try to hook");

        Class<?> clazz = XposedHelpers.findClassIfExists(classname, classLoader);

        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            XposedBridge.log(tag + declaredMethod);

        }
        XposedBridge.hookAllMethods(clazz, "initView", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);

                Activity activity = (Activity) param.thisObject;
                Intent intent = activity.getIntent();
                Bundle extras = intent.getExtras(); // 获取Intent的Extras
                for (String key : extras.keySet()) {
                    Object value = extras.get(key);
                    XposedBridge.log(tag + key + " = " + value);

                }

            }
        });
    }

    public static void hookYa2B(XC_LoadPackage.LoadPackageParam loadPackageParam) {

        String classname = "ya2.b";

        ClassLoader classLoader = loadPackageParam.classLoader;
        String tag = " hookYa2B ";
        XposedBridge.log(tag + " try to hook");

        Class<?> clazz = XposedHelpers.findClassIfExists(classname, classLoader);

        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            XposedBridge.log(tag + declaredMethod);

        }
        XposedBridge.hookAllMethods(clazz, "setSex", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                StringBuilder stringBuilder = new StringBuilder();
                XposedBridge.log(tag + "123");

                for (Object arg : param.args) {
                    stringBuilder.append(arg);
                }

                XposedBridge.log(tag + stringBuilder.toString() + "catch!!!!!");

            }
        });
    }

    public static void printParam(String tag, XC_MethodHook.MethodHookParam param) {
        StringBuilder stringBuilder = new StringBuilder();
        XposedBridge.log(tag + "打印方法参数：");

        for (Object arg : param.args) {
            stringBuilder.append(arg);
            stringBuilder.append(" ");
        }
        XposedBridge.log(tag + stringBuilder.toString() + "打印借书");

    }

    public static void hookOnclick(XC_LoadPackage.LoadPackageParam loadPackageParam) {

        String onclickClassname = "android.view.View";
        String tag = " hookOnclick ";
        Class<?> classIfExists = XposedHelpers.findClassIfExists(onclickClassname, loadPackageParam.classLoader);
        XposedBridge.log(tag + classIfExists);

        XposedBridge.hookAllMethods(classIfExists, "setOnClickListener", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                Object arg = param.args[0];
                Object on = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        XposedBridge.log(tag + " fuck");
                        ViewParent parent = v.getParent();
                        while (parent != null) {
                            XposedBridge.log(tag + " parent " + parent.getClass());
                            parent = parent.getParent();
                        }
                        ((View.OnClickListener) arg).onClick(v);
                    }
                };
                param.args[0] = on;
            }
        });

    }

    public static void hookSetText(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        String onclickClassname = "android.widget.TextView";
        String tag = " hookSetText ";
        Class<?> classIfExists = XposedHelpers.findClassIfExists(onclickClassname, loadPackageParam.classLoader);

        XposedBridge.hookAllMethods(classIfExists, "setText", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                XposedBridge.log(tag + param.args[0] + param.thisObject.getClass());
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

                for (int i = 2; i < stackTrace.length; i++) {
                    StackTraceElement element = stackTrace[i];
                    XposedBridge.log(tag + "Caller: " + element.getClassName() + "." + element.getMethodName() + " at " + element.getFileName() + ":" + element.getLineNumber());
                }
            }
        });

    }

    public static void hookToInsertMySettingUI(XC_LoadPackage.LoadPackageParam loadPackageParam) { //这是我们的设置界面

        String tag = Tag + "_setting";
        String HeadImgNewPreferenceClassname = "com.tencent.mm.ui.base.preference.HeadImgNewPreference";
        ClassLoader classLoader = loadPackageParam.classLoader;
        XposedBridge.log(tag + " 尝试注入Vavatar UI");

        Class<?> headImgNewPreferenceClass = XposedHelpers.findClassIfExists(HeadImgNewPreferenceClassname, classLoader);
        Method targetMethod = null;

        for (Method declaredMethod : headImgNewPreferenceClass.getDeclaredMethods()) {

            // 获取方法参数
            Parameter[] parameters = declaredMethod.getParameters();

            // 如果方法有一个参数并且这个参数的类型是 View
            if (parameters.length == 1 && parameters[0].getType().equals(View.class)) {
                targetMethod = declaredMethod;
                break;
            }
        }

        if (targetMethod == null) {
            XposedBridge.log(tag + " 没有找到目标方法以注入VAVATAR_UI");
            return;
        } else {
            XposedBridge.log(tag + " 找到目标方法 " + targetMethod);
        }

        XposedBridge.hookMethod(targetMethod, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);

                LinearLayout linearLayout = (LinearLayout) param.args[0];
                View childAt = linearLayout.getChildAt(linearLayout.getChildCount() - 1);
                if (childAt.getId() != R.id.setting2Activity_mcHookTool) {
                    XposedBridge.log(tag + " 正在注入Vavatar_UI");
                } else {
                    return;
                }

                Context context = linearLayout.getContext();
                Button newButton = new Button(context);
                newButton.setId(R.id.setting2Activity_mcHookTool);
                newButton.setText("VAvatar setting");
                newButton.setOnClickListener(new Vui());
                linearLayout.addView(newButton);
                XposedBridge.log(tag + " 设置入口已设置");

            };
        });

//        2024-12-30 01:55:58.673 26669-26669 LSPosed-Bridge          pid-26669                            I  hookHeadImgNewPreference invoke D
//        2024-12-30 01:55:58.674 26669-26669 LSPosed-Bridge          pid-26669                            I  hookHeadImgNewPreference invoke C
//

    }

    public static boolean toastConfig =true;

    public static void hookOnResume(XC_LoadPackage.LoadPackageParam loadPackageParam) {

        String tag = Tag + "_core";

        XposedBridge.log(tag + " 尝试注入Vavatar_core");

        String networkClassName = Configuration.SETTING.get(Configuration.NETWORK_CLASS_NAME);
        String methodParamTypeName = Configuration.SETTING.get(Configuration.METHOD_PARAM_TYPE_NAME);
        String realMethodParamTypeName = Configuration.SETTING.get(Configuration.REAL_METHOD_PARAM_TYPE_NAME);
        String mainUiClassName = Configuration.SETTING.get(Configuration.MAIN_UI_CLASS_NAME);
        String Ui_method_name = "onResume";
        String networkGetMethodName = Configuration.SETTING.get(Configuration.NETWORK_GET_METHOD_NAME);
        String networkStartMethodName = Configuration.SETTING.get(Configuration.NETWORK_START_METHOD_NAME);


        ClassLoader classLoader = loadPackageParam.classLoader;


        Class<?> networkClass = XposedHelpers.findClassIfExists(networkClassName, classLoader);
        Class<?> realMethodParamTypeClass = XposedHelpers.findClassIfExists(realMethodParamTypeName, classLoader);
        Class<?> methodParamTypeClass = XposedHelpers.findClassIfExists(methodParamTypeName, classLoader);
        Class<?> mainUiClassClass = XposedHelpers.findClassIfExists(mainUiClassName, classLoader);

        if(toastConfig){
            XposedBridge.log(tag + " networkClass " + (networkClass!=null)
                    + " realMethodParamTypeClass " + (realMethodParamTypeClass!=null)
                    + " methodParamTypeClass " + (methodParamTypeClass!=null)
                    + " mainUiClassClass " + (mainUiClassClass!=null));
        }


        XposedHelpers.findAndHookMethod(mainUiClassClass, Ui_method_name, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);

                float persistence = 0.5f;
                if ((Math.random() > persistence)) {
                    XposedBridge.log(tag + "avatar_fun被设计返回，因为概率" + (1 - persistence));
                    return;
                }

                Context context = (Context) param.thisObject;

                {

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            boolean b = Mp.shouldRefreshInfo(context);
                            if (!b) {
                                XposedBridge.log(tag + " 不需要获取公告");
                                return;
                            }
                            String infoFromDev = FileDownloader.getInfoFromDev(context);
                            if (!infoFromDev.contains("error")) {
                                Mp.onRetrievedInfoFromDev(context, infoFromDev);
                                XposedBridge.log(tag + " 获取到公告");
                            } else {
                                XposedBridge.log(tag + " 获取公告异常 " + infoFromDev);

                            }
                        }
                    })
                            .start();
                }

                {
                    new Thread(
                            new Runnable() {
                                @Override
                                public void run() {
                                    FileUtil.prepareAvatar(context);

                                    boolean b = Mp.shouldDownloadNow(context);
                                    if (!b) {
                                        XposedBridge.log(tag + " 不需要下载图片");
                                        return;
                                    }
                                    try {
                                        FileDownloader.downloadFile(context);
                                        Mp.onTryDownloading(context);
                                    } catch (Exception e) {
                                        XposedBridge.log(tag + " download err" + e.getMessage());
                                    }
                                }
                            }).start();
                }

                {
                    boolean b = Mp.shouldUploadNow(context);
                    if (!b) {
                        XposedBridge.log(tag + " 不需要更新头像");
                        return;
                    } else {
                        XposedBridge.log(tag + " 尝试更新头像");

                    }

                    Object realMethodParamIns = null;

                    Method networkGetMethod = networkClass.getDeclaredMethod(networkGetMethodName);
                    XposedBridge.log(tag + networkGetMethodName + networkGetMethod);

                    Object network = networkGetMethod.invoke(null);

                    if (network != null) {
                        XposedBridge.log(tag + "  network GOT " + network);
                        XposedBridge.log(tag + "  尝试新建实参类型对象");
                        realMethodParamIns = XposedHelpers.newInstance(realMethodParamTypeClass, 1, getTargetPath(context).getAbsolutePath(), null, true);
                        XposedBridge.log(tag + "  头像目标path " + getTargetPath(context));

                        XposedBridge.log(tag + " finding " + networkStartMethodName + " method");
                        Class<?> networkClass = network.getClass();
                        Method networkStartMethod = networkClass.getDeclaredMethod(networkStartMethodName, methodParamTypeClass);
                        XposedBridge.log(tag + " networkStartMethod " + networkStartMethod);

                        if (networkStartMethod != null) {

                            Mp.saveData(context);       // 立即冷却_保守地
                            networkStartMethod.invoke(network, realMethodParamIns);

                            toastConfig =false;

                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        Thread.sleep(10 * 1000L);
                                    } catch (Exception e) {
                                        throw new RuntimeException(e);
                                    }
                                    FileUtil.avatarChanged(context);// 必须舍弃,因为它似乎没有回调
                                    XposedBridge.log(tag + " 已经移除该头像");
                                }
                            }).start();

                        }

                    }
                }

            }
        });

    }

}