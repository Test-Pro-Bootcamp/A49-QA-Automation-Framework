package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //Verify that the song is playing and the sound bar is moving

    @FindBy(css = "[data-testid='sound-bar-play']")
    private WebElement soundBars;
    @FindBy (css = "[data-testid='play-btn']")
    private WebElement playSong;
    @FindBy (css = ".side.player-controls")
    private WebElement playPanel;
    @FindBy (css = ".ok")
    private WebElement clickOk;
    @FindBy (css = "button[title='Delete this playlist']")
    private WebElement deletePlaylist;
    @FindBy (css = "[class='playlist playlist']")
    private WebElement selectPlaylist;
    @FindBy (css = "[name='name']")
    private WebElement playListInputField;
    @FindBy (css = "[class='playlist playlist']")
    private WebElement doubleClick;

    public HomePage verifySongIsPlaying() {
        wait.until(ExpectedConditions.visibilityOf(soundBars));
        Assert.assertTrue(soundBars.isDisplayed());
        return this;
    }
    //Click on Play Button on Player Control
    public HomePage clickPlaySong() {
        wait.until(ExpectedConditions.elementToBeClickable(playSong));
        playSong.click();
        return this;
    }
    //Click on the Next Song on Player Control
    public  HomePage clickNextSongBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(playPanel));
        playPanel.click();
        return this;
    }

    //Click on OK when deleting a Playlist
    public HomePage clickOKPopUP() {
        wait.until(ExpectedConditions.elementToBeClickable(clickOk));
        clickOk.click();
        return this;
    }
    //Click on the X Playlist to delete playlist
    public HomePage clickDeletePlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(deletePlaylist));
        deletePlaylist.click();
        return this;
    }
    //Select a Playlist if there is one available
    public HomePage clickPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(selectPlaylist));
        selectPlaylist.click();
        return this;
    }

    public HomePage enterNewPlaylistName() {
        wait.until(ExpectedConditions.elementToBeClickable(playListInputField));
        playListInputField.sendKeys(Keys.chord(Keys.CONTROL + "a", Keys.BACK_SPACE));
        playListInputField.sendKeys("Newest Playlist");
        playListInputField.sendKeys(Keys.ENTER);
        return this;

    }



    public HomePage doubleClickPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(doubleClick));
        actions.doubleClick(doubleClick).perform();
        return this;




    }

}
