# LinkedList – From Scratch to Expert (Interview Notes)

This document explains **LinkedList** in Java from **beginner to expert level**, covering **internal working, indexing behavior, performance, memory usage, and when to use it**, in an interview-ready format.

---

## 1. What is a LinkedList?

A **LinkedList** is a linear data structure where elements are stored as **nodes**.

Each node contains:
- The actual data
- Reference(s) to neighboring nodes

Unlike arrays or ArrayList:
- Elements are **not stored in contiguous memory**
- There is **no direct random access**

---

## 2. Why LinkedList Exists

Problems with arrays / ArrayList:
- Costly insert/delete due to shifting
- Fixed size (arrays)

LinkedList solves:
- Dynamic size
- Easy insertion and deletion

But introduces:
- Slower access
- Higher memory usage

---

## 3. Types of Linked Lists

### Singly Linked List
A → B → C → D → null

graphql
Copy code

### Doubly Linked List (Java uses this)
null ← A ⇄ B ⇄ C ⇄ D → null

shell
Copy code

### Circular Linked List
A → B → C → A

yaml
Copy code

---

## 4. Java LinkedList Class

```java
public class LinkedList<E>
    extends AbstractSequentialList<E>
    implements List<E>, Deque<E>, Queue<E>
```

LinkedList can act as:
  - List
  - Queue
  - Deque
  - Stack (not recommended)

## 5. Internal Structure (Very Important)

### Node Class (Simplified)

```java
private static class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;
}
```
LinkedList Maintains
```java
Node<E> first; // head
Node<E> last;  // tail
int size;
```

## 6. Visual Representation

```text
first                         last
 ↓                             ↓
null ← A ⇄ B ⇄ C ⇄ D → null
```

Each node knows:
 - Its previous node
 - Its next node

## 7. Indexing in LinkedList (CRITICAL CONCEPT)
Does LinkedList have indexing?
✔ Logically – YES
❌ Physically – NO

Reason:

LinkedList implements List

So index-based methods exist:

java
Copy code
get(index)
add(index, element)
remove(index)
But internally:

There is no array

No direct index-to-memory mapping

How get(index) works internally
java
Copy code
list.get(5);
Steps:

Index is validated

JVM decides traversal direction:

java
Copy code
if (index < size / 2)
    traverse from head;
else
    traverse from tail;
Moves node-by-node until index is reached

⏱ Time Complexity: O(n)

## 8. Why Indexing Is Slow in LinkedList

- Requires traversal
- Pointer dereferencing
- No cache locality
- Nodes scattered in memory

📌 **Note:** Indexing exists only for API consistency.

---

## 9. Adding Elements

### ➕ Add at End
```java
list.add("A");

Steps:
- Create new node
- Set newNode.prev = last
- Set last.next = newNode
- Update last

⏱ Time Complexity: O(1)


## 8. Why Indexing Is Slow in LinkedList
Requires traversal

Pointer dereferencing

No cache locality

Nodes scattered in memory

📌 Indexing exists only for API consistency

## 9. Adding Elements in LinkedList

---

### ➕ Add at End

**Method Used:**

  - list.add("A");


```java
import java.util.LinkedList;

public class AddAtEndExample {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("A");
        list.add("B");

        System.out.println(list);
    }
}
```

Output:
```
[A, B]
```
Steps:
 - Create new node
 - Set newNode.prev = last
 - Set last.next = newNode
 - Update last
⏱ Time Complexity: O(1)

### ➕ Add at Beginning
**Method Used:**


 - list.addFirst("B");

```java
import java.util.LinkedList;

public class AddAtBeginningExample {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("A");
        list.addFirst("B");

        System.out.println(list);
    }
}
```

Output:
```text
[B, A]
```
Steps:
  - Create new node
  - Set newNode.next = first
  - Update first.prev
  - Update first
⏱ Time Complexity: O(1)

### ➕ Add at Index
**Method Used:**

  - list.add(2, "X");

```java
java
Copy code
import java.util.LinkedList;

public class AddAtIndexExample {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        list.add(2, "X");

        System.out.println(list);
    }
}
```

Output:

```text
[A, B, X, C]
```

Steps:
  - Traverse to index → O(n)
  - Update node links → O(1)
⏱ Overall Time Complexity: O(n)

## 10. Removing Elements
Remove from Middle
java
Copy code
list.remove(2);
Steps:

Traverse to node

Update:

prev.next

next.prev

⏱ Time Complexity: O(n)

Remove from Ends
java
Copy code
list.removeFirst();
list.removeLast();
⏱ Time Complexity: O(1)

## 11. Accessing Elements
java
Copy code
list.get(index);
No direct access

Requires traversal

⏱ Time Complexity: O(n)

## 12. Memory Overhead (Expert Insight)
Each node stores:

Data reference

Next reference

Previous reference

➡️ 3 references per element

Compared to ArrayList:

1 reference per element

## 13. Cache Performance
LinkedList is not cache-friendly:

Nodes are scattered in heap

Frequent cache misses

This is why LinkedList is often slower than ArrayList in practice.

## 14. LinkedList as Queue, Deque, Stack

### 🔹 Queue (FIFO)

```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> list = new LinkedList<>();

        list.offer("A");
        list.offer("B");
        list.offer("C");

        System.out.println(list.poll());
        System.out.println(list.peek());
    }
}
```
Output:
```
A
B
```

### 🔹 Deque (Double-Ended Queue)
```java
import java.util.Deque;
import java.util.LinkedList;

public class DequeExample {
    public static void main(String[] args) {
        Deque<String> list = new LinkedList<>();

        list.addFirst("X");
        list.addLast("Y");

        System.out.println(list);
    }
}
```
Output:
```
[X, Y]
```

### 🔹 Stack (Not Recommended)

```java
import java.util.LinkedList;

public class StackExample {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.push("A");
        list.push("B");

        System.out.println(list.pop());
        System.out.println(list);
    }
}
```
Output:

```
B
[A]
```
⚠️ Note: Stack operations using LinkedList are allowed, but ArrayDeque is preferred.

## 15. Time Complexity Summary (LinkedList)

| Operation                        | Time Complexity |
|----------------------------------|-----------------|
| `get(index)`                     | O(n)            |
| `addFirst()` / `addLast()`       | O(1)            |
| `removeFirst()` / `removeLast()` | O(1)            |
| `add(index)`                     | O(n)            |
| `remove(index)`                  | O(n)            |

## 16. When to Use LinkedList

### ✅ Use when:
- Frequent insert/remove at head or tail  
  **Example:** Implementing an undo/redo feature where elements are added and removed from ends.

- Queue / Deque use cases  
  **Example:** Task scheduling systems, printer queues, or BFS traversal using a queue.

- Size changes frequently  
  **Example:** Applications where elements are dynamically added/removed, such as playlist management.

---

### ❌ Avoid when:
- Frequent random access  
  **Example:** Accessing elements by index in a loop (`list.get(i)`), such as searching or sorting.

- Read-heavy operations  
  **Example:** Displaying large lists repeatedly (e.g., product catalogs).

- Large datasets  
  **Example:** Storing millions of elements where memory overhead and cache misses impact performance.

## 17. LinkedList vs ArrayList (Reality Check)

### Comparison Table

| Feature         | LinkedList              | ArrayList            |
|-----------------|-------------------------|----------------------|
| Internal DS     | Doubly Linked List      | Dynamic Array        |
| Indexing        | Logical only            | Physical             |
| `get(index)`    | O(n)                    | O(1)                 |
| Insert / Delete | Fast at ends            | Slow in middle       |
| Memory          | High                    | Low                  |
| Cache Friendly  | No                      | Yes                  |

---

### Advantages & Disadvantages

#### ✅ ArrayList

**Advantages**
- Fast random access (`O(1)`)
- Better cache locality
- Less memory overhead
- Performs well for read-heavy operations

**Disadvantages**
- Slow insertions/deletions in the middle
- Resizing cost when capacity grows
- Shifting elements is expensive

---

#### ✅ LinkedList

**Advantages**
- Fast insertions/deletions at beginning and end
- No resizing overhead
- Good for frequent structural modifications

**Disadvantages**
- Slow random access (`O(n)`)
- Higher memory usage (extra node pointers)
- Poor cache performance

---

### Real-World Use Cases

| Scenario                          | Preferred Collection |
|----------------------------------|----------------------|
| Frequent random access           | ArrayList            |
| Read-heavy applications          | ArrayList            |
| Queue / Deque implementation     | LinkedList           |
| Frequent insert/delete at ends   | LinkedList           |
| Memory-sensitive applications   | ArrayList            |
| Large data with frequent updates | LinkedList           |

---

### 📌 Quick Recommendation

- Use **ArrayList** by default
- Use **LinkedList** only when:
  - Insertions/deletions at ends dominate
  - Random access is rare

## 18. Interview-Ready Explanation (Memorize This)

LinkedList in Java is implemented as a doubly linked list where each element is stored as a node containing references to the previous and next nodes. Although it supports index-based operations through the List interface, it does not provide direct indexing internally, and accessing elements requires traversal, making get operations O(n). LinkedList is best suited for scenarios involving frequent insertions and deletions at the ends, such as queues and deques.

## 19. Key Takeaways
  - Doubly linked list implementation
  - No physical indexing
  - No shifting of elements
  - High memory overhead
  - Poor cache locality
  - Best for queue/deque scenarios

