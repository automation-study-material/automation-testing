# 🚀 Complete Example: GET Request → JSON Response → POJO → Print Data (Without Generic Wrapper)

This guide covers:

1️⃣ Sample JSON (GET API response)\
2️⃣ Create POJO Classes\
3️⃣ Hit GET call using Rest Assured\
4️⃣ Convert response to POJO\
5️⃣ Print full response using POJO

------------------------------------------------------------------------

## 🔹 1️⃣ Sample JSON Response (Output of GET API)

Assume this is the response from:

GET /orders/500

``` json
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

------------------------------------------------------------------------

## 🔹 2️⃣ POJO Classes

### ✅ Customer.java

``` java
public class Customer {

    private int id;
    private String name;

    public Customer() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
```

### ✅ Item.java

``` java
import java.util.List;

public class Item {

    private int itemId;
    private String name;
    private double price;
    private List<String> tags;

    public Item() {}

    public int getItemId() { return itemId; }
    public void setItemId(int itemId) { this.itemId = itemId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }
}
```

### ✅ OrderResponse.java

``` java
import java.util.List;
import java.util.Map;

public class OrderResponse {

    private String orderId;
    private double amount;
    private boolean paid;
    private Customer customer;
    private List<Item> items;
    private Map<String, String> attributes;

    public OrderResponse() {}

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public boolean isPaid() { return paid; }
    public void setPaid(boolean paid) { this.paid = paid; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public List<Item> getItems() { return items; }
    public void setItems(List<Item> items) { this.items = items; }

    public Map<String, String> getAttributes() { return attributes; }
    public void setAttributes(Map<String, String> attributes) { this.attributes = attributes; }
}
```

------------------------------------------------------------------------

## 🔹 3️⃣ Hit GET Call Using Rest Assured

``` java
import io.restassured.RestAssured;
import io.restassured.response.Response;

Response response = RestAssured
        .given()
        .baseUri("https://api.example.com")
        .when()
        .get("/orders/500")
        .then()
        .statusCode(200)
        .extract()
        .response();
```

------------------------------------------------------------------------

## 🔹 4️⃣ Convert Response to POJO

``` java
OrderResponse order = response.as(OrderResponse.class);
```

------------------------------------------------------------------------

## 🔹 5️⃣ Print All Response Data Using POJO

``` java
System.out.println("OrderId: " + order.getOrderId());
System.out.println("Amount: " + order.getAmount());
System.out.println("Paid: " + order.isPaid());

System.out.println("Customer Id: " + order.getCustomer().getId());
System.out.println("Customer Name: " + order.getCustomer().getName());

for (Item item : order.getItems()) {

    System.out.println("Item Id: " + item.getItemId());
    System.out.println("Item Name: " + item.getName());
    System.out.println("Price: " + item.getPrice());

    for (String tag : item.getTags()) {
        System.out.println("Tag: " + tag);
    }

    System.out.println("------------------------");
}

System.out.println("Delivery Type: " + order.getAttributes().get("deliveryType"));
System.out.println("Payment Mode: " + order.getAttributes().get("paymentMode"));
```

------------------------------------------------------------------------

## 🔥 What Happened Internally?

-   Rest Assured received JSON response\
-   Jackson converted JSON → Java Object\
-   Arrays → List\
-   JSON objects → POJO\
-   Key-Value pairs → Map

------------------------------------------------------------------------

## 🎯 Interview Answer

**Q: How do you convert GET API response into POJO?**

👉 Answer:

We create POJO classes matching the JSON structure and use\
`response.as(OrderResponse.class)`\
to deserialize JSON into Java object.

------------------------------------------------------------------------

## 🚀 Best Practice

✔ Validate status code before deserialization\
✔ Use assertions instead of System.out.println\
✔ Use response.prettyPrint() only for debugging\
✔ Keep POJO clean and maintainable
