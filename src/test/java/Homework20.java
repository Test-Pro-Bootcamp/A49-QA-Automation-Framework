import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import java.time.Duration;


public class Homework20 extends BaseTest{

    @Test
    public void deletePlaylist() {

        String playlistDeletedMessage ="Deleted playlist";
        provideEmail("bhakti.damle@testpro.io");
        providePassword("Mangodesk234!");
        clickSubmit();
        clickMyPlaylist();
        clickDeleteMyPlaylist();
        Assert.assertTrue(getDeletedPlaylistNotification().contains(playlistDeletedMessage));
    }
}

