import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    @Test

    public static void loginEmptyEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.setEmail("")
                .setPassword("te$t$tudent")
                .clickLogin();
        loginPage.getRegistrationLink();
    }

    @Test
    public static void loginWrongPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.setEmail("momo.carlos5@gmail.com")
                .setPassword("nnnnnn")
                .clickLogin();
        loginPage.getRegistrationLink();
    }

    @Test
    public static void loginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.setEmail("momo.carlos5@gmail.com")
                .setPassword("")
                .clickLogin();
        loginPage.getRegistrationLink();
    }

    @Test
    public static void loginWrongEmailTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.setEmail("demo@gmail.com")
                .setPassword("te$t$tudent")
                .clickLogin();
        loginPage.getRegistrationLink();
    }

    @Test
    public void loginSucceedTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        loginPage.loginValidEmailPass();

    }
}
