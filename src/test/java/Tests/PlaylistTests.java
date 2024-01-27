package Tests;

import Tests.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PlaylistTests extends BaseTest {
    String playListName ;
    @BeforeClass
    void login(){
        loginPage.loginCorrectCred();
        playListName ="Test Pro Playlist";
    }
    @Test(priority = 1)
    public void createPlaylist()  {
        playlistPage.clickOnCreatePlaylistBtn();
        playlistPage.clickOnCreateNewPlaylist();
        playlistPage.enterNewPlaylistName(playListName);
        basePage.checkShowSuccess();
    }
    @Test(priority = 2)
    public void renamePlaylist()  {
        playlistPage.doubleClickOnPlaylist(playListName);
        playListName ="Test Pro Playlist";
        playlistPage.enterNewPlaylistName(playListName);
        playlistPage.checkMessage(playListName);
    }

    @Test(priority = 3)
    public void deletePlaylist()  {
        playlistPage.clickOnPlaylist(playListName);
        playlistPage.clickOnDeletePlaylistBtn();
        basePage.checkShowSuccess();
    }
}
