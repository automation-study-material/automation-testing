For this JSON, we need **4 POJO classes** because the response contains:

1. **Order (Main Object)**
2. **Customer (Nested Object)**
3. **Item (Inside List)**
4. **Attributes (Nested Object)**

Below are the POJO classes in **clean Java format with getters/setters**. These are useful when using **Jackson / Rest Assured / Gson** in API automation (which aligns with your testing work).

---

# 1️⃣ OrderResponse.java (Main POJO)

Below is Sample response Json,
```json
{
  "orderId": "ORD500",
  "amount": 75000,
  "paid": true,
  "customer": {
    "id": 10,
    "name": "Nitin Patil"
  },
  "items": [
    {
      "itemId": 1,
      "name": "Laptop",
      "price": 50000,
      "tags": ["Electronics", "Portable", "Expensive"]
    },
    {
      "itemId": 2,
      "name": "Book",
      "price": 500,
      "tags": ["Education", "Paper"]
    }
  ],
  "attributes": {
    "deliveryType": "Express",
    "paymentMode": "CreditCard"
  }
}
```

```java
package pojo;

import java.util.List;

public class OrderResponse {

    private String orderId;
    private int amount;
    private boolean paid;
    private Customer customer;
    private List<Item> items;
    private Attributes attributes;

    public OrderResponse() {}

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }
}
```

---

# 2️⃣ Customer.java

```java
package pojo;

public class Customer {

    private int id;
    private String name;

    public Customer() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

---

# 3️⃣ Item.java

```java
package pojo;

import java.util.List;

public class Item {

    private int itemId;
    private String name;
    private int price;
    private List<String> tags;

    public Item() {}

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
```

---

# 4️⃣ Attributes.java

```java
package pojo;

public class Attributes {

    private String deliveryType;
    private String paymentMode;

    public Attributes() {}

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }
}
```

---

# 5️⃣ How to Use This POJO in Rest Assured

```java
OrderResponse response = given()
        .when()
        .get("/orders/ORD500")
        .then()
        .extract()
        .as(OrderResponse.class);

System.out.println(response.getCustomer().getName());
System.out.println(response.getItems().get(0).getName());
```

---

# 6️⃣ Expected Output

```
Nitin Patil
Laptop
```

---

✅ **Interview Tip (Important):**

When creating POJO for JSON:

1. JSON **object → Java class**
2. JSON **array → List<>**
3. JSON **primitive → matching Java datatype**
4. Nested objects require **separate POJO classes**

Example:

```
customer {}  → Customer class
items []     → List<Item>
tags []      → List<String>
attributes{} → Attributes class
```

---

If you want, I can also show a **very powerful automation tester trick**:

✅ **How to generate POJO classes automatically from JSON in 5 seconds (used by most QA engineers).**
