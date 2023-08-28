import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework20 extends BaseTest {

    @Test
    public void deletePlaylist() {

        navigateToPage();
        provideEmail("svitlana.shkribliak@testpro.io");
        providePassword("te$t$tudent49");
        clickSubmit();
        clickPlusIcon();
        clickNewPlaylistBtn();
        enterText(By.cssSelector("[name='name']"), getRandomString(10));
        clickPlaylist();
        clickDeletePlaylistBtn();
        playlistIsDeleted();
    }

    private void playlistIsDeleted() {
        WebElement playlistDeletedMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Deleted playlist')]")));
        Assert.assertTrue(playlistDeletedMsg.isDisplayed());
    }

    private void enterText(By inputLocator, String inputText) {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(inputLocator));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(inputText, Keys.ENTER);
    }

    private void clickNewPlaylistBtn() {
        WebElement newPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
        newPlaylist.click();
    }

    private void clickPlusIcon() {
        WebElement plusIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='sidebar-create-playlist-btn']")));
        plusIcon.click();
    }

    private void clickDeletePlaylistBtn() {
        WebElement deletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Delete this playlist']")));
        deletePlaylist.click();
    }

    private void clickPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlists li:nth-child(3)")));
        playlist.click();
    }

}
