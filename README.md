# HeadFirstQRCode

Quick Response Code，二维码的一种，1994 年由日本 DENSO WAVE 公司发明。


学习一下二维码相关的东西，学一下 zxing，目标：
- [x] 集成了解 zxing， 依赖是 `api 'com.google.zxing:core:3.4.1'` 版本看 release 日志；
- [x] 二维码生成功能，设置内容然后生成二维码，直接依赖 zxing 库，使用它提供的功能即可，参考 QRCode 类;
- [x] 扫码识别二维码功能：有点坑，得扣代码；


zxing github 开发文档 : https://github.com/zxing/zxing/wiki/Getting-Started-Developing

这文档写得不咋地，推荐用 IntentIntegrator 来做，具体是下载一个 App 然后用它来扫 - -。所以要做扫码功能，得自己扣代码实现。


## zxing 源码工程

clone 了 zxing的源码工程，是 Java 的而不是 Android 的，有点乱，而且不能直接用 AS 编译。

目录如下：

```
.
├── AUTHORS
├── CHANGES
├── LICENSE
├── NOTICE
├── README.md
├── android
├── android-core
├── android-integration
├── core
├── docs
├── javase
├── pom.xml
├── src
├── zxing.appspot.com
└── zxingorg
```

`api 'com.google.zxing:core:3.4.1'` 依赖的源码是在 `core` 目录下，而要做扫码需要扣 android 和 android-core 的代码，按需扣。

我自己新建了 zxing 模块，把 android 和 android-core 的代码 copy 了进去，然后跑起来了，打开 CaptureActivity 就是了。

zxing 能跑起来的 Demo 功能很多，很多不需要的，还是需要自己扣，代码太多不想搞了。。。- -


搜了下封装 zxing 的库，发现也不少：

https://github.com/jenly1314/ZXingLite
https://github.com/yuzhiqiang1993/zxing


还有一些文章：

ZXing应用详解 : https://www.jianshu.com/p/6607e69b1121

