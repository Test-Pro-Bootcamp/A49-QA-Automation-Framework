package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
public class Homework25 extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    void setup(){
        loginPage= new LoginPage(getDriver());
        homePage = new HomePage(getDriver());
        getDriver().get(url);
    }
    @Test
    public void login() {
        loginPage.loginWithCorrectCred();
        homePage.avatarImgIsDisplayed();
    }
    @Test
    public void emptyPassword(){
        loginPage.provideEmail("svitlana.shkribliak@testpro.io").providePassword("").clickSubmit();
        homePage.logoIsDisplayed();
    }

}