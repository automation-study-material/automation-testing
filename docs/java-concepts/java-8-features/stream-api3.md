# 🚀 Java Stream API Complete Guide (With Explanation + Output)

------------------------------------------------------------------------

## 🔹 1️⃣ Filter & Collect Example

### 👉 Find employees whose salary \> 50,000

### ✅ Explanation

-   `stream()` → Convert list to stream\
-   `filter()` → Apply condition\
-   `collect()` → Convert stream back to List\
-   `forEach()` → Print result

### ✅ Full Program

``` java
import java.util.*;
import java.util.stream.*;

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

public class StreamGuide {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Nitin", 60000),
                new Employee(2, "Amit", 45000),
                new Employee(3, "Meena", 75000),
                new Employee(4, "Rahul", 30000)
        );

        List<Employee> highSalary = employees.stream()
                .filter(emp -> emp.salary > 50000)
                .collect(Collectors.toList());

        highSalary.forEach(System.out::println);
    }
}
```

### ✅ Output

    1 - Nitin - 60000.0
    3 - Meena - 75000.0

------------------------------------------------------------------------

## 🔹 2️⃣ Map Example (Transform Data)

### 👉 Get only employee names

### ✅ Explanation

`map()` transforms each object into something else.

``` java
employees.stream()
        .map(emp -> emp.name)
        .forEach(System.out::println);
```

### ✅ Output

    Nitin
    Amit
    Meena
    Rahul

------------------------------------------------------------------------

## 🔹 3️⃣ Sort Example

### 👉 Sort by salary (Ascending)

``` java
employees.stream()
        .sorted(Comparator.comparingDouble(emp -> emp.salary))
        .forEach(System.out::println);
```

### ✅ Output

    4 - Rahul - 30000.0
    2 - Amit - 45000.0
    1 - Nitin - 60000.0
    3 - Meena - 75000.0

### 👉 Descending Order

``` java
employees.stream()
        .sorted(Comparator.comparingDouble((Employee emp) -> emp.salary).reversed())
        .forEach(System.out::println);
```

### ✅ Output

    3 - Meena - 75000.0
    1 - Nitin - 60000.0
    2 - Amit - 45000.0
    4 - Rahul - 30000.0

------------------------------------------------------------------------

## 🔹 4️⃣ Group By Example

### 👉 Group employees into High and Low salary

### ✅ Explanation

`groupingBy()` creates a Map.

``` java
Map<String, List<Employee>> grouped =
        employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> emp.salary > 50000 ? "High" : "Low"
                ));

grouped.forEach((key, value) ->
        System.out.println(key + " => " + value));
```

### ✅ Output

    High => [1 - Nitin - 60000.0, 3 - Meena - 75000.0]
    Low => [2 - Amit - 45000.0, 4 - Rahul - 30000.0]

------------------------------------------------------------------------

## 🔹 5️⃣ Find Max Salary Employee

### ✅ Explanation

`max()` returns Optional.

``` java
Optional<Employee> maxSalaryEmp =
        employees.stream()
                .max(Comparator.comparingDouble(emp -> emp.salary));

maxSalaryEmp.ifPresent(System.out::println);
```

### ✅ Output

    3 - Meena - 75000.0

------------------------------------------------------------------------

## 🔹 6️⃣ Count Example

``` java
long count = employees.stream()
        .filter(emp -> emp.salary > 40000)
        .count();

System.out.println("Count: " + count);
```

### ✅ Output

    Count: 3

------------------------------------------------------------------------

## 🔹 7️⃣ Reduce Example (Total Salary)

### ✅ Explanation

`reduce()` combines values into single result.

``` java
double totalSalary = employees.stream()
        .map(emp -> emp.salary)
        .reduce(0.0, Double::sum);

System.out.println("Total Salary: " + totalSalary);
```

### ✅ Output

    Total Salary: 210000.0

------------------------------------------------------------------------

# 🔟 10 Practice Problems (Interview Level)

1.  Find odd numbers\
2.  Find sum\
3.  Remove duplicates → `distinct()`\
4.  Find second highest\
5.  Sort descending\
6.  First element \> 50 → `findFirst()`\
7.  Frequency count → `groupingBy()`\
8.  Group by length\
9.  Join string → `Collectors.joining()`\
10. `allMatch()` check

------------------------------------------------------------------------

# 👨‍💼 Stream API with Employee (Simple)

``` java
employees.stream()
        .filter(emp -> emp.salary > 50000)
        .map(emp -> emp.name)
        .forEach(System.out::println);
```

Output:

    Nitin
    Meena

------------------------------------------------------------------------

# 🔄 Difference Between Stream and For-Loop

  Feature       For-Loop     Stream
  ------------- ------------ ------------
  Style         Imperative   Functional
  Code          More         Less
  Parallel      Manual       Easy
  Readability   Medium       High

------------------------------------------------------------------------

# 🤖 Selenium + Stream Example

``` java
List<WebElement> priceElements = driver.findElements(By.className("price"));

priceElements.stream()
        .map(ele -> ele.getText().replace("₹", ""))
        .map(Integer::parseInt)
        .filter(price -> price > 500)
        .forEach(System.out::println);
```

### Real Use:

-   Filtering products\
-   Validating UI lists\
-   Checking elements displayed

------------------------------------------------------------------------

# 🔹 Understanding `.forEach(System.out::println)`

Equivalent to:

``` java
.forEach(x -> System.out.println(x));
```

`::` is method reference operator.

### Types:

-   Static → `Class::method`\
-   Object → `object::method`\
-   Arbitrary → `Class::method`\
-   Constructor → `Class::new`

------------------------------------------------------------------------

# 🔥 Advanced Interview Topics

## Intermediate Operations

-   filter()\
-   map()\
-   sorted()\
-   distinct()

## Terminal Operations

-   forEach()\
-   collect()\
-   reduce()\
-   count()\
-   max()

------------------------------------------------------------------------

# 🔥 map() vs flatMap()

``` java
list.stream().flatMap(List::stream);
```

`flatMap()` flattens nested collections.

------------------------------------------------------------------------

# 🔥 Second Highest Example

``` java
List<Integer> nums = Arrays.asList(10, 40, 30, 50, 20);

Integer secondHighest = nums.stream()
        .distinct()
        .sorted(Comparator.reverseOrder())
        .skip(1)
        .findFirst()
        .get();

System.out.println(secondHighest);
```

### Output

    40

------------------------------------------------------------------------

# 🔥 Stream API with Map & HashMap

## Iterate Map

``` java
map.entrySet()
   .stream()
   .forEach(System.out::println);
```

## Frequency Count

``` java
List<String> names = Arrays.asList("A", "B", "A", "C", "B", "A");

Map<String, Long> frequency =
        names.stream()
                .collect(Collectors.groupingBy(
                        name -> name,
                        Collectors.counting()
                ));

System.out.println(frequency);
```

### Output

    {A=3, B=2, C=1}

------------------------------------------------------------------------

# 🎯 Must Remember Methods

-   filter()
-   map()
-   collect()
-   reduce()
-   sorted()
-   distinct()
-   anyMatch()
-   allMatch()
-   findFirst()
-   groupingBy()
-   toMap()
-   parallelStream()

------------------------------------------------------------------------

Happy Learning 🚀
