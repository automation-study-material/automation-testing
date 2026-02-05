
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

## Example 1 – ADMIN user
```java
jp.getString("users.find { it.role == 'ADMIN' }.name");
```
Output:
```
Umesh
```

---

## Example 2 – Active users
```java
jp.getList("users.findAll { it.active }.name");
```
Output:
```
[Umesh, Neha]
```

---

## Example 3 – Max salary
```java
jp.getInt("users.salary.max()");
```
Output:
```
90000
```

---


# 🔥 20 Practice Problems WITH ANSWERS + OUTPUTS

## Q1 Get company name
```java
jp.getString("company");
```
Output: `ABC Tech`

---

## Q2 Get total users
```java
jp.getInt("total");
```
Output: `3`

---

## Q3 Get first user id
```java
jp.getInt("users[0].id");
```
Output: `101`

---

## Q4 Get last user name
```java
jp.getString("users[-1].name");
```
Output: `Neha`

---

## Q5 Get all names list
```java
jp.getList("users.name");
```
Output:
```
[Umesh, Amit, Neha]
```

---

## Q6 Get all ids as integers
```java
jp.getList("users.id", Integer.class);
```
Output:
```
[101, 102, 103]
```

---

## Q7 Count users
```java
jp.getInt("users.size()");
```
Output: `3`

---

## Q8 Get all active users
```java
jp.getList("users.findAll { it.active }.name");
```
Output:
```
[Umesh, Neha]
```

---

## Q9 Get first inactive user
```java
jp.getString("users.find { !it.active }.name");
```
Output: `Amit`

---

## Q10 Get ADMIN role user
```java
jp.getString("users.find { it.role == 'ADMIN' }.name");
```
Output: `Umesh`

---

## Q11 Get users with salary > 55000
```java
jp.getList("users.findAll { it.salary > 55000 }.name");
```
Output:
```
[Umesh, Neha]
```

---

## Q12 Get max salary
```java
jp.getInt("users.salary.max()");
```
Output: `90000`

---

## Q13 Get min salary
```java
jp.getInt("users.salary.min()");
```
Output: `50000`

---

## Q14 Get sum of salaries
```java
jp.getInt("users.salary.sum()");
```
Output: `200000`

---

## Q15 Check if Java skill exists
```java
jp.getList("users.skills.flatten()").contains("Java");
```
Output: `true`

---

## Q16 Get second user's first skill
```java
jp.getString("users[1].skills[0]");
```
Output: `Python`

---

## Q17 Get all skills combined
```java
jp.getList("users.skills.flatten()");
```
Output:
```
[Java, Selenium, Python, Java, API]
```

---

## Q18 Convert first user to Map
```java
Map<String,Object> user = jp.getMap("users[0]");
```
Output:
```
{id=101, name=Umesh, role=ADMIN, salary=90000, active=true, skills=[Java, Selenium]}
```

---

## Q19 Convert users to POJO list
```java
List<User> users = jp.getList("users", User.class);
```
Output:
```
3 User objects created
```

---

## Q20 Assert user exists
```java
jp.getList("users.name").contains("Umesh");
```
Output: `true`

---

# 🎯 Quick Memory Tip

```
Single → getString/getInt
Array → getList
Filter → find/findAll
Aggregate → max/min/sum/size
```

---

Happy Testing 🚀
