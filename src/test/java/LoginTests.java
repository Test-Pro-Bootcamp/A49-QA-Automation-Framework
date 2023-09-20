

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    void setup() {
        loginPage = new LoginPage(getThreadDriver());
        getThreadDriver().get(url);
    }
        @Test
        public void validLogin () {
            loginPage.loginCorrectCred();
        }
        @Test
        public void validLoginOnceLoggedIn () {
            loginPage.loginCorrectCred();
        }
    }
