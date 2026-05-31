# 📱 Week 3 & Week 4: Functional Testing and UI Testing

> 🎯 Goal: Learn how mobile testers validate application functionality and user interface in real projects.

---

# 📖 Week 3: Functional Testing

# What is Functional Testing?

Functional Testing means:

```text
Verify application behaves according to business requirements.
```

Simple question:

```text
Does the feature work correctly?
```

If yes:

✅ Pass

If no:

❌ Fail

---

# Real Example

Suppose:

```text
Amazon App
```

Feature:

```text
Login
```

Requirement:

```text
User should login successfully using valid credentials.
```

Testing:

```text
Enter username

Enter password

Click Login
```

Expected:

```text
User logged in successfully
```

---

# 🔐 Login Testing

Login is one of the most commonly tested features.

---

# Scenario 1: Valid Credentials

### Steps

```text
Username = nitin@test.com

Password = Password123
```

Click Login.

Expected:

```text
Login successful
```

---

# Scenario 2: Invalid Credentials

### Steps

```text
Username = nitin@test.com

Password = WrongPassword
```

Expected:

```text
Invalid Username or Password
```

---

# Scenario 3: Blank Fields

### Steps

```text
Username = Blank

Password = Blank
```

Expected:

```text
Username is required

Password is required
```

---

# Common Login Defects

### Defect 1

```text
Correct password entered

Login failed
```

Functional defect.

---

### Defect 2

```text
Invalid password entered

User logged in
```

Critical defect.

---

# Interview Question

### What will you test on Login Page?

Answer:

* Valid Login
* Invalid Login
* Blank Fields
* Password Visibility
* Forgot Password
* Session Management
* Error Messages

---

# 📝 Registration Testing

Registration is usually more complex than Login.

---

# OTP Validation

## Scenario 1

Correct OTP

Expected:

```text
Registration successful
```

---

## Scenario 2

Incorrect OTP

Expected:

```text
Invalid OTP
```

---

## Scenario 3

Expired OTP

Expected:

```text
OTP expired
```

---

# Password Rules Testing

Suppose requirement says:

```text
Minimum 8 characters

1 Uppercase

1 Number

1 Special Character
```

---

## Valid Password

```text
Test@123
```

Expected:

```text
Accepted
```

---

## Invalid Password

```text
test123
```

Expected:

```text
Password policy message
```

---

# Email Validation

## Valid

```text
test@gmail.com
```

Accepted.

---

## Invalid

```text
testgmail.com
```

Expected:

```text
Invalid Email Format
```

---

# Common Registration Defects

### Example

```text
Invalid email accepted
```

Bug.

---

### Example

```text
OTP expired

Registration still successful
```

Bug.

---

# 🔍 Search Testing

Search functionality exists in almost every application.

---

# Exact Match

Search:

```text
iPhone 16
```

Expected:

```text
iPhone 16 displayed
```

---

# Partial Match

Search:

```text
iPho
```

Expected:

```text
iPhone suggestions displayed
```

---

# No Results

Search:

```text
XYZ123ABC999
```

Expected:

```text
No Results Found
```

---

# Common Search Defects

### Example

```text
Search returns unrelated products
```

Bug.

---

### Example

```text
No results available

Blank screen shown
```

Bug.

Expected:

```text
No Results Found
```

---

# Functional Testing Checklist

Verify:

✅ Login

✅ Logout

✅ Registration

✅ Search

✅ Profile Update

✅ Notifications

✅ Payments

✅ Forgot Password

---

# 📋 Defect Report Example

### Title

```text
Login fails with valid credentials
```

---

### Steps

```text
1. Open Application

2. Enter Valid Username

3. Enter Valid Password

4. Click Login
```

---

### Expected

```text
User should login successfully
```

---

### Actual

```text
Invalid Credentials Error Displayed
```

---

### Severity

```text
High
```

---

# 📖 Week 4: UI Testing

# What is UI Testing?

UI means:

```text
User Interface
```

Everything user sees:

* Buttons
* Images
* Labels
* Fonts
* Layouts

---

# Example

Expected:

```text
[ LOGIN ]
```

Actual:

```text
[ LOG
```

Text cut off.

UI defect.

---

# 📱 Portrait Mode Testing

Portrait Mode:

```text
|
|
|
|
|
```

Normal mobile usage.

---

# Verify

* Button Alignment
* Labels
* Images
* Text Visibility
* Layout Consistency

---

# Example

Expected:

```text
Username

Password

[ Login ]
```

Actual:

```text
Username

[ Login ]

Password
```

Layout defect.

---

# Image Testing

Verify:

* Images load properly
* Images not distorted
* Images not blurry

---

# Example

Company Logo:

Expected:

```text
Clear Logo
```

Actual:

```text
Blurred Logo
```

UI defect.

---

# 🔄 Landscape Mode Testing

Landscape Mode:

```text
------------------
------------------
```

Rotate phone.

---

# Verify

* Screen Layout
* Text Visibility
* Button Accessibility
* Responsiveness

---

# Example

Portrait:

```text
[ Login ]
```

Landscape:

```text
Button hidden
```

Bug.

---

# UI Responsiveness

Verify application adjusts correctly after screen rotation.

---

# Example

Rotate phone.

Expected:

```text
Screen adjusts properly
```

Actual:

```text
Text overlaps images
```

Bug.

---

# 📲 Device Compatibility Testing

Not all phones have same:

* Screen Size
* Resolution
* Android Version

---

# Real Example

Application works on:

```text
Samsung S24
```

but breaks on:

```text
Vivo V29
```

Compatibility defect.

---

# Devices To Test

### Samsung

Popular Android device.

---

### OnePlus

Different screen resolution.

---

### Vivo

Different UI customizations.

---

# Common Compatibility Defects

### Example

```text
Login button hidden on Vivo
```

---

### Example

```text
Text overlaps image on OnePlus
```

---

### Example

```text
App crashes on Android 12
```

---

# Interview Questions

---

# Scenario 1

## Question

User enters valid credentials but login fails.

Which testing type found this issue?

Answer:

```text
Functional Testing
```

---

# Scenario 2

## Question

Login button overlaps password field.

Which testing type found this issue?

Answer:

```text
UI Testing
```

---

# Scenario 3

## Question

App works on Samsung but crashes on Vivo.

Which testing type found this issue?

Answer:

```text
Compatibility Testing
```

---

# Scenario 4

## Question

User enters expired OTP and registration succeeds.

What is the defect?

Answer:

```text
Functional Defect
```

---

# Scenario 5

## Question

Landscape mode hides Submit button.

What is the defect?

Answer:

```text
UI Defect
```

---

# Scenario 6

## Question

Searching "iPhone" displays Shoes.

What is the defect?

Answer:

```text
Search Functional Defect
```

---

# Scenario 7

## Question

Text appears correctly on Samsung but overlaps on OnePlus.

What is the issue?

Answer:

```text
Device Compatibility Issue
```

---

# 🎯 Week 3 & Week 4 Outcome

After completing these topics, you should understand:

✅ Login Testing

✅ Registration Testing

✅ OTP Validation

✅ Password Validation

✅ Email Validation

✅ Search Testing

✅ Defect Reporting

✅ UI Testing

✅ Portrait Testing

✅ Landscape Testing

✅ Compatibility Testing

✅ Common Mobile Defects

✅ Mobile Interview Questions

---

