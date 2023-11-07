

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {



        @Test
        public void validLogin () {
            LoginPage loginPage = new LoginPage(getThreadLocal());
            loginPage.loginCorrectCred();
        }
        @Test
        public void validLoginOnceLoggedIn () {
            LoginPage loginPage = new LoginPage(getThreadLocal());
            loginPage.loginCorrectCred();
        }
    }
