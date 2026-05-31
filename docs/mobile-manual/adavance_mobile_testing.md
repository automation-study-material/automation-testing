# 📱 Week 5, 6, 7 & 8: Advanced Mobile Testing

> 🎯 Goal: Learn how mobile applications behave in real-world situations such as network issues, incoming calls, notifications, app backgrounding, and application upgrades.

---

# 📖 Week 5: Network Testing

# What is Network Testing?

Network Testing verifies how an application behaves when internet conditions change.

Real users experience:

* No Internet
* Slow Internet
* Wi-Fi Disconnect
* Mobile Data Disconnect
* Network Switching

A good mobile application should handle all these situations gracefully.

---

# 🌐 No Internet Testing

## What is No Internet Testing?

Verify application behavior when internet is unavailable.

---

## Example

Scenario:

```text id="epqkwh"
Open Amazon App

Disable Internet

Click Search
```

---

## Expected

```text id="xsv2b5"
No Internet Connection

Please try again.
```

---

## Actual Defect Example

```text id="g5wuh0"
Application crashes
```

Bug.

---

# Things To Test

Verify:

* Login
* Registration
* Search
* Payments
* Profile Update

without internet.

---

# Interview Question

### User disables internet and clicks Login.

What should happen?

Answer:

```text id="6g1fku"
Proper error message should appear.

Application should not crash.
```

---

# 🐢 Slow Internet Testing

## What is Slow Internet Testing?

Verify application behavior when network is very slow.

---

## Example

Imagine:

```text id="h5d1y4"
2G Network
```

instead of:

```text id="jz3c0i"
5G Network
```

---

## Scenario

```text id="m8t3yw"
Open App

Click Search

Slow Network
```

---

## Expected

```text id="kpj2ll"
Loading Indicator

Please Wait
```

---

## Actual Defect

```text id="6rmhrv"
Application freezes
```

Bug.

---

# Good Application Behavior

```text id="f6oowx"
Loading...

Please Wait
```

instead of:

```text id="wr7wvb"
Blank Screen
```

---

# 🔄 Network Switching Testing

## What is Network Switching?

User switches from one network to another.

---

## Real Example

```text id="kwjlwm"
Start Payment

Wi-Fi ON
```

Then:

```text id="e7ft9g"
Wi-Fi OFF

Mobile Data ON
```

---

## Expected

```text id="tqjmy4"
Transaction continues smoothly
```

---

## Verify

* No duplicate payment
* Session maintained
* Data not lost

---

## Common Defect

```text id="4y6q61"
Payment deducted twice
```

Critical defect.

---

# 📞 Week 6: Interrupt Testing

# What is Interrupt Testing?

Mobile users constantly receive interruptions.

Examples:

* Calls
* SMS
* Notifications
* Alarms

Application should handle interruptions correctly.

---

# 📞 Incoming Call Testing

## Scenario

```text id="r3dsc0"
Open Banking App

Start Money Transfer

Receive Call
```

---

## Expected

After call ends:

```text id="jj6wnh"
Application resumes correctly
```

---

## Verify

* Data preserved
* No crash
* Session remains active

---

## Defect Example

```text id="ymmnfu"
Call received

Application restarted
```

Bug.

---

# 💬 SMS Testing

## Scenario

```text id="57cfy7"
Registration Screen

Receive SMS
```

---

## Expected

```text id="7rslik"
Application remains stable
```

---

## Verify

* Form data preserved
* No refresh
* No logout

---

# ⏰ Alarm Testing

## Scenario

```text id="vqlfzh"
Application Running

Alarm Rings
```

---

## Expected

```text id="w51q91"
Alarm closes

Application remains functional
```

---

# 🔔 Notification Testing

## Scenario

```text id="n5o2uq"
Receive Push Notification
```

Example:

```text id="ggzwbl"
Order Delivered
```

---

## Verify

* Notification received
* Correct text shown
* Correct screen opens

---

## Defect Example

Notification says:

```text id="1nk7jx"
Order Delivered
```

but opens:

```text id="g6cjq5"
Home Screen
```

Bug.

---

# 📖 Week 7: App Lifecycle Testing

# What is App Lifecycle?

Applications constantly move between states.

```text id="95hf8w"
Foreground

Background

Closed

Reopened
```

Tester verifies behavior during these transitions.

---

# 🏠 Background Testing

## Scenario

```text id="crwwgq"
Open Application

Press Home Button

Wait 5 Minutes

Open Again
```

---

## Expected

```text id="2utjrw"
Application resumes correctly
```

---

## Verify

* User session
* Entered data
* Current screen

---

## Example

Before:

```text id="q5iw7e"
Cart = 5 Items
```

After reopening:

```text id="9js0ye"
Cart still = 5 Items
```

---

## Defect Example

```text id="pcpvt3"
Cart becomes empty
```

Bug.

---

# ❌ Force Close Testing

## Scenario

```text id="04d2xn"
Open Application

Force Stop App

Open Again
```

---

## Verify

* Data Integrity
* Session Handling
* No corruption

---

## Example

Before:

```text id="c4mq17"
Draft Message Saved
```

After reopening:

```text id="g2j3hc"
Draft still available
```

---

## Common Defect

```text id="81lydo"
User data lost
```

Bug.

---

# 📖 Week 8: App Update Testing

# What is App Update Testing?

Verify application works correctly after upgrade.

---

## Scenario

```text id="u2o26v"
Install Version 1.0

Login

Update To Version 1.1
```

---

## Verify

### Session

Expected:

```text id="5f08j5"
User remains logged in
```

---

### Data

Expected:

```text id="szpjjj"
User data available
```

---

### Settings

Expected:

```text id="ym9pm4"
Settings preserved
```

---

### Cart Data

Expected:

```text id="e2j0we"
Cart items remain available
```

---

# Example

Before Update:

```text id="g44frd"
Cart = 3 Products
```

After Update:

```text id="dprvcq"
Cart = 3 Products
```

---

## Defect Example

```text id="5q7a7j"
Update completed

User automatically logged out

Cart cleared
```

Bug.

---

# 🎤 Scenario-Based Interview Questions

---

# Scenario 1

## Question

User turns off internet and clicks Login.

What should happen?

### Answer

```text id="5r4v3v"
Proper error message

Application should not crash
```

---

# Scenario 2

## Question

Application freezes on slow internet.

Which testing type identified this issue?

### Answer

```text id="smycgg"
Network Testing
```

---

# Scenario 3

## Question

Payment started on Wi-Fi.

User switched to Mobile Data.

Money deducted twice.

What is the defect?

### Answer

```text id="hyg8hn"
Network Switching Defect

Critical Severity
```

---

# Scenario 4

## Question

Application crashes after incoming call.

Which testing type identified this issue?

### Answer

```text id="wglgzc"
Interrupt Testing
```

---

# Scenario 5

## Question

User receives SMS while filling registration form.

All entered data disappears.

What is the defect?

### Answer

```text id="ybbg7s"
Interrupt Handling Defect
```

---

# Scenario 6

## Question

User presses Home button.

After reopening application, cart becomes empty.

What type of issue is this?

### Answer

```text id="ytfbt8"
App Lifecycle Defect
```

---

# Scenario 7

## Question

Application update logs out every user.

What testing identified this issue?

### Answer

```text id="6slklr"
App Update Testing
```

---

# Scenario 8

## Question

Notification says "Order Delivered" but opens Home Page.

What is the defect?

### Answer

```text id="i2k4v8"
Notification Navigation Defect
```

---

# Scenario 9

## Question

Alarm rings while payment is in progress.

After closing alarm application crashes.

What type of testing identified this issue?

### Answer

```text id="6r2hrm"
Interrupt Testing
```

---

# 🎯 Week 5–8 Outcome

After completing these topics, you should understand:

✅ Network Testing

✅ No Internet Testing

✅ Slow Internet Testing

✅ Network Switching Testing

✅ Incoming Call Testing

✅ SMS Testing

✅ Alarm Testing

✅ Notification Testing

✅ Background Testing

✅ Force Close Testing

✅ App Lifecycle

✅ App Update Testing

✅ Real Mobile Defects

✅ Interview Questions & Answers

---

# 🚀 Next Learning Phase

Mobile Debugging & Tools:

* Android Studio
* ADB Commands
* Logcat
* APK Installation
* Device Logs
* Crash Investigation
* Defect Reporting
* Mobile Testing Interview Preparation
