package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void loginSucceedTest() {
       loginPage = new LoginPage(BaseTest.getThreadDriver());
       homePage = new HomePage(BaseTest.getThreadDriver());
       loginPage.successfulPortalTest();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}


