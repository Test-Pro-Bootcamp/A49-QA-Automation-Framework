
package Tests;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class InvalidLoginTest extends BaseTest{

    private WebDriver getThreadLocal() {
        return null;
    }


    @Test
    public void invalidPasswordEmail(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.provideEmail("incorrectEmail").providePassword("incorrectPwd").clickSubmit();
    }



    @Test
    public void emptyEmail(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.provideEmail("").providePassword("incorrectPwd").clickSubmit();
    }
    @Test
    public void emptyEmailPassword(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.provideEmail("").providePassword("").clickSubmit();
    }
}
