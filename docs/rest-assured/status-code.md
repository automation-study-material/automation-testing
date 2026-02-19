# 🌐 HTTP Status Codes in API Testing (Detailed Guide with Real-Time Scenarios)

This document provides:

-   ✅ Detailed description of HTTP status codes
-   🔎 Real-time API testing scenarios
-   🎯 Interview-focused explanations
-   🧪 Practical examples from real projects

------------------------------------------------------------------------

# 📌 Status Code Categories

  |Range|   Category      |  Meaning                              |
  |-----|- ---------------| --------------------------------------|
  |1xx  | Informational   | Request received, continuing process  |
  |2xx  |   Success       |  Request successfully processed       |
  |3xx  |   Redirection   |  Further action required              |
  |4xx  |   Client Error  |  Issue from client side               |
  |5xx  |   Server Error  |  Issue from server side               |




# 🟢 2xx -- SUCCESS RESPONSES

------------------------------------------------------------------------

## ✅ 200 -- OK

### 🔎 Description

Request processed successfully and response body returned.

### 🧪 Real-Time Scenario

-   Fetch user profile
-   Get product list
-   Login API returning token

### Example

``` http
GET /api/users/1
Response: 200 OK
```

### Testing Validation

-   Validate response body
-   Validate response time
-   Validate headers

------------------------------------------------------------------------

## ✅ 201 -- Created

### 🔎 Description

New resource successfully created.

### 🧪 Real-Time Scenario

-   User registration
-   Creating new order
-   Creating ticket in support system

### Example

``` http
POST /api/users
Response: 201 Created
```

### Best Practice

POST should return 201 (not 200).

------------------------------------------------------------------------

## ✅ 202 -- Accepted

### 🔎 Description

Request accepted but processing happens asynchronously.

### 🧪 Real-Time Scenario

-   Report generation
-   Background job processing
-   Email sending service

------------------------------------------------------------------------

## ✅ 204 -- No Content

### 🔎 Description

Request successful but no response body returned.

### 🧪 Real-Time Scenario

-   DELETE user
-   Update user profile (no response body)

------------------------------------------------------------------------

# 🔵 3xx -- REDIRECTION RESPONSES

------------------------------------------------------------------------

## ✅ 301 -- Moved Permanently

### 🔎 Description

Resource permanently moved to new URL.

### 🧪 Real-Time Scenario

-   API version migration
-   Old endpoint deprecated

------------------------------------------------------------------------

## ✅ 302 -- Found (Temporary Redirect)

### 🔎 Description

Temporary redirection.

### 🧪 Real-Time Scenario

-   OAuth authentication redirect
-   Login redirection

------------------------------------------------------------------------

## ✅ 304 -- Not Modified

### 🔎 Description

Resource not changed (cache validation).

### 🧪 Real-Time Scenario

-   CDN caching
-   Conditional GET request

------------------------------------------------------------------------

# 🔴 4xx -- CLIENT ERRORS

Client made mistake in request.

------------------------------------------------------------------------

## ❌ 400 -- Bad Request

### 🔎 Description

Invalid request format or missing parameters.

### 🧪 Real-Time Scenario

-   Invalid JSON format
-   Missing required field
-   Wrong data type

### Example

``` json
{
  "email": "invalid-email"
}
```

------------------------------------------------------------------------

## ❌ 401 -- Unauthorized

### 🔎 Description

Authentication required or invalid token.

### 🧪 Real-Time Scenario

-   Missing JWT token
-   Expired token

------------------------------------------------------------------------
## ❌ 402 -- Payment Required

### 🔎 Description

The request cannot be processed until payment is made.

### 🧪 Real-Time Scenario
- Card declined
- Insufficient balance
- Payment authorization failed

------------------------------------------------------------------------
## ❌ 403 -- Forbidden

### 🔎 Description

Authenticated but no permission.

### 🧪 Real-Time Scenario

-   Normal user accessing admin API
-   Role-based access control failure

------------------------------------------------------------------------

## ❌ 404 -- Not Found

### 🔎 Description

Requested resource not found.

### 🧪 Real-Time Scenario

-   Wrong endpoint
-   Invalid user ID

------------------------------------------------------------------------

## ❌ 405 -- Method Not Allowed

### 🔎 Description

HTTP method not supported.

### 🧪 Real-Time Scenario

-   Using PUT instead of POST
-   Calling DELETE on read-only API

------------------------------------------------------------------------

## ❌ 409 -- Conflict

### 🔎 Description

Conflict with current server state.

### 🧪 Real-Time Scenario

-   Duplicate email registration
-   Concurrent update conflict

------------------------------------------------------------------------

## ❌ 415 -- Unsupported Media Type

### 🔎 Description

Wrong content type sent in request.

### 🧪 Real-Time Scenario

-   Sending XML when API expects JSON
-   Wrong Content-Type header

------------------------------------------------------------------------

## ❌ 422 -- Unprocessable Entity

### 🔎 Description

Request syntactically correct but business validation failed.

### 🧪 Real-Time Scenario

-   Password too weak
-   Invalid date format
-   Business rule validation failure

------------------------------------------------------------------------

# 🔥 5xx -- SERVER ERRORS

Server failed to process valid request.

------------------------------------------------------------------------

## ❌ 500 -- Internal Server Error

### 🔎 Description

Unexpected server crash or exception.

### 🧪 Real-Time Scenario

-   NullPointerException
-   Database connection failure
-   Code bug

------------------------------------------------------------------------

## ❌ 502 -- Bad Gateway

### 🔎 Description

Invalid response from upstream server.

### 🧪 Real-Time Scenario

-   Microservice failure
-   API Gateway communication issue

------------------------------------------------------------------------

## ❌ 503 -- Service Unavailable

### 🔎 Description

Server temporarily unavailable.

### 🧪 Real-Time Scenario

-   Maintenance mode
-   High server load
-   Circuit breaker triggered

------------------------------------------------------------------------

## ❌ 504 -- Gateway Timeout

### 🔎 Description

Upstream service did not respond in time.

### 🧪 Real-Time Scenario

-   Slow database query
-   Timeout in microservice chain

------------------------------------------------------------------------

# 🎯 Common Interview Questions

### Q1: Difference between 401 and 403?

  401                 403
  ------------------- ----------------------------------
  Not authenticated   Authenticated but not authorized

------------------------------------------------------------------------

### Q2: Difference between 400 and 422?

  400            422
  -------------- ---------------------------
  Syntax error   Business validation error

------------------------------------------------------------------------

### Q3: What status should POST return?

→ 201 Created

------------------------------------------------------------------------

# 🧠 Real Project API Validation Checklist

During API testing validate:

-   Status code
-   Response time
-   Response body
-   Response headers
-   Error message format
-   Idempotency behavior

------------------------------------------------------------------------

# 📌 Most Common Status Codes in Real API Testing

-   200
-   201
-   204
-   400
-   401
-   403
-   404
-   409
-   500
-   503

------------------------------------------------------------------------

# 🚀 Final Interview Tip

In interviews, don't just say the number.\
Always explain:

-   When it occurs\
-   Whether it is client or server error\
-   Real-world microservice example

That shows practical API testing knowledge.
