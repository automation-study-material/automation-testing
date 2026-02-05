# URI vs URL — Quick Notes

## ✅ URI (Uniform Resource Identifier)

A **URI** is a generic identifier used to identify a resource on the internet.

### Key Points
- Identifies a resource by **name or location**
- May or may not provide access method
- Broader concept
- Includes **URL + URN**

### Examples
```text
https://google.com
mailto:test@gmail.com
urn:isbn:12345
```


---

## ✅ URL (Uniform Resource Locator)

A **URL** is a specific type of URI that tells:

✔ Where the resource is located  
✔ How to access it (protocol)

### Key Points
- Contains **protocol** (http/https/ftp)
- Contains **domain/IP**
- Always provides location
- Browser accessible
- Commonly used in REST APIs and web applications

### Examples
```text
https://google.com
http://localhost:8080/api/users
ftp://files.server.com/data.txt
```

---

## ✅ Relationship
```text
URI
├── URL
└── URN
```


👉 **All URLs are URIs**  
👉 **Not all URIs are URLs**

---

## ✅ Simple Analogy

| Concept | Example |
|---------|-----------|
| URI | Person name |
| URL | Home address |

Name identifies.  
Address locates.

---

## ✅ Difference Between URI and URL

| Feature | URI | URL |
|----------|---------------------------|---------------------------|
| Full form | Uniform Resource Identifier | Uniform Resource Locator |
| Purpose | Identify resource | Locate resource |
| Scope | Broader | Subset of URI |
| Location info | Optional | Mandatory |
| Protocol | Optional | Required |
| Browser accessible | Not always | Always |
| Includes | URL + URN | Only URLs |
| Examples | mailto:, urn:, https | http, https, ftp |

---

## ✅ One-Line Interview Answer

> URI identifies a resource, while URL identifies and also provides its location and access method. URL is a type of URI.
