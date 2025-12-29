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
```bash
npm install -g appium-doctor
appium-doctor
```
### ✔ Fix any missing dependencies it reports

## 🔌 Step 8: Install Appium Android Driver
```bash
appium driver install uiautomator2
appium driver list --installed
```
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
