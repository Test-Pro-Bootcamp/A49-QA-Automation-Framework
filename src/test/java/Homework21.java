import org.testng.annotations.Test;
public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylist() {
        basepage.openLoginUrl(url);
        loginPage.loginWithCorrectCred();
        playlistPage.createPlaylist();
        playlistPage.doubleClickPlaylist();
        playlistPage.enterNewPlaylistName();
        playlistPage.playlistUpdatedMsg();
    }
}