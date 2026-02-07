# 📘 Java ArrayList vs LinkedList

## Real-World Usage in Selenium + Banking Applications

------------------------------------------------------------------------

# 🧠 How to Choose

Always decide based on behavior:

-   More reading → ArrayList
-   More insert/delete → LinkedList
-   Queue/Stack → LinkedList

------------------------------------------------------------------------

# 🔷 Memory Layout Diagrams

## ArrayList (Dynamic Array)

    Index →   0    1    2    3
             [A] [B] [C] [D]

-   Continuous memory
-   Very fast random access O(1)
-   Insert/delete costly (shifting)

------------------------------------------------------------------------

## LinkedList (Nodes)

    [A|next] → [B|next] → [C|next] → [D|null]

-   Non‑continuous memory
-   Fast insert/delete O(1)
-   Slow random access O(n)
-   Extra memory for pointers

------------------------------------------------------------------------

# 🔷 ArrayList -- Banking + Selenium Scenarios

## ✅ Transaction Table Validation

``` java
List<Transaction> transactions = new ArrayList<>();

List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

for(WebElement row : rows){
    transactions.add(extract(row));
}
```

Why? - Heavy iteration - Rare modification - Fast reads

------------------------------------------------------------------------

## ✅ Store Validation Errors

``` java
List<String> errors = new ArrayList<>();
errors.add("Balance mismatch");
errors.add("Title missing");
```

Append only → ArrayList ideal

------------------------------------------------------------------------

## ✅ Selenium WebElements

``` java
List<WebElement> buttons = driver.findElements(By.tagName("button"));
```

Selenium internally uses ArrayList for fast traversal

------------------------------------------------------------------------

# 🔷 LinkedList -- Banking + Selenium Scenarios

## ✅ Test Execution Queue

``` java
Queue<TestCase> queue = new LinkedList<>();

while(!queue.isEmpty()){
   run(queue.poll());
}
```

Why? - FIFO behavior - removeFirst() fast

------------------------------------------------------------------------

## ✅ Dynamic Workflow Steps

``` java
LinkedList<String> steps = new LinkedList<>();

steps.addFirst("LaunchBrowser");
steps.remove("OTP");
```

Frequent modification → LinkedList best

------------------------------------------------------------------------

## ✅ Retry Failed Steps

``` java
LinkedList<Runnable> retries = new LinkedList<>();

while(!retries.isEmpty()){
   retries.removeFirst().run();
}
```

Queue-style execution

------------------------------------------------------------------------

# 🔷 Performance Comparison

  Operation       ArrayList   LinkedList
  --------------- ----------- ------------
  get(i)          O(1)        O(n)
  add last        O(1)        O(1)
  add middle      O(n)        O(1)
  remove middle   O(n)        O(1)
  memory          less        more
  iteration       faster      slower

------------------------------------------------------------------------

# 🔷 Quick Rule

Default: - List → ArrayList - Queue/Stack → LinkedList

------------------------------------------------------------------------

# 🔷 Interview Answer

"In our banking Selenium framework, we used ArrayList for reading tables
and storing WebElements due to fast iteration. LinkedList was used for
dynamic execution queues and retry mechanisms where frequent
insert/remove operations occur."
