# Appium Pre Execution Checklist
## Java + Maven + Android

This document explains what needs to be verified before running Appium automation tests.

---

# 1. Environment Setup Check (One Time)

Before running Appium tests, verify required tools are installed.

## Verify Java

```bash
java -version
```

Expected:

```text
Java 17 or configured version should display
```

---

## Verify Maven

```bash
mvn -version
```

Expected:

```text
Apache Maven version details
```

---

## Verify Node.js and NPM

```bash
node -v

npm -v
```

---

## Verify Appium

```bash
appium -v
```

Expected:

```text
Appium version should display
```

---

## Verify Android SDK / ADB

```bash
adb version
```

---

# 2. Start Android Device

You can run Appium tests on:

- Android Emulator
- Physical Android Device

---

# Option 1: Start Emulator

Open Android Studio:

```text
Android Studio

      ↓

Device Manager

      ↓

Start Android Virtual Device (AVD)
```

Example:

```text
Pixel 7
Android 14
```

Verify emulator connection:

```bash
adb devices
```

Expected:

```text
List of devices attached

emulator-5554    device
```

---

# Option 2: Physical Mobile Device

Connect device using:

- USB Cable
- ADB over Wi-Fi

Verify:

```bash
adb devices
```

Example:

```text
List of devices attached

RZ8N12345AB    device
```

---

# 3. Check ADB Server

ADB usually starts automatically.

Start manually:

```bash
adb start-server
```

Check connected devices:

```bash
adb devices
```

ADB Architecture:

```text
ADB Client

      ↓

ADB Server
(Local Machine Port 5037)

      ↓

ADB Daemon (adbd)

      ↓

Android Device / Emulator
```

---

# 4. Start Appium Server

Start server:

```bash
appium
```

Expected:

```text
Appium REST http interface listener started

0.0.0.0:4723
```

Architecture:

```text
Test Code

    ↓

Appium Server
(port 4723)

    ↓

ADB

    ↓

Android Device
```

---

# 5. Verify Appium Android Driver

Check installed drivers:

```bash
appium driver list
```

Expected:

```text
uiautomator2 installed
```

If missing, install:

```bash
appium driver install uiautomator2
```

---

# 6. Verify APK File

Make sure APK file exists.

Linux Example:

```text
/home/user/apps/General-Store.apk
```

Windows Example:

```text
C:\APKFiles\General-Store.apk
```

You can also manually test installation:

```bash
adb install app.apk
```

---

# 7. Verify Desired Capabilities

Example Java Code:

```java
UiAutomator2Options options =
        new UiAutomator2Options();


options.setDeviceName(
        "emulator-5554"
);


options.setPlatformName(
        "Android"
);


options.setAutomationName(
        "UiAutomator2"
);


options.setApp(
        "/home/user/apps/General-Store.apk"
);
```

Device name should match output from:

```bash
adb devices
```

Example:

```text
emulator-5554 device
```

---

# 8. Execute Maven Test

Go to project directory:

```bash
cd AppiumProject
```

Run:

```bash
mvn test
```

---

# Complete Appium Execution Flow

```text
mvn test

     ↓

TestNG

     ↓

Java Appium Client

     ↓

Appium Server

     ↓

ADB Client

     ↓

ADB Server
(port 5037)

     ↓

ADB Daemon
(adbd)

     ↓

Android Emulator
        OR
Physical Device

     ↓

Application Automation
```

---

# Daily Appium Engineer Checklist

Before execution:

## Step 1

Start:

```text
Emulator
OR
Connect Physical Device
```

---

## Step 2

Verify device:

```bash
adb devices
```

Expected:

```text
device status should be "device"
```

---

## Step 3

Start Appium:

```bash
appium
```

Check:

```text
Server running on port 4723
```

---

## Step 4

Verify:

- APK path
- Desired capabilities
- Device name
- Appium server URL

---

## Step 5

Run automation:

```bash
mvn test
```

---

# Debugging Commands

Check Android logs:

```bash
adb logcat
```

Clear logs:

```bash
adb logcat -c
```

Restart ADB:

```bash
adb kill-server

adb start-server
```

---

# Summary

Standard Appium Flow:

```text
Java Test Code

      ↓

Maven + TestNG

      ↓

Appium Java Client

      ↓

Appium Server

      ↓

ADB

      ↓

Android Device

      ↓

Application Tested
```

This is the standard workflow followed in real Appium automation projects.
