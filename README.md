<div align="center">

<h1>VAvatar</h1>
<h2>自动更换微信头像</h2>
</div>

<div align="center">


  [![Stars](https://img.shields.io/github/stars/nooniebao/vavatar?label=stars)](https://github.com/nooniebao/vavatar)

</div>

# 适配版本
8.0.47、8.0.48、8.0.49、~~8.0.50~~、8.0.51、8.0.53、8.0.54、8.0.55、8.0.56

# 触发时机
`com.tencent.mm.ui.LauncherUI#onResume()`方法执行时。

说人话就是每次**启动打开vx主界面或切屏回到vx主界面**会执行Vavatar的逻辑。


# Vavatar设置入口
![U9PEXUIWCDCA$Q0BCPVWWDF_tmb](https://github.com/user-attachments/assets/a0bcedd7-6fb7-4db1-8955-8188e5d51db4)

# 用法
- Vavatar总是尝试从上传`默认头像路径`的图片到用户头像 （这个文件路径会打印在Vavatar的设置界面）。
- 可以手动拷贝 1:1 的 jpg或png到`默认头像路径`，但请设置660权限。
- Vavatar提供了自动下载随机头像功能，填入相应url即可。此功能可以禁用。
- Vavatar的上传和下载受到`冷却时间`控制，可以设置相应的冷却时间

# 头像源

- https://avatar.corosy.com/
- https://uglyavatar.corosy.com

> https://avatar.corosy.com/ 可以返回一张远古的潮流头像
> 
> https://uglyavatar.corosy.com/ 可以返回一张丑陋头像. 必须指出: 丑陋头像的生成依赖于txstc55的项目ugly-avatar


# 版本说明（必读）

> 使用Vavatar前，请务必确认设备中安装的APK文件与下方列出的完全一致。仅比较版本号（如8056）不足以确保兼容性，必须Sha256对应。
> Vavatar的工作基于以下版本，如果Vavatar不能工作，请尝试通过下方链接下载对应版本并覆盖安装

微信 8.0.57 for Android 20250320 Latest
发布版本: 8.0.57
更新日期: 2025-03-20 12:33:03 (UTC)
下载地址: https://dldir1v6.qq.com/weixin/android/weixin8057android2820_0x28003933_arm64.apk
Sha256: 1d2a9bde01377b607abb7e2a2c9f9e172cb3cb7049fd3f99e49b7b47c048dbd8

微信 8.0.56 for Android 20250108 Latest
发布版本: 8.0.56
更新日期: 2025-01-08 02:47:02 (UTC)
下载地址: https://dldir1v6.qq.com/weixin/android/weixin8056android2800_0x28003832_arm64.apk
Sha256: 469125f8e05a8f762a5d5b881e55a91882ad8a6c2643d3728261a23a97216167

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

微信 8.0.58 for Android 20250527
发布版本: 8.0.58
更新日期: 2025-05-27 08:25:25 (UTC)
下载地址: https://dldir1v6.qq.com/weixin/android/weixin8058android2841_0x28003a3f_arm64.apk
Sha256: aa7f0716ac4e338d070680a47e1fdc8a8e4a3e1d8b3622268bc23054e564a673

微信 8.0.60 for Android 20250609
发布版本: 8.0.60
更新日期: 2025-06-09 12:38:53 (UTC)
下载地址: https://dldir1v6.qq.com/weixin/android/weixin8060android2860_0x28003c39_arm64.apk
Sha256: db84d6e93b591d3ececdfa9596102920c57e34c8320ed2ee2ff2602d1c40eb23

微信 8.0.61 for Android 20250702
发布版本: 8.0.61
更新日期: 2025-07-02 08:26:47 (UTC)
下载地址: https://dldir1v6.qq.com/weixin/android/weixin8061android2880_0x28003d34_arm64.apk
Sha256: 682fa29567b523cfcd62fa3687ceea94c962207b7d29f2962d798ce0ac789be3

> 微信历史版本由 https://github.com/DJB-Developer/wechat-android-history-versions 收集
