import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.*;

public class Homework24 extends BaseTest{
    LoginPage loginPage;
    HomePage homePage;
    PlaylistPage playListpage;
    SongsPage songsPage;
    BasePage basePage;
    @BeforeSuite
    public void setup(){
        loginPage = new LoginPage(driver);
        driver.get(url);
        homePage = new HomePage(driver);
        playListpage= new PlaylistPage(driver);
        songsPage= new SongsPage(driver);
        basePage= new BasePage(driver);
    }

    @Test
    public void spellBook(){


        loginPage.successfulPortalTest();
        homePage.newRitual()
                .createScroll();
        playListpage.castNameScroll(basePage.castRandomName());
    }
}
