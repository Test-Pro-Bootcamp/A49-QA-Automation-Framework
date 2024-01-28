import Pages.SongsPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;

public class ActionsTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage ;
    SongsPage songsPage;

    @BeforeClass
    void login(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        songsPage = new SongsPage(driver);
        loginPage.loginCorrectCred();
    }
    @Test
    void contextClickOnSong()  {
        homePage.clickAllSongs();
        songsPage.contextClickSongByName("Reactor")
                 .clickPlay();
        homePage.checkSongIsPlaying();
    }

    @Test
    void mouseHoverTest() {
        homePage.clickAllSongs()
                .mouseMoveToPlayBtn()
                .checkIfPlayBtnIsVisible();
    }
//    COMMENTED OUT AS THAT PLAYLIST NEEDS TO BE CREATED BEFORE THE TEST
//    @Test
//    void checkPlaylistSongs()  {
//        loginPage.loginCorrectCred();
//        homePage.clickOnPlaylist("Play List With Songs");
//        playlistPage.checkNumberOfSongsInPlaylist();
//    }
}
