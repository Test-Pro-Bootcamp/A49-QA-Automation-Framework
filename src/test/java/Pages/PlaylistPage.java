package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class PlaylistPage extends BasePage {
    //    constructors
    public PlaylistPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);

    }

    public void checkNumberOfSongsInPlayList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));
        List<WebElement> allSongsInPlayList = driver.findElements(By.cssSelector(""));
        for (WebElement element : allSongsInPlayList) {
            System.out.println(element.getText());
        }
        Assert.assertEquals(allSongsInPlayList.size(), 3);
    }

    public void moveMouseToPLayBtn() {
        WebElement playBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".side.player-controls")));
        actions.moveToElement(playBtn).perform();
    }

    public void clickPlay() {
        WebElement clickPlayBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playback")));
        actions.doubleClick(clickPlayBtn).perform();
    }

    public void clickOnSong() {
        WebElement clickOnSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#songResultsWrapper tr:nth-child(1) td.title")));
        clickOnSong.click();
    }

    public void bisolaPlayList() {
        WebElement bisolaPlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='#!/playlist/66852']")));
        bisolaPlayList.click();
    }

    public void addToButton() {
        WebElement addTo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-add-to")));
        addTo.click();
    }

    public void newPlayList() {
        WebElement newPlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        newPlayList.click();

    }

    public void deleteNewPlayList() {
        WebElement deletePlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".del.btn-delete-playlist")));
//        WebElement confirmDeleteCommand = driver.findElement(By.cssSelector(" body  :nth-child(7)  button.ok"));

        deletePlayList.click();
//        confirmDeleteCommand.click();

    }

    public void notificationDeleteNewPlaylist() {
        WebElement notificationDeleteNewPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        Assert.assertTrue(notificationDeleteNewPlaylist.isDisplayed());

    }

    public void doubleClickPlayList() {
        WebElement doubleClickPlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists nav ul li:nth-child(1)")));
        actions.doubleClick(doubleClickPlayList).perform();
    }

    public void clickCreatePlaylistBtn() {
        WebElement clickCreatePlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sidebar-create-playlist-btn']")));
        actions.moveToElement(clickCreatePlaylistBtn).perform();
        actions.doubleClick(clickCreatePlaylistBtn).perform();

    }

    public void enterNewPlaylist() {
        WebElement newPlayListName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ name='name']")));
        newPlayListName.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        newPlayListName.sendKeys("GreatPlaylist");
        newPlayListName.sendKeys(Keys.ENTER);

    }

    public void clickOnNewPlayList() {
        WebElement newPlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists  li:nth-child(3) a")));
        actions.moveToElement(newPlayList).perform();
    }

    public void playlistNotification() {
        WebElement successNotification= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(" div.success.show")));
        successNotification.getText();

    }

    public void doubleClickNewPlaylist() {
        WebElement firstPlaylistElement= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists ul li:nth-child(3)")));
        actions.doubleClick(firstPlaylistElement).perform();
    }

    public void renameNewPlaylist() {
        WebElement renameNewPlayList =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ name='name']")));
        renameNewPlayList.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        renameNewPlayList.sendKeys("DiffPlaylist");
        renameNewPlayList.sendKeys(Keys.ENTER);
    }
}