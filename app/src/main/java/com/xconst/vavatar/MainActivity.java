package com.xconst.vavatar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置Activity的布局
        setContentView(R.layout.activity_main);


        TextView info = findViewById(R.id.info);
        info.setText("此界面没有实际功能。模块的设置入口寄生于\"微信->我->个人信息中\"。如未出现，请检查是否安装了对应的Vavatar版本。");



        TextView viewById = findViewById(R.id.mmVersion);
        viewById.setText("当前安装的Vavatar是针对" + BuildConfig.mmVersion + "版本微信的，请仔细对照github_Readme,使用配套的Vavatar和微信。");


        TextView network = findViewById(R.id.network);
        network.setText("你的网络能访问CloudFlare.com吗？图片服务器依赖于CloudFlare网络，防火墙可能导致Vavatar无法从下默认头像源下载图片。");

        TextView gotoGithub = findViewById(R.id.gotoGithub);
        gotoGithub.setText("如果您是第一次使用Vavatar，我强烈建议先前往github阅读Readme。使用遇到问题，可前往github仓库提出issue，获得解决方案。");




    }

    // 点击按钮时的回调方法
    public void onButtonClick(View view) {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/NoonieBao/VAvatar"));
        view.getContext().startActivity(intent);

    }
}
