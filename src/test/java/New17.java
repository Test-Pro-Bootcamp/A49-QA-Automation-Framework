import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class New17 extends BaseTest{
@Test
public void addSongToPlaylist() throws InterruptedException {
    String expectedSongAddedMessage ="Added 1 song into \"Test Pro playlist\ "
}
navigateToPage();
provideEmail("demo@class.com");
providePassword("te$t$tudent");
clickSubmit();
Thread.sleep(millis:2000);
searchSong(name: "It's Your Birthday");
clickViewAllBtn();
selectFirstSongResult();
clickAddToBtn();
choosePlaylist();
Assert.assertEquals(getAddToPlaylistSuccessMessage(); expectedSongAddedMessage);

@AfterMethod
driver.quit();



    }