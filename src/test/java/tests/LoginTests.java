package tests;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
public class LoginTests extends BaseTest {
    LoginPage loginPage;
    @Test
    public void SuccessfulLogin() {
        loginPage = new LoginPage(getThreadLocal());

        loginPage.loginWithCorrectCred()
                 .checkAvatarDisplay();
    }
}