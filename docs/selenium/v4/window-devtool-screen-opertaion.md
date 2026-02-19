# Selenium 4 Advanced Features Guide

------------------------------------------------------------------------

# ✅ 4️⃣ New Window / Tab Handling API (Selenium 4)

## 🔹 What Is It?

Selenium 4 introduced a new API to open:

-   New Tab
-   New Window

Without manually handling window handles.

## New Methods:

``` java
driver.switchTo().newWindow(WindowType.TAB);
driver.switchTo().newWindow(WindowType.WINDOW);
```

------------------------------------------------------------------------

## 🔹 Problem in Selenium 3 (Old Way)

Before Selenium 4:

You had to:

-   Click link
-   Get all window handles
-   Loop through them
-   Switch manually

### Example:

``` java
String parent = driver.getWindowHandle();

driver.findElement(By.linkText("Open")).click();

Set<String> handles = driver.getWindowHandles();

for (String handle : handles) {
    if (!handle.equals(parent)) {
        driver.switchTo().window(handle);
    }
}
```

❌ Complex\
❌ Error-prone\
❌ Hard to maintain

------------------------------------------------------------------------

## 🔹 What Selenium 4 Improved

Now you can directly create and switch:

``` java
driver.switchTo().newWindow(WindowType.TAB);
```

No looping required.

------------------------------------------------------------------------

## 🔥 Real-Time Scenario

Suppose:

-   You login
-   Need to open product page in new tab
-   Perform validation
-   Close tab
-   Return to main window

------------------------------------------------------------------------

## ✅ Complete Working Example

``` java
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class NewWindowExample {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://example.com");

        String parentWindow = driver.getWindowHandle();

        // Open new tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://google.com");

        System.out.println("Title of new tab: " + driver.getTitle());

        // Close new tab
        driver.close();

        // Switch back to parent
        driver.switchTo().window(parentWindow);

        System.out.println("Back to parent: " + driver.getTitle());

        driver.quit();
    }
}
```

------------------------------------------------------------------------

# ✅ 5️⃣ Improved DevTools Support (CDP)

## 🔹 What Is CDP?

CDP = Chrome DevTools Protocol

It allows Selenium to:

-   Interact directly with browser internals
-   Monitor network
-   Intercept requests
-   Emulate devices

------------------------------------------------------------------------

## 🔹 Why It's Powerful?

Earlier:

❌ Selenium couldn't monitor network\
❌ Couldn't block requests\
❌ Couldn't capture performance

Now:

🔥 You can do all this.

------------------------------------------------------------------------

## 🔹 Create DevTools Session

``` java
DevTools devTools = ((ChromeDriver) driver).getDevTools();
devTools.createSession();
```

------------------------------------------------------------------------

# 🔥 Scenario 1: Capture Network Logs

## ✅ Complete Example

``` java
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.network.Network;
import org.openqa.selenium.devtools.v114.network.model.Request;

import java.util.Optional;

public class CaptureNetwork {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(),
                request -> {
                    Request req = request.getRequest();
                    System.out.println("Request URL: " + req.getUrl());
                });

        driver.get("https://example.com");
    }
}
```

------------------------------------------------------------------------

# 🔥 Scenario 2: Block URLs

``` java
devTools.send(Network.setBlockedURLs(List.of("*.png", "*.jpg")));
```

------------------------------------------------------------------------

# 🔥 Scenario 3: Emulate Mobile Device

``` java
devTools.send(Emulation.setDeviceMetricsOverride(
        375, 812, 50, true,
        Optional.empty(), Optional.empty(),
        Optional.empty(), Optional.empty(),
        Optional.empty(), Optional.empty(),
        Optional.empty(), Optional.empty()
));
```

------------------------------------------------------------------------

# 🔥 Scenario 4: Performance Monitoring

``` java
devTools.send(Performance.enable(Optional.empty()));
```

------------------------------------------------------------------------

## 🎯 Interview Point

CDP allows:

-   Network interception
-   API validation
-   Performance testing
-   Security testing

------------------------------------------------------------------------

# ✅ 6️⃣ Full-Screen and Minimize Window Support

## 🔹 What Changed?

Selenium 4 added:

``` java
driver.manage().window().fullscreen();
driver.manage().window().minimize();
```

Earlier only:

``` java
driver.manage().window().maximize();
```

------------------------------------------------------------------------

## 🔥 Real Scenario

Test case:

-   Verify website behavior in minimized state
-   Check full-screen mode
-   Validate UI responsiveness

------------------------------------------------------------------------

## ✅ Complete Example

``` java
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowStateExample {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

        // Fullscreen
        driver.manage().window().fullscreen();
        Thread.sleep(2000);

        // Minimize
        driver.manage().window().minimize();
        Thread.sleep(2000);

        // Maximize
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.quit();
    }
}
```

------------------------------------------------------------------------

# 📊 Interview Summary Table

| Feature        | Why Important                 |
| -------------- | ----------------------------- |
| newWindow()    | Simplifies tab handling       |
| DevTools (CDP) | Network & performance testing |
| fullscreen()   | UI validation                 |
| minimize()     | Window state testing          |


------------------------------------------------------------------------

End of Document
