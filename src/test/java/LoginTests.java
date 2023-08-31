import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void LoginValidEmailPasswordTest() {
        basepage.openLoginUrl(url);
        loginPage.loginWithCorrectCred();
        loginPage.checkAvatarDisplay();
    }
    @Test
    public void LoginInvalidEmailPasswordTest() {
        basepage.openLoginUrl(url);
        loginPage.loginWithIncorrectCred();
        loginPage.checkUrlIsTheSame();
    }
}