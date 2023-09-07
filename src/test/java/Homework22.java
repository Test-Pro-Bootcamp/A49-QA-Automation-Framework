import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PlaylistPage;

public class Homework22 extends BaseTest {

    LoginPage loginPage;
    PlaylistPage playlistPage;
    public String playlistName;


//    @BeforeClass
//    public void login(){
//        loginPage = new LoginPage(driver);
//        playlistPage = new PlaylistPage(driver);
//        //loginPage.loginWithCorrectCred();
//        playlistName = basePage.getRandomString(10);
//    }

    @Test(priority = 1)
    public void createNewPlaylist() throws InterruptedException{
        loginPage = new LoginPage(driver);
        playlistPage = new PlaylistPage(driver);
        loginPage.loginWithCorrectCred();
        //Thread.sleep(2000);
        playlistPage.clickOnNewPlayListBtn();
        playlistPage.clickOnCreateNewPlaylistBtn();
        playlistPage.enterNewPlayListName(playlistName);
        playlistPage.playlistIsCreated(playlistName);
    }

//    @Test(priority = 2)
//    public void renamePlaylist(){
//        playlistPage.doubleClickPlayList(playlistName);
//        playlistName = "New" + playlistName;
//        playlistPage.enterNewPlayListName(playlistName);
//        playlistPage.playlistIsRenamed(playlistName);
//    }
//
//    @Test(priority = 3)
//    public void deletePlaylist(){
//        playlistPage.clickOnPlayList(playlistName);
//        playlistPage.clickOnDeletePlaylistBtn(playlistName);
//        playlistPage.playlistIsDeleted(playlistName);
//    }
}
