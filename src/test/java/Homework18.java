import org.testng.annotations.Test;
public class Homework18 extends BaseTest {

    @Test
    public void playSong() {
        homePage.openLoginUrl(url);
        loginPage.loginWithCorrectCred();
        homePage.clickSongsTab();
        homePage.selectASong();
        homePage.playNextBtn();
        homePage.playBtn();
        homePage.checkSoundbars();
    }
}