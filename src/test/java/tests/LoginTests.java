package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest{
    LoginPage loginPage;
    WebDriverWait wait;
    @BeforeMethod
    void setup(){
        loginPage = new LoginPage(driver);
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @Test
    public void validEmailValidPassword()  {
        loginPage.loginToKoel();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".view-profile")));
    }
    @Test
    public void validLoginOnceLoggedIn() {
        loginPage.loginToKoel();
    }

}
