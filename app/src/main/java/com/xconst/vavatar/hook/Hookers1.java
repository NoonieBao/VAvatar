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

    static String finalTargetPath = "/data/user/0/com.tencent.mm/vavatar/test.jpg";
    static String sfaf = "com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg";

    static String logClassname = "com.tencent.mm.sdk.platformtools.l2";


    static String logClassname1 = "com.tencent.mm.sdk.platformtools.q2";


    static String xlogClassname = "com.tencent.mars.xlog.Xlog";


    public static void hookProfileHdHeadImg(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        // 没用,查看大头像的时候调用
        String tag = " hookProfileHdHeadImg ";
        XposedBridge.log(tag + " try to hook");

        ClassLoader classLoader = loadPackageParam.classLoader;
        Class<?> profileHdHeadImgClass = XposedHelpers.findClassIfExists(sfaf, classLoader);

        if (profileHdHeadImgClass != null) {
            XposedBridge.log(tag + "have catch class");

            XposedHelpers.findAndHookMethod(profileHdHeadImgClass, "m6",
                    Bitmap.class,
                    String.class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            super.beforeHookedMethod(param);
                            XposedBridge.log(tag + " beforeHookedMethod");

                        }
                    });

        }
    }

    public static void hookLog(XC_LoadPackage.LoadPackageParam loadPackageParam) {


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

    public static void test(XC_LoadPackage.LoadPackageParam loadPackageParam) {

        XposedHelpers.findAndHookMethod(Application.class, "attach", Context.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        Context context = (Context) param.args[0];
                        ClassLoader classLoader = context.getClassLoader();// java.lang.BootClassLoader


                        Class<?> classIfExists = XposedHelpers.findClassIfExists(sfaf, classLoader);

                        XposedBridge.log(Tag + classIfExists);

                        Method method;
                        if (classIfExists != null) {


                            XposedHelpers.findAndHookMethod(classIfExists, "m6", new XC_MethodHook() {
                                @Override
                                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                    super.beforeHookedMethod(param);
                                    Context context = (Context) param.args[0];
                                    XposedBridge.log(Tag + "67373737373");

                                    exit(0);
                                }
                            });

                            for (Method declaredMethod : classIfExists.getDeclaredMethods()) {
                                XposedBridge.log(Tag + declaredMethod);


                                if (declaredMethod.getName().contains("m6")) {
                                    method = declaredMethod;


                                    XposedBridge.log(Tag + declaredMethod + " imoprtant");

                                }
                            }

                        }


                    }
                });

    }

    public static void hookModelAvatarV0(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        String modelAvatarClassname = "com.tencent.mm.modelavatar.v0";
        String k2ClassName = "com.tencent.mm.plugin.setting.ui.setting.k2";
        String previewHdHeadImgClassname = "com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg";
        String bitmapUtilClassname = "com.tencent.mm.sdk.platformtools.y";

        ClassLoader classLoader = loadPackageParam.classLoader;
        String tag = " hookModelAvatarV0 ";
        XposedBridge.log(tag + " try to hook");


        String targetPath = "wcf://avatar/81/99/test.png";

        Class<?> modelavatarClass = XposedHelpers.findClassIfExists(modelAvatarClassname, classLoader);
        Class<?> bitmapUtilClass = XposedHelpers.findClassIfExists(bitmapUtilClassname, classLoader);
        Class<?> k2Class = XposedHelpers.findClassIfExists(k2ClassName, classLoader);
        Class<?> previewHdHeadImgClassnameClass = XposedHelpers.findClassIfExists(previewHdHeadImgClassname, classLoader);

        XposedBridge.log(tag + previewHdHeadImgClassnameClass);

        XposedBridge.hookAllMethods(previewHdHeadImgClassnameClass, "onActivityResult", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);

                Intent intent = (Intent) param.args[2];
                if (intent != null) {
                    intent.putExtra("CropImage_OutputPath", targetPath);
                }


            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                Intent intent = (Intent) param.args[2];
                if (intent != null) {
                    XposedBridge.log(tag + "post " + intent.getStringExtra("CropImage_OutputPath"));

                }

            }
        });


        try {


            if (true) {
                return;
            }

            Constructor<?> modelavatarClassConstructor = modelavatarClass.getConstructor(Context.class, String.class, boolean.class);
            Constructor<?> k2ClassConstructor = k2Class.getConstructor(Context.class, String.class, boolean.class);
            Constructor<?> previewLastHdHeadImgClassConstructor = previewHdHeadImgClassnameClass.getConstructor();

            Object modelAvatarIns = modelavatarClassConstructor.newInstance(null, targetPath, true);
            Method modelAvatarMethodB = modelavatarClass.getMethod("b", Runnable.class, boolean.class);

            Object previewLastHdHeadImgIns = previewLastHdHeadImgClassConstructor.newInstance();


            Object k2Ins = k2ClassConstructor.newInstance(previewLastHdHeadImgIns, Bitmap.class);


            modelAvatarMethodB.invoke(modelAvatarIns, 1, k2Ins, true);


        } catch (Exception e) {
            XposedBridge.log(tag + "contsrunct err");
            throw new RuntimeException(e);
        }


    }

    final static String FinderCropAvatarUIClassname = "com.tencent.mm.plugin.finder.ui.FinderCropAvatarUI";

    public static void hookFinderCropAvatarUI(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        ClassLoader classLoader = loadPackageParam.classLoader;
        String tag = " hookFinderCropAvatarUI ";
        XposedBridge.log(tag + " try to hook");

        Class<?> modelavatarClass = XposedHelpers.findClassIfExists(FinderCropAvatarUIClassname, classLoader);

        if (modelavatarClass != null) {
            XposedBridge.log(tag + "have catch class");


            for (Method declaredMethod : modelavatarClass.getDeclaredMethods()) {
                XposedBridge.log(tag + "method: " + declaredMethod);

                if (declaredMethod.getName().contains("initView")) {

                    XposedBridge.log(tag + "founded target method " + declaredMethod);


                    XposedBridge.hookMethod(declaredMethod, new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            super.beforeHookedMethod(param);
                            XposedBridge.log(tag + "initView() invoked");

                            StringBuilder stringBuilder = new StringBuilder();

                            StackTraceElement[] elements = Thread.currentThread().getStackTrace();
                            for (int i = 1; i < elements.length; i++) {
                                StackTraceElement s = elements[i];
                                stringBuilder.append("\tat " + s.getClassName() + "." + s.getMethodName() + "(" + s.getFileName() + ":" + s.getLineNumber() + ")");
                            }
                            XposedBridge.log(tag + "initView() 堆栈" + stringBuilder.toString());

                        }
                    });

                    break;
                }
            }

        }
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


    public static void hookModelAvatarU0(XC_LoadPackage.LoadPackageParam loadPackageParam) {

        String classname = "com.tencent.mm.modelavatar.u0";


        ClassLoader classLoader = loadPackageParam.classLoader;
        String tag = " hookModelAvatarU0 ";
        XposedBridge.log(tag + " try to hook");

        Class<?> clazz = XposedHelpers.findClassIfExists(classname, classLoader);


        XposedBridge.hookAllConstructors(clazz, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                XposedBridge.log(tag + " 构造方法");

                printParam(tag, param);
            }
        });
    }

    public static void hookModelbaseI2(XC_LoadPackage.LoadPackageParam loadPackageParam) {


        String classname = "com.tencent.mm.modelbase.i2";


        ClassLoader classLoader = loadPackageParam.classLoader;
        String tag = " hookModelbaseI2 ";
        XposedBridge.log(tag + " try to hook");

        Class<?> clazz = XposedHelpers.findClassIfExists(classname, classLoader);

        XposedBridge.hookAllMethods(clazz, "run", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                StringBuilder stringBuilder = new StringBuilder();
                for (Object arg : param.args) {
                    stringBuilder.append(arg);
                    stringBuilder.append(" ");
                }
                XposedBridge.log(tag + stringBuilder.toString() + "hookModelbaseI2");

                StackTraceElement[] elements = Thread.currentThread().getStackTrace();
                for (int i = 1; i < elements.length; i++) {
                    StackTraceElement s = elements[i];
                    stringBuilder.append("\tat " + s.getClassName() + "." + s.getMethodName() + "(" + s.getFileName() + ":" + s.getLineNumber() + ")");
                }
                XposedBridge.log(tag + "hookModelbaseI2() 堆栈" + stringBuilder.toString());
//                    System.exit(1);


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

    public static void hookS6(XC_LoadPackage.LoadPackageParam loadPackageParam) {

        ClassLoader classLoader = loadPackageParam.classLoader;

        String classname = "com.tencent.mm.app.s6";


        String tag = " hookS6 ";
        XposedBridge.log(tag + " try to hook");

        Class<?> clazz = XposedHelpers.findClassIfExists(classname, classLoader);

        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            XposedBridge.log(tag + declaredMethod);

        }
        XposedBridge.hookAllMethods(clazz, "K6", new XC_MethodHook() {
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


    public static void hookPreviewHdHeadImg(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        // 这个可以hook到

        String classname = "com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg";


        String tag = " hookPreviewHdHeadImg ";
        XposedBridge.log(tag + " try to hook");
        ClassLoader classLoader = loadPackageParam.classLoader;

        Class<?> clazz = XposedHelpers.findClassIfExists(classname, classLoader);

//            for (Method declaredMethod : clazz.getDeclaredMethods()) {
//                XposedBridge.log(tag + declaredMethod);
//
//            }
        XposedBridge.hookAllMethods(clazz, "onActivityResult", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                XposedBridge.log(tag + "不调用o6");
                throw new RuntimeException();
            }
        });

        if (true) {
            return;
        }
        XposedBridge.hookAllMethods(clazz, "onActivityResult", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                StringBuilder stringBuilder = new StringBuilder();
                XposedBridge.log(tag + "123");

                for (Object arg : param.args) {
                    stringBuilder.append(arg);
                    stringBuilder.append(" ");
                }
                if (param.args[2] != null) {
                    Intent intent = (Intent) param.args[2];
                    Bundle extras = intent.getExtras(); // 获取Intent的Extras
                    for (String key : extras.keySet()) {
                        Object value = extras.get(key);
                        XposedBridge.log(tag + key + " = " + value);

                    }
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

    public static void hookGetHdHeadImageGalleryView(XC_LoadPackage.LoadPackageParam loadPackageParam) {


        String classname = "com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView";
        String tag = " hookGetHdHeadImageGalleryView ";
        XposedBridge.log(tag + " try to hook");
        ClassLoader classLoader = loadPackageParam.classLoader;
        Class<?> clazz = XposedHelpers.findClassIfExists(classname, classLoader);

        XposedBridge.hookAllMethods(clazz, "setHdHeadImagePath", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);

                XposedBridge.log(tag + "不调用 setHdHeadImagePath");

                exit(1);
            }
        });

    }

    public static void hookY(XC_LoadPackage.LoadPackageParam loadPackageParam) {

        String s = " com.tencent.mm.sdk.platformtools.y";
        Class<?> classIfExists = XposedHelpers.findClassIfExists(s, loadPackageParam.classLoader);
        XposedBridge.hookAllMethods(classIfExists, "Y", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                XposedBridge.log("hook y " + param.args[0]);
            }
        });

    }

    public static void hookPreviewHdHeadImgM6(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        String classname = "com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg";
        String tag = " hookPreviewHdHeadImgM6 ";
        XposedBridge.log(tag + " try to hook");
        ClassLoader classLoader = loadPackageParam.classLoader;

        Class<?> clazz = XposedHelpers.findClassIfExists(classname, classLoader);


        XposedBridge.hookAllMethods(clazz, "m6", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                XposedBridge.log(tag + "break");
                printParam(tag, param);
                exit(0);
            }
        });

    }

    public static void hookAllM6Relevant(XC_LoadPackage.LoadPackageParam loadPackageParam) {

        String ya2b = "ya2.b";
        String SettingsPersonalInfoUI = "com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI";
        String PreviewHdHeadImg = "com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg";

        String tag = "hookAllM6Relevant ";

        ClassLoader classLoader = loadPackageParam.classLoader;


        Class<?> ya2bclass = XposedHelpers.findClassIfExists(ya2b, classLoader);
        Class<?> SettingsPersonalInfoUIclass = XposedHelpers.findClassIfExists(SettingsPersonalInfoUI, classLoader);
        Class<?> PreviewHdHeadImgclass = XposedHelpers.findClassIfExists(PreviewHdHeadImg, classLoader);


        XposedBridge.hookAllMethods(ya2bclass, "onActivityResult", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                printParam(tag, param);
                XposedBridge.log(tag + " ya2bclass");

            }
        });
        XposedBridge.hookAllMethods(SettingsPersonalInfoUIclass, "onActivityResult", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                printParam(tag, param);
                XposedBridge.log(tag + " SettingsPersonalInfoUIclass");
                // 选择一张照片进入了裁剪

            }
        });

        XposedBridge.hookAllMethods(PreviewHdHeadImgclass, "onActivityResult", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                printParam(tag, param);
                XposedBridge.log(tag + " PreviewHdHeadImgclass");

            }
        });

    }

    public static void hookModelAvatarV0B(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        //Yes the method b is the key path。
        String modelAvatarClassname = "com.tencent.mm.modelavatar.v0";
        ClassLoader classLoader = loadPackageParam.classLoader;
        String tag = " hookModelAvatarV0B ";
        XposedBridge.log(tag + " try to hook");


        Class<?> modelavatarClass = XposedHelpers.findClassIfExists(modelAvatarClassname, classLoader);
        XposedBridge.hookAllMethods(modelavatarClass, "b", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                XposedBridge.log(tag + " invoke b()");

                Thread.sleep(10 * 1000);
                XposedBridge.log(tag + " sleep passed");


            }
        });

    }

    public static void hookL70K1(XC_LoadPackage.LoadPackageParam loadPackageParam) {


        String k1Classname = "l70.k1";


        ClassLoader classLoader = loadPackageParam.classLoader;
        String tag = " hookL70K1 ";
        XposedBridge.log(tag + " try to hook");


        Class<?> k1Class = XposedHelpers.findClassIfExists(k1Classname, classLoader);
        XposedHelpers.findAndHookMethod(k1Class, "d", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                XposedBridge.log(tag + " t");

            }
        });


    }


    public static void hookSetting(XC_LoadPackage.LoadPackageParam loadPackageParam) {

        String SettingsPersonalInfoUIClassname = "com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI";
        ClassLoader classLoader = loadPackageParam.classLoader;
        String tag = "hookSetting ";


        Class<?> SettingsPersonalInfoUIClass = XposedHelpers.findClassIfExists(SettingsPersonalInfoUIClassname, classLoader);

        XposedBridge.hookAllMethods(SettingsPersonalInfoUIClass, "onActivityResult", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                Class<?> SettingsPersonalInfoUISuperClass = SettingsPersonalInfoUIClass.getSuperclass();
                Field field = null;
                for (Field declaredField : SettingsPersonalInfoUISuperClass.getDeclaredFields()) {
                    if (declaredField.toString().contains("RelativeLayout")) {
                        field = declaredField;
                    }
                }

                if (field != null) {
                    Object thisObject = param.thisObject;
                    field.setAccessible(true);
                    XposedBridge.log(tag + field);

                    RelativeLayout relativeLayout = (RelativeLayout) field.get(thisObject);
                    XposedBridge.log(tag + relativeLayout);
                    relativeLayout.removeViewAt(0);

                }
            }
        });


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

    public static void printCallerInfo(String tag) {
        // 获取当前线程的堆栈跟踪信息
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        // stackTrace[0] 是当前方法 printCallerInfo，stackTrace[1] 是调用者（即 methodB），stackTrace[2] 是 methodA，stackTrace[3] 是 main 方法
        StackTraceElement caller = stackTrace[2]; // 获取 methodA 的调用者（即 main 方法）

        // 输出调用者的信息
    }

    public static void hookToInsertMySettingUI(XC_LoadPackage.LoadPackageParam loadPackageParam) { //这是我们的设置界面

        String HeadImgNewPreferenceClassname = "com.tencent.mm.ui.base.preference.HeadImgNewPreference";
        ClassLoader classLoader = loadPackageParam.classLoader;
        String tag = Tag+"_setting";
        XposedBridge.log(tag + " 尝试注入Vavatar UI");


        Class<?> HeadImgNewPreferenceClass = XposedHelpers.findClassIfExists(HeadImgNewPreferenceClassname, classLoader);
        XposedBridge.log(tag  +HeadImgNewPreferenceClass);
        Method targetMethod = null;
        for (Method declaredMethod : HeadImgNewPreferenceClass.getDeclaredMethods()) {
            XposedBridge.log(tag + " HeadImgNewPreferenceClass declaredMethod: " + declaredMethod);

            // 获取方法参数
            Parameter[] parameters = declaredMethod.getParameters();
            XposedBridge.log(tag + " HeadImgNewPreferenceClass parameters: " + Arrays.toString(parameters));

            // 如果方法有一个参数并且这个参数的类型是 View
            if (parameters.length == 1 && parameters[0].getType().equals(View.class)) {
                targetMethod = declaredMethod;
                break;
            }
        }


        if(targetMethod==null){
            XposedBridge.log(tag + " 没有找到目标方法");
            return;
        }else {
            XposedBridge.log(tag + " 找到目标方法 " + targetMethod);
        }
        XposedBridge.hookMethod(targetMethod, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                XposedBridge.log(tag + " invoked " );

                LinearLayout linearLayout = (LinearLayout) param.args[0];
                View childAt = linearLayout.getChildAt(linearLayout.getChildCount() - 1);
                if (childAt.getId() != R.id.setting2Activity_mcHookTool) {
                    XposedBridge.log(tag + " 注入Vavatar UI");
                } else {
                    return;
                }
                XposedBridge.log((tag + childAt.getId() + childAt));

                Context context = linearLayout.getContext();

                Button newButton = new Button(context);
                newButton.setId(R.id.setting2Activity_mcHookTool);
                newButton.setText("VAvatar setting");
                newButton.setOnClickListener(new Vui());
                linearLayout.addView(newButton);

            }

            ;
        });

//        2024-12-30 01:55:58.673 26669-26669 LSPosed-Bridge          pid-26669                            I  hookHeadImgNewPreference invoke D
//        2024-12-30 01:55:58.674 26669-26669 LSPosed-Bridge          pid-26669                            I  hookHeadImgNewPreference invoke C
//


    }

    public static void hookAttach(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        if (true) {
            return;
        }
        String tag = " hookAttach ";
        XposedHelpers.findAndHookMethod(Application.class, "attach", Context.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                XposedBridge.log(tag + "invoke C");

            }
        });
    }

    public static void hookOnResume(XC_LoadPackage.LoadPackageParam loadPackageParam) {

        String tag = Tag+"_core";

        // 这个是底部导航栏的4个按钮，已经劫持到了触发方法


        String NETWORK_CLASS_NAME = HookEntry.SETTING.get(HookEntry.NETWORK_CLASS_NAME);
        String METHOD_PARAM_TYPE_NAME = HookEntry.SETTING.get(HookEntry.METHOD_PARAM_TYPE_NAME);
        String REAL_METHOD_PARAM_TYPE_NAME = HookEntry.SETTING.get(HookEntry.REAL_METHOD_PARAM_TYPE_NAME);
        String MAIN_UI_CLASS_NAME = HookEntry.SETTING.get(HookEntry.MAIN_UI_CLASS_NAME);
        String Ui_method_name = "onResume";
        ClassLoader classLoader = loadPackageParam.classLoader;

        String NETWORK_GET_METHOD_NAME = HookEntry.SETTING.get(HookEntry.NETWORK_GET_METHOD_NAME);
        String NETWORK_START_METHOD_NAME = HookEntry.SETTING.get(HookEntry.NETWORK_START_METHOD_NAME);

        XposedBridge.log(tag + " 尝试注入Vavatar_core");


        Class<?> NETWORK_CLASS = XposedHelpers.findClassIfExists(NETWORK_CLASS_NAME, classLoader);
        Class<?> REAL_METHOD_PARAM_TYPE_CLASS = XposedHelpers.findClassIfExists(REAL_METHOD_PARAM_TYPE_NAME, classLoader);
        Class<?> METHOD_PARAM_TYPE_CLASS = XposedHelpers.findClassIfExists(METHOD_PARAM_TYPE_NAME, classLoader);
        Class<?> MAIN_UI_CLASS_CLASS = XposedHelpers.findClassIfExists(MAIN_UI_CLASS_NAME, classLoader);

        XposedBridge.log(tag + " NETWORK_CLASS " + NETWORK_CLASS);
        XposedBridge.log(tag + " REAL_METHOD_PARAM_TYPE_CLASS " + REAL_METHOD_PARAM_TYPE_CLASS);
        XposedBridge.log(tag + " METHOD_PARAM_TYPE_CLASS " + METHOD_PARAM_TYPE_CLASS);
        XposedBridge.log(tag + " MAIN_UI_CLASS_CLASS " + MAIN_UI_CLASS_CLASS);




        XposedHelpers.findAndHookMethod(MAIN_UI_CLASS_CLASS, Ui_method_name, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);

                float persistence = 0.8f;
                if( (Math.random() > persistence) ){
                    XposedBridge.log(tag + "avatar_fun被设计返回，因为概率"+(1-persistence));
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


                    Object REAL_METHOD_PARAM_INS = null;

                    Method NETWORK_GET_METHOD = NETWORK_CLASS.getDeclaredMethod(NETWORK_GET_METHOD_NAME);
                    XposedBridge.log(tag + NETWORK_GET_METHOD_NAME + NETWORK_GET_METHOD);

                    Object NETWORK = NETWORK_GET_METHOD.invoke(null);


                    if (NETWORK != null) {
                        XposedBridge.log(tag + "  NETWORK GOT " + NETWORK);
                        XposedBridge.log(tag + "  尝试新建实参类型对象");
                        REAL_METHOD_PARAM_INS = XposedHelpers.newInstance(REAL_METHOD_PARAM_TYPE_CLASS, 1, getTargetPath(context).getAbsolutePath(), null, true);
                        XposedBridge.log(tag + "  头像目标path " +getTargetPath(context));


                        XposedBridge.log(tag + " finding "+NETWORK_START_METHOD_NAME+" method");
                        Class<?> NETWORK_CLASS = NETWORK.getClass();
                        Method NETWORK_START_METHOD = NETWORK_CLASS.getDeclaredMethod(NETWORK_START_METHOD_NAME, METHOD_PARAM_TYPE_CLASS);
                        XposedBridge.log(tag + " NETWORK_START_METHOD " + NETWORK_START_METHOD);


                        if (NETWORK_START_METHOD != null) {
                            Mp.saveData(context);       // 静茹冷却

                            NETWORK_START_METHOD.invoke(NETWORK, REAL_METHOD_PARAM_INS);


                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        Thread.sleep(10*1000L);
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

    public static void avatarHook(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        if (true) {
            return;
        }
        String previewHdHeadImgClassname = "com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg";

        String modelAvatarU0Classname = "com.tencent.mm.modelavatar.u0";        //需要替换
        String l70k1Classname = "l70.k1";       //需要替换
        String modelBaseK1Classname = "com.tencent.mm.modelbase.k1";       // 需要替换


        String tag = "avatarHook ";


        XposedBridge.log(tag + " try to hook");


        ClassLoader classLoader = loadPackageParam.classLoader;


        Class<?> k1Class = XposedHelpers.findClassIfExists(l70k1Classname, classLoader);
        Class<?> previewHdHeadImgClass = XposedHelpers.findClassIfExists(previewHdHeadImgClassname, classLoader);
        Class<?> modelAvatarU0Class = XposedHelpers.findClassIfExists(modelAvatarU0Classname, classLoader);
        Class<?> modeleBaseK1Class = XposedHelpers.findClassIfExists(modelBaseK1Classname, classLoader);


        Constructor<?> modelAvatarU0ClassConstructor;
        try {
            modelAvatarU0ClassConstructor = modelAvatarU0Class.getConstructor(int.class, String.class, String.class, boolean.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        XposedBridge.hookAllMethods(previewHdHeadImgClass, "onActivityResult", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);

                Object modelAvatarU0 = null;

                XposedBridge.log(tag + " entered onActivityResult, now invoke l70.d() ");
                Method d = k1Class.getDeclaredMethod("d");
                XposedBridge.log(tag + "  d method " + d);

                Object l70_d_ret_p1type = d.invoke(null);


                if (l70_d_ret_p1type != null) {
                    XposedBridge.log(tag + "  l70.d() ret " + l70_d_ret_p1type);

                    if (modelAvatarU0ClassConstructor != null) {
                        XposedBridge.log(tag + "  尝试新建u0");
                        modelAvatarU0 = modelAvatarU0ClassConstructor.newInstance(1, finalTargetPath, null, true);

                    } else {
                        XposedBridge.log(tag + "  modelAvatarU0ClassConstructor null ");

                    }

                    XposedBridge.log(tag + " finding f method");
                    Class<?> p1Class = l70_d_ret_p1type.getClass();
                    Method f = p1Class.getDeclaredMethod("f", modeleBaseK1Class);
                    XposedBridge.log(tag + "f method of modeleBaseK1Class " + f);


                    if (f != null) {
                        XposedBridge.log(tag + " found f method");
                        f.invoke(l70_d_ret_p1type, modelAvatarU0);
                    }


                }


            }
        });

    }


    public static void hookSettingCompatitive(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        String classname  ="com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg";
        Class<?> classIfExists = XposedHelpers.findClassIfExists(classname, loadPackageParam.classLoader);

        String tag = Tag + "hookSettingCompatitive";
        Method onActivityResultMethod = null    ;
        for (Method declaredMethod : classIfExists.getDeclaredMethods()) {
            XposedBridge.log(tag+"declaredMethod " + declaredMethod);
            if(declaredMethod.getName().contains("onActivityResult")){
                onActivityResultMethod=declaredMethod;
                break;
            }
        }
        for (Constructor<?> constructor : classIfExists.getConstructors()) {
            XposedBridge.log(tag+"constructor " + constructor);
        }

        try {
            Object o = XposedHelpers.newInstance(classIfExists);
            XposedBridge.log(tag+o );

            Intent intent = new Intent();
            intent.putExtra("CropImage_OutputPath","/data/user/0/com.tencent.mm/test.png");
            onActivityResultMethod.invoke(o,4,-1,intent);
            XposedBridge.log(tag+"done " );

        } catch (Exception e) {
            XposedBridge.log(tag+"err " );

            throw new RuntimeException(e);
        }

    }
}


