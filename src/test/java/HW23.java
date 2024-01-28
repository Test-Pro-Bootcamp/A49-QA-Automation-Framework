import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Pages.PlaylistPage;
public class HW23 extends BaseTest {
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
        playlistPage.clickOnCreatePlaylistBtn()
                .clickOnCreateNewPlaylist()
                .enterNewPlaylistName(playListName);
        basePage.checkShowSuccess();
    }
}
