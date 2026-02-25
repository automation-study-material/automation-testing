````markdown
# 🚀 JAVA STREAM API – COMPLETE MASTER GUIDE (Beginner → Advanced → Interview)

---

# 1️⃣ Introduction – What is Stream API?

Stream API is used to:

> Process collections of data in a **functional and declarative way**.

It was introduced in **Java 8**.

📦 **Package:**

```java
java.util.stream
````

---

## 🔹 What is a Stream?

A Stream is:

> A sequence of elements supporting functional-style operations.

### ⚠ Important Points

* Stream does NOT store data
* Stream works on collections
* Stream does NOT modify original collection
* Stream is lazy

---

# 2️⃣ Why Stream API Came Into Picture?

Before Java 8 → We used loops.

## ❌ Old Way (Too Much Boilerplate)

```java
List<Integer> list = Arrays.asList(1,2,3,4,5);
List<Integer> result = new ArrayList<>();

for (Integer i : list) {
    if (i % 2 == 0) {
        result.add(i);
    }
}
```

### Problems:

* More code
* Hard to read
* Manual iteration
* Difficult parallel processing

---

## ✅ With Stream API

```java
List<Integer> result = list.stream()
                            .filter(x -> x % 2 == 0)
                            .toList();
```

🔥 Cleaner
🔥 Less code
🔥 More readable
🔥 Easy parallel execution

---

# 3️⃣ How Stream Works (Very Important)

Stream has 3 Parts:

```
Source → Intermediate → Terminal
```

### Example:

```java
list.stream()                    // Source
    .filter(x -> x % 2 == 0)     // Intermediate
    .forEach(System.out::println); // Terminal
```

---

# 4️⃣ Types of Stream Operations

## 🔹 Intermediate Operations (Lazy)

* `filter()`
* `map()`
* `sorted()`
* `distinct()`
* `limit()`
* `skip()`
* `flatMap()`

Return Stream again.

---

## 🔹 Terminal Operations

* `forEach()`
* `collect()`
* `count()`
* `reduce()`
* `max()`
* `min()`
* `findFirst()`
* `anyMatch()`
* `allMatch()`

After terminal operation → Stream closed ❌

---

# 5️⃣ Lazy Evaluation (Interview Important)

This will NOT execute:

```java
list.stream()
    .filter(x -> x > 3);
```

It executes only when terminal operation added:

```java
list.stream()
    .filter(x -> x > 3)
    .count();
```

---

# 6️⃣ External vs Internal Iteration

## Before Java 8 (External Iteration)

```java
for (Integer i : list) {
    System.out.println(i);
}
```

## Stream (Internal Iteration)

```java
list.stream().forEach(System.out::println);
```

Stream controls the loop internally.

---

# 7️⃣ Stream vs Collection

| Feature     | Collection | Stream |
| ----------- | ---------- | ------ |
| Stores Data | Yes        | No     |
| Modify Data | Yes        | No     |
| Lazy        | No         | Yes    |
| Functional  | No         | Yes    |

---

# 8️⃣ Core Stream Functions (With Explanation + Programs)

---

## 🔹 1. `filter()`

Used to filter elements based on condition.

```java
List<Integer> nums = Arrays.asList(1,2,3,4,5);

// filter even numbers
nums.stream()
    .filter(n -> n % 2 == 0)   // keep only even numbers
    .forEach(System.out::println);
```

### Output

```
2
4
```

---

## 🔹 2. `map()`

Transforms data.

```java
nums.stream()
    .map(n -> n * n)   // square each number
    .forEach(System.out::println);
```

### Output

```
1
4
9
16
25
```

---

## 🔹 3. `sorted()`

```java
nums.stream()
    .sorted()
    .forEach(System.out::println);
```

### Descending

```java
nums.stream()
    .sorted(Comparator.reverseOrder())
    .forEach(System.out::println);
```

---

## 🔹 4. `distinct()`

Remove duplicates.

```java
Arrays.asList(1,2,2,3,3,4)
      .stream()
      .distinct()
      .forEach(System.out::println);
```

### Output

```
1
2
3
```



## 🔹 5. `reduce()`

Used to combine multiple elements into a single result.

### Example: Sum of Numbers

```java
int sum = nums.stream()
              .reduce(0, Integer::sum);

System.out.println(sum);
```

### Output

```
15
```

---

## 🔹 6. `collect()`

Used to convert a stream into a **List**, **Set**, or **Map**.

```java
Set<Integer> set = nums.stream()
                       .collect(Collectors.toSet());

System.out.println(set);
```

---

## 🔹 7. `count()`

Returns the number of elements matching a condition.

```java
long count = nums.stream()
                 .filter(n -> n % 2 == 0)
                 .count();

System.out.println(count);
```

---

## 🔹 8. `anyMatch()` / `allMatch()`

Used for condition checking.

```java
boolean allPositive = nums.stream().allMatch(n -> n > 0);
boolean anyGreater  = nums.stream().anyMatch(n -> n > 4);
```

---

## 🔹 9. `findFirst()`

Finds the first element matching a condition.

```java
nums.stream()
    .filter(n -> n > 3)
    .findFirst()
    .ifPresent(System.out::println);
```

---

## 🔹 10. `flatMap()`

Used to flatten nested collections.

```java
List<List<Integer>> nested =
        Arrays.asList(Arrays.asList(1,2), Arrays.asList(3,4));

nested.stream()
      .flatMap(List::stream)
      .forEach(System.out::println);
```

### Output

```
1
2
3
4
```

---

# 9️⃣ Employee Real-Time Examples (Interview Important)

## Employee Class

```java
class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return id + " - " + name + " - " + salary;
    }
}
```

---

## 🔹 Filter Employees with Salary > 50000

```java
List<Employee> highSalary = employees.stream()
        .filter(emp -> emp.salary > 50000)
        .collect(Collectors.toList());

highSalary.forEach(System.out::println);
```

### Output

```
1 - Nitin - 60000.0
3 - Meena - 75000.0
```

---

## 🔹 Map – Get Only Employee Names

```java
employees.stream()
        .map(emp -> emp.name)
        .forEach(System.out::println);
```

---

## 🔹 Sort Employees by Salary (Ascending)

```java
employees.stream()
        .sorted(Comparator.comparingDouble(emp -> emp.salary))
        .forEach(System.out::println);
```

### Descending Order

```java
employees.stream()
        .sorted(
            Comparator.comparingDouble((Employee emp) -> emp.salary)
                      .reversed()
        )
        .forEach(System.out::println);
```

---

## 🔹 Group Employees by High & Low Salary

```java
Map<String, List<Employee>> grouped =
        employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> emp.salary > 50000 ? "High" : "Low"
                ));

grouped.forEach((key, value) ->
        System.out.println(key + " => " + value));
```

---

## 🔹 Find Employee with Max Salary

```java
Optional<Employee> maxSalaryEmp =
        employees.stream()
                .max(Comparator.comparingDouble(emp -> emp.salary));

maxSalaryEmp.ifPresent(System.out::println);
```

---

## 🔹 Count Employees with Salary > 40000

```java
long count = employees.stream()
        .filter(emp -> emp.salary > 40000)
        .count();

System.out.println("Count: " + count);
```

---

## 🔹 Total Salary Using `reduce()`

```java
double totalSalary = employees.stream()
        .map(emp -> emp.salary)
        .reduce(0.0, Double::sum);

System.out.println("Total Salary: " + totalSalary);
```

### Output

```
Total Salary: 210000.0
```

```

If you want, I can **export this as a downloadable `.md` file** or **merge it into your master Stream API markdown** seamlessly.
```

