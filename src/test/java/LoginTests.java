import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest{
    @BeforeMethod
    //The Following are my Test Cases
    @Test
    public void loginEmptyEmailPassword() {
//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        provideEmail("dagebeyehu@gmail.com");


        String url = "https://qa.koel.app/";
       // Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void LoginValidEmailValidPassword() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void loginValidEmailPassword() {
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
        loginInput.sendKeys("dagebeyehu@gmail.com");
///And I enter valid password
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("yozca5uQiLxb!");
///And I click Login
        WebElement loginBtn = driver.findElement(By.cssSelector("[type='submit']"));
        loginBtn.click();
//Then Avatar is Displayed
        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());
        driver.quit();
    }
}
