package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class FailedLoginTests extends BaseTest {

    @Test
<<<<<<< HEAD
    public void loginEmptyEmailPasswordTest() {
       loginPage = new LoginPage(getThreadDriver());
=======
    public static void loginEmptyEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(BaseTest.getThreadDriver());
>>>>>>> parent of 4082b99 (Slowly updating)

        loginPage.castEmail("")
                .castPassword("Te$ter1234")
                .castSubmit();

        Assert.assertTrue(loginPage.getWizReg().isDisplayed());
    }

    @Test
<<<<<<< HEAD
    public void loginWrongPasswordTest() {
        loginPage = new LoginPage(getThreadDriver());
=======
    public static void loginWrongPasswordTest() {
        LoginPage loginPage = new LoginPage(BaseTest.getThreadDriver());
>>>>>>> parent of 4082b99 (Slowly updating)

        loginPage.castEmail("demo@class.com")
                .castPassword("te$t123")
                .castSubmit();

        Assert.assertTrue(loginPage.getWizReg().isDisplayed());
    }

    @Test
<<<<<<< HEAD
    public void loginEmptyPasswordTest() {
       loginPage = new LoginPage(getThreadDriver());
=======
    public static void loginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(BaseTest.getThreadDriver());
>>>>>>> parent of 4082b99 (Slowly updating)

        loginPage.castEmail("demo@class.com")
                .castPassword("")
                .castSubmit();

        Assert.assertTrue(loginPage.getWizReg().isDisplayed());
    }

    @Test
<<<<<<< HEAD
    public void loginWrongEmailTest() {
        loginPage = new LoginPage(getThreadDriver());
=======
    public static void loginWrongEmailTest() {
        LoginPage loginPage = new LoginPage(BaseTest.getThreadDriver());
>>>>>>> parent of 4082b99 (Slowly updating)

        loginPage.castEmail("demo@class.com")
                .castPassword("te$t$tudent")
                .castSubmit();

        Assert.assertTrue(loginPage.getWizReg().isDisplayed());
    }

}


