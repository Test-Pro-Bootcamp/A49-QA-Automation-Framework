package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class PlaylistTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    BasePage basePage;

    public String myNewPlaylist = "My New Playlist";
    public String newPlaylistTitle = "Updated " + myNewPlaylist;

    @BeforeClass
    void login(){
        loginPage = new LoginPage(getThreadLocal());
        basePage = new BasePage(getThreadLocal());
        homePage = new HomePage(getThreadLocal());
        basePage = new BasePage(getThreadLocal());

        //loginPage = new LoginPage(driver);
        //basePage = new BasePage(driver);
        //homePage = new HomePage(driver);
        loginPage.loginToKoel();
    }


    /*@Test (priority = 1, description = "Login into Koel")
    public void loginIntoKoel(){
        loginPage.loginToKoel();
        //Assert.assertTrue(Boolean.parseBoolean(driver.getCurrentUrl()), "qa.koel.app/#!/home");
    }*/

    @Test(priority = 2, description = "Create new playlist with specific name")
    public void createPlaylist() {
        homePage.createPlaylist(myNewPlaylist);
        String expectedMessage = "Created playlist \"" + myNewPlaylist + ".\"";
        Assert.assertEquals(homePage.verifyNotificationMessage(), expectedMessage);

        basePage.waitForInvisibilityOfNotificationMessage();
    }

    @Test(priority = 3, description = "Add few songs to newly created playlist with specific name")
    public void addSongsPlaylist() {
        String expectedMessage = "Added 1 song into \"" + myNewPlaylist + ".\"";

        homePage.searchForSong("Song")
                .clickViewAllButton()
                .findFirstSongInResults()
                .clickAddToButton()
                .addSongToMyNewPlaylist();
        Assert.assertEquals(homePage.verifyNotificationMessage(), expectedMessage);

        basePage.waitForInvisibilityOfNotificationMessage();
    }

    @Test(priority = 4, description = "Update title of created playlist")
    public void renamePlaylist() {
        homePage.doubleClickOnPlaylist()
                .updatePlaylistTitle(newPlaylistTitle);
        String expectedMessage = "Updated playlist \"" + newPlaylistTitle + ".\"";
        Assert.assertEquals(homePage.verifyNotificationMessage(), expectedMessage);

        basePage.waitForInvisibilityOfNotificationMessage();
    }

    @Test(priority = 5, description = "Delete playlist with updated title")
    public void deletePlaylist() {
        homePage.deleteCreatedPlaylist();
        String expectedMessage = "Deleted playlist \"" + newPlaylistTitle + ".\"";
        Assert.assertEquals(homePage.verifyNotificationMessage(), expectedMessage);

        basePage.waitForInvisibilityOfNotificationMessage();
    }
}
