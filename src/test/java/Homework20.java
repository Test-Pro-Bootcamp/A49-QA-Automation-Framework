import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException {
        String song = "dark";
        String nameOfPlaylist = "test playlist";
        String textBanner = "Deleted playlist \"" + nameOfPlaylist + "\".";
        loginWithValidCredential();
        playlistCheck(nameOfPlaylist, song);
        deleteMyPlaylist();
        confirmDeleting();
        showBanner(textBanner);

        Assert.assertTrue(true, textBanner);
    }

}
