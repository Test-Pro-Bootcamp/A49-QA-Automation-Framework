package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class PlaylistTest extends BaseTest {


    public String myNewPlaylist = "My New Playlist";
    public String newPlaylistTitle = "Updated " + myNewPlaylist;




    @Test(priority = 2, description = "Create new playlist with specific name")
    public void createPlaylist() {
        HomePage homePage = new HomePage(getThreadLocal());
        BasePage basePage = new BasePage(getThreadLocal());
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.loginToKoel();
        homePage.createPlaylist(myNewPlaylist);
        String expectedMessage = "Created playlist \"" + myNewPlaylist + ".\"";
        Assert.assertEquals(homePage.verifyNotificationMessage(), expectedMessage);

        basePage.waitForInvisibilityOfNotificationMessage();

    }

    @Test(priority = 3, description = "Add few songs to newly created playlist with specific name")
    public void addSongsPlaylist() {
        HomePage homePage = new HomePage(getThreadLocal());
        BasePage basePage = new BasePage(getThreadLocal());
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.loginToKoel();
        homePage.createPlaylist("TestPro Playlist");

        basePage.waitForInvisibilityOfNotificationMessage();

        //String expectedMessage = "Added 1 song into \"" + myNewPlaylist + ".\"";
        String expectedMessage = "Added 1 song into \"TestPro Playlist.\"";
        //LoginPage loginPage = new LoginPage(getThreadLocal());
        //loginPage.loginToKoel();

        homePage.searchForSong("Song")
                .clickViewAllButton()
                .findFirstSongInResults()
                .clickAddToButton()
                .addSongToTestProPlaylist();
        Assert.assertEquals(homePage.verifyNotificationMessage(), expectedMessage);

    }

}