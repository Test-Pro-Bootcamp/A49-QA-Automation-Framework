import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Pages.PlaylistPage;
public class PlaylistTests extends BaseTest {
    LoginPage loginPage;
    PlaylistPage playlistPage;
    public String playListName ;
    @BeforeClass
    void login(){
        loginPage = new LoginPage(driver);
        playlistPage = new PlaylistPage(driver);
        loginPage.loginCorrectCred();
        playListName ="NataliasPlaylist"+basePage.generateRandomName();
    }
    @Test(priority = 1)
    public void createPlaylist()  {
        playlistPage.clickOnCreatePlaylistBtn()
                .clickOnCreateNewPlaylist()
                .enterNewPlaylistName(playListName);
        basePage.checkShowSuccess();
    }
    @Test(priority = 2)
    public void renamePlaylist()  {
        playlistPage.doubleClickOnPlaylist(playListName);
        playListName ="Updated"+ playListName;
        playlistPage.enterNewPlaylistName(playListName)
                    .checkMessage(playListName);
    }

    @Test(priority = 3)
    public void deletePlaylist()  {
        playlistPage.clickOnPlaylist(playListName)
                    .clickOnDeletePlaylistBtn();
        basePage.checkShowSuccess();
    }

}

