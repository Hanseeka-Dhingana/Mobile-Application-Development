# Introduction To Android

## What is Android?

**Android** is an open-source, Linux-based operating system designed primarily for touchscreen mobile devices such as smartphones and tablets. It's developed by the Open Handset Alliance, led by Google.

*Key Characteristics:*
- **Open Source**: Free to use and modify
- **Linux-based**: Built on Linux kernel
- **Java/Kotlin**: Primary development languages
- **App Ecosystem**: Google Play Store with millions of apps
- **Multi-vendor**: Used by Samsung, Google, OnePlus, etc.

---

## Android Architecture

Android follows a layered architecture with four main layers:

### 1. **Linux Kernel**
   - Foundation of Android OS
   - Handles hardware drivers, memory management, process control
   - Provides security, power management

### 2. **Hardware Abstraction Layer (HAL)**
   - Provides standard interfaces to hardware capabilities
   - Camera, audio, sensors, Bluetooth
   - Allows app developers to access hardware without knowing implementation details

### 3. **Android Runtime & Native Libraries**
   - **ART (Android Runtime)**: Executes Dalvik bytecode
   - **Native C/C++ Libraries**: For performance-critical tasks
     - OpenGL (Graphics)
     - Webkit (Web browsing)
     - SQLite (Database)
     - Media frameworks

### 4. **Application Framework**
   - **Activity Manager**: Manages app lifecycle
   - **Content Providers**: Manages data sharing between apps
   - **Telephony Manager**: Handles phone calls and SMS
   - **Location Manager**: GPS and location services
   - **Resource Manager**: Manages app resources (layouts, strings)

### 5. **Applications Layer**
   - Built-in apps (Contacts, Phone, Browser)
   - Third-party apps (from Google Play Store)


![](https://github.com/Hanseeka-Dhingana/Mobile-Application-Development/blob/main/assets/android%20architecture.png)
---

## How to Install Android Studio

### Step 1: Download Android Studio
1. Visit [developer.android.com/studio](https://developer.android.com/studio)
2. Click "Download Android Studio"
3. Choose your operating system (Windows, macOS, Linux)

### Step 2: Installation Process
**Windows:**
```bash
1. Run the downloaded .exe file
2. Follow setup wizard instructions
3. Choose installation location
4. Select components to install (Android Studio, Android SDK, Android Virtual Device)
5. Complete installation and launch Android Studio
```

**macOS:**
```bash
1. Open the downloaded .dmg file
2. Drag Android Studio to Applications folder
3. Launch Android Studio from Applications
4. Follow setup wizard
```

### Step 3: SDK Setup
1. **SDK Components Setup**: Choose Android versions to support
2. **Emulator Configuration**: Set up Android Virtual Device (AVD)
3. **License Agreement**: Accept Android SDK licenses

### Step 4: Create Virtual Device (AVD)
1. Open **AVD Manager** from Tools menu
2. Click **Create Virtual Device**
3. Choose device type (Phone, Tablet, Wear OS)
4. Select system image (Recommended version)
5. Configure device name and settings

---

## First Hello World App Code Snippet

### 1. **MainActivity.java**
```java
package com.example.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Access TextView and set text programmatically
        TextView helloText = findViewById(R.id.helloTextView);
        helloText.setText("Hello, Android World!");
    }
}
```

### 2. **activity_main.xml** (Layout File)
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="16dp">

    <TextView
        android:id="@+id/helloTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        android:textSize="24sp"
        android:textStyle="bold" />

    <Button
        android:id="@+id/clickButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:text="Click Me!" />

</LinearLayout>
```

### 3. **AndroidManifest.xml**
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.myfirstapp">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:theme="@style/AppTheme">
        
        <activity
            android:name=".MainActivity"
            android:label="@string/app_name">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        
    </application>

</manifest>
```

### 4. **strings.xml** (Resources)
```xml
<resources>
    <string name="app_name">My First App</string>
    <string name="hello_world">Hello World!</string>
</resources>
```

### 5. **Adding Button Click Functionality**
```java
// Updated MainActivity.java with button click handler
public class MainActivity extends AppCompatActivity {

    private TextView helloText;
    private Button clickButton;
    private int clickCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Initialize views
        helloText = findViewById(R.id.helloTextView);
        clickButton = findViewById(R.id.clickButton);
        
        // Set button click listener
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount++;
                helloText.setText("Button clicked " + clickCount + " times!");
            }
        });
    }
}
```

### 6. **Project Structure**
```
MyFirstApp/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/myfirstapp/
│   │       │   └── MainActivity.java
│   │       ├── res/
│   │       │   ├── layout/
│   │       │   │   └── activity_main.xml
│   │       │   ├── values/
│   │       │   │   └── strings.xml
│   │       │   └── mipmap/
│   │       └── AndroidManifest.xml
│   └── build.gradle
```

### 7. **Build and Run**
1. **Connect Device**: Enable USB debugging on Android phone
2. **Run in Emulator**: Use AVD Manager to start virtual device
3. **Build APK**: Build → Make Project (Ctrl+F9)
4. **Run App**: Click Run button (Shift+F10)

**Expected Output**: App displays "Hello World!" text and a button. Clicking the button updates the text with click count.

This completes your first Android application! The app demonstrates basic concepts of activities, layouts, views, and event handling.
