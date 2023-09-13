package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class InvalidLoginTests extends BaseTest{

    @Test
    public void invalidEmailInvalidPassword(){
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmail("incorrectEmail@testio.com")
                .providePassword("invalidPassword")
                .clickSubmitButton();
    }
    @Test
    public void emptyEmailInvalidPassword(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.provideEmail("")
                .providePassword("invalidPassword")
                .clickSubmitButton();
    }

    @Test
    public void emptyEmailEmptyPassword(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.provideEmail("")
                .providePassword("")
                .clickSubmitButton();
    }
}
