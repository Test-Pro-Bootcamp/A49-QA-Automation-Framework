//import Pages.HomePage;
//import Pages.LoginPage;
//import Pages.SearchPage;
//import org.testng.annotations.Test;
//public class Homework17 extends BaseTest {
//    LoginPage loginPage;
//    SearchPage searchPage;
//    HomePage homePage;
//    @Test
//    public void addSongToPlaylist() {
//        loginPage = new LoginPage(getThreadLocal());
//        searchPage = new SearchPage(getThreadLocal());
//        homePage = new HomePage(getThreadLocal());
//
//        loginPage.loginWithCorrectCred();
//        homePage.waitForLoadingBarToDisappear();
//        searchPage.enterSongIntoSearchField()
//                  .clickViewAll()
//                  .clickOnSongTitle()
//                  .addTooBtn()
//                  .enterUniquePlaylist()
//                  .clickSubmitBtn()
//                  .checkMsg();
//    }
//}