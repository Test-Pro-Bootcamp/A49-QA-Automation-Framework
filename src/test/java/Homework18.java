
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

        loginPage.loginWithCorrectCred();
        homePage.clickSongsTab()
                .selectASong()
                .playHover();
        homePage.checkHover()
                .playBtn()
                .checkSoundbars();
    }
}