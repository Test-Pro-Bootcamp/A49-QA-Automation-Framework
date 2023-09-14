package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework26 extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void login() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.loginWithCorrectCred();
        homePage.avatarImgIsDisplayed();
    }

    @Test
    public void emptyPassword() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.provideEmail("svitlana.shkribliak@testpro.io").providePassword("").clickSubmit();
        homePage.logoIsDisplayed();
    }
}
