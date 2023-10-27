/*
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.*;
import tests.BaseTest;

public class Homework24 extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    PlaylistPage playListpage;
    SongsPage songsPage;
    BasePage basePage;
    @BeforeSuite
    public void setup(){
        loginPage = new LoginPage(getThreadDriver());
        homePage = new HomePage(getThreadDriver());
        playListpage= new PlaylistPage(getThreadDriver());
        songsPage= new SongsPage(getThreadDriver());
        basePage= new BasePage(getThreadDriver());
    }

    @Test
    public void spellBook(){


        loginPage.successfulPortalTest();
        homePage.newRitual()
                .createScroll();
        playListpage.castNameScroll(basePage.castRandomName());
    }
}
*/
