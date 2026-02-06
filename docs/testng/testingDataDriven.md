# 📘 TestNG Data Driven Testing — Complete Deep Guide

---

# 🔷 Overview

This guide covers everything about TestNG Data Driven Testing:

✅ DataProvider vs Excel vs JSON vs DB  
✅ DataProvider in parallel mode  
✅ Null return handling  
✅ Dependency behavior  
✅ Passing objects  
✅ Sharing across classes  
✅ Retry only failed rows  
✅ Excel (Apache POI) with FULL practical example + sheet + code  

---

# 🔵 1️⃣ DataProvider vs Excel vs JSON vs DB

## ✅ Purpose
Different ways to supply test data based on project needs.

| Source | Best For | Speed | Maintenance | Real Use |
|-----------|-----------|-----------|-------------|-------------|
DataProvider | small/medium | ⚡ fastest | easy | unit/functional |
Excel | business/manual testers | medium | medium | business input |
JSON | structured/nested | fast | easy | API payloads |
DB | live dynamic data | slow | complex | integration tests |

---

# 🔵 2️⃣ A. DataProvider (Recommended Default)

## Concept
Simple, fast, in‑code data.

## Code

```java
@DataProvider(name="users")
public Object[][] users(){
    return new Object[][]{
        {"admin","123"},
        {"manager","456"}
    };
}

@Test(dataProvider="users")
public void login(String user, String pass){
    System.out.println(user + ":" + pass);
}
```

## Output

```
admin:123
manager:456
```

---

# 🔵 3️⃣ B. Excel (Apache POI) — FULL PRACTICAL EXAMPLE

---

## ✅ When to use Excel?

✔ Business team edits data  
✔ Large datasets  
✔ Non-technical testers  
✔ UAT scenarios  

---

## ✅ Sample Excel Sheet (users.xlsx)

Imagine this sheet:

| username | password | role    | active |
|----------|-----------|----------|-----------|
| admin    | 123       | ADMIN    | true |
| manager  | 456       | MANAGER  | true |
| guest    | 789       | USER     | false |

👉 Multiple columns = realistic scenario

---

## ✅ Maven Dependency

```xml
<dependency>
  <groupId>org.apache.poi</groupId>
  <artifactId>poi-ooxml</artifactId>
  <version>5.2.5</version>
</dependency>
```

---

## ✅ Excel → DataProvider Code

```java
@DataProvider(name="excelUsers")
public Object[][] excelUsers() throws Exception {

    FileInputStream fis = new FileInputStream("src/test/resources/users.xlsx");
    Workbook wb = new XSSFWorkbook(fis);
    Sheet sheet = wb.getSheetAt(0);

    int rows = sheet.getPhysicalNumberOfRows();

    Object[][] data = new Object[rows-1][4]; // 4 columns

    for(int i = 1; i < rows; i++) {

        Row row = sheet.getRow(i);

        data[i-1][0] = row.getCell(0).getStringCellValue();
        data[i-1][1] = row.getCell(1).getStringCellValue();
        data[i-1][2] = row.getCell(2).getStringCellValue();
        data[i-1][3] = row.getCell(3).getBooleanCellValue();
    }

    wb.close();
    return data;
}
```

---

## ✅ Test Using Excel Data

```java
@Test(dataProvider="excelUsers")
public void loginTest(String user, String pass, String role, boolean active){

    System.out.println(user + " | " + pass + " | " + role + " | " + active);
}
```

---

## ✅ Output

```
admin | 123 | ADMIN | true
manager | 456 | MANAGER | true
guest | 789 | USER | false
```

---

## ✅ Key Learnings

✔ Supports many columns  
✔ Easy for business edits  
✔ Slightly slower than DataProvider  
✔ Best for large datasets  

---

# 🔵 4️⃣ JSON Example

## JSON

```json
[
 {"user":"admin","pass":"123"},
 {"user":"manager","pass":"456"}
]
```

## Code

```java
ObjectMapper mapper = new ObjectMapper();
User[] users = mapper.readValue(file, User[].class);
```

---

# 🔵 5️⃣ DB Example

```java
Connection con = DriverManager.getConnection(url);
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select user,pass from users");
```

---

# 🔵 6️⃣ DataProvider in Parallel Mode

```java
@DataProvider(name="users", parallel=true)
```

## Output

```
Thread11 user1
Thread12 user2
Thread13 user3
```

---

# 🔵 7️⃣ Null return from DataProvider

❌ Bad:

```java
return null;
```

Throws NPE

✅ Correct:

```java
return new Object[0][0];
```

---

# 🔵 8️⃣ Can DataProvider depend on another test?

❌ NO

Flow:

```
DataProvider → Test
```

Use @BeforeClass instead.

---

# 🔵 9️⃣ Passing Objects

```java
@DataProvider
public Object[][] users(){
    return new Object[][]{
        { new User("John",30) }
    };
}
```

---

# 🔵 🔟 Sharing DataProvider Across Classes

```java
@Test(dataProvider="users", dataProviderClass=TestDataProvider.class)
```

---

# 🔵 1️⃣1️⃣ Retry Only Failed Data Rows

```java
@Test(dataProvider="users", retryAnalyzer=Retry.class)
```

Only failed dataset retries.

---

# 🔥 Best Practices

✅ Prefer DataProvider  
✅ Excel for business input  
✅ JSON for APIs  
✅ DB for integration  
✅ Never return null  
✅ Parallel only for stateless tests  

---

# 🔥 Interview Questions

1. When to choose Excel over DataProvider?
2. How does parallel DataProvider work?
3. What happens if provider returns null?
4. How to share provider across packages?
5. How to retry only failed rows?
6. How to read Excel using POI?
7. Can DataProvider depend on test?
8. How to pass objects?
9. How to handle large datasets?
10. How to parallelize safely?

---

Happy Learning 🚀
