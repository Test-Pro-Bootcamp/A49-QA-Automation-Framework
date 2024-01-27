import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HW22 extends BaseTest {
    LoginPage loginPage;
    HomePage homePage ;

    @BeforeClass
    void login(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.loginCorrectCred();
    }
    @Test
    void contextClickOnSong()  {
        homePage.clickAllSongs();
        homePage.contextClickSongByName("Reactor");
        homePage.clickPlay();
        homePage.checkSongIsPlaying();
    }
}
