# 📱 Week 2: Mobile Testing Concepts

> 🎯 Goal: Understand different types of mobile applications and the major types of testing performed on mobile apps.

---

# 📖 1. Types of Mobile Applications

Before testing an application, a tester must understand what type of application it is.

Different app types have different testing approaches.

---

# 1. Native Applications

## What is a Native App?

A Native App is built specifically for one operating system.

Examples:

```text
Android → Java/Kotlin

iPhone → Swift/Objective-C
```

---

## Real Examples

* WhatsApp
* Google Pay
* PhonePe
* Google Maps

---

## How Native Apps Work

```text
Application
      ↓
Android APIs
      ↓
Android OS
      ↓
Mobile Hardware
```

Native apps directly communicate with the operating system.

---

## Advantages

✅ Fast

✅ Smooth UI

✅ Better performance

✅ Can use all device features

---

## Disadvantages

❌ Separate Android and iOS development required

---

## Tester Perspective

Verify:

* Camera
* GPS
* Fingerprint
* Notifications
* Contacts
* Microphone

---

## Example

WhatsApp:

```text
Record Voice Message
```

Uses:

```text
Microphone
```

Native feature.

---

# 2. Mobile Web Applications

## What is a Mobile Web App?

A website opened inside a mobile browser.

Example:

```text
https://amazon.in
```

opened in:

```text
Chrome Mobile Browser
```

---

## Real Examples

* Banking websites
* Shopping websites
* News websites

---

## How Mobile Web Apps Work

```text
Browser
      ↓
Website
      ↓
Server
```

No installation required.

---

## Advantages

✅ No installation

✅ Works on all devices

✅ Easy updates

---

## Disadvantages

❌ Internet required

❌ Limited device access

---

## Tester Perspective

Verify:

* Responsive design
* Browser compatibility
* Scrolling
* Forms
* Navigation

---

## Example

Open Amazon website:

```text
Chrome Browser
```

No APK required.

---

# 3. Hybrid Applications

## What is Hybrid App?

Combination of:

```text
Native + Web
```

---

## Example

```text
Native Container
      ↓
WebView
      ↓
HTML/CSS/JavaScript
```

---

## Real Examples

Many enterprise applications.

Some food delivery apps.

Some banking apps.

---

## How to Identify Hybrid Apps?

Open application.

Some screens feel native.

Some screens behave like websites.

Example:

```text
Login Screen → Native

Help Center → WebView
```

---

## Tester Perspective

Need to test:

* Native screens
* WebView screens
* Switching between both

---

# 📖 Interview Question

## Native vs Web vs Hybrid

| Feature          | Native | Web     | Hybrid  |
| ---------------- | ------ | ------- | ------- |
| Install Required | Yes    | No      | Yes     |
| Performance      | Fast   | Medium  | Medium  |
| Offline Support  | Yes    | No      | Partial |
| Device Access    | Full   | Limited | Partial |

---

# 🧪 Types of Mobile Testing

---

# 4. Functional Testing

## What is Functional Testing?

Verify application behaves according to requirements.

---

## Example

Login Functionality

```text
Enter Username

Enter Password

Click Login
```

Expected:

```text
User Logged In
```

---

## Tester Checks

* Login
* Registration
* Search
* Payment
* Logout

---

# Example Defect

```text
Correct password entered

Login failed
```

Functional defect.

---

# 5. UI Testing

## What is UI Testing?

Verify:

```text
Buttons

Labels

Images

Alignment

Colors
```

---

## Example

Login Button:

```text
Expected

[ Login ]
```

Actual:

```text
[ Log
```

Text cut off.

UI defect.

---

## Tester Checks

* Font size
* Alignment
* Visibility
* Landscape mode
* Portrait mode

---

# 6. Usability Testing

## What is Usability Testing?

Verify application is easy to use.

---

## Example

User wants to place order.

If process is:

```text
15 Screens
```

It is difficult.

If process is:

```text
3 Screens
```

It is easier.

---

## Tester Checks

* Easy navigation
* Clear messages
* User friendliness

---

# Example

Bad Message:

```text
ERR-504
```

Good Message:

```text
Unable to connect.
Please try again.
```

---

# 7. Compatibility Testing

## What is Compatibility Testing?

Verify application works on different:

* Devices
* Screen Sizes
* Android Versions

---

## Example

```text
Samsung S24 → Works

OnePlus 12 → Works

Vivo V29 → UI Broken
```

Compatibility defect.

---

## Tester Checks

* Android 12
* Android 13
* Android 14
* Android 15

---

# 8. Performance Testing

## What is Performance Testing?

Verify speed and stability.

---

## Example

Login takes:

```text
2 Seconds
```

Good.

---

```text
30 Seconds
```

Bad.

---

## Tester Checks

* App launch time
* Screen load time
* Search speed
* Payment speed

---

# Example

User clicks:

```text
Search
```

Result appears after:

```text
45 seconds
```

Performance issue.

---

# 9. Security Testing

## What is Security Testing?

Verify user data remains protected.

---

## Example

Banking App

Verify:

* Password hidden
* Session timeout
* Secure payment

---

## Example Defect

Password field displays:

```text
mypassword123
```

instead of:

```text
************
```

Security issue.

---

# 🛠️ Practice Exercise

Choose:

* WhatsApp
* Google Pay
* Amazon

Create:

## 20 Test Scenarios

Example:

1. Verify Login
2. Verify Logout
3. Verify Search
4. Verify Notifications
5. Verify App Launch
6. Verify Camera Access
7. Verify Internet Off
8. Verify App Update
9. Verify Reinstallation
10. Verify Permissions

---

## 20 Test Cases

Example:

### TC-01

```text
Title:
Verify login with valid credentials

Steps:
1. Open App
2. Enter Valid Username
3. Enter Valid Password
4. Click Login

Expected:
User logs in successfully
```

---

# 🎤 Scenario-Based Interview Questions

---

# Scenario 1

## Question

Application works on Samsung but crashes on Vivo.

What will you do?

### Answer

1. Reproduce issue.
2. Check Android version.
3. Check device specifications.
4. Review Logcat.
5. Raise compatibility defect.

---

# Scenario 2

## Question

User denies Location permission.

Application crashes.

What is the defect?

### Answer

Permission Handling Defect.

Expected:

```text
Location Permission Required
```

Actual:

```text
Application Crash
```

---

# Scenario 3

## Question

Login takes 40 seconds.

Which testing type identified this issue?

### Answer

Performance Testing.

---

# Scenario 4

## Question

Login button overlaps password field.

Which testing type identified this issue?

### Answer

UI Testing.

---

# Scenario 5

## Question

User enters correct password but login fails.

Which testing type identified this issue?

### Answer

Functional Testing.

---

# Scenario 6

## Question

Password is visible while typing.

Which testing type identified this issue?

### Answer

Security Testing.

---

# Scenario 7

## Question

Application looks perfect but users struggle to complete checkout.

Which testing type should be performed?

### Answer

Usability Testing.

---

# Scenario 8

## Question

App works on Android 15 but fails on Android 12.

Which testing type identified this issue?

### Answer

Compatibility Testing.

---

# 🎯 Week 2 Outcome

By the end of Week 2, you should understand:

✅ Native Applications

✅ Mobile Web Applications

✅ Hybrid Applications

✅ Functional Testing

✅ UI Testing

✅ Usability Testing

✅ Compatibility Testing

✅ Performance Testing

✅ Security Testing

✅ Real-world testing examples

✅ Mobile interview questions

✅ How to identify defects based on testing type

---


