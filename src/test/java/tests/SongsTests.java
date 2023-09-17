package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SongsPage;

public class SongsTests extends BaseTest {
    LoginPage loginPage;
    SongsPage songsPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(getDriver());
        songsPage = new SongsPage(getDriver());
        getDriver().get(url);
    }

    @Test
    public void playSong() {
        loginPage.loginWithCorrectCred();
        songsPage.chooseAllSongsList()
                .contextClickFirstSong()
                .clickPlayOption()
                .isSongPlaying();

    }
}
