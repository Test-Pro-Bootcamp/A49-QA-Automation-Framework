import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.navigateToPage()
                 .provideEmail()
                 .providePassword()
                 .clickSubmit();




    }

}
