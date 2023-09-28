import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.*;

public class PlaySongs extends BaseTest{
    RegistrationPage registrationPage;
    BasePage basePage;
    LoginPage loginPage;
    SongsPage songsPage;
    SearchPage searchPage;
    @BeforeMethod
    void setupClass() {
        registrationPage = new RegistrationPage(theDriver);
        basePage = new BasePage(theDriver);
        loginPage = new LoginPage(theDriver);
        songsPage = new SongsPage(theDriver);
        searchPage = new SearchPage(theDriver);
        theDriver.get(baseUrl);
    }

    @Test
    public void playSong() throws InterruptedException{

        loginPage.login();
        songsPage.clickToAllSongs();
        songsPage.playingSong();
        songsPage.clickPlayNextSong();
    }


}
