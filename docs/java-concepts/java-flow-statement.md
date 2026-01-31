# Java Control Statements for Software Testers

This chapter explains **decision-making and looping constructs** in Java with **real testing examples**, **retry logic**, and **interview questions with code**.

---

## 1️⃣ if Statement

### What it is
Executes a block of code **only when a condition is true**.

### Syntax
```java
if (condition) {
    // code
}
```

### Tester Example – Validate Login Result
```java
boolean isLoggedIn = true;

if (isLoggedIn) {
    System.out.println("Login Test Passed");
}
```

### Interview Q&A
**Q:** When should you use `if` instead of `if-else`?  
**A:** When you only want to act on a true condition and do nothing otherwise.

---

## 2️⃣ if-else Statement

### What it is
Provides an **alternative path** when the condition is false.

### Syntax
```java
if (condition) {
    // true block
} else {
    // false block
}
```

### Tester Example – API Status Validation
```java
int statusCode = 401;

if (statusCode == 200) {
    System.out.println("API Test Passed");
} else {
    System.out.println("API Test Failed");
}
```

### Interview Q&A
**Q:** Can `else` exist without `if`?  
**A:** No. `else` must always be associated with an `if`.

---

## 3️⃣ else-if Ladder

### What it is
Used to **check multiple conditions** sequentially.

### Syntax
```java
if (condition1) {
} else if (condition2) {
} else {
}
```

### Tester Example – Response Validation
```java
int statusCode = 404;

if (statusCode == 200) {
    System.out.println("Success");
} else if (statusCode == 401) {
    System.out.println("Unauthorized");
} else if (statusCode == 404) {
    System.out.println("Not Found");
} else {
    System.out.println("Unexpected Response");
}
```

### Interview Q&A
**Q:** How many `else-if` blocks are allowed?  
**A:** Unlimited, but only one block executes.

---

## 4️⃣ switch Statement

### What it is
Cleaner alternative to multiple `else-if` when comparing **fixed values**.

### Syntax
```java
switch (expression) {
    case value:
        break;
    default:
}
```

### Tester Example – Browser Selection
```java
String browser = "chrome";

switch (browser) {
    case "chrome":
        System.out.println("Launching Chrome");
        break;
    case "firefox":
        System.out.println("Launching Firefox");
        break;
    default:
        System.out.println("Unsupported Browser");
}
```

### Interview Q&A
**Q:** Why is `break` important in switch?  
**A:** Without `break`, execution continues to the next case (fall-through).

---

## 5️⃣ for Loop

### What it is
Used when the **number of iterations is known**.

### Syntax
```java
for (initialization; condition; increment) {
}
```

### Tester Example – Loop Through Test Data
```java
String[] users = {"admin", "guest", "tester"};

for (int i = 0; i < users.length; i++) {
    System.out.println("Testing login for: " + users[i]);
}
```

### Interview Q&A
**Q:** When is `for` preferred over `while`?  
**A:** When iteration count is fixed or predictable.

---

## 6️⃣ while Loop

### What it is
Executes while a condition remains true. Condition is checked **before** execution.

### Syntax
```java
while (condition) {
}
```

### Tester Example – Wait for Element
```java
int attempts = 0;

while (attempts < 3) {
    System.out.println("Checking element...");
    attempts++;
}
```

### Interview Q&A
**Q:** What is the risk with `while` loops?  
**A:** Infinite loops if the condition never becomes false.

---

## 7️⃣ do-while Loop

### What it is
Executes **at least once**, condition checked **after** execution.

### Syntax
```java
do {
} while (condition);
```

### Tester Example – Retry Logic
```java
int retry = 1;

do {
    System.out.println("Retry attempt: " + retry);
    retry++;
} while (retry <= 3);
```

### Interview Q&A
**Q:** Difference between `while` and `do-while`?  
**A:** `do-while` runs at least once even if condition is false.

---

## 8️⃣ break Statement

### What it is
Terminates loop or switch immediately.

### Tester Example – Stop on Failure
```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        System.out.println("Critical failure found");
        break;
    }
}
```

### Interview Q&A
**Q:** Can `break` be used outside loops?  
**A:** No, only inside loops or switch.

---

## 9️⃣ continue Statement

### What it is
Skips current iteration and moves to the next one.

### Tester Example – Skip Disabled Test Case
```java
for (int i = 1; i <= 5; i++) {
    if (i == 2) {
        continue;
    }
    System.out.println("Executing test case: " + i);
}
```

### Interview Q&A
**Q:** Difference between `break` and `continue`?  
**A:** `break` exits loop; `continue` skips iteration.

---

## 🧪 Testing Use-Case Summary

| Scenario | Java Construct |
|--------|----------------|
| Login validation | if / if-else |
| Browser selection | switch |
| Data-driven tests | for loop |
| Wait & polling | while |
| Retry mechanism | do-while |
| Stop execution | break |
| Skip test | continue |

---

## ✅ Interview Tip
> **Control statements form the backbone of test automation logic.  
If you master these, frameworks become easy.**

---
