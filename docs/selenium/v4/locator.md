# 🚀 Locators Introduced in Selenium 4 (Detailed Explanation with DOM Structure)

The major new locator feature introduced in Selenium 4 is:

✅ **Relative Locators (also called Friendly Locators)**

------------------------------------------------------------------------

## Existing Locators (Still Available)

-   id
-   name
-   className
-   tagName
-   linkText
-   partialLinkText
-   cssSelector
-   xpath

------------------------------------------------------------------------

# 🔥 1️⃣ Relative Locators (New in Selenium 4)

### Package

``` java
import static org.openqa.selenium.support.locators.RelativeLocator.with;
```

------------------------------------------------------------------------

## 🔹 Why Relative Locators Were Introduced?

Problem:

Sometimes elements:

-   Don't have unique ID
-   Have dynamic attributes
-   Complex XPath becomes unreadable

Example of hard-to-maintain XPath:

``` xpath
//div[2]/form/div[1]/input
```

------------------------------------------------------------------------

## 🔹 What Are Relative Locators?

They locate elements **based on their position relative to another
element.**

### Available Methods

| Method        | Meaning                              |
| ------------- | ------------------------------------ |
| `above()`     | Element above reference element      |
| `below()`     | Element below reference element      |
| `toLeftOf()`  | Element left of reference            |
| `toRightOf()` | Element right of reference           |
| `near()`      | Element near reference (within 50px) |

------------------------------------------------------------------------

# 🔥 DOM Structure Example

### HTML

``` html
<form>
    <label>Username</label>
    <input type="text" id="username">

    <label>Password</label>
    <input type="password" id="password">

    <button id="login">Login</button>
</form>
```

### Visual Layout

    Username
    [________]

    Password
    [________]

    [ Login ]

------------------------------------------------------------------------

# 🔥 1️⃣ above()

### Goal:

Find Username field using Password as reference.

``` java
WebElement password =
        driver.findElement(By.id("password"));

WebElement username =
        driver.findElement(
                with(By.tagName("input"))
                        .above(password));

username.sendKeys("admin");
```

### How It Works

-   Selenium finds password element
-   Then searches for input element located above it using screen
    coordinates

------------------------------------------------------------------------

# 🔥 2️⃣ below()

Find element below reference.

``` java
WebElement username =
        driver.findElement(By.id("username"));

WebElement password =
        driver.findElement(
                with(By.tagName("input"))
                        .below(username));
```

------------------------------------------------------------------------

# 🔥 3️⃣ toLeftOf()

### DOM Example

``` html
<label>Email</label>
<input type="text">
```

### Visual

    Email    [________]

### Code

``` java
WebElement label =
        driver.findElement(By.xpath("//label[text()='Email']"));

WebElement input =
        driver.findElement(
                with(By.tagName("input"))
                        .toRightOf(label));
```

------------------------------------------------------------------------

# 🔥 4️⃣ toRightOf()

Example:

    [ Remember Me ]  Checkbox

``` java
WebElement checkbox =
        driver.findElement(
                with(By.tagName("input"))
                        .toRightOf(
                                By.xpath("//label[text()='Remember Me']")));
```

------------------------------------------------------------------------

# 🔥 5️⃣ near()

Find element near another element (within 50px).

Example:

    Forgot Password?   Login Button

``` java
WebElement login =
        driver.findElement(
                with(By.tagName("button"))
                        .near(By.linkText("Forgot Password?")));
```

------------------------------------------------------------------------

# 🔥 Complete Working Example

``` java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/test/login.html");

        WebElement password =
                driver.findElement(By.id("password"));

        WebElement username =
                driver.findElement(
                        with(By.tagName("input"))
                                .above(password));

        username.sendKeys("admin");

        driver.quit();
    }
}
```

------------------------------------------------------------------------

# 🔥 How Selenium Determines Position?

Relative locators work based on:

-   Element coordinates (x, y)
-   Element bounding rectangle
-   Pixel position on page

⚠ They do NOT rely purely on DOM hierarchy.

### Important Notes

-   Layout must be stable
-   Not recommended for pixel-changing UI

------------------------------------------------------------------------

# 🔥 When Should You Use Relative Locators?

✅ Dynamic IDs\
✅ Table-based forms\
✅ Simple layouts\
✅ Label-input alignment

------------------------------------------------------------------------

# ❌ When NOT To Use

❌ Complex nested layouts\
❌ Responsive layouts where positions change\
❌ Pixel-sensitive UI

------------------------------------------------------------------------

# 🔥 Interview Question

### Q: How do Relative Locators work internally?

**Answer:**

Selenium calculates element coordinates on the page and determines
relative position based on bounding rectangle and pixel location rather
than only DOM hierarchy.

------------------------------------------------------------------------

# 🔥 Summary

| Locator     | Description                      |
| ----------- | -------------------------------- |
| above()     | Finds element above reference    |
| below()     | Finds element below reference    |
| toLeftOf()  | Finds element left of reference  |
| toRightOf() | Finds element right of reference |
| near()      | Finds element near reference     |


------------------------------------------------------------------------

# 🔥 Important Note

Relative Locators were introduced in:

**Selenium 4**

Package:

``` java
org.openqa.selenium.support.locators.RelativeLocator
```
