import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {
        LoginPage.navigateToPage();

        LoginPage.provideEmail();

        LoginPage.providePassword();

        LoginPage.clickSubmit();




    }

}
