# 🚀 Why APIs Came Into the Picture Nowadays?

------------------------------------------------------------------------

## 🔹 1️⃣ Modern Applications Are Distributed

### Earlier (Monolithic Apps):

Frontend + Backend + Database → All in one system

### Now:

-   Mobile App\
-   Web App\
-   Microservices\
-   Cloud services\
-   Third-party integrations

👉 All these components need a way to talk to each other

**That communication layer = API**

------------------------------------------------------------------------

## 🔹 2️⃣ Microservices Architecture

Modern companies use microservices instead of monolithic apps.

Instead of one big system:

-   User Service\
-   Order Service\
-   Payment Service\
-   Notification Service

Each service exposes APIs.

### Example:

    POST /users
    GET /orders/101
    POST /payments

Without APIs → Services cannot communicate.

------------------------------------------------------------------------

## 🔹 3️⃣ Multiple Client Types

One backend, many clients:

-   Web Application\
-   Android App\
-   iOS App\
-   Smart TV\
-   Partner Systems

Instead of building backend separately for each →\
We build one API layer.

### Example:

    GET /products

Used by:

-   Website\
-   Mobile App\
-   External partners

------------------------------------------------------------------------

## 🔹 4️⃣ Cloud & SaaS Explosion

Now everything is cloud-based:

-   Payment → Stripe API\
-   Maps → Google Maps API\
-   Login → OAuth APIs\
-   Messaging → Twilio API

Companies reuse services instead of building everything from scratch.

------------------------------------------------------------------------

## 🔹 5️⃣ Automation & DevOps

Since you're DevOps:

-   CI/CD tools use APIs\
-   Kubernetes exposes APIs\
-   Jenkins pipelines trigger APIs\
-   Monitoring tools expose APIs\
-   GitHub webhooks → API calls

Without APIs → Automation is impossible.

------------------------------------------------------------------------

## 🔹 6️⃣ Data-Driven World

Modern systems:

-   Need real-time data\
-   Integrate with AI services\
-   Connect to external systems

APIs make data exchange standardized (JSON, XML).

------------------------------------------------------------------------

# 🔥 Simple Real-Life Analogy

Restaurant example:

-   You (client)\
-   Kitchen (server)\
-   Waiter (API)

You don't go to kitchen directly.\
You tell waiter.\
Waiter brings response.

👉 **API = Waiter between systems**

------------------------------------------------------------------------

# 🎯 Interview Answer (Short Version)

APIs became important because modern applications are distributed, use
microservices, support multiple clients (web, mobile), and rely heavily
on cloud and automation. APIs provide a standardized way for systems to
communicate securely and efficiently.

------------------------------------------------------------------------

# 🧪 Points to Consider Before Starting API Testing

Before testing any API, consider the following:

## 1️⃣ Understand API Requirements

-   Read API documentation (Swagger/OpenAPI)
-   Understand request/response structure
-   Know supported HTTP methods (GET, POST, PUT, DELETE)

## 2️⃣ Validate Endpoint Details

-   Base URL
-   Resource path
-   Query parameters
-   Path parameters

## 3️⃣ Authentication & Authorization

-   API keys
-   OAuth tokens
-   JWT tokens
-   Basic authentication

## 4️⃣ Request Validation

-   Required fields
-   Data types
-   Boundary values
-   Invalid input scenarios

## 5️⃣ Response Validation

-   Status codes (200, 201, 400, 401, 500)
-   Response body structure
-   JSON schema validation
-   Error messages

## 6️⃣ Performance Considerations

-   Response time
-   Load handling
-   Timeout behavior

## 7️⃣ Security Testing

-   SQL injection checks
-   XSS validation
-   Data exposure
-   Role-based access validation

## 8️⃣ Integration Dependencies

-   Database validation
-   Downstream service availability
-   Third-party API impact

## 9️⃣ Environment Setup

-   Test environment readiness
-   Test data availability
-   Mock services if required

------------------------------------------------------------------------

End of Document
