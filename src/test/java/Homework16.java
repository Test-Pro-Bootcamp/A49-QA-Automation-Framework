import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {
// Homework #16: Intro to Selenium WebDriver

    // 3. Create a test case, registrationNavigation() using @ Test annotation
    @Test
    public void registrationNavigation() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 4. Using Selenium, navigate to "https://qa.koel.app/"
        String url = "https://qa.koel.app/";
        driver.get(url);

        // 5. Click the Registration link
        WebElement registrationLink = driver.findElement(By.xpath("//a[contains(text(), 'Registration / Forgot password')]"));
        registrationLink.click();

        // 6. Verify that you are redirected to Registration page using Assert method
        String registrationUrl = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl );

        driver.quit();
    }

}
