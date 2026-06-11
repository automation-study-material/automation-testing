# 📱 Complete Guide to Connecting ADB to Android Devices

---

# 🚀 1. What is ADB?

**ADB (Android Debug Bridge)** is a command-line tool that enables communication between a computer and Android devices.

### 🔥 ADB is used for:

* ✅ Appium Automation
* ✅ Mobile Testing
* ✅ Installing APKs
* ✅ Capturing Logs
* ✅ Executing Shell Commands
* ✅ Taking Screenshots
* ✅ File Transfer
* ✅ Recording Videos
* ✅ Performance Monitoring

---

# 🏗 ADB Architecture

```text
+----------------+
| Client (PC)    |
| adb commands   |
+----------------+
         |
         ▼
+----------------+
| ADB Server     |
| Port 5037      |
+----------------+
         |
         ▼
+----------------+
| ADB Daemon     |
| adbd on device |
+----------------+
```

The **adbd** process runs inside Android devices and listens for commands from the ADB Server.

---

# 📱 Device Types Supported by ADB

ADB can connect to:

## 1️⃣ Physical Devices

Examples:

* Samsung
* OnePlus
* Pixel
* Xiaomi
* Vivo
* Oppo

---

## 2️⃣ Android Emulators

Examples:

* Android Studio Emulator
* Genymotion
* LDPlayer
* BlueStacks

---

## 3️⃣ Remote Devices

Examples:

* BrowserStack
* LambdaTest
* Device Farms
* Remote Machine Devices

---

# 🔌 Method 1: Physical Device Through USB

Most common connection method.

---

## Step 1: Enable Developer Options

```text
Settings
   ↓
About Phone
   ↓
Tap Build Number 7 Times
   ↓
Developer Options Enabled
```

---

## Step 2: Enable USB Debugging

```text
Settings
   ↓
Developer Options
   ↓
USB Debugging = ON
```

---

## Step 3: Connect Mobile via USB

Execute:

```bash
adb devices
```

Example:

```text
List of devices attached
R58N31ABC    device
```

Device is ready.

---

# ⚡ Device States

---

## ✅ device

```text
R58N31ABC device
```

Connected successfully.

---

## ⚠️ unauthorized

```text
R58N31ABC unauthorized
```

Phone is waiting for permission.

Unlock phone and allow:

```text
Allow USB Debugging?
```

Press:

```text
Allow
```

---

## ❌ offline

```text
R58N31ABC offline
```

ADB communication issue.

Execute:

```bash
adb kill-server
adb start-server
```

---

# 📶 Method 2: Wireless ADB (Traditional)

Uses Port **5555**.

---

## Prerequisites

* ✅ Developer Mode ON
* ✅ USB Debugging ON
* ✅ Same WiFi Network

---

## Step 1: Connect via USB

Verify:

```bash
adb devices
```

Example:

```text
R58N31ABC device
```

---

## Step 2: Enable TCP Mode

```bash
adb tcpip 5555
```

Output:

```text
restarting in TCP mode port: 5555
```

This starts **adbd** on port 5555.

---

## Step 3: Find Phone IP

```text
Settings
   ↓
WiFi
   ↓
Connected Network
   ↓
IP Address
```

Example:

```text
192.168.1.2
```

---

## Step 4: Disconnect USB

Connect through WiFi:

```bash
adb connect 192.168.1.2:5555
```

Output:

```text
connected to 192.168.1.2:5555
```

Verify:

```bash
adb devices
```

Output:

```text
192.168.1.2:5555 device
```

---

# 🔄 Is USB Required Every Time?

### ❌ No

USB is required only initially.

---

# 🔄 After Phone Restart?

Usually execute again:

```bash
adb tcpip 5555
```

using USB.

---

# 📡 Method 3: Wireless Debugging (Android 11+)

No USB cable required.

---

## Enable Wireless Debugging

```text
Settings
   ↓
Developer Options
   ↓
Wireless Debugging
   ↓
Enable ON
```

---

## Pair Device

Select:

```text
Pair device with pairing code
```

Example:

```text
IP Address : 192.168.1.2
Pair Port  : 37001
Code        : 123456
```

---

### On PC

```bash
adb pair 192.168.1.2:37001
```

Enter:

```text
123456
```

Output:

```text
Successfully paired
```

---

## Connect Device

Suppose debugging port is:

```text
39243
```

Execute:

```bash
adb connect 192.168.1.2:39243
```

Verify:

```bash
adb devices
```

Output:

```text
192.168.1.2:39243 device
```

---

# 🔄 Pairing Required Every Time?

### ❌ No

Usually one-time pairing.

---

# 🤖 Method 4: Android Emulator

Start Emulator.

Execute:

```bash
adb devices
```

Output:

```text
emulator-5554 device
```

### No Developer Mode Needed

### No USB Needed

---

## Multiple Emulators

```text
emulator-5554
emulator-5556
emulator-5558
```

Connect to a specific emulator:

```bash
adb -s emulator-5554 shell
```

---

# 🧪 Method 5: Genymotion

Start Genymotion.

Execute:

```bash
adb devices
```

Output:

```text
192.168.56.101:5555 device
```

---

# 🌍 Method 6: Remote Devices

```text
Laptop A
    |
 Internet
    |
Laptop B
    |
 Phone
```

Laptop B exposes:

```text
10.20.1.50:5555
```

Laptop A executes:

```bash
adb connect 10.20.1.50:5555
```

---

# ☁ BrowserStack

No direct ADB required.

Capabilities:

```java
browserstack.user
browserstack.key
deviceName
platformVersion
```

BrowserStack internally manages ADB.

---

# ☁ LambdaTest

Same concept.

Devices are already connected.

---

# 🛠 Important ADB Commands

## Show Devices

```bash
adb devices
```

---

## Restart Server

```bash
adb kill-server
adb start-server
```

---

## Install APK

```bash
adb install app.apk
```

---

## Remove Application

```bash
adb uninstall com.demo.app
```

---

## Open Shell

```bash
adb shell
```

---

## Capture Logs

```bash
adb logcat
```

---

## Screenshot

```bash
adb exec-out screencap -p > image.png
```

---

## Record Screen

```bash
adb shell screenrecord /sdcard/demo.mp4
```

---

## Push File

```bash
adb push sample.txt /sdcard/
```

---

## Pull File

```bash
adb pull /sdcard/sample.txt
```

---

# 📱 Working with Multiple Devices

Suppose:

```text
R58N31ABC
192.168.1.2:5555
emulator-5554
```

Specify device:

```bash
adb -s R58N31ABC shell
```

or

```bash
adb -s emulator-5554 shell
```

---

# 🚑 Troubleshooting

---

## No Devices Found

```bash
adb devices
```

Returns:

```text
List of devices attached
```

Possible reasons:

* USB Debugging OFF
* Driver issue
* Bad cable
* Device locked

---

## Unauthorized

```text
unauthorized
```

Unlock phone and allow debugging.

---

## Offline

```text
offline
```

Restart server:

```bash
adb kill-server
adb start-server
```

---

## Cannot Connect to Port 5555

Verify:

* Same WiFi Network
* Correct IP Address
* Port 5555 Enabled

Execute:

```bash
adb tcpip 5555
adb connect <ip>:5555
```

---

# 🔢 Important ADB Ports

| Port | Purpose         |
| ---- | --------------- |
| 5037 | ADB Server      |
| 5555 | Wireless ADB    |
| 5554 | Emulator        |
| 5556 | Second Emulator |

---

# 🔥 Appium + ADB Relationship

```text
Test Script
      ↓
Appium Server
      ↓
ADB
      ↓
adbd
      ↓
Android Device
```

### Appium uses ADB internally to:

* ✅ Install APK
* ✅ Start Application
* ✅ Click Elements
* ✅ Execute Shell Commands
* ✅ Capture Logs
* ✅ Record Videos
* ✅ Take Screenshots

---

# ⭐ Conclusion

ADB is the backbone of Android automation and one of the most important components to understand when working with **Appium Mobile Testing**.
