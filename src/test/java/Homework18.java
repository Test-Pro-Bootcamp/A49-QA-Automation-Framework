
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Test;
public class Homework18 extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    @Test
    public void playSong() {
        loginPage = new LoginPage(driver);
        homePage= new HomePage(driver);

//        homePage.openLoginUrl(url);
        loginPage.loginWithCorrectCred();
        homePage.clickSongsTab();
        homePage.selectASong();
        homePage.playHover();
        homePage.checkHover();
        homePage.playBtn();
        homePage.checkSoundbars();
    }
}