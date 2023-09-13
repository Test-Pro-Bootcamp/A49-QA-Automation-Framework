package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import tests.BaseTest;

public class Homework24 extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void login() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.loginWithCorrectCred();
        homePage.avatarImgIsDisplayed();
    }

}
