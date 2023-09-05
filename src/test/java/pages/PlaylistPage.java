package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PlaylistPage extends BasePage{

   // String playlistName = getRandomString(10);
    public PlaylistPage(WebDriver driver) {

        super(driver);
    }

    public void playlistIsRenamed(String newPlaylistName) {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Updated playlist \""+ newPlaylistName +".\"']")));
        Assert.assertTrue(notification.isDisplayed());
    }

    public void enterNewPlayListName(String newPlaylistName) {
        WebElement playlistInputField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName, Keys.ENTER);

    }

    public void playlistIsCreated(String playlistName){
        WebElement createdPlaylistMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text('Created playlist "+ playlistName + "'))]")));
        Assert.assertTrue(createdPlaylistMsg.isDisplayed());
    }

    public void doubleClickPlayList(String playlistName) {
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text() = '" + playlistName + "']")));
        actions.doubleClick(playlist).perform();
    }

    public void clickOnNewPlayListBtn() {
        WebElement newPlayListBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
        newPlayListBtn.click();
    }

    public void clickOnCreateNewPlaylistBtn() {
        WebElement plusBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='sidebar-create-playlist-btn']")));
        plusBtn.click();
    }

    public void clickOnPlayList(String playlistName) {
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text() = '" + playlistName + "']")));
        actions.contextClick(playlist).perform();
    }

    public void clickOnDeletePlaylistBtn(String playlistName){
        WebElement deletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Delete this playlist']")));
        deletePlaylist.click();
    }

    public void playlistIsDeleted(String playlistName){
        WebElement playlistIsDeletedMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text('Deleted playlist "+ playlistName + "'))]")));
    }

}
