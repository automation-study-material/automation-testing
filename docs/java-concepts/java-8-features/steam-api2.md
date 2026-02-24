---
This document includes:
- Filter & Collect
- Map
- Sort
- Grouping
- Max
- Count
- Reduce
- Map & HashMap
- Selenium Example
- Advanced Interview Topics
---

# 🚀 Java Stream API Complete Guide (Extended with 25 Coding Programs)

# 🔥 25 Additional Java Stream Coding Programs (With Output)

------------------------------------------------------------------------

## 1️⃣ Find Odd Numbers

``` java
List<Integer> nums = Arrays.asList(1,2,3,4,5);
nums.stream().filter(n -> n%2!=0).forEach(System.out::println);
```

Output:

    1
    3
    5

------------------------------------------------------------------------

## 2️⃣ Find Sum of Numbers

``` java
int sum = nums.stream().reduce(0, Integer::sum);
System.out.println(sum);
```

Output:

    15

------------------------------------------------------------------------

## 3️⃣ Remove Duplicates

``` java
Arrays.asList(1,2,2,3,3,4)
.stream().distinct().forEach(System.out::println);
```

Output:

    1
    2
    3
    4

------------------------------------------------------------------------

## 4️⃣ Find Minimum

``` java
nums.stream().min(Integer::compare).ifPresent(System.out::println);
```

Output:

    1

------------------------------------------------------------------------

## 5️⃣ Average of Numbers

``` java
double avg = nums.stream().mapToInt(n->n).average().getAsDouble();
System.out.println(avg);
```

Output:

    3.0

------------------------------------------------------------------------

## 6️⃣ Convert List to Set

``` java
Set<Integer> set = nums.stream().collect(Collectors.toSet());
System.out.println(set);
```

Output:

    [1, 2, 3, 4, 5]

------------------------------------------------------------------------

## 7️⃣ Join Strings

``` java
List<String> names = Arrays.asList("Java","Stream","API");
String result = names.stream().collect(Collectors.joining(", "));
System.out.println(result);
```

Output:

    Java, Stream, API

------------------------------------------------------------------------

## 8️⃣ Count Even Numbers

``` java
long count = nums.stream().filter(n->n%2==0).count();
System.out.println(count);
```

Output:

    2

------------------------------------------------------------------------

## 9️⃣ First Element Greater Than 3

``` java
nums.stream().filter(n->n>3).findFirst().ifPresent(System.out::println);
```

Output:

    4

------------------------------------------------------------------------

## 🔟 Check All Positive

``` java
boolean allPositive = nums.stream().allMatch(n->n>0);
System.out.println(allPositive);
```

Output:

    true

------------------------------------------------------------------------

## 11️⃣ Any Number Greater Than 4

``` java
boolean any = nums.stream().anyMatch(n->n>4);
System.out.println(any);
```

Output:

    true

------------------------------------------------------------------------

## 12️⃣ Sort Descending

``` java
nums.stream().sorted(Comparator.reverseOrder())
.forEach(System.out::println);
```

Output:

    5
    4
    3
    2
    1

------------------------------------------------------------------------

## 13️⃣ Square Numbers

``` java
nums.stream().map(n->n*n).forEach(System.out::println);
```

Output:

    1
    4
    9
    16
    25

------------------------------------------------------------------------

## 14️⃣ Convert to Map (Number → Square)

``` java
Map<Integer,Integer> map =
nums.stream().collect(Collectors.toMap(n->n,n->n*n));
System.out.println(map);
```

Output:

    {1=1, 2=4, 3=9, 4=16, 5=25}

------------------------------------------------------------------------

## 15️⃣ Group Strings by Length

``` java
List<String> list = Arrays.asList("Java","C","Python","Go");
Map<Integer,List<String>> grouped =
list.stream().collect(Collectors.groupingBy(String::length));
System.out.println(grouped);
```

Output:

    {1=[C], 2=[Go], 4=[Java], 6=[Python]}

------------------------------------------------------------------------

## 16️⃣ Partition Even & Odd

``` java
Map<Boolean,List<Integer>> part =
nums.stream().collect(Collectors.partitioningBy(n->n%2==0));
System.out.println(part);
```

Output:

    {false=[1, 3, 5], true=[2, 4]}

------------------------------------------------------------------------

## 17️⃣ Frequency Count

``` java
List<String> items = Arrays.asList("A","B","A","C","B","A");
Map<String,Long> freq =
items.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
System.out.println(freq);
```

Output:

    {A=3, B=2, C=1}

------------------------------------------------------------------------

## 18️⃣ Flatten List of Lists

``` java
List<List<Integer>> nested =
Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,4));
nested.stream().flatMap(List::stream)
.forEach(System.out::println);
```

Output:

    1
    2
    3
    4

------------------------------------------------------------------------

## 19️⃣ Find Second Highest

``` java
Arrays.asList(10,40,30,50,20)
.stream().sorted(Comparator.reverseOrder())
.skip(1).findFirst().ifPresent(System.out::println);
```

Output:

    40

------------------------------------------------------------------------

## 20️⃣ Total Salary Example

``` java
double total = employees.stream()
.map(e->e.salary)
.reduce(0.0,Double::sum);
System.out.println(total);
```

Output:

    210000.0

------------------------------------------------------------------------

## 21️⃣ Convert to Uppercase

``` java
names.stream().map(String::toUpperCase)
.forEach(System.out::println);
```

Output:

    JAVA
    STREAM
    API

------------------------------------------------------------------------

## 22️⃣ Limit First 3 Elements

``` java
nums.stream().limit(3)
.forEach(System.out::println);
```

Output:

    1
    2
    3

------------------------------------------------------------------------

## 23️⃣ Skip First 2 Elements

``` java
nums.stream().skip(2)
.forEach(System.out::println);
```

Output:

    3
    4
    5

------------------------------------------------------------------------

## 24️⃣ Parallel Stream Example

``` java
nums.parallelStream()
.forEach(System.out::println);
```

Output: (Order not guaranteed)


    ---

    ## 25️⃣ Collect to List
    ```java
    List<Integer> newList =
    nums.stream().filter(n->n>2)
    .collect(Collectors.toList());
    System.out.println(newList);

Output:

    [3, 4, 5]

------------------------------------------------------------------------

# 🎯 Important Methods Recap

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
-   partitioningBy()
-   flatMap()
-   parallelStream()

------------------------------------------------------------------------

Happy Learning 🚀
