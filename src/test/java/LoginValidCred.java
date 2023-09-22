import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginValidCred extends BaseTest {
    @Test
    public void loginValid() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("natalia.kim01@testpro.io");
        loginPage.providePassword("WyYVUKJl2j5v");
        loginPage.clickSubmit();
    }


}