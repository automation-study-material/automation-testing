
```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinkChecker {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

        // Get all anchor tags
        List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println("Total Links Found: " + links.size());

        for (WebElement link : links) {

            String url = link.getAttribute("href");

            if (url == null || url.isEmpty()) {
                System.out.println("URL is empty or null");
                continue;
            }

            try {
                URL linkUrl = new URL(url);
                HttpURLConnection connection =
                        (HttpURLConnection) linkUrl.openConnection();

                connection.setRequestMethod("HEAD");
                connection.connect();

                int responseCode = connection.getResponseCode();

                if (responseCode >= 400) {
                    System.out.println(url + " ---> Broken Link ("
                            + responseCode + ")");
                } else {
                    System.out.println(url + " ---> Valid Link ("
                            + responseCode + ")");
                }

            } catch (Exception e) {
                System.out.println(url + " ---> Error Occurred");
            }
        }

        driver.quit();
    }
}
```
