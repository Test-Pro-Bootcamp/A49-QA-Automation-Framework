package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.PlaylistPage;

public class PlaylistTests extends BaseTest{
    LoginPage loginPage;
    PlaylistPage playlistPage;
    BasePage basePage;
    public String playListName;

    @BeforeClass
    void login() {
        loginPage = new LoginPage(driver);
        playlistPage = new PlaylistPage(driver);
        loginPage.loginWithCorrectCred();
        playListName = loginPage.getRandomString();
    }

    @Test(priority = 1)
    public void createPlaylist() {
        playlistPage.clickOnCreatePlaylistBtn();
        playlistPage.clickOnCreateNewPlaylist();
        playlistPage.enterNewPlaylistName(playListName);
        playlistPage.playlistIsCreatedMsg(playListName);

    }

    @Test(priority = 2)
    public void renamePlaylist() {
        playlistPage.doubleClickOnPlaylist(playListName);
        playListName = "Updated" + playListName;
        playlistPage.enterNewPlaylistName(playListName);
        playlistPage.checkMessage(playListName);
    }

    @Test(priority = 3)
    public void deletePlaylist() {
        playlistPage.clickOnPlaylist(playListName);
        playlistPage.clickOnDeletePlaylistBtn();
        playlistPage.playlistIsDeletedMsg(playListName);
    }
}
