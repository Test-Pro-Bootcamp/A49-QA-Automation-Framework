import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {

        navigateToPage();
        provideEmail("svitlana.shkribliak@testpro.io");
        providePassword("te$t$tudent49");
        clickSubmit();
        clickPlusIcon();
        clickNewPlaylistBtn();
        enterText(By.cssSelector("[name='name']"), getRandomString(10));
        clickPlaylist();
        clickDeletePlaylistBtn();
        Thread.sleep(2000);
        playlistIsDeleted();
    }

    private void playlistIsDeleted() {
        WebElement playlistDeletedMsg = driver.findElement(By.xpath("//*[contains(text(),'Deleted playlist')]"));

        Assert.assertTrue(playlistDeletedMsg.isDisplayed());
    }

    private void enterText(By inputLocator, String inputText) {
        WebElement searchInput = driver.findElement(inputLocator);
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(inputText, Keys.ENTER);
    }

    private void clickNewPlaylistBtn() {
        WebElement newPlaylist = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
        newPlaylist.click();
    }

    private void clickPlusIcon() {
        WebElement plusIcon = driver.findElement(By.cssSelector("[data-testid='sidebar-create-playlist-btn']"));
        plusIcon.click();
    }

    private void clickDeletePlaylistBtn() {
        WebElement deletePlaylist = driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        deletePlaylist.click();
    }

    private Boolean clickPlaylist() {
        WebElement playlist = driver.findElement(By.cssSelector("#playlists li:nth-child(3)"));
        Assert.assertTrue(playlist.isDisplayed());
        playlist.click();
        return true;
    }

}
