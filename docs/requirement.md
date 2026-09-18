# User Registration – Tester Practice Specification

## 1. Feature Story

### Feature: User Registration

A new user wants to create an account in an application.

The user opens the Registration page and enters:

- First Name
- Last Name
- Email
- Mobile Number
- Password
- Confirm Password
- Date of Birth
- Gender
- Country
- Terms & Conditions checkbox

After submitting the form:

1. The UI validates mandatory fields and field formats.
2. The application sends a registration API request.
3. The backend validates the request again.
4. The backend checks whether the email/mobile already exists.
5. The password is securely stored.
6. A user record is created.
7. A verification OTP/email may be sent.
8. The UI displays a successful registration message.
9. The user can verify the account and then log in.

---

# 2. Business Requirements

| ID | Requirement |
|---|---|
| REG-001 | User must provide all mandatory fields. |
| REG-002 | Email must have a valid format. |
| REG-003 | Mobile number must have the required length and format. |
| REG-004 | Password must satisfy the defined password policy. |
| REG-005 | Confirm Password must match Password. |
| REG-006 | User must accept Terms & Conditions. |
| REG-007 | Email must be unique. |
| REG-008 | Mobile number must be unique if required by the business. |
| REG-009 | Successful registration creates exactly one user account. |
| REG-010 | Password must never be returned in API responses. |
| REG-011 | Duplicate submission must not create duplicate accounts. |
| REG-012 | Verification should be required if the business flow uses email/OTP verification. |

---

# 3. UI Testing

## 3.1 Page-Level Checks

Verify:

- Registration page opens successfully.
- Correct page title/header is displayed.
- All required fields are visible.
- Labels are correct.
- Mandatory fields are clearly identified.
- Register button is visible.
- Terms & Conditions link works.
- Privacy Policy link works if present.
- Tab order is logical.
- Keyboard navigation works.
- Page works on supported browsers.
- Page works on supported mobile/responsive resolutions.

---

# 4. Field-Level Test Cases

## First Name

### Valid

- `Nitin`
- `John`
- `Mary`

### Invalid / Edge Cases

- Empty
- Only spaces
- One character
- Maximum allowed length
- Maximum + 1 character
- Numbers: `Nitin123`
- Special characters: `Nitin@`
- Very long input
- Leading spaces
- Trailing spaces
- Unicode characters if supported

Questions for requirement clarification:

- Are numbers allowed?
- Are hyphens allowed?
- Are apostrophes allowed?
- What is the maximum length?

---

# 5. Last Name

Test the same categories:

- Valid name
- Empty
- Spaces
- Minimum length
- Maximum length
- Maximum + 1
- Numbers
- Special characters
- Leading/trailing spaces
- Unicode characters

---

# 6. Email

## Valid Examples

- `test@gmail.com`
- `john.doe@example.com`
- `user+test@example.com`

## Invalid Examples

- Empty
- `test`
- `test@`
- `@gmail.com`
- `test@gmail`
- `test..abc@gmail.com`
- `test @gmail.com`
- Spaces before/after email
- Very long email

## Boundary Cases

Test the documented maximum email length.

Also test:

- Uppercase email
- Mixed-case email
- Same email with different case
- Existing email

Example:

```text
user@gmail.com
USER@GMAIL.COM
User@gmail.com
```

Verify whether the application treats them as the same account according to the business rule.

---

# 7. Mobile Number

Test:

- Empty
- Valid number
- Less than required digits
- More than required digits
- Alphabetic characters
- Special characters
- Spaces
- Country code
- Leading zero
- Existing mobile number
- Very large input

Example for a 10-digit Indian mobile rule:

```text
9876543210       -> valid example
987654321        -> invalid length
98765432101      -> invalid length
abcdefghij       -> invalid
```

Do not assume these exact rules unless they are specified by the product.

---

# 8. Password

Suppose the requirement is:

```text
Minimum 8 characters
At least 1 uppercase
At least 1 lowercase
At least 1 number
At least 1 special character
```

Test:

```text
Password1@
password1@
PASSWORD1@
Password@
Password1
Pass1@
P@1
```

Also test:

- Empty password
- Spaces
- Leading/trailing spaces
- Maximum allowed length
- Maximum + 1
- Copy/paste behavior
- Password masking
- Show/hide password button
- Very long input
- Common/weak password if password-strength rules exist

---

# 9. Confirm Password

Test:

```text
Password:        Password1@
Confirm Password: Password1@
```

Expected:

```text
Match
```

Then:

```text
Password:        Password1@
Confirm Password: Password2@
```

Expected:

```text
Mismatch error
```

Also test:

- Empty confirm password
- Case difference
- Extra space
- Special character difference

---

# 10. Terms & Conditions

Test:

- Checkbox unchecked + Register
- Checkbox checked + Register
- Click label
- Open Terms & Conditions
- Keyboard interaction

Expected:

```text
Unchecked -> Registration should not proceed
Checked   -> Registration can proceed if all other validations pass
```

---

# 11. UI Positive Flow

### Test Case: Successful Registration

Input:

```text
First Name       = Nitin
Last Name        = Patil
Email            = unique@test.com
Mobile           = valid unique number
Password         = Password1@
Confirm Password = Password1@
DOB              = valid date
Gender           = valid option
Country          = India
Terms            = Checked
```

Click:

```text
Register
```

Expected:

1. Client-side validation passes.
2. API request is sent.
3. API returns success.
4. User sees success message.
5. User record is created.
6. Verification process starts if applicable.
7. Duplicate user is not created.

---

# 12. Negative UI Scenarios

Test registration with:

- All fields empty
- One mandatory field missing
- Invalid email
- Invalid mobile
- Weak password
- Password mismatch
- Terms unchecked
- Existing email
- Existing mobile
- Invalid DOB
- Future DOB
- Invalid dropdown value
- Multiple rapid clicks on Register
- Browser refresh during submission
- Network disconnected during submission
- Slow network
- API returns 400
- API returns 409
- API returns 500

---

# 13. API Registration Contract

Example endpoint:

```http
POST /api/v1/users/register
```

### Request

```json
{
  "firstName": "Nitin",
  "lastName": "Patil",
  "email": "nitin@example.com",
  "mobile": "9876543210",
  "password": "Password1@",
  "confirmPassword": "Password1@",
  "dateOfBirth": "1995-05-10",
  "gender": "MALE",
  "country": "IN",
  "termsAccepted": true
}
```

### Successful Response

Example:

```json
{
  "userId": "USR12345",
  "message": "Registration successful",
  "verificationRequired": true
}
```

Important:

**Password should not be returned in the response.**

---

# 14. API Test Cases

## Positive

### Valid request

Expected:

```http
HTTP 201 Created
```

Verify:

- Status code
- Response schema
- User ID generated
- Message
- Verification flag
- Response time
- Required headers

---

## Missing Field

Remove email:

```json
{
  "firstName": "Nitin",
  "lastName": "Patil",
  "mobile": "9876543210"
}
```

Expected:

```http
400 Bad Request
```

Verify:

- Correct error message
- Correct field identified
- No user created

---

# 15. Duplicate Registration

Send the same request twice.

### First request

```text
201 Created
```

### Second request

Expected business behavior could be:

```text
409 Conflict
```

or another documented response.

Most importantly verify:

```text
Only one user record exists.
```

---

# 16. API Edge Cases

Test:

### Null

```json
{
  "email": null
}
```

### Empty string

```json
{
  "email": ""
}
```

### Blank string

```json
{
  "email": "   "
}
```

### Wrong data type

```json
{
  "mobile": 9876543210
}
```

when API expects a string.

### Extra fields

```json
{
  "firstName": "Nitin",
  "unknownField": "test"
}
```

Verify whether the API rejects or ignores unknown fields according to the API contract.

### Very long values

Send strings beyond documented limits.

### Special characters

Test safely with:

```text
< > " ' & %
```

and verify proper validation/encoding.

---

# 17. API Security Checks

Verify:

- Password is sent only over HTTPS.
- Password is not returned in response.
- Password is not exposed in normal application logs.
- Sensitive data is not unnecessarily exposed in error messages.
- Authentication/authorization requirements are respected where applicable.
- Rate limiting exists if specified.
- Registration endpoint cannot be abused by unlimited automated requests.
- Server-side validation cannot be bypassed by disabling browser JavaScript.

Important tester mindset:

> Never trust UI validation alone.

A user can call the API directly using Postman/curl.

Therefore:

```text
UI Validation
      +
API Validation
      +
Database Validation
```

should all be tested.

---

# 18. Database Validation

After successful registration:

```sql
SELECT *
FROM users
WHERE email = 'nitin@example.com';
```

Verify:

- Exactly one record exists.
- Correct email.
- Correct mobile.
- Correct name.
- Correct status.
- Created timestamp is populated.
- Verification status is correct.
- Password is stored securely according to the application's security design.

Never expect to compare a plaintext password with the database if the system correctly hashes passwords.

---

# 19. Important Database Edge Cases

Check:

### Duplicate

```sql
SELECT email, COUNT(*)
FROM users
GROUP BY email
HAVING COUNT(*) > 1;
```

### Duplicate mobile

```sql
SELECT mobile, COUNT(*)
FROM users
GROUP BY mobile
HAVING COUNT(*) > 1;
```

### Missing data

Check whether mandatory columns contain unexpected NULL values.

### Transaction failure

Example:

```text
User record created
       ↓
OTP creation fails
```

Verify the expected business behavior.

The system should not accidentally leave inconsistent data.

---

# 20. End-to-End Flow

Think like this:

```text
                USER
                  |
                  v
          Registration UI
                  |
           Client Validation
                  |
                  v
          POST /register API
                  |
          Server Validation
                  |
          Check Duplicate
             /        \
           Yes         No
           |           |
        Reject         |
                       v
                 Create User
                       |
                       v
                 Create OTP
                       |
                       v
               Send Email/SMS
                       |
                       v
             Registration Success
                       |
                       v
                Verify Account
                       |
                       v
                    Login
```

---

# 21. Most Important Edge Cases

For an SDET interview, remember these categories:

| Category | Examples |
|---|---|
| Empty | `null`, `""`, spaces |
| Boundary | min, max, max+1 |
| Format | invalid email/mobile |
| Duplicate | existing email/mobile |
| Special characters | `< > " ' & %` |
| Case | `User@test.com` vs `user@test.com` |
| Length | very short / very long |
| Data type | string vs number |
| Business rule | age, country, terms |
| Concurrency | two registrations simultaneously |
| Double click | two requests |
| Network | timeout/disconnection |
| API errors | 400/401/409/429/500 |
| DB | duplicate/inconsistent records |
| Security | password exposure, validation bypass |
| Performance | slow registration/API response |

---

# 22. Concurrency Scenario

This is an important real-world test.

Two requests arrive at almost the same time:

```text
Request A -> user@test.com
Request B -> user@test.com
```

Both might initially check:

```text
Does email exist? -> NO
```

The database/application must still prevent two accounts from being created.

Test this using parallel API requests and verify the final database state.

---

# 23. Tester Thinking Process

When a developer gives you a Registration feature, don't immediately start writing test cases.

Ask:

### Step 1 — Understand the business

```text
Who can register?
What fields are mandatory?
What makes a user unique?
Is email verification required?
Is mobile verification required?
What password policy applies?
Can an existing user register again?
```

### Step 2 — Understand UI

```text
What fields?
What validations?
What error messages?
What browsers/devices?
What happens after success?
```

### Step 3 — Understand API

```text
Endpoint?
Method?
Headers?
Request schema?
Response schema?
Status codes?
Error codes?
Authentication?
Rate limits?
```

### Step 4 — Understand database

```text
Which table?
Which columns?
Unique constraints?
User status?
Verification status?
Audit fields?
```

### Step 5 — Test the complete chain

```text
UI
 ↓
API
 ↓
Service/Business Logic
 ↓
Database
 ↓
Email/SMS/OTP
 ↓
Verification
 ↓
Login
```

---

# 24. Interview Answer

If interviewer asks:

**"How would you test a registration functionality?"**

You can say:

> "First I understand the registration business rules and mandatory fields. I test the UI for positive, negative and boundary scenarios such as valid data, empty fields, invalid email, invalid mobile, password rules, password mismatch and terms and conditions.
>
> Then I test the registration API independently using Postman or Rest Assured. I validate status codes, request and response schema, error handling, duplicate registration and invalid payloads.
>
> After successful registration, I validate the database to make sure exactly one user record is created with correct data. I also verify that sensitive information like passwords is not exposed.
>
> Finally, I perform end-to-end testing from registration through verification and login. I also cover edge cases like double-click submission, concurrent registration, network failures, API 4xx/5xx responses and boundary values."

---

# 25. Suggested Test Execution Order

```text
1. Requirement Analysis
       ↓
2. UI Functional Testing
       ↓
3. API Testing
       ↓
4. Database Validation
       ↓
5. Integration Testing
       ↓
6. Negative & Edge Cases
       ↓
7. Security Checks
       ↓
8. Performance/Concurrency
       ↓
9. End-to-End Testing
       ↓
10. Regression Testing
```

This gives you a realistic **SDET-level registration testing exercise** rather than only a list of UI test cases.
