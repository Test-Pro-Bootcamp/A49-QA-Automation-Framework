package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class FailedLoginTests extends BaseTest {
    LoginPage loginPage;

    @Test
    public void loginEmptyEmailPasswordTest() {
       loginPage = new LoginPage(BaseTest.getThreadDriver());

        loginPage.castEmail("")
                .castPassword("Te$ter1234")
                .castSubmit();

        Assert.assertTrue(loginPage.getWizReg().isDisplayed());
    }

    @Test
    public void loginWrongPasswordTest() {
        loginPage = new LoginPage(BaseTest.getThreadDriver());

        loginPage.castEmail("demo@class.com")
                .castPassword("te$t123")
                .castSubmit();

        Assert.assertTrue(loginPage.getWizReg().isDisplayed());
    }

    @Test
    public void loginEmptyPasswordTest() {
       loginPage = new LoginPage(BaseTest.getThreadDriver());

        loginPage.castEmail("demo@class.com")
                .castPassword("")
                .castSubmit();

        Assert.assertTrue(loginPage.getWizReg().isDisplayed());
    }

    @Test
    public void loginWrongEmailTest() {
        loginPage = new LoginPage(BaseTest.getThreadDriver());

        loginPage.castEmail("demo@class.com")
                .castPassword("te$t$tudent")
                .castSubmit();

        Assert.assertTrue(loginPage.getWizReg().isDisplayed());
    }

}


