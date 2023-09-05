package pages;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlaylistPage extends BasePage {

    public PlaylistPage(WebDriver driver) {
        super(driver);
    }
    //click on Search Field and enter a song title

    @FindBy (css = "input[placeholder='Press F to search']")
    WebElement searchInput;
    @FindBy (css = "button[data-test='view-all-songs-btn']" )
    WebElement viewAllBtn;
    @FindBy (xpath = "//*[@id='songResultsWrapper']/div/div/div[1]/table/tr[1]/td[2]" )
    WebElement clickSong;
    @FindBy (css = "[data-test='add-to-btn']")
    WebElement addToBtn;
    @FindBy (css = "section[id='songResultsWrapper'] input[placeholder='Playlist name']")
    WebElement newPlaylist;
    @FindBy (css = "section[id='songResultsWrapper'] button[title='Save']")
    WebElement saveBtn;
    public PlaylistPage enterSongIntoSearchField() {
        wait.until(ExpectedConditions.elementToBeClickable(searchInput));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys("Dark Days");
        return this;
    }
    //click on view all button
    public PlaylistPage clickViewAllBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(viewAllBtn));
        viewAllBtn.click();
        return this;
    }
    //click and highlight a song
    public PlaylistPage clickSongTitle() {
        wait.until(ExpectedConditions.elementToBeClickable(clickSong));
        clickSong.click();
        return this;
    }
    //add a song to a location
    public PlaylistPage clickAddToBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(addToBtn));
        addToBtn.click();
        return this;
    }
    //enter a playlist name
    public PlaylistPage enterPlaylistName() {
        wait.until(ExpectedConditions.elementToBeClickable(newPlaylist));
        newPlaylist.click();
        newPlaylist.clear();
        newPlaylist.sendKeys("Newest Hits");
        return this;
    }
    //click on save button
    public PlaylistPage clickSaveBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        saveBtn.click();
        return this;
    }
}
