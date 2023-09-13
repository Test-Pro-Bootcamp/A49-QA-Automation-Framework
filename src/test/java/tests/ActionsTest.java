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
        //loginPage = new LoginPage(driver);
        //homePage = new HomePage(driver);
        //songsPage = new SongsPage(driver);
        loginPage = new LoginPage(getThreadLocal());
        homePage = new HomePage(getThreadLocal());
        songsPage = new SongsPage(getThreadLocal());
        loginPage.loginToKoel();
    }

    @Test
    void contextClickTest()  {
        //HomePage homePage = new HomePage(getThreadLocal());
        //SongsPage songsPage = new SongsPage(getThreadLocal());

        homePage.clickAllSongs();
        songsPage.findSong("Epic Song")
                .clickPlayOption()
                .checkIfSongIsPlaying();
    }


    @Test
    void doubleClickTest() {
        //HomePage homePage = new HomePage(getThreadLocal());
        //SongsPage songsPage = new SongsPage(getThreadLocal());

        homePage.clickAllSongs();
        songsPage.doubleclickOnSong("Pluto")
                .checkIfSongIsPlaying();
    }

}