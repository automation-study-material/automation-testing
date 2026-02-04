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

```java
Map<String, String> data = new HashMap<>();
data.put("name", "John");
data.put("job", "Tester");

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

```java
given()
    .baseUri("https://reqres.in")
    .log().all()
.when()
    .get("/api/users/2")
.then()
    .log().body()
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

## 16. How to Revise These Notes

1. Read one section
2. Copy code
3. Run it
4. Modify values
5. Observe response

That’s how confidence is built.

---

If you want next:

* Complete **API Automation Framework**
* **Interview Q&A mapped to these topics**
* **Real project structure (Maven + TestNG)**
* **CI/CD execution (Jenkins)**

Tell me what you want next and I’ll extend this.

---

## 17. Interview Questions & Answers (Mapped to Above Topics)

### Q1. What is an API and why do we test APIs?

**Answer:**
An API is a contract that allows two systems to communicate. We test APIs to validate business logic, data accuracy, performance, and error handling without relying on UI, which makes testing faster, stable, and more reliable.

---

### Q2. Why is API testing preferred over UI testing?

**Answer:**
API testing is faster, less flaky, independent of UI changes, and helps detect defects early in the development cycle. UI tests are mainly for end-to-end validation.

---

### Q3. What is REST and what are its constraints?

**Answer:**
REST is an architectural style for designing networked applications. Its constraints include client-server architecture, statelessness, uniform interface, cacheability, layered system, and optional code-on-demand.

---

### Q4. Difference between POST, PUT, and PATCH?

**Answer:**
POST creates a new resource and is non-idempotent. PUT replaces the entire resource and is idempotent. PATCH updates only specific fields of a resource.

---

### Q5. What does idempotent mean?

**Answer:**
An operation is idempotent if multiple identical requests produce the same result. GET, PUT, and DELETE are idempotent; POST is not.

---

### Q6. What are common HTTP status codes you validate?

**Answer:**
200 (OK), 201 (Created), 204 (No Content), 400 (Bad Request), 401 (Unauthorized), 403 (Forbidden), 404 (Not Found), and 500 (Internal Server Error).

---

### Q7. What is REST Assured and why is it used?

**Answer:**
REST Assured is a Java-based library used for API automation. It simplifies API testing using readable syntax and integrates easily with TestNG, Maven, and CI tools.

---

### Q8. What is JSON Path and where is it used?

**Answer:**
JSON Path is used to extract values from JSON responses for validation, looping, or passing data between API calls.

---

### Q9. What is a POJO and why is it important in API automation?

**Answer:**
A POJO is a Plain Old Java Object used to map JSON payloads. It improves readability, reusability, and maintainability and is considered an industry best practice.

---

### Q10. How do you handle authentication in REST Assured?

**Answer:**
Authentication is handled using headers, tokens, OAuth, or API keys. Tokens are usually generated once and reused using RequestSpecification or utility classes.

---

### Q11. What is RequestSpecification and why do we use it?

**Answer:**
RequestSpecification is used to store common request configurations like base URI, headers, and authentication to avoid duplication and improve framework maintainability.

---

### Q12. How do you validate API responses?

**Answer:**
By validating status codes, response body values, headers, response schema, and execution time.

---

### Q13. How do you debug API automation failures?

**Answer:**
By enabling request and response logging, checking payloads, validating headers, and analyzing response codes and error messages.

---

## 18. CI/CD Execution – Jenkins (Complete Beginner-Friendly Explanation)

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
