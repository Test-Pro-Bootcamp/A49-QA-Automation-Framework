package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class PlaylistTest extends BaseTest_threads {


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

        //homePage.deleteCreatedPlaylist();

    }

    @Test(priority = 3, description = "Add few songs to newly created playlist with specific name")
    public void addSongsPlaylist() throws InterruptedException {
        HomePage homePage = new HomePage(getThreadLocal());
        BasePage basePage = new BasePage(getThreadLocal());
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.loginToKoel();
        homePage.createPlaylist("TestPro Playlist");
        Thread.sleep(5000);

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
/*
    @Test(priority = 4, description = "Update title of created playlist")
    public void renamePlaylist() {
        HomePage homePage = new HomePage(getThreadLocal());
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.loginToKoel();
        homePage.doubleClickOnPlaylist()
                .updatePlaylistTitle(newPlaylistTitle);
        String expectedMessage = "Updated playlist \"" + newPlaylistTitle + ".\"";
        Assert.assertEquals(homePage.verifyNotificationMessage(), expectedMessage);
    }

    @Test(priority = 5, description = "Delete playlist with updated title")
    public void deletePlaylist() {
        HomePage homePage = new HomePage(getThreadLocal());
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.loginToKoel();

        homePage.deleteCreatedPlaylist();
        String expectedMessage = "Deleted playlist \"" + newPlaylistTitle + ".\"";
        Assert.assertEquals(homePage.verifyNotificationMessage(), expectedMessage);

    }
 */
}