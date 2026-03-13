
# BDD (Behavior Driven Development)

## 1. Why BDD Was Introduced

BDD was introduced to **solve the communication gap between business stakeholders and technical teams**.

In traditional frameworks like **TestNG or JUnit**:

- Test cases are written in **programming languages (Java, Python, etc.)**
- Only **developers and automation engineers** understand them
- **Business Analysts, Product Owners, and Clients cannot easily read them**

BDD introduces:

- **Gherkin language**
- **Plain English scenarios**
- Better collaboration between **Business + QA + Developers**

### Example

#### TestNG Style Test

```java
@Test
public void loginTest() {
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.id("password")).sendKeys("1234");
    driver.findElement(By.id("login")).click();
    Assert.assertTrue(driver.getTitle().contains("Dashboard"));
}
````

Only technical users understand this.



#### BDD (Cucumber) Style

```gherkin
Scenario: Successful login
  Given user is on login page
  When user enters username "admin" and password "1234"
  Then user should see dashboard page
```

Now **Business, QA, and Developers all understand it**.

---

# 2. Advantages of BDD Over TestNG

| Aspect                    | BDD (Cucumber)                          | TestNG                        |
| ------------------------- | --------------------------------------- | ----------------------------- |
| Readability               | Human readable scenarios                | Code based tests              |
| Stakeholder Collaboration | Business, QA, Dev all understand        | Mostly developers             |
| Requirement Mapping       | Direct mapping to business requirements | Harder to trace               |
| Documentation             | Feature files act as documentation      | Separate documentation needed |
| Living Documentation      | Always updated with code                | Not automatic                 |
| Communication             | Improves team communication             | Limited to technical team     |
| Behavior Focus            | Focus on application behavior           | Focus on implementation       |

---

# 3. Example Framework Structure

### TestNG

```
LoginTest.java
SignupTest.java
PaymentTest.java
```

Tests are written only in **Java classes**.

---

### BDD

```
features/
   login.feature
   signup.feature
   payment.feature
```

Feature files describe **system behavior**.

---

# 4. Key Components of BDD

BDD frameworks typically include:

1. **Feature File** → Business readable scenarios
2. **Step Definition** → Java implementation
3. **Runner Class** → Executes scenarios
4. **Gherkin Keywords**

```
Feature
Scenario
Given
When
Then
And
But
```

---

# 5. When to Use BDD

BDD is useful when:

* Project involves **business stakeholders**
* Requirements need **clear documentation**
* Teams follow **Agile methodology**
* Communication between **QA + Dev + BA** is important

---

# 6. When TestNG Is Better

TestNG is better for:

* **Unit testing**
* **API testing frameworks**
* **Pure automation frameworks**
* **High performance execution**

---

# 7. Best Practice in Industry

Most Selenium automation frameworks use:

```
Cucumber + TestNG + Selenium
```

Where:

* **Cucumber** → Behavior scenarios
* **TestNG** → Execution, reporting, parallel execution
* **Selenium** → Browser automation

---
