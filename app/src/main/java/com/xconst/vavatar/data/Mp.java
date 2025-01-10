package com.xconst.vavatar.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.xconst.vavatar.hook.HookEntry;

import de.robv.android.xposed.XSharedPreferences;

public class Mp {

    private static final String SHARED_PREF_NAME = "vavatar";
    private static SharedPreferences sharedPreferences = null;

    private static XSharedPreferences xSharedPreferences = null;

    public static final String LAST_UPLOAD_TIME = "LAST_UPLOAD_TIME"; // 上一次上传时间
    public static final String LAST_DOWNLOAD_TIME = "LAST_DOWNLOAD_TIME"; // 上一次下载时间

    private static final String LAST_RETRIEVE_INFO_TIME = "LAST_RETRIEVE_INFO_TIME"; // 上次拉取公告时间

    public static final String UPLOAD_FRE = "UPLOAD_FRE"; // 上传间隔
    public static final String DOWNLOAD_FRE = "DOWNLOAD_FRE"; // 下载间隔

    public static final long MIN_UP_PRE = 1 * 60; // 最小上传间隔

    public static final String TOAST_SWITCH = "TOAST_SWITCH"; // Toast开关
    public static final String NOTIFY_SWITCH = "NOTIFY_SWITCH"; // Notification开关

    public static final String DOWNLOAD_SWITCH = "DOWNLOAD_SWITCH"; // 下载开关


    public static final String IMG_URL = "IMG_URL"; // 静态变量作为键

    public static final String IS_SET_URL = "FIRST_SET_URL"; // 用户是否自定义了源

    private static final String DEFAULT_IMG_URL = "https://avatar.corosy.com/"; // 默认的头像源


    public static final String GLOBAL_SWITCH = "GLOBAL_SWITCH"; // 总开关


    public static final String INFO_FROM_DEV_URL = "https://json.api.corosy.com/vavatarinfo";   //公告地址

    private static final String INFO_FROM_DEV_CONTENT = "INFO_FROM_DEV";    //公告内容


    @Deprecated
    private static SharedPreferences getSp(Context context) {

        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }

    private static XSharedPreferences getSpX(Context context) {
        // 使用 XSharedPreferences 读取指定包名和文件名的 SharedPreferences
        if (xSharedPreferences == null) {
            // XSharedPreferences 需要目标包名和文件名作为参数
            xSharedPreferences = new XSharedPreferences("com.tencent.mm", SHARED_PREF_NAME);
            // 确保 SharedPreferences 文件对外可读
            xSharedPreferences.makeWorldReadable();
        }
        return xSharedPreferences;
    }


    public static void onTryDownloading(Context context) {
        long currentTimeSeconds = System.currentTimeMillis() / 1000; // 当前时间戳（精确到秒）
        saveData(context, LAST_DOWNLOAD_TIME, currentTimeSeconds);
    }

    public static void onRetrievedInfoFromDev(Context context, Object value) {
        long currentTimeSeconds = System.currentTimeMillis() / 1000; // 当前时间戳（精确到秒）
        saveData(context, LAST_RETRIEVE_INFO_TIME, currentTimeSeconds);
        saveData(context, INFO_FROM_DEV_CONTENT, value);
    }


    public static boolean globalSwitch(Context context) {
        return loadBool(context, GLOBAL_SWITCH);
    }

    public static boolean downloadSwitch(Context context) {
        return loadBool(context, DOWNLOAD_SWITCH);
    }

    public static boolean notifySwitch(Context context) {
        return loadBool(context, NOTIFY_SWITCH);
    }

    public static boolean toastSwitch(Context context) {
        return loadBool(context, TOAST_SWITCH);
    }

    public static long getLastInfoTime(Context context) {
        return loadLong(context, LAST_RETRIEVE_INFO_TIME);
    }

    public static String getInfoFromDevFromSp(Context context) {
        return loadStr(context, INFO_FROM_DEV_CONTENT);
    }

    public static long getUploadFre(Context context) {
        long l = loadLong(context, UPLOAD_FRE);
        if (l < MIN_UP_PRE) {
            l = MIN_UP_PRE;
        }
        return l;
    }

    public static String getDownloadUrl(Context context) {
        if (!loadBool(context, IS_SET_URL)) {
            return DEFAULT_IMG_URL;
        }
        return loadStr(context, IMG_URL);
    }

    public static long getDownloadFre(Context context) {
        long l = loadLong(context, DOWNLOAD_FRE);
        if (l < MIN_UP_PRE) {
            l = MIN_UP_PRE;
        }
        return l;
    }

    public static long getLastUploadTime(Context context) {
        return loadLong(context, LAST_UPLOAD_TIME);
    }

    /**
     * @return 当前时间-目标时间
     */
    public static long calculateTimeDifference(Context context, String key) {
        long savedTimestamp = loadLong(context, key);
        long currentTimestamp = System.currentTimeMillis() / 1000;
        return currentTimestamp - savedTimestamp;
    }

    public static void saveUrl(Context context, String key, Object value) {
        saveData(context, IS_SET_URL, true);
        saveData(context, key, value);
    }

    public static void saveData(Context context, String key, Object value) {

        SharedPreferences.Editor editor = getSp(context).edit();
        if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        }

        editor.apply();

    }

    public static void saveData(Context context) {
        long currentTimeSeconds = System.currentTimeMillis() / 1000; // 当前时间戳（精确到秒）
        saveData(context, LAST_UPLOAD_TIME, currentTimeSeconds);
    }


    public static String loadStr(Context context, String key) {
        SharedPreferences sharedPreferences = getSp(context);
        return sharedPreferences.getString(key, "none.");
    }

    public static long loadLong(Context context, String key) {
        SharedPreferences sharedPreferences = getSp(context);
        return sharedPreferences.getLong(key, 0);
    }

    public static boolean loadBool(Context context, String key) {
        SharedPreferences sharedPreferences = getSp(context);
        return sharedPreferences.getBoolean(key, false);
    }


    // 计算时间差（秒）
    public static boolean shouldUploadNow(Context context) {    //现在是否要下上传头像

        long l = calculateTimeDifference(context, LAST_UPLOAD_TIME);
        if (l > getUploadFre(context)) {
            return true;
        }
        return false;
    }

    public static boolean shouldDownloadNow(Context context) {  //现在是否要下载头像
        boolean aSwitch = downloadSwitch(context);
        if (!aSwitch) {
            return false;
        }
        long l = calculateTimeDifference(context, LAST_DOWNLOAD_TIME);
        if (l > getDownloadFre(context)) {
            return true;
        }
        return false;
    }

    public static boolean shouldRefreshInfo(Context context) { //现在是否要获取公告
        long l = loadLong(context, LAST_RETRIEVE_INFO_TIME);
        long currentTimeSeconds = System.currentTimeMillis() / 1000; // 当前时间戳（精确到秒）
        return l + 3600 * 24 < currentTimeSeconds;
    }

}