import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SongPage;

public class Homework23 extends BaseTest {
    LoginPage loginPage;
    HomePage homePage ;
    SongPage songPage;

    @BeforeClass
    void login(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        songPage = new SongPage(driver);
        loginPage.loginCorrectCred();
    }
    @Test
    void contextClickOnSong()  {
        homePage.clickAllSongs();
        songPage.contextClickSongByName("Reactor").clickPlay();
       // homePage.checkSongIsPlaying();
    }

    @Test
   void mouseHoverTest() {
        homePage.clickAllSongs().mouseMoveToPlayBtn().checkIfPlayBtnIsVisible();
    }
//    COMMENTED OUT AS THAT PLAYLIST NEEDS TO BE CREATED BEFORE THE TEST
//    @Test
//    void checkPlaylistSongs()  {
//        loginPage.loginCorrectCred();
//        homePage.clickOnPlaylist("Play List With Songs");
//        playlistPage.checkNumberOfSongsInPlaylist();
    }
