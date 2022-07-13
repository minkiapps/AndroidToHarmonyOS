# Android to HarmonyOS

This Repository shows how an Android Example App is ported to HarmonyOS App for Huawei Smartwatch.

### Android
![chuck_phone](https://user-images.githubusercontent.com/52449229/178690474-4757d050-7cfe-43ca-94a1-ef8a30942d1c.gif)

### HarmonyOS 
![chuck_watch](https://user-images.githubusercontent.com/52449229/178690565-aa85d301-4fed-4b96-94b0-d3cc85ac75c8.gif)

For the Android App, popular 3rd party Libraries are used from Github
- Dagger
- Glide
- Rxjava/RxAndroid
- Retrofit
- Moshi

Many popular Android 3rd party libraries are "harmonised" on [Gitee](https://gitee.com/HarmonyOS-tpc) and can be used for HarmonyOS App
- Glide
- RxOhos
- Butterknife

Java Libraries can be 100% used for HarmonyOS development
- Dagger
- Rxjava
- Retrofit
- Moshi

Eventhough Kotlin can't be used for HarmonyOS development, you can still compile Kotlin code in a separate Maven project and use the compiled jar
in the HarmonyOS project, see [KotlinLib](https://github.com/minkiapps/AndroidToHos/tree/main/KotlinLib).
