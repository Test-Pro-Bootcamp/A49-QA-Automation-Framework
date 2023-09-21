package tests;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import org.testng.annotations.Test;
public class SongsTests extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    @Test
    public void playSong() {
        loginPage = new LoginPage(getThreadLocal());
        homePage= new HomePage(getThreadLocal());

        loginPage.loginWithCorrectCred();
        homePage.waitForLoadingBarToDisappear();
        homePage.clickSongsTab()
                .selectASong()
                .playHover();
        homePage.checkHover()
                .playBtn()
                .checkSoundbars();
    }
}