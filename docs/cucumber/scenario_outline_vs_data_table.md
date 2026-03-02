# 🚀 Scenario Outline vs DataTable (Complete Interview Notes)

This document covers:

-   Basic difference
-   Execution behavior
-   Reporting difference
-   Real-time usage
-   Complex DataTable examples
-   Design decisions (Senior level thinking)

------------------------------------------------------------------------

# ✅ 1️⃣ Scenario Outline

## 🔹 Definition

Scenario Outline is used to execute the same scenario multiple times
with different datasets.

Each row in the Examples table creates a new scenario execution.

------------------------------------------------------------------------

## ✅ Structure

``` gherkin
Scenario Outline: Login with multiple credentials
  Given User is on login page
  When User enters "<username>" and "<password>"
  Then Login should be "<status>"

Examples:
  | username | password | status  |
  | admin    | admin123 | success |
  | user     | wrong123 | failure |
```

------------------------------------------------------------------------

## 🔹 How It Works

-   Scenario runs once per row
-   2 rows → 2 executions
-   Each execution appears separately in report

------------------------------------------------------------------------

## 🔹 Step Definition

``` java
@When("User enters {string} and {string}")
public void user_enters_credentials(String username, String password) {

    driver.findElement(By.id("user")).sendKeys(username);
    driver.findElement(By.id("pass")).sendKeys(password);
}

@Then("Login should be {string}")
public void login_should_be(String status) {

    boolean isLoggedIn = driver.findElements(By.id("logout")).size() > 0;

    if(status.equalsIgnoreCase("success")) {
        Assert.assertTrue(isLoggedIn);
    } else {
        Assert.assertFalse(isLoggedIn);
    }
}
```

------------------------------------------------------------------------

## 🎯 Key Characteristics

-   Multiple executions
-   Clean reporting
-   Ideal for positive/negative combinations
-   Best for independent test cases

------------------------------------------------------------------------

# ✅ 2️⃣ DataTable

## 🔹 Definition

DataTable passes multiple data rows inside a single scenario execution.

Scenario runs only once, but data is iterated inside step definition.

------------------------------------------------------------------------

## ✅ Basic Example

``` gherkin
Scenario: Register multiple users
  When user enters below user details
    | name  | email           | city   |
    | Nitin | nitin@gmail.com | Mumbai |
    | Rahul | rahul@gmail.com | Pune   |
```

------------------------------------------------------------------------

## 🔹 Step Definition

``` java
@When("user enters below user details")
public void userEntersBelowUserDetails(DataTable table) {

    List<Map<String, String>> users = table.asMaps(String.class, String.class);

    for (Map<String, String> user : users) {
        System.out.println(user.get("name"));
        System.out.println(user.get("email"));
        System.out.println(user.get("city"));
    }
}
```

------------------------------------------------------------------------

## 🎯 Key Characteristics

-   Single execution
-   Data handled using DataTable
-   Used for bulk processing
-   One entry in report

------------------------------------------------------------------------

# 🔥 Core Difference (Interview Table)

  Feature             Scenario Outline        DataTable
  ------------------- ----------------------- -------------------------
  Execution           Multiple times          Single time
  Data Location       Examples section        Inside step
  Reporting           Separate test entries   One entry
  Failure Isolation   Per dataset             Entire scenario fails
  Best For            Independent tests       Bulk transactional flow

------------------------------------------------------------------------

# 🚀 Advanced DataTable Examples (SDET Level)

## 1️⃣ Multiple Users (List of Maps)

``` gherkin
Scenario: Create users with full details
  When user enters below user details
    | name   | email            | city   | mobile | age |
    | Nitin  | nitin@gmail.com  | Mumbai | 98765  | 28  |
    | Rahul  | rahul@gmail.com  | Pune   | 91234  | 30  |
```

``` java
List<Map<String, String>> users = table.asMaps(String.class, String.class);

for (Map<String, String> user : users) {
    System.out.println(user.get("name"));
}
```

✔ Uses asMaps()
✔ Most common interview case

------------------------------------------------------------------------

## 2️⃣ Convert DataTable to POJO (Nested Object)

``` gherkin
Scenario: Create user with address
  When user enters user details with address
    | name  | email           | street  | city   | pincode |
    | Nitin | nitin@gmail.com | MG Road | Mumbai | 400001  |
```

``` java
Map<String, String> data = table.asMaps(String.class, String.class).get(0);

Address address = new Address(
        data.get("street"),
        data.get("city"),
        data.get("pincode")
);

User user = new User(
        data.get("name"),
        data.get("email"),
        address
);
```

✔ Manual mapping\
✔ Nested object handling\
✔ Frequently asked in SDET interviews

------------------------------------------------------------------------

## 3️⃣ List Inside List (User with Roles)

``` gherkin
Scenario: Create user with roles
  When user enters user and roles
    | name  | roles              |
    | Nitin | ADMIN,USER,MANAGER |
```

``` java
Map<String, String> data = table.asMaps(String.class, String.class).get(0);

List<String> roles = Arrays.asList(data.get("roles").split(","));

User user = new User(data.get("name"), roles);
```

✔ Use split()
✔ Convert string to List
✔ Advanced parsing

------------------------------------------------------------------------

# 🚀 Real-World Use Case Comparison

## 🔹 Example: Register 10 Users

### If using Scenario Outline:

-   Opens flow 10 times
-   10 separate report entries
-   3rd user fails → only 3rd test fails

### If using DataTable:

-   Opens flow once
-   Loops internally
-   3rd user fails → whole scenario fails

------------------------------------------------------------------------

# 🧠 Senior-Level Decision Rule

## Use Scenario Outline when:

-   Each dataset represents independent validation
-   Reporting separation is important
-   Parallel execution is required

## Use DataTable when:

-   Same page
-   Same business transaction
-   Bulk operation
-   Data is logically grouped

------------------------------------------------------------------------

# 🎯 Performance & Parallel Execution

  Factor              Scenario Outline         DataTable
  ------------------- ------------------------ ----------------------
  Parallel Friendly   Yes                      No (single scenario)
  Execution Speed     Slower (repeated flow)   Faster
  Debugging           Easy                     Harder
  CI Visibility       Better                   Limited

------------------------------------------------------------------------

# 🏆 Final Interview Answer (Best Version)

Scenario Outline is used for data-driven testing where the same scenario
executes multiple times with different datasets and each execution is
reported separately.

DataTable is used to pass multiple data rows into a single scenario
execution, typically for bulk operations within the same transaction
flow.

------------------------------------------------------------------------

# 🔥 Ultimate Summary

-   🔹 Test Case Driven → Use Scenario Outline
-   🔹 Data Driven Inside Same Flow → Use DataTable
-   🔹 Reporting Matters → Scenario Outline
-   🔹 Performance Matters → DataTable
