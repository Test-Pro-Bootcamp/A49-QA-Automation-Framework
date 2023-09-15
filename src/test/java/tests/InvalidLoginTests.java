package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class InvalidLoginTests extends BaseTest{

    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        loginPage = new LoginPage(driver);

    }
    @Test
    public void invalidPassword() {
        loginPage.provideEmail("svitlana.shkribliak@testpro.io")
                .providePassword("incorrectPass")
                .clickSubmit();

    }
    @Test
    public void notExistingEmail() {
        loginPage.provideEmail("svitlana@class.com")
                .providePassword("te$t$tudent49")
                .clickSubmit();
    }

    @Test
    public void emptyEmail(){
        loginPage.provideEmail(" ")
                .providePassword("te$t$tudent49")
                .clickSubmit();
    }

    @Test
    public void emptyPassword(){
        loginPage.provideEmail("svitlana.shkribliak@testpro.io")
                .providePassword(" ")
                .clickSubmit();
    }

    @Test
    public void emptyEmailAndPassword(){
        loginPage.provideEmail(" ").providePassword(" ").clickSubmit();
    }
}
