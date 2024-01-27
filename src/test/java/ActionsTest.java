import Tests.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class ActionsTest extends BaseTest {

    @Test
    void contextClickOnSong(){
        loginpage.loginCorrectCred();
        homePage.clickAllSongs();
        homePage.contextClickSongByName("Reactor");
        homePage.clickPlay();
        homePage.checkSongIsPlaying();
    }

    @Test
    void mouseHoverTest(){
        loginPage.loginCorrectCred();
        homePage.clickAllSongs();
        homePage.mouseMoveToPlayBtn();
        homePage.checkIfPlayBtnIsVisible();
    }
    @Test
    void checkPlaylistSongs(){
        loginPage.loginCorrectCred();
        homePage.clickOnPlaylist("Dawits Playlist");
        playlistPage.checkNumberOfSongsInPlaylist();
    }

}

