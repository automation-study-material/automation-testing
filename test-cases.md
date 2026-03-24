# 🧪 Test Case Sheet Template

---

## 🔹 Project Details

| Field | Value |
|------|------|
| Project Name | |
| Module Name | |
| Tested By | |
| Date | |
| Build Version | |

---

## 🔹 Test Case Sheet

| TC_ID | Test Scenario | Test Case Description | Pre-Condition | Test Steps | Test Data | Expected Result | Actual Result | Status (Pass/Fail) | Severity | Priority | Comments |
|------|--------------|----------------------|--------------|-----------|----------|----------------|--------------|-------------------|----------|----------|----------|
| TC_01 | Login | Verify login with valid credentials | User registered | 1. Open app <br> 2. Enter valid email & password <br> 3. Click login | email, password | User should login successfully | | | High | High | |
| TC_02 | Login | Verify login with invalid password | User registered | Enter valid email + wrong password | invalid password | Error message displayed | | | Medium | High | |
| TC_03 | Forgot Password | Verify reset with valid email | User exists | Click forgot password → Enter email | email | Reset link sent | | | High | Medium | |

---

## 🔹 Status Definition

| Status | Meaning |
|--------|--------|
| Pass | Test case executed successfully |
| Fail | Expected result not matching |
| Blocked | Cannot execute due to issue |
| Not Run | Not executed |

---

## 🔹 Severity Definition

| Severity | Meaning |
|----------|--------|
| High | Critical functionality broken |
| Medium | Major issue but workaround exists |
| Low | Minor issue |

---

## 🔹 Priority Definition

| Priority | Meaning |
|----------|--------|
| High | Fix immediately |
| Medium | Fix in next release |
| Low | Can be delayed |

---

## 🔹 Best Practices

- Use clear and simple language
- Keep test steps precise
- Always include expected result
- Maintain unique TC_ID
- Cover:
  - Positive cases
  - Negative cases
  - Edge cases

---

## 🚀 Bonus Tip

Always design test cases considering:
> Boundary + Negative + Real user behavior
