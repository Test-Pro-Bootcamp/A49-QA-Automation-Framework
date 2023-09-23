import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class Homework25 extends BaseTest {

    @Test(description = "Homework 25 - Cloud Execution Rename Playlist")
    public void renamePlaylist() {
        String newPlaylistName = "New Name";
        String successMessage = "Updated playlist \"New Name.\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        BasePage basePage = new BasePage(driver);

        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.typeNewPlaylistName(newPlaylistName);
        Assert.assertEquals(homePage.verifySuccessMessage(), successMessage);
    }

}
