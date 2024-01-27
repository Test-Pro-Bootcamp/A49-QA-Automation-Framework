import Pages.LoginPage;
import Pages.PlaylistPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class PlayListTests extends BaseTest{
    LoginPage loginPage;
    PlaylistPage playlistPage;
    public String playListName ;
    @BeforeClass
    void login(){
        loginPage = new LoginPage(driver);
        playlistPage = new PlaylistPage(driver);
        loginPage.loginCorrectCred();
        playListName ="Dawits Playlist"+basePage.generateRandomName();
    }
    @Test
    public void createPlaylist()  {
        playlistPage.clickOnCreatePlaylistBtn();
        playlistPage.clickOnCreateNewPlaylist();
        playlistPage.enterNewPlaylistName(playListName);
        basePage.checkShowSuccess();
    }
    @Test
    public void renamePlaylist()  {
        playlistPage.doubleClickOnPlaylist(playListName);
        playListName ="Updated"+ playListName;
        playlistPage.enterNewPlaylistName(playListName);
        playlistPage.checkMessage(playListName);
    }

    @Test
    public void deletePlaylist()  {
        playlistPage.clickOnPlaylist(playListName);
        playlistPage.clickOnDeletePlaylistBtn();
        basePage.checkShowSuccess();
    }

}