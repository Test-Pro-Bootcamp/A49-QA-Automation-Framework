import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 {
    @Test
    public void RegistrationNavigation () {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//When I open my URL
        String url = "https://qa.koel.app/";
        driver.get(url);
//        AND I click on Registration Link
        WebElement registration = driver.findElement(By.cssSelector("[href='registration']"));
        registration.click();

//        Then I am redirected to Registration Page
        String page = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(), page);
        driver.quit();
    }
}
