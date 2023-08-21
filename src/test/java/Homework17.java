import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String newSongAddedNotification = "Added 1 song into";

        navigateToPage();
        provideEmail("bhakti.damle@testpro.io");
        providePassword("Mangodesk234!");
        clickSubmit();
        searchSong("For the Poor");
        clickViewAllButton();
        selectFirstSong();
        clickAddToButton();
        choosePlaylist();
        Assert.assertTrue(getNotification().contains(newSongAddedNotification));


    }

}
