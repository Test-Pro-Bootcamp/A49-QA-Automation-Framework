
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String expectedSongAddedMessage = "Added 1 song into \"Test Pro Playlist.\"";

        navigateToPage();
        provideEmail("demo@class.com");
       providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        searchSong("Pluto");
        Thread.sleep(2000);
        clickViewAllBtn();
       selectFirstSongResult();
       clickAddToBtn();
        choosePlaylist();
        Assert.assertEquals(getAddToPlaylistSuccessMessage(), expectedSongAddedMessage);
    }


    }




