# API Testing with REST Assured – Deep Dive (Beginner → 4 Years Experience)

These notes are written to be **read slowly and understood**, not skimmed. Every concept includes **why it exists**, **when it’s used**, and **complete working code snippets** so nothing feels magical or confusing.

---

## 1. What is an API? (Real-World Explanation)

An **API (Application Programming Interface)** is a contract that allows two software systems to communicate.

### Real example:

* A mobile app asks for a list of hotels
* The backend fetches data from database
* API sends only required data back

The UI never talks directly to the database.

```
Mobile App / Web UI → API → Backend Logic → Database
```

### Why APIs are critical

* Same backend supports **Web, Mobile, Third-party apps**
* Frontend & backend can be written in different languages
* Improves **security, scalability, maintainability**

---

## 2. What is API Testing?

API Testing means validating:

* Request structure
* Response correctness
* Business logic
* Error handling
* Performance and security (basic level)

### Why API testing is preferred over UI testing

* Faster execution
* Less flaky
* No UI dependency
* Early bug detection

---

## 3. REST Architecture Explained Clearly

**REST (Representational State Transfer)** is an architectural style.

### REST Principles

1. **Client–Server** – UI and backend are independent
2. **Stateless** – Every request contains all information
3. **Uniform Interface** – Uses HTTP methods
4. **Cacheable** – Responses can be cached
5. **Layered System** – Security, load balancer layers allowed

---

## 4. HTTP Methods (With Business Meaning)

### GET – Fetch Data

* Does not modify data
* Safe and idempotent

### POST – Create Data

* Creates new resource
* Not idempotent

### PUT – Update / Replace

* Updates entire resource
* Idempotent

### PATCH – Partial Update

* Updates selected fields

### DELETE – Remove Data

* Deletes resource

---

## 5. HTTP Status Codes (Tester’s Thinking)

### Success

* 200 OK – Request successful
* 201 Created – Resource created
* 204 No Content – Success, no body

### Client Errors

* 400 – Bad request / invalid payload
* 401 – Authentication failed
* 403 – Permission issue
* 404 – Resource not found

### Server Errors

* 500 – Internal server error
* 503 – Service down

---

## 6. REST Assured Introduction

REST Assured is a Java library used to test REST APIs.

### Why testers use it

* Easy syntax
* Java-based
* Integrates with TestNG
* Supports JSON & XML

---

## 7. Maven Dependencies (Complete)

```xml
<dependencies>
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.3.0</version>
    </dependency>

    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.8.0</version>
        <scope>test</scope>
    </dependency>

    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.15.2</version>
    </dependency>
</dependencies>
```

---

## 8. First Complete REST Assured Test

```java
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class GetUsersTest {

    @Test
    public void getUsers() {

        given()
            .baseUri("https://reqres.in")
        .when()
            .get("/api/users?page=2")
        .then()
            .statusCode(200)
            .body("page", equalTo(2))
            .body("data.size()", greaterThan(0));
    }
}
```

### Explanation (Line by line)

* `given()` → request setup
* `when()` → action
* `then()` → validation

---

## 9. Sending Request Body (All Ways)

### 9.1 String Payload

```java
String payload = "{\"name\":\"John\",\"job\":\"Tester\"}";

given()
    .baseUri("https://reqres.in")
    .contentType("application/json")
    .body(payload)
.when()
    .post("/api/users")
.then()
    .statusCode(201);
```

---

### 9.2 HashMap Payload
#### Json Reuest
```json
{
  "name": "John",
  "job": "QA Engineer",
  "age": 30,
  "isActive": true,
  "address": {
    "street": "MG Road",
    "city": "Pune",
    "zip": "411001"
  },
  "skills": ["Java", "Selenium", "API"],
  "projects": [
    {
      "projectName": "Banking App",
      "duration": 12
    },
    {
      "projectName": "E-commerce",
      "duration": 8
    }
  ]
}
```
```java
import java.util.*;

Map<String, Object> data = new HashMap<>();

// Simple fields
data.put("name", "John");
data.put("job", "QA Engineer");
data.put("age", 30);
data.put("isActive", true);

// Nested Object (address)
Map<String, Object> address = new HashMap<>();
address.put("street", "MG Road");
address.put("city", "Pune");
address.put("zip", "411001");

data.put("address", address);

// Array (skills)
List<String> skills = Arrays.asList("Java", "Selenium", "API");
data.put("skills", skills);

// Array of Objects (projects)
Map<String, Object> project1 = new HashMap<>();
project1.put("projectName", "Banking App");
project1.put("duration", 12);

Map<String, Object> project2 = new HashMap<>();
project2.put("projectName", "E-commerce");
project2.put("duration", 8);

List<Map<String, Object>> projects = new ArrayList<>();
projects.add(project1);
projects.add(project2);

data.put("projects", projects);

given()
    .baseUri("https://reqres.in")
    .contentType("application/json")
    .body(data)
.when()
    .post("/api/users")
.then()
    .statusCode(201);

```

---

### 9.3 JSON File Payload

```java
File file = new File("src/test/resources/user.json");

given()
    .baseUri("https://reqres.in")
    .contentType("application/json")
    .body(file)
.when()
    .post("/api/users")
.then()
    .statusCode(201);
```

---

## 10. POJO Concept (Very Important)

### POJO Class

```java
public class User {
    private String name;
    private String job;

    public User() {}

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getJob() { return job; }
    public void setJob(String job) { this.job = job; }
}
```

### Using POJO in Test

```java
User user = new User("John", "Tester");

given()
    .baseUri("https://reqres.in")
    .contentType("application/json")
    .body(user)
.when()
    .post("/api/users")
.then()
    .statusCode(201);
```

---

## 11. JSON Path – Complete Usage

```java
String response = given()
    .baseUri("https://reqres.in")
.when()
    .get("/api/users?page=2")
.then()
    .extract().response().asString();

JsonPath js = new JsonPath(response);

int totalPages = js.getInt("total_pages");
int userCount = js.getInt("data.size()");
String firstEmail = js.getString("data[0].email");
```

---

## 12. RequestSpecification (Framework Level)

```java
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected RequestSpecification request;

    @BeforeClass
    public void setup() {
        request = given()
            .baseUri("https://reqres.in")
            .contentType("application/json");
    }
}
```

### Using It

```java
public class CreateUserTest extends BaseTest {

    @Test
    public void createUser() {
        request
            .body(new User("Alex", "QA"))
        .when()
            .post("/api/users")
        .then()
            .statusCode(201);
    }
}
```

---

## 13. Logging (Debugging Like a Pro)

Logging helps understand **what was sent** and **what was received** when tests fail.

```java
given()
    .baseUri("https://reqres.in")
    .log().all()              // logs request details
.when()
    .get("/api/users/2")
.then()
    .log().status()           // logs status code
    .log().body()             // logs response body
    .statusCode(200);
```

---

## 14. Authentication – Bearer Token (Full Example)

```java
String token = "your_token_here";

given()
    .baseUri("https://api.example.com")
    .header("Authorization", "Bearer " + token)
.when()
    .get("/profile")
.then()
    .statusCode(200);
```

---

## 15. Best Practices (Industry Standard)

* Always validate status code
* Validate response body
* Avoid hard-coded data
* Use POJOs
* Centralize auth logic
* Use RequestSpecification
* Separate test data

---

## 16. Assertion Validation (Very Important for Interviews & Projects)

Assertions decide **pass or fail** of a test. Interviewers expect you to know **what you validate and why**.

### 16.1 Status Code Assertion

```java
given()
    .baseUri("https://reqres.in")
.when()
    .get("/api/users/2")
.then()
    .statusCode(200);
```

Why: Confirms request succeeded.

---

### 16.2 Response Body Field Validation

```java
given()
    .baseUri("https://reqres.in")
.when()
    .get("/api/users/2")
.then()
    .body("data.id", equalTo(2))
    .body("data.email", containsString("@"));
```

Why: Ensures correct data returned.

---

### 16.3 Multiple Assertions Together

```java
given()
    .baseUri("https://reqres.in")
.when()
    .get("/api/users/2")
.then()
    .statusCode(200)
    .body("data.first_name", notNullValue())
    .body("data.last_name", notNullValue());
```

---

### 16.4 Header Validation

```java
given()
    .baseUri("https://reqres.in")
.when()
    .get("/api/users/2")
.then()
    .header("Content-Type", containsString("application/json"));
```

---

### 16.5 Response Time Validation

```java
given()
    .baseUri("https://reqres.in")
.when()
    .get("/api/users/2")
.then()
    .time(lessThan(2000L));
```

Why: Basic performance validation.

---

### 16.6 Schema Validation (Interview Favorite)

```java
given()
    .baseUri("https://reqres.in")
.when()
    .get("/api/users/2")
.then()
    .assertThat()
    .body(matchesJsonSchemaInClasspath("userSchema.json"));
```

Why: Validates complete response structure.

---

## 17. How to Revise These Notes

1. Read concept
2. Understand **why assertion is used**
3. Run code
4. Intentionally break assertion
5. Observe failure message

---

If you want next:

* Complete **API Automation Framework**
* **Interview Q&A mapped to these topics**
* **Real project structure (Maven + TestNG)**
* **CI/CD execution (Jenkins)**

Tell me what you want next and I’ll extend this.

---

## 17. Interview Questions & Answers (With Code & Explanation)

### Q1. How do you validate an API response?

**Answer:**
I validate status code, response body, headers, schema, and response time.

```java
given()
    .baseUri("https://reqres.in")
.when()
    .get("/api/users/2")
.then()
    .statusCode(200)
    .body("data.id", equalTo(2));
```

---

### Q2. How do you validate JSON response fields?

**Answer:**
Using JSON Path with Hamcrest matchers.

```java
.body("data.email", containsString("@"))
.body("data.first_name", notNullValue());
```

---

### Q3. How do you pass data from one API to another?

**Answer:**
By extracting response values using JsonPath.

```java
String response = given().get("/api/users/2").asString();
JsonPath js = new JsonPath(response);
int userId = js.getInt("data.id");
```

---

### Q4. How do you handle assertions in REST Assured?

**Answer:**
REST Assured uses Hamcrest assertions for readable and fluent validations.

```java
.body("data.id", equalTo(2))
.body("data.email", containsString("reqres"));
```

---

### Q5. What validations do you perform in real projects?

**Answer:**
I validate status code, mandatory fields, data correctness, headers, schema, and response time.

---

### Q6. What happens if an assertion fails?

**Answer:**
Test execution stops for that test and the framework marks it as failed with a detailed error message.

---

### Q7. How do you validate error responses?

**Answer:**
By asserting error status codes and messages.

```java
given()
    .get("/api/users/999")
.then()
    .statusCode(404);
```

---

## 18. CI/CD Execution – Jenkins (Complete Beginner-Friendly Explanation)

– Jenkins (Complete Beginner-Friendly Explanation)

### What is CI/CD?

CI/CD automates build, test, and deployment processes so code changes are validated continuously.

* **CI (Continuous Integration):** Run tests automatically on every code commit
* **CD (Continuous Delivery):** Prepare code for release

---

### Why Jenkins for API Automation?

* Open source
* Easy Maven integration
* Widely used in industry
* Supports scheduled and triggered executions

---

### Jenkins Job Flow for API Automation

```
Developer Commit → GitHub → Jenkins → Maven Build → REST Assured Tests → Report
```

---

### Step 1. Prerequisites

* Java installed
* Maven installed
* Jenkins installed
* Git repository with API automation code

---

### Step 2. Maven Project Structure (Industry Standard)

```
api-automation
 ├── pom.xml
 ├── src/test/java
 │    ├── tests
 │    ├── base
 │    └── utils
 └── src/test/resources
```

---

### Step 3. TestNG Configuration (testng.xml)

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="API Suite">
    <test name="API Tests">
        <classes>
            <class name="tests.GetUsersTest"/>
            <class name="tests.CreateUserTest"/>
        </classes>
    </test>
</suite>
```

---

### Step 4. Jenkins Job Configuration (Freestyle Job)

1. Open Jenkins
2. Create **New Item → Freestyle Project**
3. Configure Source Code Management → Git
4. Add GitHub repository URL
5. Add Maven build step

**Maven Command:**

```
mvn clean test
```

---

### Step 5. Jenkins Execution Result

* Console output shows API execution logs
* TestNG results displayed
* Build marked as SUCCESS or FAILURE

---

### Step 6. Common Jenkins Interview Questions

**Q. How do you trigger Jenkins jobs?**
A. Manually, scheduled (cron), or via Git webhook.

**Q. What happens if API tests fail?**
A. Jenkins marks the build as failed and stops the pipeline.

**Q. Can API tests run headlessly in Jenkins?**
A. Yes, API tests don’t need UI or browser.

---

### Jenkins + API Automation Best Practices

* Keep Jenkinsfile or job simple
* Do not hard-code credentials
* Separate environments (QA, UAT)
* Generate reports after execution

---
