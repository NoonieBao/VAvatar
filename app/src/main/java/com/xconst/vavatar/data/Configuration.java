package com.xconst.vavatar.data;

import java.util.HashMap;
import java.util.Map;

import com.xconst.vavatar.BuildConfig;

public class Configuration {

    public final static String NETWORK_CLASS_NAME = "NETWORK_CLASS_NAME";     //（获取f的调用者的方法）的工具类
    public final static String METHOD_PARAM_TYPE_NAME = "modelBaseK1Classname";     //f方法的参数类型

    public final static String REAL_METHOD_PARAM_TYPE_NAME = "modelAvatarU0Classname";      // f执行时候参数实例化的类型

    public final static String NETWORK_GET_METHOD_NAME = "methodName0";
    public final static String NETWORK_START_METHOD_NAME = "methodName1";

    public final static String MAIN_UI_CLASS_NAME = "MAIN_UI_CLASS_NAME";

    public final static String SHARE_TINKER = "SHARE_TINKER";
    public final static String SHARE_TINKER_METHOD_NAME = "SHARE_TINKER_METHOD_NAME";

    public final static Map<String, Map<String, String>> SETTING_SET = new HashMap<String, Map<String, String>>() {{
        put("2540_8046", new HashMap<String, String>() {{    //8046  无法登陆了
            put(NETWORK_CLASS_NAME, "h70.l1");//c8      //静态类
            put(METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelbase.k1");//c8       // 最终方法的参数类型
            put(REAL_METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelavatar.u0");  //8.0.46 c8
            put(NETWORK_GET_METHOD_NAME, "d");  //8.0.48
            put(NETWORK_START_METHOD_NAME, "f");  //8.0.48
            put(MAIN_UI_CLASS_NAME, "com.tencent.mm.ui.LauncherUI");
        }});
        put("2560_8047", new HashMap<String, String>() {{    //通过
            put(NETWORK_CLASS_NAME, "h70.l1");//c8     //静态类
            put(METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelbase.k1");//c8       // 最终方法的参数类型
            put(REAL_METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelavatar.u0");  //8.0.47 c8
            put(NETWORK_GET_METHOD_NAME, "d");
            put(NETWORK_START_METHOD_NAME, "f");
            put(MAIN_UI_CLASS_NAME, "com.tencent.mm.ui.LauncherUI");

        }});
        put("2580_8048", new HashMap<String, String>() {{
            put(NETWORK_CLASS_NAME, "l70.k1");//c7      //静态类
            put(METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelbase.k1");//c1       // 最终方法的参数类型
            put(REAL_METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelavatar.u0");  //8.0.48 c5
            put(NETWORK_GET_METHOD_NAME, "d");
            put(NETWORK_START_METHOD_NAME, "f");
            put(MAIN_UI_CLASS_NAME, "com.tencent.mm.ui.LauncherUI");


        }});

        put("2600_8049", new HashMap<String, String>() {{    //8.0.49    通过
            put(NETWORK_CLASS_NAME, "u70.k1");//c8
            put(METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelbase.k1");//c8
            put(REAL_METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelavatar.u0");//c8
            put(NETWORK_GET_METHOD_NAME, "d");
            put(NETWORK_START_METHOD_NAME, "f");
            put(MAIN_UI_CLASS_NAME, "com.tencent.mm.ui.LauncherUI");

        }});
        put("2701", new HashMap<String, String>() {{    //8.0.50    没用
            put(NETWORK_CLASS_NAME, "d80.k1");
            put(METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelbase.k1");
            put(REAL_METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelavatar.u0");
        }});
        put("2720_8051", new HashMap<String, String>() {{    //8.0.51    成功
            put(NETWORK_CLASS_NAME, "da0.h1");//c10
            put(METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelbase.l1");//c10
            put(REAL_METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelavatar.v0");   //c12
            put(NETWORK_GET_METHOD_NAME, "d");
            put(NETWORK_START_METHOD_NAME, "g");
            put(MAIN_UI_CLASS_NAME, "com.tencent.mm.ui.LauncherUI");

        }});
        put("2740_8053", new HashMap<String, String>() {{    //8.0.53    通过
            put(NETWORK_CLASS_NAME, "ga0.h1");//c13
            put(METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelbase.l1");//c12
            put(REAL_METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelavatar.v0");//12
            put(NETWORK_GET_METHOD_NAME, "d");
            put(NETWORK_START_METHOD_NAME, "g");
            put(MAIN_UI_CLASS_NAME, "com.tencent.mm.ui.LauncherUI");

        }});
        put("2760_8054", new HashMap<String, String>() {{    //8.0.54    通过
            put(NETWORK_CLASS_NAME, "na0.i1");//c11
            put(METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelbase.m1");//c11
            put(REAL_METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelavatar.v0");//c11
            put(NETWORK_GET_METHOD_NAME, "d");
            put(NETWORK_START_METHOD_NAME, "g");
            put(MAIN_UI_CLASS_NAME, "com.tencent.mm.ui.LauncherUI");

        }});
        put("2780_8055", new HashMap<String, String>() {{    //8.0.55    通过
            put(NETWORK_CLASS_NAME, "aa0.j1");  //c10
            put(METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelbase.n1");//c10
            put(REAL_METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelavatar.v0");//c10
            put(NETWORK_GET_METHOD_NAME, "d");
            put(NETWORK_START_METHOD_NAME, "g");
            put(MAIN_UI_CLASS_NAME, "com.tencent.mm.ui.LauncherUI");

        }});
        put("2800_8056", new HashMap<String, String>() {{    //8.0.56    通过
            put(NETWORK_CLASS_NAME, "ib0.i1");  //c10
            put(METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelbase.n1");//c10
            put(REAL_METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelavatar.v0");//c10
            put(NETWORK_GET_METHOD_NAME, "d");
            put(NETWORK_START_METHOD_NAME, "g");
            put(MAIN_UI_CLASS_NAME, "com.tencent.mm.ui.LauncherUI");
            put(SHARE_TINKER, "com.tencent.tinker.loader.shareutil.ShareTinkerInternals");//C10
            put(SHARE_TINKER_METHOD_NAME, "isTinkerEnabled"); //C10
            // // com.tencent.tinker.loader.shareutil.ShareTinkerInternals#isTinkerEnabled
            // com.tencent.tinker.loader.TinkerLoader#tryLoadPatchFilesInternal

        }});
        put("2820_8057", new HashMap<String, String>() {{    //8.0.56    通过
            put(NETWORK_CLASS_NAME, "bc0.i1");  //静态类
            put(NETWORK_GET_METHOD_NAME, "d");
            put(NETWORK_START_METHOD_NAME, "g");//方法
            put(METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelbase.n1"); //方法参数类型
            put(REAL_METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelavatar.v0");//多态
            put(MAIN_UI_CLASS_NAME, "com.tencent.mm.ui.LauncherUI");
            put(SHARE_TINKER, "com.tencent.tinker.loader.shareutil.ShareTinkerInternals");
            put(SHARE_TINKER_METHOD_NAME, "isTinkerEnabled");
            // // com.tencent.tinker.loader.shareutil.ShareTinkerInternals#isTinkerEnabled
            // com.tencent.tinker.loader.TinkerLoader#tryLoadPatchFilesInternal

        }});
        put("2841_8058", new HashMap<String, String>() {{
            put(NETWORK_CLASS_NAME, "qd0.j1");//c7      //静态类
            put(METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelbase.n1");//c1       // 最终方法的参数类型
            put(REAL_METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelavatar.v0");  //8.0.48 c5
            put(NETWORK_GET_METHOD_NAME, "d");
            put(NETWORK_START_METHOD_NAME, "f");
            put(MAIN_UI_CLASS_NAME, "com.tencent.mm.ui.LauncherUI");


        }});
        put("2860_8060", new HashMap<String, String>() {{
            put(NETWORK_CLASS_NAME, "fe0.j1");//c7      //静态类
            put(METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelbase.n1");//c1       // 最终方法的参数类型
            put(REAL_METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelavatar.v0");  //8.0.48 c5
            put(NETWORK_GET_METHOD_NAME, "d");
            put(NETWORK_START_METHOD_NAME, "g");
            put(MAIN_UI_CLASS_NAME, "com.tencent.mm.ui.LauncherUI");
        }});
        put("2880_8061", new HashMap<String, String>() {{
            put(NETWORK_CLASS_NAME, "xe0.j1");//c7      //静态类
            put(METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelbase.n1");//c1       // 最终方法的参数类型
            put(REAL_METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelavatar.v0");  //8.0.48 c5
            put(NETWORK_GET_METHOD_NAME, "d");
            put(NETWORK_START_METHOD_NAME, "g");
            put(MAIN_UI_CLASS_NAME, "com.tencent.mm.ui.LauncherUI");


        }});
        put("2900_8062", new HashMap<String, String>() {{
            put(NETWORK_CLASS_NAME, "of0.j1");//c7      //静态类
            put(METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelbase.n1");//c1       // 最终方法的参数类型
            put(REAL_METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelavatar.v0");  //8.0.48 c5
            put(NETWORK_GET_METHOD_NAME, "d");
            put(NETWORK_START_METHOD_NAME, "g");
            put(MAIN_UI_CLASS_NAME, "com.tencent.mm.ui.LauncherUI");


        }});
        put("2920_8063", new HashMap<String, String>() {{
            put(NETWORK_CLASS_NAME, "ng0.j1");//c7      //静态类
            put(METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelbase.n1");//c1       // 最终方法的参数类型
            put(REAL_METHOD_PARAM_TYPE_NAME, "com.tencent.mm.modelavatar.v0");  //8.0.48 c5
            put(NETWORK_GET_METHOD_NAME, "d");
            put(NETWORK_START_METHOD_NAME, "g");
            put(MAIN_UI_CLASS_NAME, "com.tencent.mm.ui.LauncherUI");


        }});
    }};

    public static Map<String, String> SETTING;


    public static void initHookParam() {
        if (SETTING != null) {
            return;
        }
        String flavorValue = BuildConfig.mmVersion;
        SETTING = SETTING_SET.get(flavorValue);
    }

}



































