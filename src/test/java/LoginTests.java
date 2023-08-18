import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {
//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//When I open my URL
        String url = "https://qa.koel.app/";
        driver.get(url);
//        AND I enter a valid login
        WebElement loginInput = driver.findElement(By.cssSelector("[type='email']"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("anna.gertzen@testpro.io");
//        ANd I enter a valid password
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("te$t$tudent");
//        And I click login
        WebElement loginBtn = driver.findElement(By.cssSelector("[type='submit']"));
        loginBtn.click();
//        Then Avatar is Displayed
        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));


        Assert.assertTrue(avatar.isDisplayed());
        driver.quit();
    }

    @Test
    public void IncorrectLogin() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//When I open my URL
        String url = "https://qa.koel.app/";
        driver.get(url);
//        AND I enter a invalid login
        WebElement loginInput = driver.findElement(By.cssSelector("[type='email']"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("anna@testpro.io");
//        ANd I enter a valid password
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("te$t$tudent");
//        And I click login
        WebElement loginBtn = driver.findElement(By.cssSelector("[type='submit']"));
        loginBtn.click();
//        Then User stays on login page
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }


}
