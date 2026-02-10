# 🚀 Custom Exceptions in Selenium – Complete Notes

---

# 🔴 The Big Question

> ❓ *If Selenium and Java already provide many exceptions, why do we need custom exceptions?*

---

## ✅ Short Answer

Built-in exceptions tell **WHAT failed**,
Custom exceptions tell **WHY it failed in business/framework context**.

---



# 🧠 Why Selenium Built-in Exceptions Are NOT Enough

Selenium exceptions like:

* NoSuchElementException
* TimeoutException
* ElementNotInteractableException

tell only **technical failure**, not **intent or meaning**.

---

## ❌ Example (Confusing)

```text
NoSuchElementException
```

Questions:

* Login failed?
* Wrong page?
* User not created?
* Locator issue?

❌ Not clear

---

## ✅ With Custom Exception (Clear)

```text
LoginFailedException: User could not login due to invalid credentials
```

✔ Meaningful
✔ Readable
✔ Business-focused

---

---

# ✅ Why We Create Custom Exceptions

| Reason                | Benefit                     |
| --------------------- | --------------------------- |
| Business meaning      | Clear failure reason        |
| Framework clarity     | Easy debugging              |
| Reusability           | Same exception across tests |
| Clean code            | No duplicate error handling |
| Better reports        | Meaningful logs             |
| Interview expectation | Senior-level design         |

---

---

# 🧩 Types of Custom Exceptions

You can create:

1️⃣ Checked custom exception
2️⃣ Runtime (Unchecked) custom exception

---

# 🔹 1️⃣ Custom Runtime Exception (Most common in Selenium)

## When to use

✔ Test failure
✔ Validation failure
✔ Framework misuse

---

## Step 1: Create Custom Exception Class

```java
public class LoginFailedException extends RuntimeException {

    public LoginFailedException(String message) {
        super(message);
    }
}
```

✔ Extends RuntimeException
✔ No need to force handling

---

---

## Step 2: Throw Custom Exception (throw)

```java
public void login(String user, String pass) {

    if(user == null || pass == null) {
        throw new LoginFailedException("Username or Password is null");
    }

    // Selenium logic
}
```

---

---

## Step 3: Use in Selenium Test

```java
@Test
public void loginTest() {

    loginPage.login(null, "password123");
}
```

---

## Output

```text
LoginFailedException: Username or Password is null
```

✔ Clear
✔ Actionable

---

---

# 🔹 2️⃣ Custom Checked Exception (Less common)

## When to use

✔ External dependency
✔ Configuration issue
✔ Mandatory handling

---

## Step 1: Create Checked Exception

```java
public class BrowserNotSupportedException extends Exception {

    public BrowserNotSupportedException(String message) {
        super(message);
    }
}
```

---

## Step 2: Declare using throws

```java
public void launchBrowser(String browser)
        throws BrowserNotSupportedException {

    if(!browser.equals("chrome")) {
        throw new BrowserNotSupportedException("Browser not supported");
    }
}
```

---

## Step 3: Handle using try-catch

```java
try {
    launchBrowser("safari");
}
catch (BrowserNotSupportedException e) {
    System.out.println(e.getMessage());
}
```

---

---

# 🔥 Real Selenium Framework Example (Best Practice)

---

## Scenario: Element not found after wait

### ❌ Bad practice

```java
driver.findElement(By.id("login"));
```

Throws:

```
NoSuchElementException
```

---

## ✅ Good practice (Wrap with custom exception)

```java
public WebElement findElement(By locator) {

    try {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    catch (TimeoutException e) {
        throw new ElementNotVisibleException(
            "Element not visible: " + locator.toString());
    }
}
```

---

## Custom Exception

```java
public class ElementNotVisibleException extends RuntimeException {

    public ElementNotVisibleException(String message) {
        super(message);
    }
}
```

---

## Output

```text
ElementNotVisibleException: Element not visible: id=loginBtn
```

✔ Clear failure
✔ Better report
✔ Faster debugging

---

---

# 🔁 How Custom Exceptions Flow in Framework

```
Low-level Selenium action
        ↓
throw CustomException
        ↓
Test layer (JUnit/TestNG)
        ↓
Report + Screenshot + Fail test
```

---

---

# 🏗️ Where to Place Custom Exceptions

Best practice:

```
src/main/java
 └── exceptions
      ├── LoginFailedException.java
      ├── ElementNotVisibleException.java
      ├── BrowserNotSupportedException.java
```

---

---

# 🔹 throw vs throws in Custom Exceptions

| Keyword | Usage                   |
| ------- | ----------------------- |
| throw   | Create custom exception |
| throws  | Declare responsibility  |

---

## Example

```java
public void openPage() throws PageLoadException {
    throw new PageLoadException("Page load failed");
}
```

---

---

# ✅ Handling Custom Exceptions

---

## Option 1: Let Test Fail (Recommended)

```java
throw new LoginFailedException("Login failed");
```

✔ Test fails
✔ Clear reason

---

## Option 2: Catch and Log

```java
try {
    login();
}
catch(LoginFailedException e) {
    logger.error(e.getMessage());
    throw e; // rethrow
}
```

---

---

# ❌ When NOT to Create Custom Exception

❌ For every small issue
❌ For simple NullPointer
❌ Overengineering

---

---

# 🎯 Interview GOLD Explanation

> “Although Selenium provides many exceptions, they are technical. Custom exceptions help represent business and framework-level failures clearly. They improve readability, debugging, reusability, and reporting, especially in large automation frameworks.”

---

---

# ✅ Interview One-Liner

> “Custom exceptions in Selenium provide meaningful, domain-specific error messages and help separate technical failures from business logic, making automation frameworks more maintainable.”

---

---

# 🧠 Memory Trick

```
Built-in exception → WHAT failed
Custom exception   → WHY it failed
```

---

END
