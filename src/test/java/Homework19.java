//import Pages.HomePage;
//import Pages.LoginPage;
//import Pages.PlaylistPage;
//import org.testng.annotations.Test;
//public class Homework19 extends BaseTest {
//    LoginPage loginPage;
//    PlaylistPage playlistPage;
//    HomePage homePage;
//    @Test
//    public void deletePlaylist() {
//        loginPage = new LoginPage(getThreadLocal());
//        playlistPage = new PlaylistPage(getThreadLocal());
//        homePage = new HomePage(getThreadLocal());
//
//        loginPage.loginWithCorrectCred();
//        homePage.waitForLoadingBarToDisappear();
//        playlistPage.clickAddPlaylist();
//        playlistPage.selectNewOption();
//        String randomName = homePage.generateRandomName();
//        playlistPage.newPlaylist(randomName);
//        homePage.selectNewRandomPlaylist();
//        homePage.clickDeleteBtn();
//        homePage.verifyStringName();
//    }
//}