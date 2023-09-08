package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {

    public HomePage (WebDriver givenDriver) {
        super(givenDriver);
    }


    @FindBy (css = ".playlist:nth-child(3)")
    WebElement firstPlaylist;
    @FindBy (css = "[name='name']");
    WebElement playlistNameField;
    @FindBy (css = "div.success.show");
    WebElement renamePlaylistSuccessMsg;

     public HomePage doubleClickPlaylist() {
         wait.until(ExpectedConditions.elementToBeClickable(firstPlaylist)).doubleClick();
        return this; }

    public HomePage enterNewPlaylistName (String playlistName){
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg(){
        return findElement(renamePlaylistSuccessMsg).getText();

    }
}