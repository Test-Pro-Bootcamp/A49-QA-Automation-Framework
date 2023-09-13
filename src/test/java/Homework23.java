
import org.testng.annotations.Test;
import pages.SongsPage;



public class Homework23 extends BaseTest{
    @Test
    public void fillingPlaylist() throws InterruptedException{
        SongsPage songsPage = new SongsPage(theDriver);

        loginWithValidCredential();
        songsPage.addSongToPlaylist("Lambs")
                 .deletePlaylist();
    }

}

