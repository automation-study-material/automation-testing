
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

You are using **Rest Assured + JsonPath**.
`jp.getList("users.name")` will return a **List of all names** from the `users` array.

Below is how you **iterate the list**.

---

# 1️⃣ JSON Structure

Your JSON contains:

* Root keys → `page`, `total`, `company`
* Array → `users`
* Inside each user → `id`, `name`, `role`, `salary`, `skills`

Example extraction path:

```
users.name
```

This means:

```
users -> array
name  -> field inside each object
```

Result will be:

```
["Umesh", "Amit", "Neha"]
```

---

# 2️⃣ Java Code – Iterate Using For Loop

```java
1  Response response = given()
2      .when()
3      .get("/users");
4
5  JsonPath jp = response.jsonPath();
6
7  List<String> names = jp.getList("users.name");
8
9  for (int i = 0; i < names.size(); i++) {
10     System.out.println(names.get(i));
11 }
```

### Output

```
Umesh
Amit
Neha
```

---

# 3️⃣ Iterate Using For-Each Loop (Better Way)

```java
1  Response response = given().get("/users");
2
3  JsonPath jp = response.jsonPath();
4
5  List<String> names = jp.getList("users.name");
6
7  for(String name : names){
8      System.out.println(name);
9  }
```

---

# 4️⃣ Iterate Complete User Object

If you want **each user object**, use:

```java
List<Map<String, Object>> users = jp.getList("users");

for(Map<String, Object> user : users){
    System.out.println(user.get("name"));
    System.out.println(user.get("role"));
}
```

Output

```
Umesh
ADMIN
Amit
USER
Neha
USER
```

---

# 5️⃣ Extract Specific User

Example: first user name

```java
String name = jp.getString("users[0].name");
System.out.println(name);
```

Output

```
Umesh
```

---

# 6️⃣ Interview Tip ⭐

Common Rest Assured JsonPath usages:

| Purpose        | Code                                                |
| -------------- | --------------------------------------------------- |
| Get all names  | `jp.getList("users.name")`                          |
| Get first name | `jp.getString("users[0].name")`                     |
| Get list size  | `jp.getList("users").size()`                        |
| Filter data    | `jp.getList("users.findAll{it.role=='USER'}.name")` |

---

If you want, I can also show **10 most important RestAssured JsonPath tricks asked in Automation Testing interviews** (like filtering ADMIN users, highest salary, skill contains Java, etc.).



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
