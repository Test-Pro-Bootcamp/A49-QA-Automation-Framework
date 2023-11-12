package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SongsPage;

public class ActionsTest extends BaseTest {




    @Test
    void contextClickTest()  {
        HomePage homePage = new HomePage(getThreadLocal());
        SongsPage songsPage = new SongsPage(getThreadLocal());
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.loginToKoel();

        homePage.clickAllSongs();
        songsPage.findSong("Epic Song")
                .clickPlayOption()
                .checkIfSongIsPlaying();
    }

    /* @Test
    void searchContextClickTest() {
        HomePage homePage = new HomePage(getThreadLocal());
        SongsPage songsPage = new SongsPage(getThreadLocal());
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.loginToKoel();

        homePage.searchForSong("Epic Song");
        homePage.findFirstSongInResults();
        
    } */

    @Test
    void doubleClickTest() {
        HomePage homePage = new HomePage(getThreadLocal());
        SongsPage songsPage = new SongsPage(getThreadLocal());
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.loginToKoel();

        homePage.clickAllSongs();
        songsPage.doubleclickOnSong("Pluto")
                .checkIfSongIsPlaying();
    }

}