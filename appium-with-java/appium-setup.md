# 📱 Complete Appium Installation & Configuration Guide (Windows)

This document explains **everything required to install, configure, and run Appium tests on a Windows machine** from scratch.

✔ Includes all downloads  
✔ Includes environment variables  
✔ Includes Android Studio & Emulator  
✔ Includes Appium Server, Inspector & Drivers  
✔ Includes sample test & verification steps  

---

## 🧰 System Requirements

- Windows 10 / 11 (64-bit)
- Minimum 8 GB RAM (16 GB recommended)
- Internet connection
- Administrator access

---

## 🔽 Step 1: Install Java (JDK)

### Download
👉 https://adoptium.net  

Choose:
- Temurin
- JDK 11 or JDK 17
- Windows x64 MSI

### Install
- Run installer
- Keep default options

---

### Set JAVA_HOME

1. Open **System Properties**
2. Click **Environment Variables**
3. Add **New System Variable**

```text
Variable Name: JAVA_HOME
Variable Value: C:\Program Files\Java\jdk-17
```

### Update PATH
```text
%JAVA_HOME%\bin
```
### Verify

```
java -version
```

## 🔽 Step 2: Install Node.js (Required for Appium)

### Download
👉 https://nodejs.org

### Choose:
- LTS version

### Install
- Keep all default options
- Ensure Add to PATH is checked

### Verify

```bash
node -v
npm -v
```

## 🔽 Step 3: Install Android Studio
### Download
👉 https://developer.android.com/studio

### Install
During installation, make sure these are selected:

- ✅ Android SDK

- ✅ Android SDK Platform

- ✅ Android Virtual Device

- ✅ Android Emulator
---
##⚙️ Step 4: Configure Android SDK Environment Variables

### Locate SDK Path
Default location:

```text
C:\Users\<USERNAME>\AppData\Local\Android\Sdk
```
### Set ANDROID_HOME
```text
Variable Name: ANDROID_HOME
Variable Value: C:\Users\<USERNAME>\AppData\Local\Android\Sdk
```

### Update PATH
Add all of these:

```text
Copy code
%ANDROID_HOME%\platform-tools
%ANDROID_HOME%\tools
%ANDROID_HOME%\tools\bin
%ANDROID_HOME%\emulator
```

### Verify
```bash
adb version
```

## 📱 Step 5: Create Android Emulator
- Open Android Studio
- Go to More Actions → Device Manager
- Click Create Device
- Choose Pixel
- Select API 30+ system image
- Finish & Start Emulator

### Verify Emulator
```bash
adb devices
output- emulator-5554 device
```

## 🚀 Step 6: Install Appium Server (CLI)
```bash
npm install -g appium
appium -v
```

## 🩺 Step 7: Install Appium Doctor (Highly Recommended)

Appium Doctor is a **diagnostic tool** that checks whether your machine has all the required software and environment variables to run Appium successfully.

It helps identify missing dependencies before you start writing or running automation tests.

### 📌 Why is it required?

- ✅ Verifies that Node.js is installed correctly.
- ✅ Checks if Java (JDK) is installed.
- ✅ Validates Android SDK installation.
- ✅ Ensures ADB (Android Debug Bridge) is available.
- ✅ Confirms environment variables like `ANDROID_HOME`, `JAVA_HOME`, and `PATH`.
- ✅ Checks Android Build Tools and Platform Tools.
- ✅ Saves debugging time by identifying configuration issues early.

> **Note:** Appium Doctor is **not mandatory**, but it is highly recommended for every Appium developer.

### Install Appium Doctor

```bash
npm install -g appium-doctor
```

### Verify Android Environment

```bash
appium-doctor --android
```

Or run the general health check:

```bash
appium-doctor
```

### Example Output

```text
info AppiumDoctor ### Diagnostic for necessary dependencies starting ###

✔ Node.js is installed
✔ Java is installed
✔ Android SDK is installed
✔ adb exists
✔ ANDROID_HOME is set

info AppiumDoctor ### Diagnostic completed. No issues found. ###
```

### If Any Dependency is Missing

Example:

```text
✖ JAVA_HOME environment variable is NOT set
✖ Android Build Tools are missing
✖ adb was NOT found
```

Fix the reported issues before proceeding to the next step.

---

## 🔌 Step 8: Install Appium Android Driver (UiAutomator2)

Starting with **Appium 2.x**, the Appium Server is only a **core framework**. It does **not include platform-specific drivers** like Android or iOS by default.

To automate Android devices, you must install the **UiAutomator2 Driver** separately.

### 📌 Why is it required?

Without the Android driver:

- ❌ Appium cannot communicate with Android devices.
- ❌ Appium cannot launch Android applications.
- ❌ Appium cannot inspect or locate UI elements.
- ❌ Automation scripts will fail before execution.

### UiAutomator2 Driver Responsibilities

The UiAutomator2 Driver is responsible for:

- 📱 Connecting to Android Emulators and Real Devices.
- 🚀 Installing and launching APK files.
- 🔍 Finding UI elements using ID, XPath, Accessibility ID, etc.
- 👆 Performing user actions like:
  - Click
  - Send Keys
  - Swipe
  - Scroll
  - Drag & Drop
  - Long Press
- 📸 Taking Screenshots.
- 📋 Retrieving Logs.
- 🔄 Managing App Lifecycle (Install, Launch, Close, Uninstall).

---

### Install the Android Driver

```bash
appium driver install uiautomator2
```

Expected Output:

```text
✔ Installing 'uiautomator2'
✔ Driver installed successfully
```

---

### Verify Installed Drivers

```bash
appium driver list --installed
```

Example Output:

```text
Installed Drivers

✔ uiautomator2@<latest-version>
```

---

### View All Available Drivers

```bash
appium driver list
```

Example:

```text
uiautomator2
xcuitest
espresso
mac2
windows
```

---

### What Happens if the Driver is Not Installed?

When you start Appium and execute a test, you may see errors like:

```text
Could not find a driver for automationName 'UiAutomator2'
```

or

```text
No driver found for platformName Android
```

This means Appium Server is running, but it has no Android automation driver installed.

---

### Appium 1.x vs Appium 2.x

| Appium 1.x | Appium 2.x |
|------------|------------|
| Drivers included with Appium | Drivers installed separately |
| Large installation size | Lightweight and modular |
| Updating Appium updates all drivers | Drivers can be updated independently |
| Less flexible | More flexible and extensible |

---

### Verify Driver Installation

You can also check detailed information:

```bash
appium driver list --installed
```

Expected Output:

```text
- uiautomator2
  Version : x.x.x
  Automation Name : UiAutomator2
  Platform : Android
```

---

### Flow Diagram

```text
Java Test Script
        │
        ▼
Appium Client (Java)
        │
        ▼
Appium Server
        │
        ▼
UiAutomator2 Driver
        │
        ▼
ADB (Android Debug Bridge)
        │
        ▼
Android Emulator / Real Device
        │
        ▼
Android Application
```

---

### Summary

| Tool | Purpose | Required |
|------|---------|----------|
| Appium Server | Receives automation commands | ✅ Yes |
| Appium Doctor | Validates system setup | ⭐ Recommended |
| UiAutomator2 Driver | Automates Android devices | ✅ Yes |
| Android SDK | Provides Android tools | ✅ Yes |
| ADB | Connects Appium to Android devices | ✅ Yes |
| Java (JDK) | Required for Java automation | ✅ Yes |
| Node.js | Runs Appium and npm packages | ✅ Yes |
## 🧭 Step 9: Install Appium Inspector (GUI Tool)
### Download
👉 https://github.com/appium/appium-inspector/releases

### Install
- Download Windows .exe
- Install & open

### Used for:
- Inspecting elements
- Getting locators
- Validating capabilities

## ▶️ Step 10: Start Appium Server
### Option 1: Command Line
```bash
appium
```
### Option 2: Appium Inspector
- Click Start Server

#### Default URL:

```text
http://127.0.0.1:4723
```

## 🧪 Step 11: Create Appium Automation Project (Java)
### Create Maven Project
```bash
mvn archetype:generate
Choose:
maven-archetype-quickstart
```
### pom.xml Dependencies
```xml
Copy code
<dependencies>
    <dependency>
        <groupId>io.appium</groupId>
        <artifactId>java-client</artifactId>
        <version>9.2.2</version>
    </dependency>

    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.20.0</version>
    </dependency>

    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.9.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## 📋 Step 12: Desired Capabilities (Android)

```java
DesiredCapabilities caps = new DesiredCapabilities();
caps.setCapability("platformName", "Android");
caps.setCapability("automationName", "UiAutomator2");
caps.setCapability("deviceName", "Android Emulator");
caps.setCapability("app", "C:\\apps\\demo.apk");
```

## 🧪 Step 13: Sample Appium Test (Java)
```java
AndroidDriver driver = new AndroidDriver(
    new URL("http://127.0.0.1:4723"),
    caps
);

driver.findElement(AppiumBy.id("com.example:id/username"))
      .sendKeys("admin");

driver.quit();
```
## ▶️ Step 14: Run Test
```bash
mvn test
```
### ❗ Common Issues & Fixes
#### Emulator not detected
```bash
adb kill-server
adb start-server
```

#### ANDROID_HOME not working
- Restart system
- Recheck PATH entries

#### Appium doctor failures
- Install missing SDK tools from Android Studio → SDK Manager

## ✅ Final Checklist
- ✔ Java Installed
- ✔ Node.js Installed
- ✔ Android Studio Installed
- ✔ SDK & Emulator Configured
✔ Appium Server Installed
✔ Driver Installed
✔ Test Executed Successfully
