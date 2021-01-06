# HeadFirstQRcode

学习一下二维码相关的东西，学一下 zxing。

- [x] 了解 zxing， 依赖是 `api 'com.google.zxing:core:3.4.1'`
- [x] 二维码生成，设置内容然后生成二维码，直接依赖 zxing 库即可;
- [ ] 扫码识别二维码，有点坑，得扣代码；

zxing github 开发文档 : https://github.com/zxing/zxing/wiki/Getting-Started-Developing

文档写得不咋地，推荐用 IntentIntegrator 来做，具体是下载一个 App 然后用它来扫 - -。所以要做扫码功能，得自己扣代码。


## zxing

工程是 Java 的而不是 Android 的，很乱，而且不能直接用 AS 编译。

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


`api 'com.google.zxing:core:3.4.1'` 依赖的源码是在 `core` 目录下，而要做扫码需要扣 android 和 android-core 的代码，按需扣。