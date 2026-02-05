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
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class DemoTest {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        // ---------------------------
        // 1️⃣ JSON → POJO
        // ---------------------------
        RootResponse data =
                mapper.readValue(
                        new File("src/test/resources/testdata/user.json"),
                        RootResponse.class);


        // ---------------------------
        // 2️⃣ FETCH VALUES (BEFORE)
        // ---------------------------
        System.out.println("====== BEFORE ======");

        User user = data.getUsers().get(0);

        System.out.println("Name: " + user.getProfile().getName());
        System.out.println("Email: " + user.getProfile().getEmail());
        System.out.println("City: " + user.getProfile().getAddress().getCity());
        System.out.println("Salary: " + user.getSalary());
        System.out.println("Active: " + user.isActive());
        System.out.println("RequestId: " + data.getMeta().getRequestId());


        // ---------------------------
        // 3️⃣ SET / MODIFY VALUES
        // ---------------------------
        user.getProfile().setName("Nitin");
        user.getProfile().setEmail("nitin@test.com");
        user.getProfile().getAddress().setCity("Mumbai");

        user.setSalary(120000);
        user.setActive(false);

        data.getMeta().setRequestId("REQ999");
        data.setCompany("XYZ Corp");


        // ---------------------------
        // 4️⃣ FETCH VALUES (AFTER)
        // ---------------------------
        System.out.println("\n====== AFTER ======");

        System.out.println("Name: " + user.getProfile().getName());
        System.out.println("Email: " + user.getProfile().getEmail());
        System.out.println("City: " + user.getProfile().getAddress().getCity());
        System.out.println("Salary: " + user.getSalary());
        System.out.println("Active: " + user.isActive());
        System.out.println("RequestId: " + data.getMeta().getRequestId());
    }
}

```

✅ Output

```text
====== BEFORE ======
Name: Umesh
Email: umesh@test.com
City: Pune
Salary: 90000
Active: true
RequestId: REQ123

====== AFTER ======
Name: Nitin
Email: nitin@test.com
City: Mumbai
Salary: 120000
Active: false
RequestId: REQ999
```
---

## Recommendation

Small → JsonPath  
Complex → ⭐ POJO + Lombok ⭐  

---

Happy Testing 🚀
