Great 👍 Since you’re working with APIs (and also learning automation), this is very useful for **interview + real project**.

Below I’ll give you:

1️⃣ Complete **Postman Test Script**
2️⃣ Validate:

* Status Code
* Response Time
* Headers
* JSON Schema
* Specific Keys
* List validation
* Store values into Environment Variables
  3️⃣ Important Interview Points

---

# 🔹 Example API (Sample Response)

Assume API:

```
GET https://reqres.in/api/users?page=2
```

Sample Response:

```json
{
  "page": 2,
  "per_page": 6,
  "total": 12,
  "data": [
    {
      "id": 7,
      "email": "michael.lawson@reqres.in",
      "first_name": "Michael",
      "last_name": "Lawson"
    }
  ]
}
```

---

# ✅ Postman Test Script (Put in "Tests" Tab)

```javascript
// Parse response
let jsonData = pm.response.json();


// 1️⃣ Validate Status Code
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});


// 2️⃣ Validate Response Time
pm.test("Response time is less than 2 seconds", function () {
    pm.expect(pm.response.responseTime).to.be.below(2000);
});


// 3️⃣ Validate Response Header
pm.test("Content-Type is application/json", function () {
    pm.response.to.have.header("Content-Type");
    pm.expect(pm.response.headers.get("Content-Type"))
        .to.include("application/json");
});


// 4️⃣ Validate Root Keys
pm.test("Validate main keys exist", function () {
    pm.expect(jsonData).to.have.property("page");
    pm.expect(jsonData).to.have.property("per_page");
    pm.expect(jsonData).to.have.property("data");
});


// 5️⃣ Validate List is Returned
pm.test("Validate data is array and not empty", function () {
    pm.expect(jsonData.data).to.be.an("array");
    pm.expect(jsonData.data.length).to.be.above(0);
});


// 6️⃣ Validate Specific Keys in Each Object
pm.test("Validate keys inside each user object", function () {
    jsonData.data.forEach(user => {
        pm.expect(user).to.have.property("id");
        pm.expect(user).to.have.property("email");
        pm.expect(user).to.have.property("first_name");
        pm.expect(user).to.have.property("last_name");
    });
});


// 7️⃣ Validate Specific Value
pm.test("Validate page number is 2", function () {
    pm.expect(jsonData.page).to.eql(2);
});


// 8️⃣ Validate Email Format
pm.test("Validate email format", function () {
    jsonData.data.forEach(user => {
        pm.expect(user.email).to.match(
            /^[^\s@]+@[^\s@]+\.[^\s@]+$/
        );
    });
});


// 9️⃣ JSON Schema Validation
let schema = {
    "type": "object",
    "required": ["page", "per_page", "data"],
    "properties": {
        "page": {"type": "number"},
        "per_page": {"type": "number"},
        "data": {
            "type": "array",
            "items": {
                "type": "object",
                "required": ["id", "email", "first_name", "last_name"],
                "properties": {
                    "id": {"type": "number"},
                    "email": {"type": "string"},
                    "first_name": {"type": "string"},
                    "last_name": {"type": "string"}
                }
            }
        }
    }
};

pm.test("Schema is valid", function () {
    pm.response.to.have.jsonSchema(schema);
});


// 🔟 Store value into Environment Variable
pm.environment.set("userId", jsonData.data[0].id);
pm.environment.set("userEmail", jsonData.data[0].email);
```

---

# 🔥 How to Use Stored Variable

Next API request:

```
GET https://reqres.in/api/users/{{userId}}
```

Postman automatically replaces `{{userId}}`.

---

# 🎯 Important Interview Points (Very Important)

When interviewer asks:

### ❓ What validations you do in API testing?

You should answer like this:

1️⃣ Validate Status Code
2️⃣ Validate Response Body
3️⃣ Validate Headers
4️⃣ Validate Response Time
5️⃣ Validate Schema
6️⃣ Validate Data Type
7️⃣ Validate Mandatory Fields
8️⃣ Validate Negative Scenarios
9️⃣ Validate Authorization
🔟 Validate Pagination

---

### ❓ Difference between Schema Validation & Key Validation?

| Key Validation                | Schema Validation           |
| ----------------------------- | --------------------------- |
| Check specific field manually | Validate complete structure |
| More coding                   | Cleaner & structured        |
| Not strict                    | Strict contract validation  |

---

### ❓ Why Schema Validation Important?

* Ensures API contract consistency
* Prevents breaking changes
* Useful in Microservices
* Important in CI/CD

---

# 💡 Pro-Level Tips (Interview Impact)

1. Always validate response time (< 2s or as per SLA)
2. Validate negative scenarios (401, 400, 404)
3. Validate null values
4. Use dynamic variables
5. Chain APIs using environment variables
6. Use pre-request script for token generation
7. Validate sorting & pagination

---


