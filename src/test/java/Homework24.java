import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.PlaylistPage;

public class Homework24 extends BaseTest {
    String playlistName;
    LoginPage loginPage;
    BasePage basePage;
    PlaylistPage playlistPage;

    @Test
    public void login() {
        loginPage = new LoginPage(driver);
        loginPage.loginWithCorrectCred();
    }

}
