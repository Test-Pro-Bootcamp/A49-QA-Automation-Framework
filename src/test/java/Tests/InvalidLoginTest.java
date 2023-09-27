package Tests;

 import Pages.LoginPage;
import org.testng.annotations.Test;


public class InvalidLoginTest extends BaseTest{




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
