package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SongsPage extends BasePage{
    public SongsPage(WebDriver driver) {
        super(driver);
    }
    BasePage basePage = new BasePage(driver);
    @FindBy(css =".playback")
    WebElement playbackBtn;
    @FindBy(css = "input[placeholder='Press F to search']")
    WebElement searchBar;
    @FindBy(css = "button[data-test='view-all-songs-btn']")
    WebElement viewAll;
    @FindBy(css = ".search-results .song-item .title")
    WebElement firstSong;
    @FindBy(css = ".btn-add-to")
    WebElement addTo;
    @FindBy(css = "section[id='songResultsWrapper'] input[placeholder='Playlist name']")
    WebElement newPlaylist;
    @FindBy(css = "#songResultsWrapper [type='submit']")
    WebElement miniSave;

    public SongsPage contextClickSongByName(String songName)  {
        WebElement song =wait.until(ExpectedConditions.
                elementToBeClickable(By.xpath("//section[@id='songsWrapper']//td[text()='"+songName+"']")));
        actions.contextClick(song).perform();
        return this;
    }
    public SongsPage clickPlay() {
        wait.until(ExpectedConditions.elementToBeClickable(playbackBtn)).click();
        return this;
    }
    public SongsPage searchSong(){
        wait.until(ExpectedConditions.elementToBeClickable(searchBar)).click();
        return this;
    }
    public SongsPage enterTitleIntoSearch(){
        enterText(By.cssSelector("input[type='search']"), "BossStatus");
        return this;
    }
    public SongsPage allResults(){
        wait.until(ExpectedConditions.elementToBeClickable(viewAll)).click();
        return this;
    }
    public SongsPage songResult(){
        wait.until(ExpectedConditions.elementToBeClickable(firstSong)).click();
        return this;
    }
    public SongsPage addButton(){
        wait.until(ExpectedConditions.elementToBeClickable(addTo)).click();
        return this;
    }
    public SongsPage createPlaylist(){
        wait.until(ExpectedConditions.elementToBeClickable(newPlaylist)).click();
        wait.until(ExpectedConditions.visibilityOf(newPlaylist)).sendKeys(basePage.castRandomName());
        wait.until(ExpectedConditions.elementToBeClickable(miniSave)).click();
        return this;
    }
}
