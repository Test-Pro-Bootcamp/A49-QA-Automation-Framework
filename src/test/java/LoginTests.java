import Pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    LoginPage loginPage;
    @Test
    public void LoginValidEmailPasswordTest() {
        loginPage = new LoginPage(getThreadLocal());

        loginPage.loginWithCorrectCred()
                 .checkAvatarDisplay();
    }
    @Test
    public void LoginInvalidEmailPasswordTest() {
        loginPage = new LoginPage(getThreadLocal());

        loginPage.loginWithIncorrectCred()
                 .checkUrlIsTheSame();
    }
}