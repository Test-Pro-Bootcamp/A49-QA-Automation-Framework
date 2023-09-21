//package tests;
//
//import pageObjects.HomePage;
//import pageObjects.LoginPage;
//import pageObjects.PlaylistPage;
//import org.testng.annotations.Test;
//
//public class PlaylistTests extends BaseTest {
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
//        playlistPage.createPlaylist();
//        homePage.clickDeleteBtn();
//        homePage.verifyStringName();
//    }
//    @Test
//    public void renamePlaylist() {
//        loginPage = new LoginPage(getThreadLocal());
//        playlistPage = new PlaylistPage(getThreadLocal());
//        homePage = new HomePage(getThreadLocal());
//
//        loginPage.loginWithCorrectCred();
//        homePage.waitForLoadingBarToDisappear();
//        playlistPage.createPlaylist()
//                    .doubleClickPlaylist()
//                    .enterNewPlaylistName()
//                    .playlistUpdatedMsg();
//    }
//}