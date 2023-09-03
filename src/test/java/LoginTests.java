import Pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    LoginPage loginPage;

    @Test
    public void LoginValidEmailPasswordTest() {
        loginPage = new LoginPage(driver);

        basepage.openLoginUrl(url);
        loginPage.loginWithCorrectCred();
        loginPage.checkAvatarDisplay();
    }
    @Test
    public void LoginInvalidEmailPasswordTest() {
        loginPage = new LoginPage(driver);

        basepage.openLoginUrl(url);
        loginPage.loginWithIncorrectCred();
        loginPage.checkUrlIsTheSame();
    }
}