package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    By firstScroll = By.cssSelector(".playlist:nth-child(3)");
    By spellTarget = By.cssSelector("[name='name']");
    By getRenamedScrollAch = By.cssSelector("div.success.show");

    public void doubleClickScrolllist(){
        doubleClick(firstScroll);
    }

    public void clickOnPlaylist(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + playlistName + "')]"))).click();
    }

    public void clickAllSongs() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li a.songs"))).click();
    }

    public void clickPlay() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playback"))).click();
    }

    public void checkSongIsPlaying() {
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        Assert.assertTrue(soundBar.isDisplayed());
    }

    public void checkIfPlayBtnIsVisible() {
        WebElement playBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='play-btn']")));
        Assert.assertTrue(playBtn.isDisplayed());
    }

    public void mouseMoveToPlayBtn() {
        WebElement playPanel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".side.player-controls")));
        actions.moveToElement(playPanel).click(playPanel).perform();
    }

    public void contextClickSongByName(String songName) {
        WebElement song = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id=' songWrapper']//td[text()='" + songName + "']")));
        actions.contextClick(song).perform();
    }
    public void castRenameScroll(String newScrollName) {
        findElement(spellTarget).sendKeys(Keys.chord(Keys.LEFT_CONTROL,"A", Keys.BACK_SPACE));
        findElement(spellTarget).sendKeys(newScrollName);
        findElement(spellTarget).sendKeys(Keys.RETURN);
        /*WebElement nameTarget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[id='playlists'] li:nth-child(3)")));
        actions.doubleClick(nameTarget).perform();
        WebElement spellTarget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        spellTarget.sendKeys(Keys.chord(Keys.LEFT_CONTROL,"A", Keys.BACK_SPACE));
        spellTarget.sendKeys(newScrollName);
        spellTarget.sendKeys(Keys.RETURN);*/
    }
    public String getRenamePlaylistSuccessMsg() {
        return findElement(getRenamedScrollAch).getText();
    }

   /* By userAvatarIcon = By.cssSelector("img.avatar");

    public WebElement getUserAvatar() {

        return findElement(userAvatarIcon);*/

}



