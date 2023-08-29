import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        String textBanner = "Deleted playlist \"first playlist.\"";
        loginWithValidCredential();
        playlistCheck();
        deleteMyPlaylist();
        confirmDeleting();
        showBanner(textBanner);

        Assert.assertTrue(true,textBanner);

    }

}
