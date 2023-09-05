package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    //Verify that the song is playing and the sound bar is moving
    public static void verifySongIsPlaying() {
        WebElement soundBars = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        Assert.assertTrue(soundBars.isDisplayed());
    }
    //Click on Play Button on Player Control
    public static void clickPlaySong() {
        WebElement playSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='play-btn']")));
        playSong.click();
    }
    //Click on the Next Song on Player Control
    public static void clickNextSongBtn() {
        WebElement playPanel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".side.player-controls")));
        playPanel.click();
    }

    //Click on OK when deleting a Playlist
    public static void clickOKPopUP() {
        WebElement clickOk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ok")));
        clickOk.click();
    }
    //Click on the X Playlist to delete playlist
    public static void clickDeletePlaylist() {
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[title='Delete this playlist']")));
        deletePlaylist.click();
    }
    //Select a Playlist if there is one available
    public static void clickPlaylist() {
        WebElement selectPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='playlist playlist']")));
        selectPlaylist.click();
    }

    public static void enterNewPlaylistName() {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL + "a", Keys.BACK_SPACE));
        playlistInputField.sendKeys("Newest Playlist");
        playlistInputField.sendKeys(Keys.ENTER);

    }



    public static void doubleClickPlaylist() {
        WebElement doubleClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='playlist playlist']")));

        actions.doubleClick(doubleClick).perform();




    }

}
