# 🚀 Complex DataTable Examples (SDET Interview Level)

Let's do complex DataTable examples like real SDET interview level.

This guide covers 3 advanced scenarios:

1️⃣ Multiple users (List of Maps)\
2️⃣ Nested object (User + Address POJO)\
3️⃣ List inside List (User with multiple roles)

------------------------------------------------------------------------

# 🚀 1️⃣ Complex Example -- Multiple Users

## ✅ Feature File

``` gherkin
Feature: Create Multiple Users

Scenario: Create users with full details
  When user enters below user details
    | name     | email              | city    | mobile | age |
    | Nitin    | nitin@gmail.com    | Mumbai  | 98765  | 28  |
    | Rahul    | rahul@gmail.com    | Pune    | 91234  | 30  |
    | Sneha    | sneha@gmail.com    | Delhi   | 99887  | 25  |
```

## ✅ Step Definition

``` java
@When("user enters below user details")
public void userEntersBelowUserDetails(DataTable table) {

    List<Map<String, String>> users = table.asMaps(String.class, String.class);

    for (Map<String, String> user : users) {

        System.out.println("Name: " + user.get("name"));
        System.out.println("Email: " + user.get("email"));
        System.out.println("City: " + user.get("city"));
        System.out.println("Mobile: " + user.get("mobile"));
        System.out.println("Age: " + user.get("age"));
        System.out.println("------------------------");
    }
}
```

------------------------------------------------------------------------

# 🚀 2️⃣ Complex Example -- Convert DataTable to POJO (Nested Object)

Now we create:

User\
→ Address (Nested Object)

## ✅ Feature File

``` gherkin
Scenario: Create user with address
  When user enters user details with address
    | name  | email           | street     | city   | pincode |
    | Nitin | nitin@gmail.com | MG Road    | Mumbai | 400001  |
```

## ✅ POJO Classes

### User.java

``` java
public class User {

    private String name;
    private String email;
    private Address address;

    public User(String name, String email, Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public Address getAddress() { return address; }
}
```

### Address.java

``` java
public class Address {

    private String street;
    private String city;
    private String pincode;

    public Address(String street, String city, String pincode) {
        this.street = street;
        this.city = city;
        this.pincode = pincode;
    }

    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getPincode() { return pincode; }
}
```

## ✅ Step Definition

``` java
@When("user enters user details with address")
public void userDetailsWithAddress(DataTable table) {

    Map<String, String> data = table.asMaps(String.class, String.class).get(0);

    Address address = new Address(
            data.get("street"),
            data.get("city"),
            data.get("pincode")
    );

    User user = new User(
            data.get("name"),
            data.get("email"),
            address
    );

    System.out.println("User Name: " + user.getName());
    System.out.println("Street: " + user.getAddress().getStreet());
}
```

------------------------------------------------------------------------

# 🚀 3️⃣ Advanced -- List Inside List (User with Roles)

## ✅ Feature File

``` gherkin
Scenario: Create user with roles
  When user enters user and roles
    | name  | roles               |
    | Nitin | ADMIN,USER,MANAGER  |
```

## ✅ POJO

``` java
import java.util.List;

public class User {

    private String name;
    private List<String> roles;

    public User(String name, List<String> roles) {
        this.name = name;
        this.roles = roles;
    }

    public String getName() { return name; }
    public List<String> getRoles() { return roles; }
}
```

## ✅ Step Definition

``` java
@When("user enters user and roles")
public void userWithRoles(DataTable table) {

    Map<String, String> data = table.asMaps(String.class, String.class).get(0);

    List<String> roles = Arrays.asList(data.get("roles").split(","));

    User user = new User(data.get("name"), roles);

    System.out.println("Name: " + user.getName());

    for (String role : user.getRoles()) {
        System.out.println("Role: " + role);
    }
}
```

------------------------------------------------------------------------

# 🎯 Interview-Level Concepts Covered

  | Scenario               | Method Used       |
| ---------------------- | ----------------- |
| Header + multiple rows | asMaps()          |
| Key-value format       | asMap()           |
| Convert to POJO        | Manual mapping    |
| Nested object          | Create inner POJO |
| List inside list       | split() + List    |

------------------------------------------------------------------------

🔥 These examples are SDET-ready and commonly asked in interviews.
