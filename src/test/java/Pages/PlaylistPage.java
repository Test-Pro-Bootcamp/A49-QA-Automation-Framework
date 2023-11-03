package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class PlaylistPage extends BasePage {
    //    constructors

    @FindBy (css ="[ name='name']")
    WebElement newPlayListName;
    @FindBy (css =".playlist:nth-child(3)")
    WebElement newPlayList;
    @FindBy (css =".del.btn-delete-playlist")
    WebElement deletePlayList;
    @FindBy (css ="div.success.show")
    WebElement notificationDeleteNewPlaylist;
    @FindBy (css ="#songResultsWrapper tr:nth-child(1) td.title")
    WebElement clickOnSong;
    @FindBy (css ="#playlists ul li:nth-child(3)")
    WebElement bisolaPlayList;
    @FindBy (css =".btn-add-to")
    WebElement addToButton;
    @FindBy (css ="#playlists nav ul li:nth-child(1)")
    WebElement doubleClickPlayList;
    @FindBy (css ="[data-testid='sidebar-create-playlist-btn']")
    WebElement clickCreatePlaylistBtn;
    @FindBy (css ="#playlists  li:nth-child(3) a")
    WebElement clickOnNewPlayList;
    @FindBy (css =" div.success.show")
    WebElement playlistNotification;
    @FindBy (css ="#playlists ul li:nth-child(3)")
    WebElement doubleClickNewPlaylist;
    @FindBy (css ="[ name='name']")
    WebElement renameNewPlaylist;

    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public PlaylistPage checkNumberOfSongsInPlayList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));
        List<WebElement> allSongsInPlayList = driver.findElements(By.cssSelector(""));
        for (WebElement element : allSongsInPlayList) {
            System.out.println(element.getText());
        }
        Assert.assertEquals(allSongsInPlayList.size(), 3);
        return this;
    }

    public PlaylistPage moveMouseToPLayBtn() {
        WebElement playBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".side.player-controls")));
        actions.moveToElement(playBtn).perform();
        return this;
    }

    public PlaylistPage clickPlay() {
        WebElement clickPlayBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playback")));
        actions.doubleClick(clickPlayBtn).perform();
        return this;
    }

    public PlaylistPage clickOnSong() {
       wait.until(ExpectedConditions.visibilityOf(clickOnSong));
        clickOnSong.click();
        return this;
    }

    public PlaylistPage bisolaPlayList() {
         wait.until(ExpectedConditions.visibilityOf(bisolaPlayList));
        actions.moveToElement(bisolaPlayList).perform();
        actions.click(bisolaPlayList).perform();

        return this;
    }

    public PlaylistPage addToButton() {
         wait.until(ExpectedConditions.visibilityOf(addToButton));
        actions.click(addToButton).perform();
        return this;
    }

    public PlaylistPage newPlayList() {
         wait.until(ExpectedConditions.visibilityOf(newPlayList));
        newPlayList.click();
return this;
    }

    public PlaylistPage deleteNewPlayList() {
        wait.until(ExpectedConditions.visibilityOf(deletePlayList));
        actions.click(deletePlayList).perform();
return this;

    }

    public PlaylistPage notificationDeleteNewPlaylist() {
         wait.until(ExpectedConditions.visibilityOf(notificationDeleteNewPlaylist));
        Assert.assertTrue(notificationDeleteNewPlaylist.isDisplayed());
return this;
    }

    public PlaylistPage doubleClickPlayList() {
         wait.until(ExpectedConditions.visibilityOf(doubleClickPlayList));
        actions.doubleClick(doubleClickPlayList).perform();
        return this;
    }

    public PlaylistPage clickCreatePlaylistBtn() {
        wait.until(ExpectedConditions.visibilityOf(clickCreatePlaylistBtn));
        actions.moveToElement(clickCreatePlaylistBtn).perform();
        actions.doubleClick(clickCreatePlaylistBtn).perform();
return this;
    }

    public PlaylistPage enterNewPlaylist() {
        wait.until(ExpectedConditions.visibilityOf(newPlayListName));
        newPlayListName.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        newPlayListName.sendKeys("GreatPlaylist");
        newPlayListName.sendKeys(Keys.ENTER);
return this;
    }

    public PlaylistPage clickOnNewPlayList() {
         wait.until(ExpectedConditions.visibilityOf(clickOnNewPlayList));
        actions.moveToElement(clickOnNewPlayList).perform();
        return this;
    }

    public PlaylistPage playlistNotification() {
        wait.until(ExpectedConditions.visibilityOf(playlistNotification));
        playlistNotification.getText();
return this;
    }

    public PlaylistPage doubleClickNewPlaylist() {
         wait.until(ExpectedConditions.visibilityOf(doubleClickNewPlaylist));
        actions.doubleClick(doubleClickNewPlaylist).perform();
        return this;
    }

    public PlaylistPage renameNewPlaylist() {
        WebElement renameNewPlayList =wait.until(ExpectedConditions.visibilityOf(renameNewPlaylist));
        renameNewPlayList.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        renameNewPlayList.sendKeys("DiffPlaylist");
        renameNewPlayList.sendKeys(Keys.ENTER);
        return this;
    }
}