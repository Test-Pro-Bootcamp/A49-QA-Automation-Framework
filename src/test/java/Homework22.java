import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest {

    String playlistName;
    @BeforeClass
    public void login(){
        loginPage.loginWithCorrectCred();
        playlistName = basePage.getRandomString();
    }
    @Test(priority = 1)
    public void createPlaylist(){
        playlistPage.clickOnNewPlaylistBtn();
        playlistPage.clickOnCreateNewPlaylist();
        playlistPage.enterNewPlayListName(playlistName);
        playlistPage.playlistIsCreated(playlistName);
    }

    @Test(priority = 2)
    public void renamePlaylist(){
        playlistPage.doubleClickPlayList(playlistName);
        playlistName = "New" + playlistName;
        playlistPage.enterNewPlayListName(playlistName);
        playlistPage.playlistIsRenamed(playlistName);
    }

    @Test(priority = 3)
    public void deletePlaylist(){
        playlistPage.clickOnPlayList(playlistName);
        playlistPage.clickOnDeletePlaylistBtn(playlistName);
        playlistPage.playlistIsDeleted(playlistName);
    }

}
