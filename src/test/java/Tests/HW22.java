package Tests;

import Tests.BaseTest;
import org.testng.annotations.Test;

public class HW22 extends BaseTest {
    @Test
    void contextClickOnSong(){
        loginPage.loginCorrectCred();
        homePage.clickAllSongs();
        homePage.contextClickSongByName("Reactor");
        homePage.clickPlay();
        homePage.checkSongIsPlaying();
    }
}