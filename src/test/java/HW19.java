import org.apache.commons.compress.archivers.zip.ExtraFieldUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class HW19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedPlaylistDeleteMessage = "Deleted playlist \"Test Pro Playlist\"";
        navigateToPage();
        provideEmail("dagebeyehu@gmail.com");
        providePassword("yozca5uQiLxb!");
        clickSubmit();
        Thread.sleep(3000);
        clickonPlaylist();
        clickonDeletePlaylistBtn();
        checkShowSuccess();

    }

    private void clickonOK() {
        WebElement OKBtn = driver.findElement(By.cssSelector(".ok"));
        OKBtn.click();
    }

    private void checkShowSuccess() {
        WebElement notification = driver.findElement(By.cssSelector("div.show.success"));
        Assert.assertTrue(notification.isDisplayed());
    }

    private void clickonDeletePlaylistBtn() {
        WebElement DeletePlaylistBtn = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        DeletePlaylistBtn.click();
    }

    private void clickonPlaylist() {
        WebElement Playlist = driver.findElement(By.cssSelector("[href='#!/playlist/85967']"));
        Playlist.click();
    }

}
