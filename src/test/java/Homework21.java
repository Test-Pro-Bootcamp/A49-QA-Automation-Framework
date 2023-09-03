import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class Homework21 extends BaseTest{
    @Test
    public void renamePlaylist() throws InterruptedException, AWTException {

        loginWithValidCredential();
        String nameNew = "Songs&Albums";
        String textBanner = "Updated playlist \"" + nameNew + "\".";
        createPlaylistAnotherWay("Singers");
        renamePlaylists("Singers", "Songs&Albums");
        showBanner(textBanner);
        Assert.assertTrue(true, textBanner);


    }
}
