import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {
    @Test
    public void registrationNavigation() {
    ///Given I have set and opened the browser
    //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    ///When I opened my URL
        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement registrationLink = driver.findElement(By.cssSelector("[href='registration']"));
        registrationLink.click();

        String registrationURL = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(), registrationURL);

        driver.quit();


    }

    @Test
    public void loginInvalidEmailPassword() throws InterruptedException {
///Given I have set and opened the browser
//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    ///When I opened my URL
        String url = "https://qa.koel.app/";
        driver.get(url);
    ///And I Enter valid Login
        WebElement loginInput = driver.findElement(By.cssSelector("[type='email']"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("notExisting@gmail.com");
    ///And I enter valid password
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("yozca5uQiLxb!");
    ///And I click Login
        WebElement loginBtn = driver.findElement(By.cssSelector("[type='submit']"));
        loginBtn.click();
        Thread.sleep(2000);
    //The URL has not changed
        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertEquals(driver.getCurrentUrl(),url);
        driver.quit();

    }
}








