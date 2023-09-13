import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.*;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist() {
        String callPlaylist = "test";
        String song = "HoliznaCC";
        String textBanner = "Added 1 song into \"" + callPlaylist + "\".";
        loginWithValidCredential();
        playlistCheck(callPlaylist, song);
        search(song);
        clickViewAll();
        returnAnySong(3, searchResultsTable,1).click();
        clickAddTo();
        clickPlaylist();
        showBanner(textBanner);

        Assert.assertTrue(true, textBanner);

    }


}
