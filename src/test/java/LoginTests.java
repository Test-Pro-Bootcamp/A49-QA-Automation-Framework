import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
public class LoginTests extends BaseTest {
    static LoginPage loginPage;
    @BeforeMethod
    void setup() {
        loginPage = new LoginPage(getThreadLocal());
        getThreadLocal().get(url);
    }
    @Test
    public static void validLogin() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.loginCorrectCred();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public static void invalidPasswordEmail() {
        loginPage.provideEmail("incorrectEmail")
                .providePassword("incotrerctPwd")
                .clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public static void emptyEmail() {
        loginPage.provideEmail("")
                .providePassword("incotrerctPwd")
                .clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public static void emptyEmailPassword() {
        loginPage.provideEmail("")
                .providePassword("")
                .clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}