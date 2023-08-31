import org.testng.annotations.Test;
public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() {
        basepage.openLoginUrl(url);
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