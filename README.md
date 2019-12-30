# FirebaseAnalytics   

In few words, *FirebaseAnalytics* is a free app measurement solution that provides insight on app usage and user engagement, which means that we will have a lot of data to make decisions regarding behaviors, patterns and demography among others when users use our app.  


```gradle
  // add the Firebase SDK for Google Analytics
    implementation 'com.google.firebase:firebase-analytics:17.2.0'
    // add SDKs for any other desired Firebase products
    // https://firebase.google.com/docs/android/setup#available-libraries
```

```gradle
// Add to the bottom of the Module gradle
apply plugin: 'com.google.gms.google-services'
```

Put this line in top level `build.gradle`  
```gradle
classpath 'com.google.gms:google-services:4.3.2'
```

**Don't forget to provide INTERNET permission**  
```xml
  <uses-permission android:name="android.permission.INTERNET" />
```

**Hints**  

```java
// Obtain the Firebase Analytics instance.
FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this);
```

```java
//Logs an app event
firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

//Sets whether analytics collection is enabled for this app on this device.
firebaseAnalytics.setAnalyticsCollectionEnabled(true);

//Sets the minimum engagement time required before starting a session. The default value is 10000 (10 seconds).
firebaseAnalytics.setMinimumSessionDuration(500);

//Sets the duration of inactivity that terminates the current session. The default value is 1800000 (30 minutes).
firebaseAnalytics.setSessionTimeoutDuration(500);
```    
