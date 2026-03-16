Below is a **clean Selenium Java syntax cheat-sheet** including everything you asked:

* Screenshot
* JavaScriptExecutor
* Actions class
* Alerts
* Window handling
* Frames
* Waits (Implicit + Explicit + Fluent)

You can **review this quickly before interviews**.

---

# 1️⃣ Screenshot Syntax

```java
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
File dest = new File("C:\\Screenshots\\test.png");

FileHandler.copy(src, dest);
```

### Screenshot of WebElement

```java
WebElement element = driver.findElement(By.id("logo"));

File src = element.getScreenshotAs(OutputType.FILE);
FileHandler.copy(src, new File("C:\\Screenshots\\element.png"));
```

---

# 2️⃣ JavaScriptExecutor Syntax

### Create object

```java
JavascriptExecutor js = (JavascriptExecutor) driver;
```

### Scroll page

```java
js.executeScript("window.scrollBy(0,500)");
```

### Scroll to element

```java
js.executeScript("arguments[0].scrollIntoView(true);", element);
```

### Click element

```java
js.executeScript("arguments[0].click();", element);
```

### Enter text

```java
js.executeScript("arguments[0].value='Admin';", element);
```

### Get page title

```java
String title = js.executeScript("return document.title").toString();
```

---

# 3️⃣ Actions Class Syntax

```java
import org.openqa.selenium.interactions.Actions;

Actions actions = new Actions(driver);
```

### Mouse Hover

```java
actions.moveToElement(element).perform();
```

### Double Click

```java
actions.doubleClick(element).perform();
```

### Right Click

```java
actions.contextClick(element).perform();
```

### Drag and Drop

```java
actions.dragAndDrop(source, target).perform();
```

### Click and Hold

```java
actions.clickAndHold(element).perform();
```

### Keyboard Actions

```java
actions.sendKeys(Keys.ENTER).perform();
```

---

# 4️⃣ Alert Handling

### Switch to alert

```java
Alert alert = driver.switchTo().alert();
```

### Accept alert

```java
alert.accept();
```

### Dismiss alert

```java
alert.dismiss();
```

### Get alert text

```java
String text = alert.getText();
```

### Send text to alert

```java
alert.sendKeys("Hello");
```

---

# 5️⃣ Window Handling

### Get current window

```java
String parent = driver.getWindowHandle();
```

### Get all windows

```java
Set<String> windows = driver.getWindowHandles();
```

### Switch window

```java
for(String win : windows)
{
    driver.switchTo().window(win);
}
```

### Example: Switch to child window

```java
String parent = driver.getWindowHandle();

for(String win : driver.getWindowHandles())
{
    if(!win.equals(parent))
    {
        driver.switchTo().window(win);
    }
}
```

---

# 6️⃣ Frame Handling

### Switch using index

```java
driver.switchTo().frame(0);
```

### Switch using name/id

```java
driver.switchTo().frame("frameName");
```

### Switch using WebElement

```java
WebElement frame = driver.findElement(By.id("frame1"));
driver.switchTo().frame(frame);
```

### Switch back to main page

```java
driver.switchTo().defaultContent();
```

### Switch back to parent frame

```java
driver.switchTo().parentFrame();
```

---

# 7️⃣ Waits in Selenium

## Implicit Wait

Applied globally.

```java
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
```

---

## Explicit Wait

Wait for specific element.

```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

WebElement element =
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
```

### Wait for clickable element

```java
wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));
```

---

## Fluent Wait

More flexible wait.

```java
Wait<WebDriver> wait = new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(30))
        .pollingEvery(Duration.ofSeconds(5))
        .ignoring(NoSuchElementException.class);

WebElement element = wait.until(driver ->
        driver.findElement(By.id("username")));
```

---

# ⭐ Quick Interview Cheat Sheet

### Screenshot

```java
((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
```

---

### JavaScriptExecutor

```java
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].click();", element);
```

---

### Actions

```java
Actions actions = new Actions(driver);
actions.moveToElement(element).perform();
```

---

### Alert

```java
driver.switchTo().alert().accept();
```

---

### Window

```java
driver.switchTo().window(windowID);
```

---

### Frame

```java
driver.switchTo().frame("frameName");
```

---

### Wait

```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
```

---

💡 Since you have **3+ years QA + DevOps experience**, interviewers often also ask:

**“How do you design a Selenium framework from scratch?”**

If you want, I can also give a **1-page Selenium Automation Framework Cheat Sheet** (POM + TestNG + Maven + Utilities) that **many senior automation engineers use for interviews.**
