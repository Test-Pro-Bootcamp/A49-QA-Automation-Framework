import Pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    void setUp(){
        loginPage = new LoginPage(driver);
        driver.get(url);
    }

    @Test
    public void LoginValidEmailPasswordTest() {
//        loginPage = new LoginPage(driver);

        loginPage.loginWithCorrectCred()
                 .checkAvatarDisplay();
    }
    @Test
    public void LoginInvalidEmailPasswordTest() {
//        loginPage = new LoginPage(driver);

        loginPage.loginWithIncorrectCred()
                 .checkUrlIsTheSame();
    }
}