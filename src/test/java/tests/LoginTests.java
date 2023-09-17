package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(getDriver());
        getDriver().get(url);

    }

    @Test
    public void validPasswordAndEmail() {
        loginPage.loginWithCorrectCred();
    }
}
