# 🚀 Writing Your First Appium Test Script

## 🎯 Objective

In this section, you will learn how to write your very first Appium test that:

* Connects to the Appium Server.
* Connects to an Android Emulator or Real Device.
* Installs the application (APK).
* Launches the application.
* Creates an Appium Session.
* Closes the session.

---

# 📁 Project Structure

```text
AppiumProject
│
├── apps
│     └── ApiDemos-debug.apk
│
├── src
│   └── test
│       └── java
│           └── com
│               └── appium
│                   └── FirstAndroidTest.java
│
├── pom.xml
└── testng.xml
```

---

# 📦 Step 1: Import Required Classes

```java
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.URL;
import java.nio.file.Paths;
```

## Why are these imports required?

| Import                | Purpose                                                                    |
| --------------------- | -------------------------------------------------------------------------- |
| `AndroidDriver`       | Connects Appium with an Android device or emulator.                        |
| `UiAutomator2Options` | Stores all desired capabilities like device name, platform, APK path, etc. |
| `Test`                | Marks the method as a TestNG test case.                                    |
| `URL`                 | Connects to the Appium Server.                                             |
| `Paths`               | Reads the APK from your project folder.                                    |

---

# 🏗 Step 2: Create Test Class

```java
public class FirstAndroidTest {
```

Every Java program starts with a class.

This class contains our automation test.

---

# 🧪 Step 3: Create Test Method

```java
@Test
public void launchApplication() throws Exception {
```

## What does `@Test` mean?

It tells **TestNG** that this method is a test case.

When you execute the project, TestNG automatically runs this method.

---

# ⚙️ Step 4: Create UiAutomator2Options

```java
UiAutomator2Options options = new UiAutomator2Options();
```

Think of this as creating a **configuration object**.

Here we tell Appium:

* Which platform?
* Which device?
* Which application?
* Which automation engine?

---

# 📱 Step 5: Configure Device Details

```java
options.setPlatformName("Android");
options.setAutomationName("UiAutomator2");
options.setDeviceName("emulator-5554");
```

## Platform Name

```java
options.setPlatformName("Android");
```

Tells Appium to automate an Android device.

---

## Automation Name

```java
options.setAutomationName("UiAutomator2");
```

Specifies which Appium Driver should be used.

```text
Android
    │
    ▼
UiAutomator2 Driver
```

---

## Device Name

```java
options.setDeviceName("emulator-5554");
```

Specifies which emulator or physical device Appium should connect to.

Verify using:

```bash
adb devices
```

Example Output:

```text
List of devices attached

emulator-5554    device
```

---

# 📦 Step 6: Provide APK Path

```java
String apkPath = Paths.get("apps", "ApiDemos-debug.apk")
                      .toAbsolutePath()
                      .toString();

options.setApp(apkPath);
```

## Why is this required?

This tells Appium:

> Install this APK on the emulator before running the test.

Appium automatically performs the following:

```text
Read APK
      │
      ▼
Install APK
      │
      ▼
Launch App
      │
      ▼
Create Session
```

> **Note:** The APK does **not** need to be installed manually.

---

# 🔗 Step 7: Connect to Appium Server

```java
AndroidDriver driver =
        new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options);
```

## What happens here?

Appium creates a new automation session.

```text
Java Test
     │
     ▼
Appium Java Client
     │
HTTP Request
     │
     ▼
Appium Server
     │
     ▼
UiAutomator2 Driver
     │
     ▼
ADB
     │
     ▼
Android Emulator
```

---

# ▶️ Step 8: Execute Automation

Once the session is created, Appium has already launched the application.

Now you can automate it.

Example:

```java
driver.findElement(AppiumBy.accessibilityId("Preference")).click();
```

---

# 🛑 Step 9: Close Session

```java
driver.quit();
```

## Why?

This:

* Closes the application.
* Ends the Appium Session.
* Releases the emulator/device connection.

> **Best Practice:** Always close the session after your test.

---

# 💻 Complete Code

```java
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.URL;
import java.nio.file.Paths;

public class FirstAndroidTest {

    @Test
    public void launchApplication() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("emulator-5554");

        String apkPath = Paths.get("apps", "ApiDemos-debug.apk")
                              .toAbsolutePath()
                              .toString();

        options.setApp(apkPath);

        AndroidDriver driver =
                new AndroidDriver(
                        new URL("http://127.0.0.1:4723"),
                        options);

        System.out.println("Application launched successfully.");

        driver.quit();
    }
}
```

---

# 🔄 End-to-End Execution Flow

```text
Start Appium Server
        │
        ▼
Run TestNG Test
        │
        ▼
Create UiAutomator2Options
        │
        ▼
Read APK
        │
        ▼
Connect to Appium Server
        │
        ▼
Create Session
        │
        ▼
Install APK
        │
        ▼
Launch Application
        │
        ▼
Perform Automation
        │
        ▼
Close Session
```
