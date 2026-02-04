
# Rest Assured OOP Framework (Enterprise Style)

This document explains a **Java Rest Assured API automation framework** using **OOP principles**, including:

- RetryAnalyzer for flaky APIs
- Token handling with ThreadLocal
- Response validation utility
- BDD-style execution

---

## 📁 Folder Structure

```
restassured-oops-framework/
├── base/
│   ├── BaseTest.java
│   └── BaseService.java
├── clients/
│   └── RestClient.java
├── constants/
│   └── Endpoints.java
├── interfaces/
│   └── HttpActions.java
├── listeners/
│   └── RetryAnalyzer.java
├── models/
│   └── LoginRequest.java
├── services/
│   └── LoginService.java
├── utils/
│   ├── RequestSpecUtil.java
│   ├── TokenManager.java
│   └── ResponseValidator.java
└── tests/
    └── LoginApiTest.java
```

---

## 🔁 RetryAnalyzer.java
**Purpose:** Retries flaky API tests automatically.

```java
public class RetryAnalyzer implements IRetryAnalyzer {
    private int count = 0;
    private static final int MAX_RETRY = 2;

    public boolean retry(ITestResult result) {
        if (count < MAX_RETRY) {
            count++;
            return true;
        }
        return false;
    }
}
```

---

## 🔐 TokenManager.java
**Purpose:** Thread-safe token storage for parallel execution.

```java
public class TokenManager {
    private static ThreadLocal<String> token = new ThreadLocal<>();

    public static void setToken(String authToken) {
        token.set(authToken);
    }

    public static String getToken() {
        return token.get();
    }

    public static void clear() {
        token.remove();
    }
}
```

---

## 📦 RequestSpecUtil.java
**Purpose:** Centralized request specification.

```java
public class RequestSpecUtil {
    public static RequestSpecification getSpec() {
        return new RequestSpecBuilder()
            .setBaseUri("https://example.com")
            .addHeader("Authorization", "Bearer " + TokenManager.getToken())
            .setContentType("application/json")
            .build();
    }
}
```

---

## ✅ ResponseValidator.java
**Purpose:** Common response assertions.

```java
public class ResponseValidator {
    public static void validateStatus(Response response, int code) {
        Assert.assertEquals(response.statusCode(), code);
    }

    public static void validateNotNull(Response response, String path) {
        Assert.assertNotNull(response.jsonPath().get(path));
    }
}
```

---

## 🧩 HttpActions.java
**Purpose:** Abstract HTTP contract.

```java
public interface HttpActions {
    Response get(RequestSpecification req, String endpoint);
    Response post(RequestSpecification req, String endpoint);
}
```

---

## 🚀 RestClient.java
**Purpose:** Encapsulates Rest Assured calls.

```java
public class RestClient implements HttpActions {
    public Response post(RequestSpecification req, String endpoint) {
        return given(req).when().post(endpoint);
    }
}
```

---

## 🧱 BaseService.java
**Purpose:** Base class for all API services.

```java
public abstract class BaseService {
    protected RestClient client = new RestClient();
    protected RequestSpecification request = RequestSpecUtil.getSpec();
}
```

---

## 🔑 LoginService.java
**Purpose:** Handles Login API.

```java
public class LoginService extends BaseService {
    public Response login(LoginRequest payload) {
        return client.post(request.body(payload), Endpoints.LOGIN);
    }
}
```

---

## 🧪 LoginApiTest.java (BDD)
**Purpose:** BDD-style readable API test.

```java
@Test(retryAnalyzer = RetryAnalyzer.class)
public void loginTest() {
    givenLoginPayload();
    whenLoginApiCalled();
    thenValidateResponse();
}
```

---

## ⭐ Interview Summary

"My Rest Assured framework applies OOP principles with service abstraction, ThreadLocal token handling, retry mechanisms for flaky APIs, reusable validators, and BDD-style test readability."
