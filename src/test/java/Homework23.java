import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Homework23 extends BaseTest {
    String playlistName;

    // I implemented the Page Factory for methods from the Login and createPlaylist tests only.
    @BeforeClass
    public void login() {
        loginPage.loginWithCorrectCred();
        playlistName = basePage.getRandomString();
    }

    @Test(priority = 1)
    public void createPlaylist() {
        playlistPage.clickOnNewPlaylistBtn()
                    .clickOnCreateNewPlaylist()
                    .enterNewPlayListName(playlistName)
                    .playlistIsCreated(playlistName);
    }

    @Test(priority = 2)
    public void renamePlaylist() {
        playlistPage.doubleClickPlayList(playlistName);
        playlistName = "New" + playlistName;
        playlistPage.enterNewPlayListName(playlistName)
                    .playlistIsRenamed(playlistName);
    }

    @Test(priority = 3)
    public void deletePlaylist() {
        playlistPage.clickOnPlayList(playlistName)
                    .clickOnDeletePlaylistBtn(playlistName)
                    .playlistIsDeleted(playlistName);
    }
}
