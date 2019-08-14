### 介绍
安卓运行时主题

### 依赖
#### 自身
##### AndroidLibrary - Library
* implementation 'androidx.preference:preference:1.0.0'
* api 'com.github.snpmyn:*Util*:master-SNAPSHOT'（避重）
#### com.github.snpmyn:Util(api)
##### AndroidLibrary - UtilOne
* api 'com.github.bumptech.glide:glide:4.9.0'（避重）
* api 'com.google.android.material:material:1.1.0-alpha09'（避重）
* api 'com.jakewharton.timber:timber:4.7.1'（避重）
* implementation 'com.qw:soulpermission:1.2.1_x'
* implementation 'org.apache.commons:commons-lang3:3.9'

### 权限
#### com.github.snpmyn:Util
##### app
* android:name="android.permission.WRITE_EXTERNAL_STORAGE"（避重）
* android:name="android.permission.READ_EXTERNAL_STORAGE"（避重）
