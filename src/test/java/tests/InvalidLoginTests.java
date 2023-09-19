package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

//method used for Grid execution without parallel execution (threads)
public class InvalidLoginTests extends BaseTest {

    @Test
    //@Parameters("baseURL")
    public void invalidEmailInvalidPassword() throws InterruptedException {
        //LoginPage loginPage = new LoginPage(getThreadLocal());
        LoginPage loginPage = new LoginPage(driver);
        //driver.get(baseURL);
        loginPage.provideEmail("incorrectEmail@testio.com")
                .providePassword("invalidPassword")
                .clickSubmitButton();
    }
    @Test
    public void emptyEmailInvalidPassword(){
        //LoginPage loginPage = new LoginPage(getThreadLocal());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail("")
                .providePassword("invalidPassword")
                .clickSubmitButton();
    }

    @Test
    public void emptyEmailEmptyPassword(){
        //LoginPage loginPage = new LoginPage(getThreadLocal());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail("")
                .providePassword("")
                .clickSubmitButton();
    }
}
