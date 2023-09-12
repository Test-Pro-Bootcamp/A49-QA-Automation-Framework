package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SongsPage;

public class ActionsTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage ;
    SongsPage songsPage;

    @BeforeClass
    void login(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        songsPage = new SongsPage(driver);
        loginPage.loginToKoel();
    }

    @Test
    void contextClickTest()  {
        homePage.clickAllSongs();
        songsPage.findSong("Epic Song")
                .clickPlayOption()
                .checkIfSongIsPlaying();
    }

    /*@Test
    void contextClick()  {
        homePage.clickAllSongs();
        songsPage.findSong("Epic Song")
                .clickPlayOption()
                .checkIfSongIsPlaying();
    }*/

    @Test
    void doubleClickTest() {
        homePage.clickAllSongs();
        songsPage.doubleclickOnSong("Pluto")
                .checkIfSongIsPlaying();
    }

}