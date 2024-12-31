package com.xconst.vavatar.ui;

import static com.xconst.vavatar.ui.SettingUi.generateCheckBox;
import static com.xconst.vavatar.ui.SettingUi.generateEditText;
import static com.xconst.vavatar.ui.SettingUi.setViewGroupsVisibility;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xconst.vavatar.data.Mp;

public class Vui implements View.OnClickListener {


    @Override
    public void onClick(View v) {
        generateUI(v.getContext());
    }

     private void generateUI(Context context) {
        // 创建 AlertDialog.Builder 对象
        final String title = "VAvatar设置";

        TextView titleTextView = new TextView(context);


        EditText updateFre = generateEditText(context, "上传频率(s)", true);

        CheckBox shouldDownload = generateCheckBox(context, "自动下载");
        EditText downloadUrl = generateEditText(context, "URL", false);
        EditText downloadFre = generateEditText(context, "下载频率(s)", true);

        CheckBox shouldNotify = generateCheckBox(context, "通知提醒");
        CheckBox shouldToast = generateCheckBox(context, "Toast提醒");


        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);

        builder.setPositiveButton("好", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        LinearLayout layout = generateSettingLayout(context);
        builder.setView(layout);


        Button information = new Button(context);
        information.setText("信息和帮助");
        information.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/NoonieBao/QAvatar"));
            context.startActivity(intent);
        });



        titleTextView.setText("VAvatar");
        titleTextView.setGravity(Gravity.CENTER); // 设置文本居中

        TextView infoFromDevView = new TextView(context);
        infoFromDevView.setText(Mp.getInfoFromDevFromSp(context) + "\n刷新时间:" + Mp.getLastInfoTime(context));




        shouldDownload.setText("自动下载");

        shouldDownload.setOnCheckedChangeListener((buttonView, isChecked) -> {
            setViewGroupsVisibility(isChecked, downloadUrl, downloadFre);
        });

        LinearLayout autoDownloadWrapper = new LinearLayout(context);
        autoDownloadWrapper.setOrientation(LinearLayout.VERTICAL);
        autoDownloadWrapper.setBackgroundColor(Color.rgb(170, 187, 255)); // 设置为红色


        Button saveSetting = new Button(context);
        saveSetting.setText("保存设置");

        autoDownloadWrapper.addView(shouldDownload);
        autoDownloadWrapper.addView(downloadUrl);
        autoDownloadWrapper.addView(downloadFre);

        updateFre.setText(String.valueOf(Mp.getUploadFre(context)));
//            target.setText(String.valueOf(Mp.getTargetAcc(activity)));

        downloadUrl.setText(Mp.getDownloadUrl(context));
        downloadFre.setText(String.valueOf(Mp.getDownloadFre(context)));

//            totalSwitch.setChecked(Mp.globalSwitch(activity));
        shouldDownload.setChecked(Mp.downloadSwitch(context));
        shouldNotify.setChecked(Mp.notifySwitch(context));
        shouldToast.setChecked(Mp.toastSwitch(context));

        setViewGroupsVisibility(shouldDownload.isChecked(), downloadUrl, downloadFre);

        layout.addView(titleTextView);
        layout.addView(infoFromDevView);
//            layout.addView(totalSwitch);
        layout.addView(updateFre);
        layout.addView(autoDownloadWrapper);
        layout.addView(shouldNotify);
        layout.addView(shouldToast);
        layout.addView(saveSetting);
        layout.addView(information);

        saveSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mp.saveData(context, Mp.DOWNLOAD_SWITCH, shouldDownload.isChecked());
                Mp.saveUrl(context, Mp.IMG_URL, downloadUrl.getText().toString());
                Mp.saveData(context, Mp.DOWNLOAD_FRE, Long.valueOf(downloadFre.getText().toString()));
                Mp.saveData(context, Mp.UPLOAD_FRE, Long.valueOf(updateFre.getText().toString()));
//                    Mp.saveData(activity, Mp.TARGRT_ACC, Long.valueOf(target.getText().toString()));

//                    Mp.saveData(activity, Mp.GLOBAL_SWITCH, totalSwitch.isChecked());
                Mp.saveData(context, Mp.NOTIFY_SWITCH, shouldNotify.isChecked());
                Mp.saveData(context, Mp.TOAST_SWITCH, shouldToast.isChecked());

                Toast.makeText(context, "设置已保存", Toast.LENGTH_SHORT).show();
            }
        });




        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private LinearLayout generateSettingLayout(Context context){
        LinearLayout layout = new LinearLayout(context);
        layout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(48, 24, 48, 24); // 添加内边距增强可读性
        return layout;

    }

}
