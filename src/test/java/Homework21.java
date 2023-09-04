import Pages.LoginPage;
import Pages.PlaylistPage;
import org.testng.annotations.Test;
public class Homework21 extends BaseTest {
    LoginPage loginPage;
    PlaylistPage playlistPage;
    @Test
    public void renamePlaylist() {
        loginPage = new LoginPage(driver);
        playlistPage = new PlaylistPage(driver);

        loginPage.loginWithCorrectCred();
        playlistPage.createPlaylist();
        playlistPage.doubleClickPlaylist();
        playlistPage.enterNewPlaylistName();
        playlistPage.playlistUpdatedMsg();
    }
}