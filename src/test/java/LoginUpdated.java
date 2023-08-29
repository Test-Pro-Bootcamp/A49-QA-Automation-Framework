import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginUpdated extends BaseTest {
    @Test
    public void loginValidEmailAndValidPassword() {

        navigateToPage();
        provideEmail("demo@testpro.io");
        providePassword("te$t$tudent");
        clickSubmitButton();

        WebElement avatarIcon = driver.findElement(By.cssSelector("[class='avatar']"));
        //Expected result: User should be directed to home page
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test
    public void loginInvalidEmailAndValidPassword(){
        navigateToPage();
        provideEmail("invalidemail@testprro.io");
        providePassword("OPJKDUhA");
        clickSubmitButton();
        //Expected result: User should remain on the same page
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test //(enabled = false, description ="Test is ok but do not use it")
    public void InvalidEmailLong() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Step 1. Open koel login page
        String url = "https://qa.koel.app/";
        driver.get(url);

        //Step 2. Enter NOT existing username
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.clear();
        emailField.sendKeys("invalidEmail@testpro.io");

        //Step 3. Enter correct password
        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.clear();
        passwordField.sendKeys("OPJKDUhA");
        //passwordField.sendKeys("te$t$tudent");

        //Step 4. Click Log In button
        WebElement submitButton = driver.findElement(By.cssSelector("[type = 'submit']"));
        submitButton.click();

        //WebElement avatarIcon = driver.findElement(By.cssSelector("[class='avatar']"));
        //Expected result: User should stay on Login page
        //Assert.assertTrue(avatarIcon.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();

    }

    @Test (enabled = false, description ="Test is ok but do not use it")
    public void EmptyEmail() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Step 1. Open koel login page
        String url = "https://qa.koel.app/";
        driver.get(url);

        //Step 2. Empty username
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.clear();
        emailField.sendKeys("");

        //Step 3. Enter correct password
        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.clear();
        passwordField.sendKeys("OPJKDUhA");
        //passwordField.sendKeys("te$t$tudent");

        //Step 4. Click Log In button
        WebElement submitButton = driver.findElement(By.cssSelector("[type = 'submit']"));
        submitButton.click();

        //WebElement avatarIcon = driver.findElement(By.cssSelector("[class='avatar']"));
        //Expected result: User should stay on Login page
        //Assert.assertTrue(avatarIcon.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();

    }
}
