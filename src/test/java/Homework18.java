import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class Homework18 extends BaseTest {
    @Test(description = "Homework 18 - playSong")

    public void playSong() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.logInWithRightCredentials();
        homePage.clickNextSongBtn()
                .clickPlaySong()
                .verifySongIsPlaying();
    }
}
