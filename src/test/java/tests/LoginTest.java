package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest_threads{
    LoginPage loginPage= new LoginPage(getThreadLocal());
    HomePage homePage= new HomePage(getThreadLocal());

    @Test
    public void validEmailValidPassword(){
        loginPage.successfulPortalTest();
        Assert.assertTrue(homePage.isWizardDisplayed());
    }
}
