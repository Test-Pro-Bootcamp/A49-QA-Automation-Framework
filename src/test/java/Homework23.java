

        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;
        import pages.HomePage;
        import pages.LoginPage;
        import pages.SongsPage;
public class Homework23 extends BaseTest{

    LoginPage loginPage;
    HomePage homePage;
    pages.SongsPage songsPage;

    @BeforeClass
    void login(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        songsPage = new pages.SongsPage(driver);
        loginPage.loginCorrectCred();
    }

    @Test
    void contextClickOnSong() {
        homePage.clickAllSongs();
        songsPage.contextClickSongByName("Reactor").clickPlay();
        homePage.checkSongIsPlaying();
    }

    @Test
    void mouseHoverTest () {
        homePage.clickAllSongs().mouseMoveToPlayBtn().checkIfPlayBtnIsVisible();
    }


}
