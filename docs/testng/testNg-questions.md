
# TestNG + Selenium (4+ Years Experience) – Interview Study Guide

---

## Core TestNG Concepts

1. Explain TestNG architecture. Why is it better than JUnit?
2. What is the lifecycle of TestNG annotations?
3. Difference between @BeforeSuite, @BeforeTest, @BeforeClass, @BeforeMethod
4. When to use @BeforeTest instead of @BeforeMethod?
5. What happens if @BeforeMethod fails?
6. What is alwaysRun = true?
7. priority vs dependsOnMethods vs dependsOnGroups
8. How dependencies are resolved internally?
9. invocationCount and threadPoolSize
10. How to run same test multiple times with different data?

---

## testng.xml

11. Explain structure of testng.xml
12. suite vs test vs class vs method
13. How to pass parameters from XML?
14. @Parameters vs @DataProvider
15. How to run only failed tests?
16. Group include/exclude
17. Dynamic exclusion of tests
18. Enable parallel execution
19. parallel = tests vs classes vs methods vs instances
20. threadCount working internally

---

## Data Driven Testing

21. DataProvider vs Excel vs JSON vs DB
22. DataProvider in parallel mode
23. Null return from DataProvider
24. Can DataProvider depend on another test?
25. Passing objects in DataProvider
26. Sharing test data across classes
27. Retry only failed data rows

---

## Listeners & Hooks

28. What are Listeners?
29. ITestListener, ISuiteListener, IInvokedMethodListener, IRetryAnalyzer
30. When to use each?
31. Screenshot on failure
32. Custom reporting
33. @AfterMethod vs Listener difference
34. Log test start/end
35. Global retry logic
36. Multiple listeners together

---

## Parallel Execution

37. How TestNG achieves parallelism
38. Thread-safety in Selenium
39. WebDriver failures in parallel
40. ThreadLocal<WebDriver>
41. Driver factory design
42. synchronized vs ThreadLocal
43. Parallel browsers/tests/methods
44. Avoiding data collision
45. Sharing resources safely
46. Static driver issues

---

## Framework Design

47. Design framework from scratch
48. Design patterns: POM, Factory, Singleton, Builder
49. Separate test vs page logic
50. Environment configs
51. Reusable utilities
52. Placement of setup, listeners, configs
53. Base test class
54. Reduce duplication
55. Logging integration
56. Reporting integration

---

## Selenium Integration

57. Driver init in @BeforeMethod
58. Why not constructor?
59. Safe driver quit
60. Pass browser type from XML
61. Cross-browser tests
62. Headless mode
63. Screenshot capture automatically
64. Sharing driver across pages
65. Handle stale elements

---

## CI/CD & Execution

66. Run TestNG via Maven
67. Surefire vs Failsafe
68. Jenkins integration
69. Pass params from Jenkins
70. Run in Docker
71. Selenium Grid setup
72. Publish reports in pipeline
73. Run only changed tests
74. Nightly regression

---

## Debugging & Real-world Problems

75. Works locally but fails in CI
76. Pass individually but fail in suite
77. Random parallel failures
78. Memory leaks
79. Flaky tests fixes
80. Stabilize waits
81. Hard vs Explicit vs Fluent waits
82. Element not interactable
83. TimeoutException causes
84. Capture network logs
85. Dynamic locators

---

## Advanced / Tricky

86. Run without testng.xml?
87. Dynamic tests at runtime
88. Skip programmatically
89. Stop suite on critical failure
90. Share state between tests
91. SoftAssert vs HardAssert
92. Conditional execution
93. Modify results in listener
94. Custom annotations
95. Tagging like Cucumber
96. Hybrid framework (API + UI + DB)
97. Dependent tests in parallel
98. Version test data
99. Scale to 1000+ tests
100. Reduce execution time drastically

---

## Bonus Tips

- Master ThreadLocal driver
- Implement retry & listener logic
- Understand test lifecycle deeply
- Be ready to design framework on whiteboard
- Practice CI/CD integration

---

Happy Learning!
