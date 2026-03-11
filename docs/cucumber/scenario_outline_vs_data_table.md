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
Scenario: Create users with full details
  Given user test setup is ready
  When user enters below user details
    | name   | email            | city   | mobile | age |
    | Nitin  | nitin@gmail.com  | Mumbai | 98765  | 28  |
    | Rahul  | rahul@gmail.com  | Pune   | 91234  | 30  |
```

------------------------------------------------------------------------

## 🔹 Step Definition

``` java
1  import io.cucumber.datatable.DataTable;
2  import io.cucumber.java.en.Given;
3  import io.cucumber.java.en.When;
4  import java.util.List;
5  import java.util.Map;
6
7  public class UserStepDefinition {
8
9      @Given("user test setup is ready")
10     public void user_test_setup_is_ready() {
11         System.out.println("Step 1 Executed: GIVEN step - Test setup completed");
12     }
13
14     @When("user enters below user details")
15     public void user_enters_below_user_details(DataTable table) {
16
17         System.out.println("Step 2 Executed: WHEN step - Reading DataTable");
18
19         List<Map<String, String>> users =
20                 table.asMaps(String.class, String.class);
21
22         for (Map<String, String> user : users) {
23
24             System.out.println("Processing user record...");
25
26             System.out.println("Name   : " + user.get("name"));
27             System.out.println("Email  : " + user.get("email"));
28             System.out.println("City   : " + user.get("city"));
29             System.out.println("Mobile : " + user.get("mobile"));
30             System.out.println("Age    : " + user.get("age"));
31
32             System.out.println("-------------------------");
33         }
34     }
35 }
```
Output- When we run scenario
```text
Step 1 Executed: GIVEN step - Test setup completed

Step 2 Executed: WHEN step - Reading DataTable

Processing user record...
Name   : Nitin
Email  : nitin@gmail.com
City   : Mumbai
Mobile : 98765
Age    : 28
-------------------------

Processing user record...
Name   : Rahul
Email  : rahul@gmail.com
City   : Pune
Mobile : 91234
Age    : 30
-------------------------
```
------------------------------------------------------------------------

## 🎯 Key Characteristics

-   Single execution
-   Data handled using DataTable
-   Used for bulk processing
-   One entry in report

------------------------------------------------------------------------

# 🔥 Core Difference (Interview Table)

| Feature           | Scenario Outline      | DataTable              |
|------------------|----------------------|------------------------|
| **Execution**     | Multiple times       | Single time            |
| **Data Location** | Examples section     | Inside step            |
| **Reporting**     | Separate test entries| One entry              |
| **Failure Isolation** | Per dataset     | Entire scenario fails  |
| **Best For**      | Independent tests    | Bulk transactional flow|

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

### Address Class
- Explanation:
  - Address object stores:
    - street
    - city
    - pincode
      
``` java
1  public class Address {
2
3      private String street;
4      private String city;
5      private String pincode;
6
7      public Address(String street, String city, String pincode) {
8          this.street = street;
9          this.city = city;
10         this.pincode = pincode;
11     }
12
13     public String getStreet() {
14         return street;
15     }
16
17     public String getCity() {
18         return city;
19     }
20
21     public String getPincode() {
22         return pincode;
23     }
24 }
```

### User Class
- Explanation:
  - User object stores:
    - name
    - email
    - address (nested object)
   
```java
1  public class User {
2
3      private String name;
4      private String email;
5      private Address address;
6
7      public User(String name, String email, Address address) {
8          this.name = name;
9          this.email = email;
10         this.address = address;
11     }
12
13     public String getName() {
14         return name;
15     }
16
17     public String getEmail() {
18         return email;
19     }
20
21     public Address getAddress() {
22         return address;
23     }
24 }
```

### Stef Def Class
```java
1  import io.cucumber.datatable.DataTable;
2  import io.cucumber.java.en.When;
3  import java.util.Map;
4
5  public class UserStepDefinition {
6
7      @When("user enters user details with address")
8      public void user_enters_user_details_with_address(DataTable table) {
9
10         Map<String, String> data =
11                 table.asMaps(String.class, String.class).get(0);
12
13         Address address = new Address(
14                 data.get("street"),
15                 data.get("city"),
16                 data.get("pincode")
17         );
18
19         User user = new User(
20                 data.get("name"),
21                 data.get("email"),
22                 address
23         );
24
25         System.out.println("User Name: " + user.getName());
26         System.out.println("Email: " + user.getEmail());
27         System.out.println("Street: " + user.getAddress().getStreet());
28         System.out.println("City: " + user.getAddress().getCity());
29         System.out.println("Pincode: " + user.getAddress().getPincode());
30     }
31 }
```

Output
```text
User Name: Nitin
Email: nitin@gmail.com
Street: MG Road
City: Mumbai
Pincode: 400001
```
✔ Manual mapping
✔ Nested object handling
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
