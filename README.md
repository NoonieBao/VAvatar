<div align="center">

<h1>VAvatar</h1>
<h2>自动更换微信头像</h2>
</div>

<div align="center">


  [![Stars](https://img.shields.io/github/stars/nooniebao/vavatar?label=stars)](https://github.com/nooniebao/vavatar)

</div>

# 适配版本
8.0.47、8.0.48、8.0.49、~~8.0.50~~、8.0.51、8.0.53、8.0.54、8.0.55

不支持`8.0.50` ！

8.0.46或许有效，但由于我无法登陆旧版本，未能进行测试。

# 触发时机
`com.tencent.mm.ui.LauncherUI#onResume()`方法执行时。

说人话就是每次**启动打开vx主界面或切屏回到vx主界面**会执行Vavatar的逻辑。


# Vavatar设置入口
![U9PEXUIWCDCA$Q0BCPVWWDF_tmb](https://github.com/user-attachments/assets/a0bcedd7-6fb7-4db1-8955-8188e5d51db4)

# 用法
- Vavatar总是尝试从上传`默认头像路径`的图片到用户头像 （这个文件路径会打印在Vavatar的设置界面）。
- 可以手动拷贝 1:1 的 jpg或png到`默认头像路径`，但请设置660权限。
- Vavatar提供了自动下载随机头像功能，填入相应url即可。（具体请见https://github.com/NoonieBao/QAvatar ），此功能可以禁用。
- Vavatar的上传和下载受到`冷却时间`控制，可以设置相应的冷却时间

# 头像源

- https://avatar.corosy.com/
- https://uglyavatar.corosy.com

> https://avatar.corosy.com/ 可以返回一张远古的潮流头像
> 
> https://uglyavatar.corosy.com/ 可以返回一张丑陋头像. 必须指出: 丑陋头像的生成依赖于txstc55的项目ugly-avatar


# 版本说明
> Vavatar的工作基于以下版本，如果Vavatar不能工作，请尝试下载对应版本并覆盖安装

微信 8.0.55 for Android 20241218 Latest
发布版本: 8.0.55(2780)
更新日期: 2024-12-18 12:34:30 (UTC)
下载地址: https://dldir1v6.qq.com/weixin/android/weixin8055android2780_0x28003734_arm64.apk
Sha256: 4ea6dab90a901846c76b43abfe75130c3b25d4f129c770c5b6e1ec1e101834dd

微信 8.0.54 for Android20241121
发布版本: 8.0.54(2760)
更新日期: 2024-11-21 14:16:27 (UTC)
下载地址: https://dldir1.qq.com/weixin/android/weixin8054android2760_0x28003636_arm64.apk
Sha256: 97b589772aca1fb8b0887e6109df3dc00234b1c14c452c6bcc90435e47e0049b

微信 8.0.53 for Android 20241015
发布版本: 8.0.53(2740)
更新日期: 2024-10-15 08:21:44 (UTC)
下载地址: https://dldir1.qq.com/weixin/android/weixin8053android2740_0x28003533_arm64.apk
Sha256: 180216ea4ecf6825760e0379d32696518f529745d1dcc89a763e2b1431e3dc07

微信 8.0.51 for Android 20240919
发布版本: 8.0.51(2720)
更新日期: 2024-09-19 07:15:41 (UTC)
下载地址: https://dldir1.qq.com/weixin/android/weixin8051android2720_0x28003333_arm64_1.apk
Sha256: 6915bff4422c7d5ec34cd2d743b19946cf40e2d26987be7a86286bfe054116d3

微信 8.0.49 for Android 20240520
发布版本: 8.0.49(2600)
更新日期: 2024-05-20 10:15:16 (UTC)
下载地址: https://dldir1.qq.com/weixin/android/weixin8049android2600_0x2800313d_arm64.apk
Sha256: e8402abfcd88f540d00ddeac451c847deed0d1b162d41fa3b2c6eb86f4c4b5b8

微信 8.0.48 for Android 20240322
发布版本: 8.0.48(2580)
更新日期: 2024-03-22 12:23:29 (UTC)
下载地址: https://dldir1.qq.com/weixin/android/weixin8048android2580_0x28003036_arm64.apk
Sha256: cf7914632e78b9a8e8bd84fe01e667ee64789c15b556da315b9c0a8a87aa3646

微信 8.0.47 for Android 20240207
发布版本: 8.0.47(2560)
更新日期: 2024-02-07 09:13:40 (UTC)
下载地址: https://dldir1.qq.com/weixin/android/weixin8047android2560_0x28002f36_arm64.apk
Sha256: 81edded6ec9d12644a62365e6e09d7780ca7b5985a478d66e34514681b8e4868

微信 8.0.46 for Android 20240123
发布版本: 8.0.46(2540)
更新日期: 2024-01-23 06:18:27 (UTC)
下载地址: https://dldir1.qq.com/weixin/android/weixin8046android2540_0x28002e34_arm64.apk
Sha256: 8bab0e24bec94c26c898afd9c7454879588926dc7c19e6d688fa9f25b53d7a77

> 微信历史版本由 https://github.com/DJB-Developer/wechat-android-history-versions 收集