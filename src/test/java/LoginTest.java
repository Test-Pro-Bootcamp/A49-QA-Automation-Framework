

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;


public class LoginTest extends BaseTest {
    LoginPage loginPage;
    RegistrationPage registrationPage;
    @BeforeMethod
    void setupClass() {
        loginPage = new LoginPage(theDriver);
        registrationPage = new RegistrationPage(theDriver);

        theDriver.get(baseUrl);
    }



    @Test
    public void validLogin() {
        loginPage.login();

    }
    @Test
    public void invalidPassword() {
        loginPage.enterEmail("incorrectEmail").enterPassword("incotrerctPwd").clickLogin();

    }
    @Test
    public void emptyPassword(){
        loginPage.enterEmail("demo@class.com").enterPassword("").clickLogin();
    }
    @Test
    public void emptyEmailPassword(){
        loginPage.enterEmail("").enterPassword("").clickLogin();
    }




}
