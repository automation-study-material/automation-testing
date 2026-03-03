# SOAP vs REST (Deep Explanation with Examples)

## 1️⃣ What is SOAP?

SOAP (Simple Object Access Protocol) is a strict, standardized messaging
protocol used for communication between applications.

-   Uses XML only\
-   Has very strict rules\
-   Works like a formal contract-based system

Think of SOAP like sending a registered legal document 📄\
Everything must follow a fixed format, otherwise it's rejected.

### Example (SOAP Request)

``` xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:emp="http://example.com/employee">
   <soapenv:Header/>
   <soapenv:Body>
      <emp:getEmployee>
         <emp:id>101</emp:id>
      </emp:getEmployee>
   </soapenv:Body>
</soapenv:Envelope>
```

### Key Characteristics

-   Always wrapped inside Envelope → Header → Body\
-   Uses WSDL (Web Services Description Language)\
-   Heavy, verbose, but very secure & reliable

------------------------------------------------------------------------

## 2️⃣ What is REST?

REST (Representational State Transfer) is an architectural style, not a
protocol.

-   Lightweight\
-   Mostly uses JSON\
-   Uses standard HTTP methods

Think of REST like ordering food on Swiggy/Zomato 🍔\
Simple request → simple response.

### Example (REST Request)

    GET /employees/101

### REST Response (JSON)

``` json
{
  "id": 101,
  "name": "Nitin",
  "age": 30,
  "department": "QA"
}
```

### Key Characteristics

-   No strict format\
-   Easy to use\
-   Fast and scalable

------------------------------------------------------------------------

## 3️⃣ Transport Protocol

### SOAP

-   Works with HTTP (HyperText Transfer Protocol), HTTPS (HyperText Transfer Protocol Secure), SMTP (Simple Mail Transfer Protocol), TCP (Transmission Control Protocol)
-   Not tied to web only

**Why it matters?**\
Used in banking & enterprise systems where HTTP may not be enough.

### REST

-   Uses HTTP/HTTPS only
-   Designed for the web

**Example**

    POST /payments

------------------------------------------------------------------------

## 4️⃣ Data Format

### SOAP

-   Only XML
-   Very verbose

``` xml
<age>30</age>
```

### REST

-   JSON (most common)
-   XML, text, HTML also possible

``` json
"age": 30
```

👉 REST is lighter and faster

------------------------------------------------------------------------

## 5️⃣ Contract (WSDL vs OpenAPI)

### SOAP -- WSDL (Mandatory)

WSDL defines: - Methods
- Parameters
- Data types
- Response structure

Client and server must match exactly.

### REST -- OpenAPI / Swagger (Optional)

-   Documentation driven
-   Flexible

👉 SOAP = Strict contract\
👉 REST = Flexible agreement

------------------------------------------------------------------------

## 6️⃣ Security

### SOAP

Built-in standards: 
- WS-Security
- XML Encryption
- Digital Signatures

Used when: 
- Financial transactions
- High security required

### REST

Security handled via: 
- HTTPS
- OAuth2
- JWT
- API keys

👉 SOAP security is heavy but strong
👉 REST security is simple and modern

------------------------------------------------------------------------

## 7️⃣ State Management

### SOAP

-   Can be stateful
-   Maintains session

Example:
User logs in → session maintained across calls

### REST

-   Stateless\
-   Each request is independent

```{=html}
<!-- -->
```
    Authorization: Bearer <token>

👉 REST scales better for cloud & microservices

------------------------------------------------------------------------

## 8️⃣ Error Handling

### SOAP

Uses structured Faults

``` xml
<soap:Fault>
   <faultcode>soap:Client</faultcode>
   <faultstring>Invalid Employee ID</faultstring>
</soap:Fault>
```

### REST

Uses HTTP status codes

    404 Not Found

``` json
{
  "error": "Employee not found"
}
```

------------------------------------------------------------------------

## 9️⃣ Performance

### SOAP

-   Heavy XML
-   More bandwidth
-   Slower

### REST

-   Lightweight JSON
-   Faster
-   Better caching

👉 REST wins for performance 🚀

------------------------------------------------------------------------

## 🔟 Real-World Usage

### SOAP Used In:

-   Banking systems
-   Payment gateways
-   Enterprise legacy systems
-   Telecom

### REST Used In:

-   Web applications
-   Mobile apps
-   Microservices
-   Public APIs (Google, Twitter, GitHub)

------------------------------------------------------------------------

## 🔥 Side-by-Side Comparison

  Feature       SOAP                 REST
  ------------- -------------------- ------------------
  Type          Protocol             Architecture
  Data Format   XML only             JSON, XML
  Speed         Slower               Faster
  Security      WS-Security          OAuth, JWT
  Contract      WSDL mandatory       Swagger optional
  State         Stateful             Stateless
  Complexity    High                 Low
  Usage         Enterprise systems   Modern apps

------------------------------------------------------------------------

# Stateful vs Stateless (Deep Explanation with Examples)

## 1️⃣ What is State?

State = stored information about a client between requests.

Examples: 
- Logged-in user
- Shopping cart
- Session ID
- Previous request data

------------------------------------------------------------------------

## 2️⃣ Stateful System (Concept)

A stateful system remembers the client.
👉 The server stores session data.

Think of it like calling the same bank executive every time 📞

------------------------------------------------------------------------

## 🧠 Real-Life Example (Stateful)

**Hotel Front Desk**

You check in → Room 305
Next day room service knows: 
- Room number
- Preferences

➡️ Because they remember you

------------------------------------------------------------------------

## 3️⃣ Stateful -- Technical Example (SOAP-style)

### Step 1: Login

``` xml
<login>
   <username>nitin</username>
   <password>pass123</password>
</login>
```

### Step 2: Server Creates Session

    SessionID = ABC123

### Step 3: Next Request

``` xml
<getAccountBalance>
   <sessionId>ABC123</sessionId>
</getAccountBalance>
```

### Characteristics

-   Server stores session\
-   Client sends session ID\
-   Server remembers user state

------------------------------------------------------------------------

## 4️⃣ Stateless System (Concept)

A stateless system does NOT remember the client.
👉 Each request contains all required info.

Street food stall example 🌮

------------------------------------------------------------------------

## 5️⃣ Stateless -- Technical Example (REST-style)

### Request 1

    GET /users/101
    Authorization: Bearer eyJhbGciOi...

### Request 2

    PUT /users/101
    Authorization: Bearer eyJhbGciOi...

``` json
{
  "name": "Nitin",
  "age": 30
}
```

👉 Server does NOT store session
👉 Token contains identity info

------------------------------------------------------------------------

## 6️⃣ Token vs Session

### Stateful (Session-based)

-   Session on server
-   More memory
-   Harder to scale

### Stateless (Token-based)

-   No server memory
-   Token contains user info
-   Easy to scale

------------------------------------------------------------------------

## 7️⃣ Why REST is Stateless

-   Scalability
-   Microservices
-   Load balancers

**Load Balancer Example**

    Request 1 → Server A
    Request 2 → Server B
    Request 3 → Server C

------------------------------------------------------------------------

## 8️⃣ Where Stateful Fits Better

Used when: 
- Long transactions
- High consistency
- Financial workflows

Examples: 
- Banking
- Legacy enterprise
- SOAP services

------------------------------------------------------------------------

## 🔁 Stateful vs Stateless (SOAP vs REST)

  Aspect        SOAP (Mostly Stateful)   REST (Stateless)
  ------------- ------------------------ ------------------
  State         Maintains state          No state
  Session       Stored on server         None
  Client        Session ID               Full request
  Scalability   Harder                   Easier
  Performance   Slower                   Faster
  Use Case      Banking, enterprise      Web, cloud

------------------------------------------------------------------------

## Example Summary

### SOAP (Stateful)

Login once → Session maintained → Reuse session

### REST (Stateless)

Every request → Full info + token
