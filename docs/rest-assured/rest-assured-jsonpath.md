
# RestAssured JsonPath – Complete Guide with Examples + Practice

---

## ❓ Clarification: "Assume API returns"

When we say:

> Assume API returns the following JSON

It means:

👉 This JSON is inside the **Response object**

Example:

```java
Response response = given().get("/users");
JsonPath jp = response.jsonPath();
```

`jsonPath()` lets you query the response body like a tree.

---

# 📦 Sample JSON (Used for all examples)

```json
{
  "page": 1,
  "total": 3,
  "company": "ABC Tech",
  "users": [
    {
      "id": 101,
      "name": "Umesh",
      "role": "ADMIN",
      "salary": 90000,
      "active": true,
      "skills": ["Java", "Selenium"]
    },
    {
      "id": 102,
      "name": "Amit",
      "role": "USER",
      "salary": 50000,
      "active": false,
      "skills": ["Python"]
    },
    {
      "id": 103,
      "name": "Neha",
      "role": "USER",
      "salary": 60000,
      "active": true,
      "skills": ["Java", "API"]
    }
  ]
}
```

---

# 🚀 Basic Extraction

```java
JsonPath jp = response.jsonPath();

int page = jp.getInt("page");
String company = jp.getString("company");
String firstUser = jp.getString("users[0].name");
```

---

# 🚀 Filtering Examples

```java
jp.getString("users.find { it.role == 'ADMIN' }.name");
jp.getList("users.findAll { it.active }.name");
jp.getInt("users.salary.max()");
```

---

# 🔥 20 Practice Problems (with Answers)

## Q1 Get company name
```java
jp.getString("company");
```

## Q2 Get total users
```java
jp.getInt("total");
```

## Q3 Get first user id
```java
jp.getInt("users[0].id");
```

## Q4 Get last user name
```java
jp.getString("users[-1].name");
```

## Q5 Get all names list
```java
jp.getList("users.name");
```

## Q6 Get all ids as integers
```java
jp.getList("users.id", Integer.class);
```

## Q7 Count users
```java
jp.getInt("users.size()");
```

## Q8 Get all active users
```java
jp.getList("users.findAll { it.active }.name");
```

## Q9 Get first inactive user
```java
jp.getString("users.find { !it.active }.name");
```

## Q10 Get ADMIN role user
```java
jp.getString("users.find { it.role == 'ADMIN' }.name");
```

## Q11 Get users with salary > 55000
```java
jp.getList("users.findAll { it.salary > 55000 }.name");
```

## Q12 Get max salary
```java
jp.getInt("users.salary.max()");
```

## Q13 Get min salary
```java
jp.getInt("users.salary.min()");
```

## Q14 Get sum of salaries
```java
jp.getInt("users.salary.sum()");
```

## Q15 Check if "Java" skill exists
```java
jp.getList("users.skills.flatten()").contains("Java");
```

## Q16 Get second user's first skill
```java
jp.getString("users[1].skills[0]");
```

## Q17 Get all skills combined
```java
jp.getList("users.skills.flatten()");
```

## Q18 Convert first user to Map
```java
Map<String,Object> user = jp.getMap("users[0]");
```

## Q19 Convert users to POJO list
```java
List<User> users = jp.getList("users", User.class);
```

## Q20 Assert user exists
```java
assertTrue(jp.getList("users.name").contains("Umesh"));
```

---

# 🎯 Interview One-Liner

> jsonPath() converts API response into a queryable structure to extract, filter, and validate JSON fields easily.

---

Happy Testing 🚀
