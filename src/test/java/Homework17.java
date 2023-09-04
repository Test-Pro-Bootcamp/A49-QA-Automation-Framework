import Pages.LoginPage;
import Pages.SearchPage;
import org.testng.annotations.Test;
public class Homework17 extends BaseTest {
    LoginPage loginPage;
    SearchPage searchPage;
    @Test
    public void addSongToPlaylist() {
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);

//        basepage.openLoginUrl(url);
        loginPage.loginWithCorrectCred();
        searchPage.enterSongIntoSearchField();
        searchPage.clickViewAll();
        searchPage.clickOnSongTitle();
        searchPage.addTooBtn();
        searchPage.enterUniquePlaylist();
        searchPage.clickSubmitBtn();
        searchPage.checkMsg();
    }
}