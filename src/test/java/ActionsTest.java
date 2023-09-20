package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.SongsPage;

public class ActionsTest extends BasePage {
    LoginPage loginPage;
    HomePage homePage;
    SongsPage songsPage;

    public ActionsTest(WebDriver driver) {
        super(driver);
    }

    @BeforeClass
    void login(){

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        songsPage = new SongsPage(driver);
        loginPage.successfulPortalTest();
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
        homePage.clickAllSongs().mouseMoveToPlayBtn().checkIfPlayBtnIsVisible();
    }
//    COMMENTED OUT AS THAT PLAYLIST NEEDS TO BE CREATED BEFORE THE TEST
//    @Test
//    void checkPlaylistSongs()  {
//        loginPage.loginCorrectCred();
//        homePage.clickOnPlaylist("Play List With Songs");
//        playlistPage.checkNumberOfSongsInPlaylist();
//    }
}