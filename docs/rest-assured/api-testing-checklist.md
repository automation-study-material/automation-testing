# Advanced API Testing Guide (Senior / Lead Level)

------------------------------------------------------------------------

# 1️⃣ Advanced API Testing Checklist

## 🔹 Architecture Understanding

-   Understand microservices dependencies
-   Identify upstream and downstream services
-   Verify service contracts (OpenAPI / Swagger)
-   Validate backward compatibility

## 🔹 Contract Testing

-   Validate request & response schema
-   Ensure no breaking changes
-   Consumer-driven contract testing (Pact)

## 🔹 Data Integrity Validation

-   Validate DB updates after API calls
-   Cross-service data consistency
-   Idempotency validation (PUT vs POST)

## 🔹 Security Testing

-   Authentication validation (JWT, OAuth2)
-   Authorization (Role-based access)
-   Token expiration scenarios
-   SQL Injection
-   XSS
-   Rate limiting validation
-   Sensitive data exposure checks

## 🔹 Performance & Scalability

-   Response time benchmarking
-   Load testing (JMeter / Gatling)
-   Stress testing
-   Spike testing
-   Soak testing

## 🔹 Observability Validation

-   Logs verification
-   Monitoring metrics
-   Distributed tracing validation

## 🔹 Negative & Edge Case Testing

-   Invalid payloads
-   Missing headers
-   Invalid content-type
-   Very large payloads
-   Boundary values

------------------------------------------------------------------------

# 2️⃣ Real-Time API Testing Scenarios with Rest Assured

## 🔹 Setup Dependency (Maven)

``` xml
<dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>5.3.0</version>
    <scope>test</scope>
</dependency>
```

------------------------------------------------------------------------

## 🔹 Scenario 1: Validate GET API

``` java
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Test
public void getUserTest() {
    given()
        .baseUri("https://api.example.com")
    .when()
        .get("/users/101")
    .then()
        .statusCode(200)
        .body("id", equalTo(101));
}
```

------------------------------------------------------------------------

## 🔹 Scenario 2: POST API with Body Validation

``` java
@Test
public void createUserTest() {
    String requestBody = "{ "name": "Nitin", "role": "QA" }";

    given()
        .header("Content-Type", "application/json")
        .body(requestBody)
    .when()
        .post("/users")
    .then()
        .statusCode(201)
        .body("name", equalTo("Nitin"));
}
```

------------------------------------------------------------------------

## 🔹 Scenario 3: Token-Based Authentication

``` java
@Test
public void secureApiTest() {
    given()
        .header("Authorization", "Bearer " + token)
    .when()
        .get("/secure-data")
    .then()
        .statusCode(200);
}
```

------------------------------------------------------------------------

## 🔹 Scenario 4: Response Time Validation

``` java
@Test
public void responseTimeTest() {
    given()
    .when()
        .get("/users")
    .then()
        .time(lessThan(2000L));
}
```

------------------------------------------------------------------------

# 3️⃣ CI/CD Pipeline Integration for API Testing (DevOps Focused)

## 🔹 Why Integrate API Tests in CI/CD?

-   Catch defects early
-   Prevent broken deployments
-   Ensure regression coverage
-   Maintain API contracts

------------------------------------------------------------------------

## 🔹 Jenkins Pipeline Example

``` groovy
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/org/repo.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Run API Tests') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
```

------------------------------------------------------------------------

## 🔹 Best Practices for DevOps Integration

### 1️⃣ Run Tests in Different Environments

-   Dev
-   QA
-   Staging

Use environment variables.

### 2️⃣ Parallel Test Execution

-   Use Maven Surefire parallel config
-   Reduce execution time

### 3️⃣ Dockerized API Testing

Example Dockerfile:

``` dockerfile
FROM maven:3.9.6-eclipse-temurin-17
WORKDIR /app
COPY . .
RUN mvn clean test
```

------------------------------------------------------------------------

### 4️⃣ Trigger Tests After Deployment

-   Deploy to staging
-   Trigger smoke API tests
-   Block production deployment if failed

------------------------------------------------------------------------

### 5️⃣ Integrate with Kubernetes

-   Run tests as Kubernetes Job
-   Validate service endpoints
-   Use Helm values for environment config

------------------------------------------------------------------------

# 🎯 Senior-Level Interview Tip

As a Senior/Lead:

-   Focus on architecture-level validation
-   Think about scalability
-   Validate security & performance
-   Ensure CI/CD quality gates
-   Implement contract testing

------------------------------------------------------------------------

End of Advanced API Testing Guide
