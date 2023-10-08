import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomeTest extends BaseTest{
    @Test
    public void addSongToPlaylist() {
        LoginPage login = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        login.loginValidEmailPass();
        homePage.SearchSongs("Robert John");
        homePage.clickViewAll();
        homePage.addSongToMyPlaylist();
        homePage.clickLogout();


    }
}
