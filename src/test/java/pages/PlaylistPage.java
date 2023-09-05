package pages;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlaylistPage extends BasePage {

    public PlaylistPage(WebDriver driver) {
        super(driver);
    }
    //click on Search Field and enter a song title
    public static void enterSongIntoSearchField() {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Press F to search']")));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys("Dark Days");
    }
    //click on view all button
    public static void clickViewAllBtn() {
        WebElement viewAllBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-test='view-all-songs-btn']")));
        viewAllBtn.click();
    }
    //click and highlight a song
    public static void clickSongTitle() {
        WebElement clickSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='songResultsWrapper']/div/div/div[1]/table/tr[1]/td[2]")));
        clickSong.click();
    }
    //add a song to a location
    public static void clickAddToBtn() {
        WebElement addToBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='add-to-btn']")));
        addToBtn.click();
    }
    //enter a playlist name
    public static void enterPlaylistName() {
        WebElement newPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[id='songResultsWrapper'] input[placeholder='Playlist name']")));
        newPlaylist.click();
        newPlaylist.clear();
        newPlaylist.sendKeys("Newest Hits");
    }
    //click on save button
    public static void clickSaveBtn() {
        WebElement saveBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[id='songResultsWrapper'] button[title='Save']")));
        saveBtn.click();
    }
}
