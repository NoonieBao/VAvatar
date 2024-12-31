package com.xconst.vavatar.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xconst.vavatar.R;
import com.xconst.vavatar.data.Mp;
import com.xconst.vavatar.utils.RefUtil;

import java.lang.reflect.Constructor;

import de.robv.android.xposed.XposedBridge;

public class SettingUi {


    static final String TAG = "SettingUi ";

    public static CheckBox generateCheckBox(Context context, String text) {
        CheckBox checkBox = new CheckBox(context);
        checkBox.setText(text);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(0, 16, 0, 16); // 添加间距
        checkBox.setLayoutParams(layoutParams);
        return checkBox;
    }

    public static void setViewGroupsVisibility(boolean b, View... groups) {
        for (View group : groups) {
            group.setVisibility(b ? View.VISIBLE : View.GONE);
        }
    }

    public static synchronized void addSettingEntry(Activity activity, ViewGroup viewGroup, Class<?> CnFormSimpleItem) {

        // 创建一个新的 RelativeLayout 作为布局视图

        View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);

        if (childAt.getId() == R.id.setting2Activity_mcHookTool) {
            XposedBridge.log(TAG + "无需重复添加设置控件");
            return;
        } else {
            XposedBridge.log(TAG + "go");

        }

        ViewGroup layoutView = null;
        try {
            if (CnFormSimpleItem != null) {
                for (Constructor<?> constructor : CnFormSimpleItem.getConstructors()) {
                    XposedBridge.log("SettingHook " + constructor);
                }
                Constructor<?>[] constructors = CnFormSimpleItem.getConstructors();
                for (Constructor<?> constructor : constructors) {
                    Class<?>[] parameters = constructor.getParameterTypes();
                    if (parameters.length == 1) {
                        constructor.setAccessible(true);
                        layoutView = (ViewGroup) constructor.newInstance(activity);
                    }
                }
                layoutView.setId(R.id.setting2Activity_mcHookTool);
                RefUtil.invoke_virtual(layoutView, "setLeftText", "QAvatar",
                        CharSequence.class);
                RefUtil.invoke_virtual(layoutView, "setBgType", 2, int.class);
            }
        } catch (Exception e) {
            XposedBridge.log("SettingHook " + "CnFormSimpleItem 失败" + e.getMessage());

        }

        if (layoutView == null) {
            layoutView = new LinearLayout(activity);
            layoutView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT));
            ((LinearLayout) layoutView).setOrientation(LinearLayout.VERTICAL); // 设置为垂直方向
            ((LinearLayout) layoutView).setGravity(Gravity.CENTER); // 设置内容居中
        }

        View.OnClickListener onClickListener = v -> {
            // 创建对话框构建器
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);

            LinearLayout layout = new LinearLayout(activity);
            layout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.setPadding(48, 24, 48, 24); // 添加内边距增强可读性

            Button information = new Button(activity);
            information.setText("信息和帮助");
            information.setOnClickListener(view -> {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/NoonieBao/QAvatar"));
                activity.startActivity(intent);
            });

            EditText updateFre = generateEditText(activity, "更新频率(s)", true);
            EditText downloadUrl = generateEditText(activity, "URL", false);
            EditText downloadFre = generateEditText(activity, "下载频率(s)", true);

            TextView titleTextView = new TextView(activity);
            titleTextView.setText("QAvatar");
            titleTextView.setGravity(Gravity.CENTER); // 设置文本居中

            TextView infoFromDevView = new TextView(activity);
            infoFromDevView.setText(Mp.getInfoFromDevFromSp(activity) + "\n刷新时间:" + Mp.getLastInfoTime(activity));


//            CheckBox totalSwitch = new CheckBox(activity);
//            totalSwitch.setText("总开关");

            CheckBox shouldDownload = new CheckBox(activity);
            shouldDownload.setText("自动下载");

            shouldDownload.setOnCheckedChangeListener((buttonView, isChecked) -> {
                setViewGroupsVisibility(isChecked, downloadUrl, downloadFre);
            });

            LinearLayout autoDownloadWrapper = new LinearLayout(activity);
            autoDownloadWrapper.setOrientation(LinearLayout.VERTICAL);
            autoDownloadWrapper.setBackgroundColor(Color.rgb(170, 187, 255)); // 设置为红色

            CheckBox shouldNotify = generateCheckBox(activity, "通知提醒");
            CheckBox shouldToast = generateCheckBox(activity, "Toast提醒");

            Button saveSetting = new Button(activity);
            saveSetting.setText("保存设置");

            autoDownloadWrapper.addView(shouldDownload);
            autoDownloadWrapper.addView(downloadUrl);
            autoDownloadWrapper.addView(downloadFre);

            updateFre.setText(String.valueOf(Mp.getUploadFre(activity)));
//            target.setText(String.valueOf(Mp.getTargetAcc(activity)));

            downloadUrl.setText(Mp.getDownloadUrl(activity));
            downloadFre.setText(String.valueOf(Mp.getDownloadFre(activity)));

//            totalSwitch.setChecked(Mp.globalSwitch(activity));
            shouldDownload.setChecked(Mp.downloadSwitch(activity));
            shouldNotify.setChecked(Mp.notifySwitch(activity));
            shouldToast.setChecked(Mp.toastSwitch(activity));

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
                    Mp.saveData(activity, Mp.DOWNLOAD_SWITCH, shouldDownload.isChecked());
                    Mp.saveUrl(activity, Mp.IMG_URL, downloadUrl.getText().toString());
                    Mp.saveData(activity, Mp.DOWNLOAD_FRE, Long.valueOf(downloadFre.getText().toString()));
                    Mp.saveData(activity, Mp.UPLOAD_FRE, Long.valueOf(updateFre.getText().toString()));
//                    Mp.saveData(activity, Mp.TARGRT_ACC, Long.valueOf(target.getText().toString()));

//                    Mp.saveData(activity, Mp.GLOBAL_SWITCH, totalSwitch.isChecked());
                    Mp.saveData(activity, Mp.NOTIFY_SWITCH, shouldNotify.isChecked());
                    Mp.saveData(activity, Mp.TOAST_SWITCH, shouldToast.isChecked());

                    Toast.makeText(activity, "设置已保存", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setView(layout);
            final Dialog dialog = builder.create();

            // 设置对话框居中显示
            WindowManager.LayoutParams layoutParams = dialog.getWindow().getAttributes();
            layoutParams.gravity = Gravity.CENTER;
            dialog.getWindow().setAttributes(layoutParams);

            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int widthPixels = displayMetrics.widthPixels;
            int heightPixels = displayMetrics.heightPixels;

            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {
                    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                    layoutParams.copyFrom(dialog.getWindow().getAttributes());
                    layoutParams.width = widthPixels; // 设置宽度为包裹内容
                    layoutParams.height = heightPixels; // 设置高度为包裹内容
                    dialog.getWindow().setAttributes(layoutParams);
                }
            });

            dialog.show();
        };

        layoutView.setOnClickListener(onClickListener);

        viewGroup.addView(layoutView);

    }

    public static EditText generateEditText(Context context, String hint, boolean isNum) {
        EditText editText = new EditText(context);
        editText.setHint(hint);
        if (isNum) {
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);

        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(0, 16, 0, 16); // 添加间距
        editText.setLayoutParams(layoutParams);
        return editText;
    }

}
