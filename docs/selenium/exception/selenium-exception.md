# 🚀 Selenium Exceptions -- Detailed Guide with Scenarios & Solutions

This document covers the most common Selenium exceptions with:

-   ✅ Detailed description\
-   🔎 3--4 Real-world scenarios\
-   🛠 Practical solutions

------------------------------------------------------------------------

# 1️⃣ NoSuchElementException

## ✅ Description

Thrown when Selenium is unable to locate an element using the given
locator strategy.\
It means the element is not present in the DOM at the time of search.

## 🔎 Scenarios

1.  Incorrect locator (wrong ID, XPath typo).
2.  Element loads dynamically after AJAX call.
3.  Element is inside an iframe but driver hasn't switched to it.
4.  Element inside Shadow DOM.

## 🛠 Solutions

-   Validate locator in DevTools.
-   Use Explicit Wait:

``` java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
```

-   Switch to frame if required:

``` java
driver.switchTo().frame("frameName");
```

------------------------------------------------------------------------

# 2️⃣ StaleElementReferenceException

## ✅ Description

Occurs when the element reference stored earlier becomes invalid because
the DOM has refreshed or changed.

## 🔎 Scenarios

1.  Page refresh after locating element.
2.  React/Angular re-render.
3.  AJAX updates replacing DOM node.
4.  Navigation to another page.

## 🛠 Solutions

-   Re-locate element before interacting.
-   Use refreshed condition:

``` java
wait.until(ExpectedConditions.refreshed(
    ExpectedConditions.presenceOfElementLocated(By.id("submit"))));
```

------------------------------------------------------------------------

# 3️⃣ TimeoutException

## ✅ Description

Thrown when a wait condition is not satisfied within the specified time.

## 🔎 Scenarios

1.  Element never appears.
2.  Wrong ExpectedCondition used.
3.  Slow network or backend delay.
4.  Incorrect synchronization logic.

## 🛠 Solutions

-   Increase wait duration.
-   Use correct ExpectedCondition:

``` java
wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));
```

------------------------------------------------------------------------

# 4️⃣ ElementNotInteractableException

## ✅ Description

Element exists in DOM but cannot be interacted with.

## 🔎 Scenarios

1.  Hidden element.
2.  Disabled button.
3.  Element outside viewport.
4.  CSS overlay hiding element.

## 🛠 Solutions

Scroll into view:

``` java
((JavascriptExecutor)driver)
.executeScript("arguments[0].scrollIntoView(true);", element);
```

Use explicit wait for clickability.

------------------------------------------------------------------------

# 5️⃣ ElementClickInterceptedException

## ✅ Description

Occurs when another element is blocking the target element from being
clicked.

## 🔎 Scenarios

1.  Popup overlay.
2.  Loading spinner.
3.  Sticky header covering element.
4.  Modal dialog present.

## 🛠 Solutions

-   Wait for overlay to disappear.
-   Use JavaScript click as fallback:

``` java
((JavascriptExecutor)driver)
.executeScript("arguments[0].click();", element);
```

------------------------------------------------------------------------

# 6️⃣ InvalidSelectorException

## ✅ Description

Thrown when XPath or CSS selector syntax is invalid.

## 🔎 Scenarios

1.  Typo in XPath.
2.  Unsupported CSS selector.
3.  Mixing XPath syntax inside CSS selector.
4.  Missing brackets or quotes.

## 🛠 Solutions

-   Validate selector in browser console.
-   Correct syntax before execution.

------------------------------------------------------------------------

# 7️⃣ NoSuchFrameException

## ✅ Description

Thrown when Selenium cannot find the specified frame.

## 🔎 Scenarios

1.  Incorrect frame name or index.
2.  Frame loads dynamically.
3.  Switching before frame is available.

## 🛠 Solutions

``` java
wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameName"));
```

------------------------------------------------------------------------

# 8️⃣ NoSuchWindowException

## ✅ Description

Occurs when attempting to switch to a window that does not exist.

## 🔎 Scenarios

1.  Window already closed.
2.  Invalid window handle.
3.  Switching too early.

## 🛠 Solutions

``` java
Set<String> handles = driver.getWindowHandles();
```

Validate before switching.

------------------------------------------------------------------------

# 9️⃣ SessionNotCreatedException

## ✅ Description

Browser session could not be started.

## 🔎 Scenarios

1.  Driver-browser version mismatch.
2.  Browser not installed.
3.  Port conflict.
4.  Corrupted driver binary.

## 🛠 Solutions

-   Use Selenium Manager (4.6+).
-   Use WebDriverManager.
-   Update browser & driver.

------------------------------------------------------------------------

# 🔟 WebDriverException

## ✅ Description

Generic parent exception for many WebDriver-related issues.

## 🔎 Scenarios

1.  Browser crash.
2.  Driver crash.
3.  Network interruption.
4.  Invalid capabilities.

## 🛠 Solutions

-   Restart browser session.
-   Check driver logs.
-   Validate environment setup.

------------------------------------------------------------------------

# 1️⃣1️⃣ UnhandledAlertException

## 🔎 Scenario

Alert present but not handled before performing next action.

## 🛠 Solution

``` java
driver.switchTo().alert().accept();
```

------------------------------------------------------------------------

# 1️⃣2️⃣ NoAlertPresentException

## 🔎 Scenario

Attempting to switch to alert when none is present.

## 🛠 Solution

``` java
wait.until(ExpectedConditions.alertIsPresent());
```

------------------------------------------------------------------------

# 🎯 Most Common Exceptions in Real Projects

-   NoSuchElementException
-   StaleElementReferenceException
-   TimeoutException
-   ElementClickInterceptedException
-   SessionNotCreatedException

------------------------------------------------------------------------

# 🧠 Best Practices to Avoid Selenium Exceptions

-   Use Explicit Wait (avoid Thread.sleep).
-   Use stable and unique locators.
-   Handle frames and windows properly.
-   Keep browser and driver versions updated.
-   Implement proper exception handling framework.

------------------------------------------------------------------------

# 📌 Interview Tip

Most interviewers expect:

-   Clear understanding of dynamic DOM issues.
-   Ability to explain StaleElementReferenceException.
-   Proper synchronization strategies.
