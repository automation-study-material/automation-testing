# Appium Java Commands Cheat Sheet

Technology:

Java + Appium + UiAutomator2 + TestNG

---

# 1. Launch Application

```java
AndroidDriver driver =
        new AndroidDriver(
            new URL("http://127.0.0.1:4723"),
            options
        );
```

---

# 2. Find Element

## By Accessibility Id (Recommended)

```java
driver.findElement(
    AppiumBy.accessibilityId("Preference")
);
```

---

## By ID

```java
driver.findElement(
    AppiumBy.id("android:id/text1")
);
```

---

## By XPath

```java
driver.findElement(
    AppiumBy.xpath("//android.widget.TextView[@text='Preference']")
);
```

---

## By ClassName

```java
driver.findElement(
    AppiumBy.className("android.widget.Button")
);
```

---

# 3. Click

```java
driver.findElement(
    AppiumBy.accessibilityId("Preference")
).click();
```

---

# 4. Enter Text (sendKeys)

```java
driver.findElement(
    AppiumBy.id("username")
)
.sendKeys("Nitin");
```

---

# 5. Clear Text

```java
driver.findElement(
    AppiumBy.id("username")
)
.clear();
```

---

# 6. Get Text

```java
String value =
driver.findElement(
    AppiumBy.id("message")
)
.getText();


System.out.println(value);
```

---

# 7. Check Element Displayed

```java
boolean status =
driver.findElement(
    AppiumBy.id("login")
)
.isDisplayed();
```

---

# 8. Check Enabled

```java
boolean status =
driver.findElement(
    AppiumBy.id("button")
)
.isEnabled();
```

---

# 9. Check Selected

Checkbox / Radio Button:

```java
boolean checked =
driver.findElement(
    AppiumBy.id("checkbox")
)
.isSelected();
```

---

# 10. Dropdown / Spinner Handling

Click dropdown:

```java
driver.findElement(
    AppiumBy.id("spinner")
)
.click();
```

Select value:

```java
driver.findElement(
    AppiumBy.xpath(
     "//android.widget.TextView[@text='India']"
    )
).click();
```

Flow:

Dropdown
   ↓
Open Options
   ↓
Click Required Value

---

# 11. Handle Alert / Popup

Accept:

```java
driver.switchTo()
      .alert()
      .accept();
```

Dismiss:

```java
driver.switchTo()
      .alert()
      .dismiss();
```

Get message:

```java
String msg =
driver.switchTo()
      .alert()
      .getText();
```

---

# 12. Hide Keyboard

```java
driver.hideKeyboard();
```

---

# 13. Long Press

```java
WebElement element =
driver.findElement(
 AppiumBy.accessibilityId("Button")
);


new Actions(driver)

.clickAndHold(element)

.pause(Duration.ofSeconds(2))

.release()

.perform();
```

---

# 14. Scroll By Text

Very common Android command:

```java
driver.findElement(
    AppiumBy.androidUIAutomator(
    "new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))"
    )
);
```

---

# 15. Swipe Gesture

```java
driver.executeScript(
"mobile: swipeGesture",
Map.of(

"left",100,
"top",100,
"width",600,
"height",600,
"direction","up",
"percent",0.75

));
```

---

# 16. Drag And Drop

```java
driver.executeScript(
"mobile: dragGesture",
Map.of(

"elementId",
((RemoteWebElement)element).getId(),

"endX",500,
"endY",700

));
```

---

# 17. Tap Using Coordinates

```java
driver.executeScript(
"mobile: clickGesture",
Map.of(

"x",200,

"y",400

));
```

---

# 18. Press Back Button

```java
driver.navigate()
      .back();
```

---

# 19. Home Button

```java
driver.pressKey(
new KeyEvent(AndroidKey.HOME)
);
```

---

# 20. Android Enter Key

```java
driver.pressKey(
new KeyEvent(AndroidKey.ENTER)
);
```

---

# 21. Multi Window / Context Handling

Mostly for Hybrid apps.

Get contexts:

```java
Set<String> contexts =
driver.getContextHandles();


System.out.println(contexts);
```

Example output:

NATIVE_APP

WEBVIEW_com.demo.app


Switch:

```java
driver.context(
"WEBVIEW_com.demo.app"
);
```

Back to mobile:

```java
driver.context(
"NATIVE_APP"
);
```

---

# 22. Get Current Activity

```java
String activity =
driver.currentActivity();
```

---

# 23. Get Package Name

```java
String packageName =
driver.getCurrentPackage();
```

---

# 24. Close App

```java
driver.terminateApp(
"io.appium.android.apis"
);
```

---

# 25. Open App Again

```java
driver.activateApp(
"io.appium.android.apis"
);
```

---

# 26. Install APK

```java
driver.installApp(
"C:\\apps\\demo.apk"
);
```

---

# 27. Remove App

```java
driver.removeApp(
"io.appium.android.apis"
);
```

---

# 28. Check App Installed

```java
boolean status =
driver.isAppInstalled(
"io.appium.android.apis"
);
```

---

# 29. Screenshot

```java
File src =
driver.getScreenshotAs(
OutputType.FILE
);
```

---

# 30. Wait

Implicit:

```java
driver.manage()
.timeouts()
.implicitlyWait(
Duration.ofSeconds(10)
);
```

Explicit:

```java
WebDriverWait wait =
new WebDriverWait(
driver,
Duration.ofSeconds(10)
);


wait.until(
ExpectedConditions.visibilityOf(element)
);
```

---

# Industry Flow

Test

 ↓

Page Object

 ↓

Appium Commands

 ↓

Appium Server

 ↓

ADB

 ↓

Android Device
