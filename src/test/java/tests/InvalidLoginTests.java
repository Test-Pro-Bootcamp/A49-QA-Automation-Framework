package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class InvalidLoginTests extends BaseTest{
    LoginPage loginPage;
    @BeforeMethod
    public void setup(){
        loginPage = new LoginPage(driver);
        //loginPage = new LoginPage(getThreadDriver());
        driver.get(url);
        //getThreadDriver().get(url);
    }
    @Test
    public void invalidEmailInvalidPassword(){
        //LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail("incorrectEmail@testio.com")
                .providePassword("invalidPassword")
                .clickSubmitButton();
    }
    @Test
    public void emptyEmailInvalidPassword(){
        loginPage.provideEmail("")
                .providePassword("invalidPassword")
                .clickSubmitButton();
    }

    @Test
    public void emptyEmailEmptyPassword(){
        loginPage.provideEmail("")
                .providePassword("")
                .clickSubmitButton();
    }
}
