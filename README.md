# Sensor-Master
How To Build Compass

## Todo
- [x] Sensor Proximity
- [x] Sensor Compass Combination TYPE_ACCELEROMETER,TYPE_MAGNETIC_FIELD

## Install at local
Open Gradel App, project:  
``` android {
    compileSdkVersion 25
    buildToolsVersion "25.0.2"
    defaultConfig {
        applicationId "com.example.afifur.sensorsample"
        minSdkVersion 22
        targetSdkVersion 25
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    compile 'com.android.support:appcompat-v7:22.0.0'
    compile 'com.android.support:design:22.2.0'
    compile 'com.android.support.constraint:constraint-layout:1.0.1'
    testCompile 'junit:junit:4.12'
}
```
 

## License
MIT

