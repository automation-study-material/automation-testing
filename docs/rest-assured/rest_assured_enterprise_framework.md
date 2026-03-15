# Enterprise REST Assured API Automation Framework

## Overview

This document describes a **production‑grade REST Assured API Automation
Framework** used for scalable API testing in enterprise environments.

### Technologies Used

-   Rest Assured
-   TestNG
-   Hamcrest Assertions
-   Jackson ObjectMapper
-   JSON Schema Validation
-   Extent Reports
-   Allure Reports
-   Maven
-   Apache POI (Excel Data Driven)
-   Java OOP Principles

------------------------------------------------------------------------

# 1. Framework Architecture

    enterprise-api-automation-framework
    │
    ├── src/main/java
    │   ├── base
    │   ├── builder
    │   ├── client
    │   ├── config
    │   ├── engine
    │   ├── auth
    │   ├── models
    │   │   ├── request
    │   │   └── response
    │   ├── specs
    │   ├── reporting
    │   └── utils
    │
    ├── src/test/java
    │   └── tests
    │
    ├── src/test/resources
    │   ├── config
    │   ├── data
    │   └── schemas
    │
    ├── testng.xml
    └── pom.xml

------------------------------------------------------------------------

# 2. API Automation Layers

    Test Layer
        │
        ▼
    Client Layer
    (API specific methods)
        │
        ▼
    Generic API Engine
    (Executes REST methods)
        │
        ▼
    Request Builder Layer
    (headers, body, params)
        │
        ▼
    REST Assured Core
        │
        ▼
    Response Processing Layer
    (JSON → POJO conversion)
        │
        ▼
    Validation Layer
    (Hamcrest + Schema validation)
        │
        ▼
    Reporting Layer
    (Extent + Allure)

### Layer Responsibilities

| Layer              | Responsibility              |
| ------------------ | --------------------------- |
| Test Layer         | Contains TestNG test cases  |
| Client Layer       | API specific business logic |
| Generic API Engine | Executes HTTP methods       |
| Request Builder    | Builds dynamic API requests |
| REST Assured       | Sends HTTP requests         |
| Response Layer     | Converts JSON to POJO       |
| Validation Layer   | Validates API responses     |
| Reporting Layer    | Generates reports           |


------------------------------------------------------------------------

# 3. Request / Response Flow

    Test Case
       │
       ▼
    Create Payload / Data
       │
       ▼
    Request Builder
    (add headers, body)
       │
       ▼
    Generic API Engine
       │
       ▼
    REST Assured Request
       │
       ▼
    API Server
       │
       ▼
    Response Received
       │
       ▼
    Jackson ObjectMapper
    (JSON → POJO)
       │
       ▼
    Assertions
    (Hamcrest)
       │
       ▼
    Schema Validation
       │
       ▼
    Reports Generated

------------------------------------------------------------------------

# 4. Test Execution Pipeline

    Developer Commit
           │
           ▼
    CI Pipeline Trigger (Jenkins / GitHub Actions)
           │
           ▼
    Maven Build
           │
           ▼
    Environment Selection
    (dev / qa / prod)
           │
           ▼
    TestNG Test Execution
           │
           ▼
    Parallel API Tests
           │
           ▼
    Retry Failed Tests
    (Retry Analyzer)
           │
           ▼
    Generate Reports
    (Extent + Allure)
           │
           ▼
    Publish Test Results

------------------------------------------------------------------------

# 5. Generic API Engine

Centralized class that executes all API calls.

    GET
    POST
    PUT
    DELETE
    PATCH

Benefits: - Avoids repeated RestAssured code - Centralized API
execution - Easy maintenance

------------------------------------------------------------------------

# 6. Request Builder Pattern

Builds dynamic API requests.

Responsibilities: - Add headers - Add request body - Add query
parameters - Add authentication token

Benefits: - Fluent request building - Clean code - Reusable components

------------------------------------------------------------------------

# 7. Token Management

Handles authentication tokens.

    Login API → Get Token → Store Token → Reuse Token

Features: - Token caching - Automatic token refresh - Centralized
authentication

------------------------------------------------------------------------

# 8. Data Driven Testing

Framework supports:

### JSON Data

    users.json

### Excel Data

    users.xlsx

DataProvider reads test data and runs multiple API tests.

Benefits: - Run multiple test scenarios - No code change required

------------------------------------------------------------------------

# 9. Dynamic Payload Generation

Payloads generated dynamically using:

-   UUID
-   Random values
-   Timestamp
-   Faker libraries

Example:

    User_12345
    User_98374

Prevents duplicate data issues.

------------------------------------------------------------------------

# 10. API Chaining

Uses response data from one API in another API.

Example flow:

    Create User
         │
         ▼
    Extract User ID
         │
         ▼
    Get User
         │
         ▼
    Update User
         │
         ▼
    Delete User

Benefits: - Real workflow testing - End‑to‑end API validation

------------------------------------------------------------------------

# 11. Schema Validation

Validates response structure using JSON Schema.

Example:

    user-schema.json

Benefits: - Ensures contract validation - Detects API changes quickly

------------------------------------------------------------------------

# 12. Retry Analyzer

Automatically retries failed tests.

    Max Retry = 2

Useful for: - Network instability - Temporary API failures

------------------------------------------------------------------------

# 13. Reporting

## Extent Reports

HTML report with: - Step logs - Request/response details - Screenshots

## Allure Reports

Provides: - Trend analysis - Execution history - Graphical dashboards

Command:

    mvn clean test
    allure serve target/allure-results

------------------------------------------------------------------------

# 14. Parallel Execution

Configured in **TestNG**.

    thread-count=5
    parallel=tests

Benefits: - Faster execution - CI/CD friendly

------------------------------------------------------------------------

# 15. Environment Switching

Supports:

    dev
    qa
    prod

Run command:

    mvn test -Denv=qa

Properties file automatically loaded.

------------------------------------------------------------------------

# 16. Java OOP Concepts Used

  Concept         Implementation
  --------------- -------------------------------
  Encapsulation   POJO request/response classes
  Inheritance     BaseTest class
  Abstraction     API Engine
  Polymorphism    Request Builder methods
  Modularity      Layered architecture
  Reusability     Utility classes

------------------------------------------------------------------------

# 17. Advantages of the Framework

-   Highly scalable architecture
-   Clean layered design
-   Supports CI/CD pipelines
-   Reusable API execution engine
-   Dynamic test data generation
-   Environment independent testing
-   Advanced reporting capabilities
-   Parallel test execution
-   Easy maintenance

------------------------------------------------------------------------

# 18. Conclusion

This framework design provides a **robust, maintainable, and scalable
API automation solution** suitable for:

-   Enterprise automation teams
-   CI/CD pipelines
-   Large microservices architectures
-   End‑to‑end API validation

The modular architecture ensures **high reusability, faster execution,
and better maintainability**.
