

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class InvalidLoginTests extends BaseTest{
    LoginPage loginPage;
    @BeforeMethod
    void setup(){
        loginPage= new LoginPage(getThreadDriver());
        getThreadDriver().get(url);
    }
    @Test
    public void invalidPasswordEmail(){
        loginPage.provideEmail("incorrectEmail").providePassword("incotrerctPwd").clickSubmit();
    }
    @Test
    public void emptyEmail(){
        loginPage.provideEmail("").providePassword("incotrerctPwd").clickSubmit();
    }
    @Test
    public void emptyEmailPassword(){
        loginPage.provideEmail("").providePassword("").clickSubmit();
    }
}