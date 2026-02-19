# 🚀 Stream API (From Scratch to Advanced)

I'll explain this in very simple steps first, then go deeper.

------------------------------------------------------------------------

# 1️⃣ What is Stream API?

Stream API is used to:

> Process collections of data in a functional and declarative way.

It was introduced in **Java 8**.

Package:

    java.util.stream

------------------------------------------------------------------------

# 2️⃣ Why Stream API Was Introduced?

## Before Java 8:

``` java
List<Integer> list = Arrays.asList(1,2,3,4,5);
List<Integer> result = new ArrayList<>();

for (Integer i : list) {
    if (i % 2 == 0) {
        result.add(i);
    }
}
```

Too much boilerplate 😵

------------------------------------------------------------------------

## With Stream API:

``` java
List<Integer> result = list.stream()
                            .filter(x -> x % 2 == 0)
                            .toList();
```

🔥 Cleaner\
🔥 Less code\
🔥 More readable

------------------------------------------------------------------------

# 3️⃣ What is a Stream?

A Stream is:

> A sequence of elements supporting functional-style operations.

### Important:

-   ⚠ Stream does NOT store data\
-   ⚠ Stream works on collections\
-   ⚠ Stream does NOT modify original collection

------------------------------------------------------------------------

# 4️⃣ How Stream Works (Very Important)

Stream processing has 3 parts:

1.  Source\
2.  Intermediate Operations\
3.  Terminal Operation

### Example:

``` java
list.stream()                   // Source
    .filter(x -> x % 2 == 0)    // Intermediate
    .forEach(System.out::println); // Terminal
```

------------------------------------------------------------------------

# 5️⃣ Types of Stream Operations

## 🔹 1. Intermediate Operations

-   filter()
-   map()
-   sorted()
-   distinct()
-   limit()
-   skip()

They return Stream again.\
They are lazy (do not execute immediately).

------------------------------------------------------------------------

## 🔹 2. Terminal Operations

-   forEach()
-   collect()
-   count()
-   reduce()
-   toList()

They produce final result.

After terminal operation → Stream is closed.

------------------------------------------------------------------------

# 6️⃣ Common Stream Methods (Important)

## 🔹 filter()

``` java
list.stream()
    .filter(x -> x > 3)
    .forEach(System.out::println);
```

------------------------------------------------------------------------

## 🔹 map()

``` java
list.stream()
    .map(x -> x * 2)
    .forEach(System.out::println);
```

------------------------------------------------------------------------

## 🔹 sorted()

``` java
list.stream()
    .sorted()
    .forEach(System.out::println);
```

------------------------------------------------------------------------

## 🔹 distinct()

``` java
list.stream()
    .distinct()
    .forEach(System.out::println);
```

------------------------------------------------------------------------

## 🔹 collect()

``` java
List<Integer> result = list.stream()
                            .filter(x -> x % 2 == 0)
                            .collect(Collectors.toList());
```

------------------------------------------------------------------------

# 7️⃣ Real Example with Objects (Interview Important)

### Employee class:

``` java
class Employee {
    String name;
    int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
}
```

### Filter employees with salary \> 50000:

``` java
employees.stream()
         .filter(e -> e.getSalary() > 50000)
         .forEach(e -> System.out.println(e.name));
```

------------------------------------------------------------------------

# 8️⃣ reduce() Method (Advanced)

Used to combine elements.

### Example: Sum of numbers

``` java
int sum = list.stream()
              .reduce(0, (a, b) -> a + b);
```

------------------------------------------------------------------------

# 9️⃣ Parallel Stream

``` java
list.parallelStream()
    .filter(x -> x % 2 == 0)
    .forEach(System.out::println);
```

Uses multiple threads internally.

⚠ Use carefully (order not guaranteed).

------------------------------------------------------------------------

# 🔟 Stream vs Collection

  Feature       Collection   Stream
  ------------- ------------ --------
  Stores Data   Yes          No
  Modify Data   Yes          No
  Lazy          No           Yes
  Functional    No           Yes

------------------------------------------------------------------------

# 1️⃣1️⃣ Lazy Evaluation (Very Important)

This does NOT execute:

``` java
list.stream()
    .filter(x -> x > 3);
```

It executes only when terminal operation added:

``` java
list.stream()
    .filter(x -> x > 3)
    .count();
```

------------------------------------------------------------------------

# 1️⃣2️⃣ Internal Working (Advanced)

When you write:

``` java
list.stream()
    .filter(...)
    .map(...)
    .collect(...);
```

JVM:

-   Creates pipeline
-   Chains intermediate operations
-   Executes only when terminal operation invoked
-   Uses internal iteration (not external for-loop)

------------------------------------------------------------------------

# 1️⃣3️⃣ External vs Internal Iteration

## Before Java 8:

``` java
for (Integer i : list) {
    System.out.println(i);
}
```

External iteration.

------------------------------------------------------------------------

## Stream:

``` java
list.stream().forEach(System.out::println);
```

Internal iteration (Stream controls loop).

------------------------------------------------------------------------

# 1️⃣4️⃣ Real World Use Cases

-   ✔ Filtering data from DB results\
-   ✔ Sorting employees\
-   ✔ Transforming API responses\
-   ✔ Grouping data\
-   ✔ Aggregation (sum, average)\
-   ✔ Parallel processing

------------------------------------------------------------------------

# 1️⃣5️⃣ Most Asked Interview Questions

## ❓ Difference between map() and flatMap()?

-   map → one-to-one transformation\
-   flatMap → flatten nested structure

------------------------------------------------------------------------

## ❓ Can stream be reused?

❌ No. After terminal operation → stream closed.

------------------------------------------------------------------------

## ❓ Difference between findFirst() and findAny()?

findAny is faster in parallel stream.

------------------------------------------------------------------------

# 🎯 Simple Memory Formula

    Stream = Source → Intermediate → Terminal

------------------------------------------------------------------------

End of Document
