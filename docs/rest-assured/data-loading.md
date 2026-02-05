# RestAssured – All Ways to Retrieve Data from Response (with Lombok POJO Demo)

Great question — this is exactly what separates beginner RestAssured users from framework-level automation engineers.

This guide shows:
- JsonPath
- path()
- Map/List
- POJO (Lombok based)
- Which is best

---

## 📦 Sample JSON

```json
{
  "meta": {
    "requestId": "REQ123",
    "status": "SUCCESS"
  },
  "company": "ABC Tech",
  "users": [
    {
      "id": 101,
      "profile": {
        "name": "Umesh",
        "email": "umesh@test.com",
        "address": {
          "city": "Pune",
          "zip": 411001
        }
      },
      "roles": ["ADMIN", "DEV"],
      "salary": 90000,
      "active": true
    }
  ]
}
```

---

## ✅ JsonPath

```java
JsonPath jp = response.jsonPath();
String name = jp.getString("users[0].profile.name");
int zip = jp.getInt("users[0].profile.address.zip");
```

---

## ✅ path()

```java
String name = response.then().extract().path("users[0].profile.name");
```

---

## ✅ Map/List

```java
List<Map<String,Object>> users = response.jsonPath().getList("users");
System.out.println(users.get(0).get("salary"));
```

---

# 🔥 Lombok POJO (BEST PRACTICE)

## Maven

```xml
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <version>1.18.30</version>
  <scope>provided</scope>
</dependency>
```

---

## Address.java
```java
import lombok.Data;

@Data
public class Address {
    private String city;
    private int zip;
}
```

## Profile.java
```java
import lombok.Data;

@Data
public class Profile {
    private String name;
    private String email;
    private Address address;
}
```

## User.java
```java
import lombok.Data;
import java.util.List;

@Data
public class User {
    private int id;
    private Profile profile;
    private List<String> roles;
    private int salary;
    private boolean active;
}
```

## Meta.java
```java
import lombok.Data;

@Data
public class Meta {
    private String requestId;
    private String status;
}
```

## RootResponse.java
```java
import lombok.Data;
import java.util.List;

@Data
public class RootResponse {
    private Meta meta;
    private String company;
    private List<User> users;
}
```

---

## Deserialize

```java
RootResponse data = response.as(RootResponse.class);
```

## A)Getting up values

```java
Users user = data.getUsers().get(0);

System.out.println("Name: " + user.getProfile().getName());
System.out.println("Email: " + user.getProfile().getEmail());
System.out.println("City: " + user.getProfile().getAddress().getCity());
System.out.println("Salary: " + user.getSalary());
System.out.println("Active: " + user.isActive());

String name = data.getUsers().get(0).getProfile().getName();
int zip = data.getUsers().get(0).getProfile().getAddress().getZip();
String requestId = data.getMeta().getRequestId();

System.out.println("Name var: " + name);
System.out.println("Zip: " + zip);
System.out.println("RequestId: " + requestId);

```

Output
```text
Name: Umesh
Email: umesh@test.com
City: Pune
Salary: 90000
Active: true
Name var: Umesh
Zip: 411001
RequestId: REQ123
```

## B)Setting up values
```java
System.out.println("Name: " + user.getProfile().getName());
System.out.println("Email: " + user.getProfile().getEmail());
System.out.println("City: " + user.getProfile().getAddress().getCity());
System.out.println("Salary: " + user.getSalary());
System.out.println("Active: " + user.isActive());

String name = data.getUsers().get(0).getProfile().getName();
int zip = data.getUsers().get(0).getProfile().getAddress().getZip();
String requestId = data.getMeta().getRequestId();

System.out.println("Name var: " + name);
System.out.println("Zip: " + zip);
System.out.println("RequestId: " + requestId);
```

Output:

```text
Name: Nitin
Email: nitin@test.com
City: Mumbai
Salary: 120000
Active: false
Name var: Nitin
Zip: 411001
RequestId: REQ999
```
---

## Recommendation

Small → JsonPath  
Complex → ⭐ POJO + Lombok ⭐  

---

Happy Testing 🚀
