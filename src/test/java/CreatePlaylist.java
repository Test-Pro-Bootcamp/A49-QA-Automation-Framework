import Pages.HomePage;
import Pages.LoginPage;
import Pages.PlaylistPage;
import Pages.Profilepage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CreatePlaylist extends BaseTest {


    @Test
    public void createPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);

        loginPage.loginWithCorrectCredentials();
        playlistPage.clickCreatePlaylistBtn()
                    .doubleClickPlayList()
                    .enterNewPlaylist()
                    .clickOnNewPlayList();


    }
    }

