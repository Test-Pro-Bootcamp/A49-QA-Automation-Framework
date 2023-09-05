package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class ActionsTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @BeforeClass
    void login() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.loginCorrectCred();
    }

    @Test
    void contextClickOnSong() {
        homePage.clickAllSongs();
        homePage.contextClickSongByName("Reactor");
        homePage.clickPlay();
        homePage.checkSongIsPlaying();
    }

    @Test
    void mouseHoverTest() {
        homePage.clickAllSongs();
        homePage.mouseMoveToPlayBtn();
        homePage.checkIfPlayBtnIsVisible();
    }

}