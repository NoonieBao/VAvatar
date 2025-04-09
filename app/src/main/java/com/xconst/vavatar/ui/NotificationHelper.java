package com.xconst.vavatar.ui;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.widget.Toast;
import com.xconst.vavatar.data.Mp;

public class NotificationHelper {

    private static final String CHANNEL_ID = "RdAvatar";

    public static void sendNotification(Context context, String title, String message) {

        boolean bq = Mp.toastSwitch(context);

        if (bq) {
            Toast toast = Toast.makeText(context, title + " " + message, Toast.LENGTH_SHORT);
            toast.show();
        }

        boolean b = Mp.notifySwitch(context);
        if (!b) {
            return;
        }

        createNotificationChannel(context);

        // 获取 NotificationManager
        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification.Builder builder = new Notification.Builder(context, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle(title)
                .setContentText(message);
        // 构建通知
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
//                .setSmallIcon(android.R.drawable.ic_dialog_info)
//                .setContentTitle(title)
//                .setContentText(message)
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        int id = (int) System.nanoTime();
        notificationManager.notify(id, builder.build());
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                String ns = Context.NOTIFICATION_SERVICE;
                NotificationManager notificationManager1 = (NotificationManager) context.getSystemService(ns);
                notificationManager1.cancel(id);

            }
        }, 10000);
    }

    private static void createNotificationChannel(Context context) {
        // 创建通知渠道（适用于 Android 8.0 及以上版本）
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "RdAvatar",
                    NotificationManager.IMPORTANCE_DEFAULT);

            channel.setImportance(NotificationManager.IMPORTANCE_MIN);
            // 注册通知渠道
            NotificationManager notificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            notificationManager.createNotificationChannel(channel);
        }
    }
}
