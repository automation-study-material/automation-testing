1. import org.openqa.selenium.By;
2. import org.openqa.selenium.Keys;
3. import org.openqa.selenium.WebDriver;
4. import org.openqa.selenium.WebElement;
5. import org.openqa.selenium.chrome.ChromeDriver;
6. import org.openqa.selenium.interactions.Actions;

7. public class KeyboardActionsDemo {

8.     public static void main(String[] args) throws InterruptedException {

9.         // Launch browser
10.        WebDriver driver = new ChromeDriver();
11.        driver.manage().window().maximize();

12.        // Open demo site
13.        driver.get("https://demoqa.com/text-box");

14.        // Create Actions object
15.        Actions actions = new Actions(driver);

16.        // Locate elements
17.        WebElement fullName = driver.findElement(By.id("userName"));
18.        WebElement email = driver.findElement(By.id("userEmail"));
19.        WebElement currentAddress = driver.findElement(By.id("currentAddress"));

20.        // -----------------------------
21.        // 1. sendKeys() - Type text
22.        // -----------------------------
23.        actions.sendKeys(fullName, "Nitin Patil").perform();

24.        // -----------------------------
25.        // 2. TAB - Move to next field
26.        // -----------------------------
27.        actions.sendKeys(Keys.TAB).perform();

28.        // -----------------------------
29.        // 3. Type Email
30.        // -----------------------------
31.        actions.sendKeys("nitin@test.com").perform();

32.        // -----------------------------
33.        // 4. ENTER key
34.        // -----------------------------
35.        actions.sendKeys(Keys.ENTER).perform();

36.        // -----------------------------
37.        // 5. SHIFT + typing (Uppercase)
38.        // -----------------------------
39.        actions.keyDown(Keys.SHIFT)
40.               .sendKeys("selenium")
41.               .keyUp(Keys.SHIFT)
42.               .perform();

43.        // -----------------------------
44.        // 6. CTRL + A (Select All)
45.        // -----------------------------
46.        actions.keyDown(Keys.CONTROL)
47.               .sendKeys("a")
48.               .keyUp(Keys.CONTROL)
49.               .perform();

50.        // -----------------------------
51.        // 7. CTRL + C (Copy)
52.        // -----------------------------
53.        actions.keyDown(Keys.CONTROL)
54.               .sendKeys("c")
55.               .keyUp(Keys.CONTROL)
56.               .perform();

57.        // -----------------------------
58.        // 8. TAB - Move to next field
59.        // -----------------------------
60.        actions.sendKeys(Keys.TAB).perform();

61.        // -----------------------------
62.        // 9. CTRL + V (Paste)
63.        // -----------------------------
64.        actions.keyDown(Keys.CONTROL)
65.               .sendKeys("v")
66.               .keyUp(Keys.CONTROL)
67.               .perform();

68.        // -----------------------------
69.        // 10. BACKSPACE
70.        // -----------------------------
71.        actions.sendKeys(Keys.BACK_SPACE).perform();

72.        // -----------------------------
73.        // 11. DELETE
74.        // -----------------------------
75.        actions.sendKeys(Keys.DELETE).perform();

76.        // -----------------------------
77.        // 12. ARROW KEYS
78.        // -----------------------------
79.        actions.sendKeys(Keys.ARROW_LEFT).perform();
80.        actions.sendKeys(Keys.ARROW_RIGHT).perform();
81.        actions.sendKeys(Keys.ARROW_UP).perform();
82.        actions.sendKeys(Keys.ARROW_DOWN).perform();

83.        // -----------------------------
84.        // 13. ESCAPE key
85.        // -----------------------------
86.        actions.sendKeys(Keys.ESCAPE).perform();

87.        // -----------------------------
88.        // 14. CTRL + X (Cut)
89.        // -----------------------------
90.        actions.keyDown(Keys.CONTROL)
91.               .sendKeys("x")
92.               .keyUp(Keys.CONTROL)
93.               .perform();

94.        // -----------------------------
95.        // 15. Function Key (F5 - Refresh)
96.        // -----------------------------
97.        actions.sendKeys(Keys.F5).perform();

98.        // Wait for observation
99.        Thread.sleep(5000);

100.       // Close browser
101.       driver.quit();
102.   }
103. }
