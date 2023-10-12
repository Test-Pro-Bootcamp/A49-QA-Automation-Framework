package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.UUID;
public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    private By clickViewAll = By.cssSelector("[data-test='view-all-songs-btn']");
    private By clickOnSongTitle = By.cssSelector(".search-results .song-item .title");
    private By addTooBtn = By.cssSelector(".btn-add-to");
    private By clickSubmitBtn = By.cssSelector("#songResultsWrapper [type='submit']");
    public SearchPage enterSongIntoSearchField(String text) {
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='search']")));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);
        return this;
    }
    public SearchPage clickViewAll () {
        WebElement viewBtn = wait.until(ExpectedConditions.elementToBeClickable(clickViewAll));
        actions.click(viewBtn).perform();
        return this;
    }
    public SearchPage clickOnSongTitle () {
        WebElement songClick = wait.until(ExpectedConditions.elementToBeClickable(clickOnSongTitle));
        actions.click(songClick).perform();
        return this;
    }
    //Method clicks on ADDToo Btn
    public SearchPage addTooBtn () {
        wait.until(ExpectedConditions.elementToBeClickable(addTooBtn)).click();
        return this;
    }
    public SearchPage clickSubmitBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(clickSubmitBtn)).click();
        return this;
    }
    //Creates a Unique playlist for every test
    public SearchPage enterUniquePlaylist(String text) {
        WebElement uniquePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#songResultsWrapper [data-test='new-playlist-name")));
        uniquePlaylist.click();
        uniquePlaylist.click();
        uniquePlaylist.sendKeys(getRandomString());
        return this;
    }
    public SearchPage selectFavoritesOption () {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#songResultsWrapper li.favorites"))).click();
        return this;
    }
    //CLick submit btn
    public void selectFirstPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(3) > a"))).click();
    }
    String getRandomString () {
        UUID uuid = UUID. randomUUID();
        return uuid.toString();
    }
    public void checkMsg () {
        WebElement verifyMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alertify-logs")));
        Assert.assertTrue(verifyMessage.isDisplayed());
    }

    public void checkLikedIcon () {
        WebElement verifyIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#favoritesWrapper .item-container")));
        Assert.assertEquals(verifyIcon.getText(), "Lament");
    }

    public SearchPage clickFavoritesTab () {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.playlist.favorites"))).click();
        return this;
    }

    public void unlikeBtn () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#favoritesWrapper td.favorite > button"))).click();
    }
}