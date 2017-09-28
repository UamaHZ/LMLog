# LMLog
[![](https://jitpack.io/v/UamaHZ/LMLog.svg)](https://jitpack.io/#UamaHZ/LMLog)

Android日志打印工具。

## 添加依赖
首先需要在项目的 `build.gradle` 文件中配置 [https://jitpack.io](https://jitpack.io) 的 maven 库：
```
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```
其次在需要引用该的 module 的 `build.gradle` 中添加依赖：
```
 compile 'com.github.UamaHZ:LMLog:1.0.0'
```

## 用法

```
LMLog.v("verbose");
LMLog.d("debug");
LMLog.i("information");
LMLog.w("warning");
LMLog.e("error");
LMLog.json("json");
LMLog.d("Example", "debug");
 

```
+  `LMLog.DEBUG = true ` 可开启日志，建议在 `application`中调用
+  `LMLog.TAG = "customTag" ` 可设置全局tag






