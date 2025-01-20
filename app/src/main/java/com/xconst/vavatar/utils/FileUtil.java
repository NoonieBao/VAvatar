package com.xconst.vavatar.utils;

import android.content.Context;


import com.xconst.vavatar.hook.HookEntry;

import java.io.File;
import java.util.Arrays;
import java.util.Random;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;

public class FileUtil {

    public static final String nextTick="nextTick";
    public static final String nextAvatar=nextTick+".png";

    public static final String theUsedJpg ="Used.png";
    public static final String TAG = HookEntry.TAG;

    final static String reDir="vavatar";

    private static Context getContext(Object args) {
        if(args instanceof  Context){
            return (Context) args;
        }
        if(args instanceof XC_MethodHook.MethodHookParam){
            XC_MethodHook.MethodHookParam param = (XC_MethodHook.MethodHookParam) args;
            return (Context) param.args[0];
        }
        return null;
    }

    //设置成功
    public synchronized static void prepareAvatar(Object arg){
        Context context=getContext(arg);

        File file = getAvatarDir(context);

        randomSetNext(file);
    }

    public synchronized static void avatarChanged(Object arg){
        Context context=getContext(arg);
        File file = getAvatarDir(context);

        String TAG="MulDexHookRes ";
        File target = new File(file ,nextAvatar);
        XposedBridge.log(TAG+target);

        if(target.exists()){
            File file1 = new File(file, System.nanoTime() + theUsedJpg);
            XposedBridge.log(TAG+file1.getPath());

            boolean b = target.renameTo(file1);

            if(b){
                XposedBridge.log(TAG+target.getName() +" delete");
                return;
            }
        }

        XposedBridge.log(TAG +" avatarChanged err");

    }
    public synchronized static void randomSetNext(File dir) {
        File[] files = dir.listFiles();
        final boolean[] hasUnUsed = {false};
        File[] filteredFiles = Arrays.stream(files)
                .filter(f -> {

                    if (f.getName().contains(theUsedJpg)) {
                        return false;           //已经使用过的
                    }
                    if (f.getName().contains(nextAvatar)) {
                        hasUnUsed[0] = true;    //已经准备好了下一张
                    }
                    return true;
                }).toArray(File[]::new);

        if(hasUnUsed[0]){
            XposedBridge.log(TAG+"已存在"+nextAvatar);
            return;
        }
        if(filteredFiles.length==0){
            XposedBridge.log(TAG+"没有图片");
            return;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(filteredFiles.length);

        File target = filteredFiles[randomIndex];
        File dist = new File(dir, nextAvatar);

        if(!dist.exists()){
            boolean b = target.renameTo(dist);
            if(b){
                XposedBridge.log(TAG+"重命名成功");
                return;
            }
        }

        XposedBridge.log(TAG+"重命名失败");

    }

    public static File getAvatarDir(Context context) {
        File filesDir = context.getExternalFilesDir(null);

        File dir = new File(filesDir, reDir);
        if(!dir.exists()){
            dir.mkdirs();
        }
        return dir;
    }

    public static File getTargetPath(Context context){
        return new File(getAvatarDir(context), nextAvatar);
    }



}
