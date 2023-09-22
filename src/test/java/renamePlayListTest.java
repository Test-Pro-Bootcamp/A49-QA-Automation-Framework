import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class renamePlayListTest extends BaseTest {

    @Test
    public void renamePlayList() {
        String newPlayList = "Homework22";
        String updatePLMsg = "Updated playlist";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        // loginPage.loginCorrectCred();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlayListName(newPlayList);
        /// Assert.assertEquals(homePage.playListMessage(), updatePLMsg);

    }

}