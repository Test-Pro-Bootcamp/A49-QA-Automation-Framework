
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SongsPage;



public class Homework23 extends BaseTest{
    @Test
    public void fillingPlaylist() throws InterruptedException{
        SongsPage songsPage = new SongsPage(theDriver);

        LoginPage loginPage = new LoginPage(theDriver);
        loginPage.login();
        songsPage.addSongToPlaylist("Lambs")
                 .deletePlaylist();
    }

}

