# 📱 Week 1: Mobile Testing Basics

> 🎯 Goal: Understand Android fundamentals, APK files, installation process, permissions, storage, and how testers receive and install builds in real projects.

---

# 📖 1. What is Android OS?

## Definition

**OS = Operating System**

Android OS is software that manages:

* Mobile hardware
* Applications
* Memory
* Storage
* Network
* Device resources

Think of Android as the manager of your phone.

When you:

* Open WhatsApp
* Take photos
* Make calls
* Use Google Pay

Android OS manages all these activities.

---

## Examples

| Device  | Operating System |
| ------- | ---------------- |
| Samsung | Android          |
| OnePlus | Android          |
| Vivo    | Android          |
| Oppo    | Android          |
| iPhone  | iOS              |

---

## Why Should a Tester Care?

Different Android versions behave differently.

Example:

```text
App works on Android 15
App crashes on Android 12
```

This is called a:

✅ Compatibility Issue

---

# 📖 2. Android Versions

Android releases a new version almost every year.

| Version    | Release Year |
| ---------- | ------------ |
| Android 12 | 2021         |
| Android 13 | 2022         |
| Android 14 | 2023         |
| Android 15 | 2024         |

---

## How to Check Android Version

```text
Settings
→ About Phone
→ Software Information
→ Android Version
```

---

## Why Test Different Versions?

Example:

```text
Samsung S24 → Android 15
Samsung A52 → Android 13
OnePlus → Android 14
```

Your application should work correctly on all supported versions.

---

## Interview Question

### Why is Compatibility Testing Important?

**Answer:**

Different Android devices and versions may behave differently, causing:

* UI issues
* Crashes
* Functional failures

---

# 📖 3. What is an APK File?

APK stands for:

```text
Android Package Kit
```

APK is the installation file for Android applications.

---

## Comparison

| Platform | Installation File |
| -------- | ----------------- |
| Windows  | .exe              |
| Android  | .apk              |

Examples:

```text
whatsapp.apk
amazon.apk
banking.apk
```

---

## What Does APK Contain?

An APK contains:

* Application Code
* Images
* Icons
* Configurations
* Libraries
* Resources

---

## Real Example

Developer creates:

```text
MyApp_v1.0.apk
```

Tester receives APK and starts testing.

---

## Interview Question

### What is APK?

**Answer:**

APK is an Android installation package used to install Android applications.

---

# 📖 4. How APK is Generated

## Complete Flow

```text
GitHub Repository
       ↓
Clone Project
       ↓
Build Project
       ↓
APK Generated
       ↓
APK Stored On Laptop
       ↓
Install On Mobile
       ↓
Testing
```

---

## Clone Project

Example:

```bash
git clone https://github.com/company/mobile-app.git
```

---

## Build Project

Android projects use Gradle.

```bash
gradlew assembleDebug
```

or

```bash
./gradlew assembleDebug
```

---

## Build Process

```text
Java/Kotlin Source Code
          ↓
Compilation
          ↓
Resource Processing
          ↓
APK Packaging
          ↓
APK Generated
```

---

# 📖 5. Where is APK Stored?

After build completes:

```text
project-root
└── app
    └── build
        └── outputs
            └── apk
                └── debug
                    └── app-debug.apk
```

Example:

```text
C:\Projects\BankingApp\app\build\outputs\apk\debug\app-debug.apk
```

---

# 📖 6. How Testers Transfer APK to Mobile

After APK generation, testers need to install it on a real device.

---

## Method 1: WhatsApp

```text
Laptop
   ↓
WhatsApp Web
   ↓
Mobile
   ↓
Install APK
```

### Pros

* Easy
* Beginner friendly

### Cons

* Not common in enterprise projects
* File size limitations

---

## Method 2: Bluetooth

```text
Laptop
   ↓
Bluetooth
   ↓
Mobile
```

### Pros

* No internet required

### Cons

* Slow

---

## Method 3: Google Drive

```text
Upload APK
      ↓
Download On Mobile
      ↓
Install
```

### Pros

* Easy sharing

### Cons

* Requires internet

---

## Method 4: USB File Transfer

```text
Connect Phone
      ↓
Copy APK
      ↓
Install
```

### Pros

* Fast
* Reliable

### Cons

* Manual process

---

# 📖 7. How Real Testers Install APK

## Industry Standard: ADB

Most companies use ADB.

---

### Enable Developer Options

```text
Settings
→ About Phone
→ Tap Build Number 7 Times
```

---

### Enable USB Debugging

```text
Settings
→ Developer Options
→ USB Debugging
```

---

### Connect Device

Connect phone using USB cable.

Allow:

```text
Allow USB Debugging?
```

Select:

```text
Allow
```

---

### Verify Device

```bash
adb devices
```

Expected:

```text
List of devices attached

R58N123456 device
```

---

### Install APK

```bash
adb install app-debug.apk
```

or

```bash
adb install C:\Projects\BankingApp\app\build\outputs\apk\debug\app-debug.apk
```

---

## How ADB Works

```text
Laptop
   ↓
Read APK
   ↓
USB Connection
   ↓
Transfer APK
   ↓
Android Package Manager
   ↓
Install App
```

---

# 📖 8. App Installation Testing

Verify:

* Installation successful
* App icon appears
* App launches correctly
* No error messages

---

## Sample Test Cases

### Test Case 1

```text
Install APK
Launch App
```

Expected:

```text
Application launches successfully
```

---

### Test Case 2

Install with low storage.

Expected:

```text
Proper error message displayed
```

---

### Test Case 3

Install same APK again.

Expected:

```text
Upgrade/Reinstall works correctly
```

---

# 📖 9. App Uninstallation Testing

Steps:

```text
Long Press App
→ Uninstall
```

Verify:

* App removed
* Icon disappears
* Storage released

---

# 📖 10. Reinstallation Testing

Scenario:

```text
Install App
Login
Uninstall
Install Again
```

Verify:

* App opens correctly
* Registration works
* Login works

---

# 📖 11. App Permissions

Applications need permissions to access device resources.

---

## Camera Permission

Used for:

* QR scanning
* Taking photos

Example:

Google Pay QR Scanner

---

## Microphone Permission

Used for:

* Voice messages

Example:

WhatsApp Voice Messages

---

## Contacts Permission

Used for:

* Contact synchronization

Example:

WhatsApp Contacts

---

## Location Permission

Used for:

* Maps
* Delivery Apps

Example:

Google Maps

---

## Storage Permission

Used for:

* Uploading files
* Downloading files

---

## Permission Testing

### Scenario 1

Allow permission.

Expected:

```text
Feature works successfully
```

### Scenario 2

Deny permission.

Expected:

```text
Proper warning displayed
Application should not crash
```

---

## Common Defect

```text
Permission denied
Application crashes
```

Severity:

```text
High
```

---

# 📖 12. Internal vs External Storage

## Internal Storage

Phone memory.

Example:

```text
128 GB Device Storage
```

Stores:

* Apps
* App Data
* Settings

---

## External Storage

Examples:

* SD Card
* Memory Card

---

## Why Testers Care

When storage is full:

Can app:

* Save photos?
* Download files?
* Update itself?

These are valid test scenarios.

---

# 🧪 Practice Exercises

## Exercise 1

Find:

```text
Android Version
Device Model
```

Path:

```text
Settings
→ About Phone
```

---

## Exercise 2

Check Permissions

```text
Settings
→ Apps
→ WhatsApp
→ Permissions
```

Observe:

* Camera
* Microphone
* Contacts
* Storage

---

## Exercise 3

Install and Reinstall App

```text
Install
Open
Close
Uninstall
Install Again
```

Observe:

* Installation time
* Launch behavior
* Login state

---

# 🎯 Week 1 Outcome

By the end of Week 1, you should understand:

✅ Android OS

✅ Android Versions

✅ APK Files

✅ APK Build Process

✅ APK Storage Location

✅ APK Installation Methods

✅ ADB Installation

✅ Installation Testing

✅ Uninstallation Testing

✅ Reinstallation Testing

✅ App Permissions

✅ Internal vs External Storage

---



# 📱 Mobile Testing Interview & Debugging Guide

> A practical guide for Manual Mobile Testers covering real-world scenarios, defect investigation, Logcat analysis, ADB usage, and interview preparation.

---

# 🎯 Learning Objectives

After completing this guide, you should be able to:

✅ Investigate mobile issues using logs

✅ Understand Logcat

✅ Use ADB commands

✅ Analyze crashes

✅ Debug permission issues

✅ Debug network issues

✅ Answer mobile testing interview questions confidently

---

# 🔍 Mobile Logging & Debugging

## Why Are Logs Important?

Suppose a user reports:

```text
Login is not working
```

Without logs:

```text
Something is broken
```

With logs:

```text
Network Issue
Backend Issue
Permission Issue
Application Crash
Database Issue
```

Logs help identify the root cause.

---

# 📖 What is Logcat?

Android continuously generates logs while applications run.

Example:

```text
User Clicked Login

Calling Login API

Response Received

Login Successful
```

or

```text
Camera Permission Denied

Application Crashed
```

All logs are stored in:

```text
Logcat
```

Think of Logcat as:

```text
Application Logs
+
Crash Logs
+
Network Logs
+
System Logs
```

---

# 🛠️ Viewing Logs

## Method 1: Android Studio

### Enable

```text
Developer Options
USB Debugging
```

### Open Logcat

```text
View
→ Tool Windows
→ Logcat
```

---

### Sample Logs

```text
LoginActivity Started

Calling Login API

Response 200 OK

Login Successful
```

---

## Method 2: ADB

### Verify Device

```bash
adb devices
```

Expected:

```text
List of devices attached

R58N123456 device
```

---

### Start Logcat

```bash
adb logcat
```

---

### Filter Logs

```bash
adb logcat | findstr MyApp
```

---

# 🚨 Important Errors Every Tester Should Recognize

## Crash

```text
FATAL EXCEPTION
```

Meaning:

```text
Application Crash
```

---

## Null Pointer

```text
NullPointerException
```

Meaning:

```text
Developer Bug
```

---

## Network Timeout

```text
SocketTimeoutException
```

Meaning:

```text
Server Not Responding
```

---

## Permission Issue

```text
SecurityException
```

Meaning:

```text
Permission Missing
```

---

# 📱 Scenario 1: Login Works on Android 15 But Fails on Android 12

## Question

You tested the application on Android 15 and login works correctly.

On Android 12 login fails.

What will you do?

---

## Answer

1. Reproduce issue.
2. Open Logcat.
3. Compare Android versions.
4. Verify API responses.
5. Verify permissions.
6. Raise compatibility defect.

---

## Example

```text
Samsung S24 (Android 15)
Login Successful

Samsung A52 (Android 12)
Login Failed
```

---

## Log Investigation

Possible Log:

```text
SocketTimeoutException
```

or

```text
SecurityException
```

---

# 📱 Scenario 2: Camera Permission Crash

## Question

User denies camera permission.

Application crashes.

---

## Expected

```text
Camera permission required
```

---

## Actual

```text
Application crashes
```

---

## Severity

```text
High
```

---

## Log Output

```text
SecurityException

Camera Permission Denied
```

---

## Defect Report

### Title

```text
Application crashes when camera permission is denied
```

### Evidence

```text
SecurityException observed in Logcat
```

---

# 📱 Scenario 3: Storage Full

## Question

Phone storage is almost full.

What should be tested?

---

## Verify

* Photo Upload
* File Download
* App Update
* Screenshot Saving
* Cache Generation

---

## Example

```text
Storage Used:

127.9 GB / 128 GB
```

---

## Expected

```text
Proper warning displayed
```

Not:

```text
Application crash
```

---

# 📱 Scenario 4: Incoming Call During Payment

## Scenario

```text
Open Google Pay

Enter ₹1000

Click Pay

Incoming Call

Call Ends
```

---

## Verify

* App resumes
* Payment state preserved
* No duplicate transaction

---

# 📱 Scenario 5: Switching Network

## Scenario

```text
Wi-Fi ON

Start Payment

Wi-Fi OFF

Mobile Data ON
```

---

## Verify

* Session remains active
* Payment continues
* No duplicate payment

---

## Possible Logs

```text
SocketTimeoutException
```

or

```text
Connection Lost
```

---

# 📱 Scenario 6: Application Update

## Scenario

```text
Version 1.0 Installed

Update to 1.1
```

---

## Verify

* User remains logged in
* Cart data remains
* Settings preserved
* No crashes

---

# 📱 Scenario 7: Notification Testing

## Notification

```text
Your order has been delivered
```

---

## Verify

* Notification received
* Correct message
* Correct screen opens

---

## Expected

```text
Order Details Screen
```

---

# 📱 Scenario 8: Reinstallation

## Scenario

```text
Install App

Login

Uninstall

Install Again
```

---

## Verify

* Login works
* Registration works
* No corrupted data

---

# 📱 Scenario 9: OTP Not Received

## Investigation Checklist

Verify:

1. Mobile Network
2. Correct Number
3. Backend Service
4. SMS Permission

---

## Example

```text
OTP API Response = Success

SMS Not Received
```

Possible integration issue.

---

# 📱 Scenario 10: UI Breaks on Vivo Device

## Example

```text
Samsung

[ Login ]
```

```text
Vivo

Login Button Hidden
```

---

## Defect Type

```text
Device Compatibility Issue
```

---

# 📱 Scenario 11: Back Button After Payment

## Scenario

```text
Payment Successful

Back Button Pressed
```

---

## Expected

```text
Order Summary Screen
```

Not:

```text
Payment Screen Again
```

---

# 📱 Scenario 12: Application in Background

## Scenario

```text
Open Banking App

Press Home

Wait 10 Minutes

Open Again
```

---

## Verify

* Session validity
* Data persistence
* Stability

---

# 📋 Common ADB Commands

```bash
adb devices
```

List connected devices.

---

```bash
adb logcat
```

View logs.

---

```bash
adb install app.apk
```

Install APK.

---

```bash
adb uninstall package_name
```

Remove application.

---

# 🎤 Frequently Asked Interview Question

## Developer Gives You an APK. What Will You Test First?

### Answer

1. Install APK
2. Launch App
3. Verify no crash
4. Verify login
5. Verify permissions
6. Verify navigation
7. Check logs if issues occur
8. Begin functional testing

---

# 🏆 Golden Rule of Mobile Testing

❌ Weak Defect

```text
App is not working
```

---

✅ Strong Defect

```text
Application crashes when camera permission is denied.

SecurityException observed in Logcat.

Crash reproduced on Android 14 and Android 15.
```

This is the level of detail expected from strong mobile testers.

