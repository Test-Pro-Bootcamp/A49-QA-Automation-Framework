

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;


public class LoginTest extends BaseTest {
    LoginPage loginPage;
    @BeforeMethod
    void setupClass() {
        loginPage = new LoginPage(theDriver);
        theDriver.get(baseUrl);
    }
    @Test
    public void validLogin() {
        loginPage.login();
    }
//    @Test
//    public void validLoginOnceLoggedIn() {
//
//        loginPage.login();
//    }

}
