# ACtions
- `click` - driver.findElement(AppiumBy.accessibilityId("Preference")).click();
-  `long-press` -  https://appium.github.io/appium.io/docs/en/writing-running-appium/android/android-mobile-gestures/
   understand events
- `scroll` - We can scroll by text using two way - ref: https://appium.github.io/appium.io/docs/en/writing-running-appium/android/android-mobile-gestures/#:~:text=%2C%200.75%0A))%3B-,mobile%3A%20scrollGesture,-This%20gesture%20performs

```java
public void scroll(String textTillScroll, AndroidDriver driver) {
   driver.findElement(AppiumBy.androidUIAutomator("new  UiScrollable(newUiSelector()).scrollIntoView(text(\""+textTillScroll+"\"))"));
	}
```

```java
boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
    "left", 100, "top", 100, "width", 200, "height", 200,
    "direction", "down",
    "percent", 3.0
));
```

- `swipe` - we can swipe (horizontal direction)- It may be images
  
