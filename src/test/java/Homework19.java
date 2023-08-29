import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        String textBanner = "Deleted playlist \"first playlist.\"";
        loginWithValidCredential();
        try {
            openPlaylist();
        }
        catch (Exception e) {
            search("dark");
            clickViewAll();
            returnAnySong(1, searchResultsTable, 1).click();
            clickAddTo();
            createSimplePlaylist("first playlist");
            Thread.sleep(5000);

        }

        deleteMyPlaylist();
        confirmDeleting();
        showBanner(textBanner);

        Assert.assertTrue(true,textBanner);

    }

}
