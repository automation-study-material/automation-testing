# Enterprise REST Assured Automation Framework (TestNG)

This document describes a **complete enterprise‑level API automation
framework** using:

-   Rest Assured
-   TestNG
-   Jackson ObjectMapper
-   POJO Serialization / Deserialization
-   Logging Filters
-   Request / Response logging to file
-   Retry Mechanism
-   Token Management (OAuth / JWT)
-   Data Driven Testing
-   Parallel Execution
-   Docker Execution
-   CI/CD Integration

------------------------------------------------------------------------

# 1. Complete Folder Structure

    api-automation-framework
    │
    ├── src
    │   └── test
    │       ├── java
    │       │
    │       │   ├── base
    │       │   │   └── BaseTest.java
    │       │
    │       │   ├── config
    │       │   │   └── ConfigManager.java
    │       │
    │       │   ├── auth
    │       │   │   └── TokenManager.java
    │       │
    │       │   ├── listeners
    │       │   │   ├── TestListener.java
    │       │   │   └── RetryAnalyzer.java
    │       │
    │       │   ├── specs
    │       │   │   ├── RequestSpecBuilderUtil.java
    │       │   │   └── ResponseSpecBuilderUtil.java
    │       │
    │       │   ├── utils
    │       │   │   ├── JacksonUtil.java
    │       │   │   ├── LogUtil.java
    │       │   │   └── ExtentManager.java
    │       │
    │       │   ├── pojo
    │       │   │   └── User.java
    │       │
    │       │   └── tests
    │       │       └── UserAPITest.java
    │       │
    │       └── resources
    │           ├── config
    │           │   ├── dev.properties
    │           │   ├── qa.properties
    │           │   └── prod.properties
    │           │
    │           └── testdata
    │               └── users.xlsx
    │
    ├── Dockerfile
    ├── Jenkinsfile
    └── pom.xml

------------------------------------------------------------------------

# 2. Jackson ObjectMapper

Used for converting **Java object ↔ JSON**.

JacksonUtil.java

``` java
package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    public static String convertObjectToJson(Object obj) {

        try{
            return mapper.writeValueAsString(obj);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static <T> T convertJsonToObject(String json, Class<T> clazz){

        try{
            return mapper.readValue(json, clazz);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
```

------------------------------------------------------------------------

# 3. Request / Response Logging to File

LogUtil.java

``` java
package utils;

import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class LogUtil {

    public static PrintStream logStream(){

        try{
            return new PrintStream(
                new FileOutputStream("logs/api-logs.txt", true)
            );
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
```

Usage

``` java
given()
.filter(new RequestLoggingFilter(LogUtil.logStream()))
.filter(new ResponseLoggingFilter(LogUtil.logStream()))
.get("/users");
```

------------------------------------------------------------------------

# 4. Retry Mechanism

RetryAnalyzer.java

``` java
package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int count = 0;
    int maxRetry = 2;

    public boolean retry(ITestResult result){

        if(count < maxRetry){
            count++;
            return true;
        }

        return false;
    }
}
```

Usage

``` java
@Test(retryAnalyzer = listeners.RetryAnalyzer.class)
```

------------------------------------------------------------------------

# 5. Token Management (OAuth / JWT)

TokenManager.java

``` java
package auth;

import static io.restassured.RestAssured.*;

public class TokenManager {

    static String token;

    public static String getToken(){

        if(token == null){

            token =
            given()
            .contentType("application/json")

            .body("{\"username\":\"admin\",\"password\":\"admin\"}")

            .post("/auth/login")

            .jsonPath()
            .getString("token");

        }

        return token;
    }
}
```

Usage

``` java
given()
.header("Authorization","Bearer " + TokenManager.getToken())
.get("/users");
```

------------------------------------------------------------------------

# 6. Parallel Execution with TestNG

testng.xml

``` xml
<suite name="API Suite" parallel="methods" thread-count="5">

<test name="API Tests">

<classes>
<class name="tests.UserAPITest"/>
</classes>

</test>

</suite>
```

Benefits

-   Faster execution
-   Supports CI pipelines
-   Large regression suites run quickly

------------------------------------------------------------------------

# 7. Dockerized API Test Execution

Dockerfile

    FROM maven:3.9.6-eclipse-temurin-17

    WORKDIR /app

    COPY . .

    RUN mvn clean install

    CMD ["mvn","test"]

Build Image

    docker build -t api-tests .

Run Tests

    docker run api-tests

------------------------------------------------------------------------

# 8. CI/CD Integration (Jenkins)

Jenkinsfile

    pipeline {

    agent any

    stages {

    stage('Checkout'){
    steps{
    git 'https://github.com/company/api-tests'
    }
    }

    stage('Build'){
    steps{
    sh 'mvn clean install'
    }
    }

    stage('Run Tests'){
    steps{
    sh 'mvn test'
    }
    }

    stage('Publish Report'){
    steps{
    archiveArtifacts artifacts: 'test-output/*'
    }
    }

    }

    }

------------------------------------------------------------------------

# 9. GitHub Actions CI Example

.github/workflows/api-tests.yml

    name: API Tests

    on: [push]

    jobs:

    build:

    runs-on: ubuntu-latest

    steps:

    - uses: actions/checkout@v3

    - name: Setup Java
    uses: actions/setup-java@v3
    with:
      distribution: temurin
      java-version: 17

    - name: Run Tests
    run: mvn clean test

------------------------------------------------------------------------

# 10. Complete Framework Flow

    Environment Config
          ↓
    BaseTest
          ↓
    Request Specification
          ↓
    Authentication Token
          ↓
    Test Execution
          ↓
    Retry Mechanism
          ↓
    Logging Filters
          ↓
    Response Validation
          ↓
    Extent Reports
          ↓
    CI/CD Pipeline

------------------------------------------------------------------------

# 11. Interview Explanation (Very Important)

When asked **"Explain your API automation framework architecture"**

You can answer:

1.  Framework built using **Rest Assured + TestNG**
2.  Environment configs managed via **property files**
3.  Authentication handled via **TokenManager**
4.  JSON serialization handled via **Jackson ObjectMapper**
5.  Request and Response specs reusable
6.  Logging captured using **RestAssured Filters**
7.  Failed tests retried using **RetryAnalyzer**
8.  Reports generated using **Extent Reports**
9.  Tests executed in **parallel using TestNG**
10. Tests executed in **Docker containers**
11. CI/CD integrated using **Jenkins or GitHub Actions**

------------------------------------------------------------------------

END
