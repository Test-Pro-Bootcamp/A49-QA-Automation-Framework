
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PlaylistPage;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {


    @Test
   public void addSongToPlayList()  {
        HomePage homePage = new HomePage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);

//        Thread.sleep(2000);
        homePage.searchTab("somewhere in the dark")
                .viewAllButton();
        playlistPage.clickOnSong()
                    .addToButton()
                    .bisolaPlayList();

    }



}
