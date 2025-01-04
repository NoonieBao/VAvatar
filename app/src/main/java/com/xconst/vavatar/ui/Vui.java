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
import com.xconst.vavatar.utils.FileUtil;

public class Vui implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        generateUI(v.getContext());
    }

    private void generateUI(Context context) {

        final String title = "VAvatar设置";

        TextView titleTextView = new TextView(context);
        titleTextView.setText("VAvatar");
        titleTextView.setGravity(Gravity.CENTER); // 设置文本居中


        TextView infoFromDevView = new TextView(context);
        infoFromDevView.setText(Mp.getInfoFromDevFromSp(context) + "\n公告刷新时间:" + Mp.getLastInfoTime(context));


        TextView pathToAvatar = new TextView(context);
        pathToAvatar.setText("`默认头像路径:`" + FileUtil.getAvatarDir(context).getAbsolutePath() + "`");


        LinearLayout updateFreWrapper = new LinearLayout(context);
        TextView updateFreTv = new TextView(context);
        EditText updateFreEdit = generateEditText(context, "上传频率(s)", true);
        updateFreTv.setText("头像上传冷却时间(s)");
        updateFreEdit.setText(String.valueOf(Mp.getUploadFre(context)));
        updateFreWrapper.setOrientation(LinearLayout.VERTICAL);
        updateFreWrapper.addView(updateFreEdit);
        updateFreWrapper.addView(updateFreTv);


        LinearLayout autoDownloadWrapper = new LinearLayout(context);
        CheckBox shouldDownload = generateCheckBox(context, "自动下载");
        EditText downloadUrl = generateEditText(context, "URL", false);
        EditText downloadFre = generateEditText(context, "下载频率(s)", true);
        TextView autoDownloadTv = new TextView(context);
        shouldDownload.setText("自动下载");
        shouldDownload.setOnCheckedChangeListener((buttonView, isChecked) -> {
            setViewGroupsVisibility(isChecked, downloadUrl, downloadFre);
        });
        autoDownloadTv.setText("自动从指定url下载图片到`默认头像路径`，请确保来源可信。图片要求1:1，jpg或者png格式。");
        downloadUrl.setText(Mp.getDownloadUrl(context));
        downloadFre.setText(String.valueOf(Mp.getDownloadFre(context)));
        shouldDownload.setChecked(Mp.downloadSwitch(context));
        autoDownloadWrapper.setOrientation(LinearLayout.VERTICAL);
        autoDownloadWrapper.addView(shouldDownload);
        autoDownloadWrapper.addView(downloadUrl);
        autoDownloadWrapper.addView(downloadFre);
        autoDownloadWrapper.addView(autoDownloadTv);


        CheckBox shouldNotify = generateCheckBox(context, "通知提醒");
        CheckBox shouldToast = generateCheckBox(context, "Toast提醒");
        shouldNotify.setChecked(Mp.notifySwitch(context));
        shouldToast.setChecked(Mp.toastSwitch(context));


        Button saveSetting = new Button(context);
        saveSetting.setText("保存设置");


        Button gotoGithub = new Button(context);
        gotoGithub.setText("反馈&开源&帮助");
        gotoGithub.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/NoonieBao/VAvatar"));
            context.startActivity(intent);
        });
        

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

        infoFromDevView.setBackgroundColor(Color.rgb(170, 187, 255)); // aabbff
        pathToAvatar.setBackgroundColor(Color.rgb(187, 255, 170)); // bbffaa
        updateFreWrapper.setBackgroundColor(Color.rgb(170, 187, 255)); // aabbff
        autoDownloadWrapper.setBackgroundColor(Color.rgb(187, 255, 170)); // bbffaa

        setViewGroupsVisibility(shouldDownload.isChecked(), downloadUrl, downloadFre);

        layout.addView(titleTextView);
        layout.addView(infoFromDevView);
        layout.addView(pathToAvatar);
        layout.addView(updateFreWrapper);
        layout.addView(autoDownloadWrapper);
        layout.addView(saveSetting);
        layout.addView(gotoGithub);

        saveSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mp.saveData(context, Mp.DOWNLOAD_SWITCH, shouldDownload.isChecked());
                Mp.saveUrl(context, Mp.IMG_URL, downloadUrl.getText().toString());
                Mp.saveData(context, Mp.DOWNLOAD_FRE, Long.valueOf(downloadFre.getText().toString()));
                Mp.saveData(context, Mp.UPLOAD_FRE, Long.valueOf(updateFreEdit.getText().toString()));
                Mp.saveData(context, Mp.NOTIFY_SWITCH, shouldNotify.isChecked());
                Mp.saveData(context, Mp.TOAST_SWITCH, shouldToast.isChecked());
                Toast.makeText(context, "设置已保存", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private LinearLayout generateSettingLayout(Context context) {
        LinearLayout layout = new LinearLayout(context);
        layout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(48, 24, 48, 24); // 添加内边距增强可读性
        return layout;

    }

}
