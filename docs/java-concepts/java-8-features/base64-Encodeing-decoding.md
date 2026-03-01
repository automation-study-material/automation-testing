Here is your content in clean **.md file format** 👇

---

# 🔵 Base64 Encoding & Decoding (Java 8)

---

## ✅ What is Base64?

Base64 is a **binary-to-text encoding scheme** that converts binary data into ASCII string format.

---

### 👉 Used when:

* Sending data over HTTP
* Encoding images in JSON
* Basic Authentication
* Storing binary data in text format

---

## 🔎 Why Base64 is Needed?

Some systems only support **text data**.

### 📌 Example:

* Email attachments
* JSON payloads
* URL parameters

```
Binary → Base64 → Safe Text Format
```

---

## ✅ Java 8 Base64 Utility

Java 8 introduced:

```java
import java.util.Base64;
```

Before Java 8, we used external libraries like **Apache Commons Codec**.

---

## 🔹 Types of Base64 Encoders in Java 8

| Type  | Method             | Usage                 |
| ----- | ------------------ | --------------------- |
| Basic | `getEncoder()`     | Standard encoding     |
| URL   | `getUrlEncoder()`  | URL-safe encoding     |
| MIME  | `getMimeEncoder()` | For email attachments |

---

## ✅ Encoding Example (Detailed)

```java
import java.util.Base64;

public class Base64Example {

    public static void main(String[] args) {

        String original = "Java8";

        // Convert String to byte[]
        byte[] bytes = original.getBytes();

        // Encode
        String encoded = Base64.getEncoder().encodeToString(bytes);

        System.out.println("Encoded: " + encoded);
        // Output: Encoded: SmF2YTg=
    }
}
```

---

## 🔎 Step-by-Step Internal Working

1. `"Java8"` → Converted to ASCII bytes
2. Bytes grouped into 3-byte blocks
3. Each block converted into 4 Base64 characters
4. `=` used as padding if required

---

## ✅ Decoding Example

```java
String encoded = "SmF2YTg=";

byte[] decodedBytes = Base64.getDecoder().decode(encoded);

String decoded = new String(decodedBytes);

System.out.println("Decoded: " + decoded);

// Output: Decoded: Java8
```

---

## 🔥 Interview Points

* Base64 increases size by approximately **33%**
* It is **NOT encryption** (no security provided)
* Used in **JWT tokens**
* Used in **Basic Authentication header**

Example:

```
Authorization: Basic base64(username:password)
```

Tell me what you want next 🚀
