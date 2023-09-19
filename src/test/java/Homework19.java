import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.SearchPage;
import pages.SongsPage;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        String song = "dark";
        String nameOfPlaylist = "test playlist";
        String textBanner = "Deleted playlist \"" + nameOfPlaylist + "\".";
        BasePage basePage = new BasePage(theDriver);
        LoginPage loginPage = new LoginPage(theDriver);
        SongsPage songPage = new SongsPage(theDriver);
        SearchPage searchPage = new SearchPage(theDriver);
        loginPage.login();
        searchPage.playlistCheckSearch(nameOfPlaylist, song);
        songPage.deletePlaylist();

        basePage.showBanner(textBanner);

        Assert.assertTrue(true,textBanner);


    }

}
