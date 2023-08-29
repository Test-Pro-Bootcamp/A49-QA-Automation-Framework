import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.*;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException, AWTException {
        String textBanner = "Added 1 song into \"first playlist.\"";
        loginWithValidCredential();
        clearMyPlaylist();
        //Thread.sleep(3000);
        search("dark");
        clickViewAll();
        returnAnySong(0, searchResultsTable,1).click();
        clickAddTo();
        clickPlaylist();
        //Thread.sleep(3000);

        Assert.assertEquals(showBanner(textBanner), textBanner);

    }


}
