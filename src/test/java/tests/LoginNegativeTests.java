package tests;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
public class LoginNegativeTests extends BaseTest {
    LoginPage loginPage;
    @Test
    public void LoginWithInvalidCred() {
        loginPage = new LoginPage(getThreadLocal());

        loginPage.loginWithIncorrectCred()
                .checkUrlIsTheSame();
    }
    @Test
    public void LoginWithEmptyEmailField() {
        loginPage = new LoginPage(getThreadLocal());

        loginPage.loginEmptyEmailField()
                .checkUrlIsTheSame();
    }
    @Test
    public void LoginWithEmptyPasswordField() {
        loginPage = new LoginPage(getThreadLocal());

        loginPage.loginEmptyPasswordField()
                .checkUrlIsTheSame();
    }
}
