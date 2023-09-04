package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.UUID;

public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy ( css = "[data-test='view-all-songs-btn']")
    WebElement viewAllBtn;
    @FindBy ( css = ".search-results .song-item .title")
    WebElement clickSong;
    @FindBy ( css = ".btn-add-to")
    WebElement addBtn;
    @FindBy ( css = "#songResultsWrapper [type='submit']")
    WebElement submitBtn;
//    By clickViewAll = By.cssSelector("[data-test='view-all-songs-btn']");
//    By clickOnSongTitle = By.cssSelector(".search-results .song-item .title");
//    By addTooBtn = By.cssSelector(".btn-add-to");
//    By clickSubmitBtn = By.cssSelector("#songResultsWrapper [type='submit']");
    public SearchPage enterSongIntoSearchField() {
        enterText(By.cssSelector("input[type='search']"), "Dark Days");
        return this;
    }
    public SearchPage clickViewAll () {
        wait.until(ExpectedConditions.elementToBeClickable(viewAllBtn)).click();
        return this;
    }
    public SearchPage clickOnSongTitle () {
        wait.until(ExpectedConditions.elementToBeClickable(clickSong)).click();
        return this;
    }
    //Method clicks on ADDToo Btn
    public SearchPage addTooBtn () {
        wait.until(ExpectedConditions.elementToBeClickable(addBtn)).click();
        return this;
    }
    //Creates a Unique playlist for every test
    public SearchPage enterUniquePlaylist() {
        enterText(By.cssSelector("#songResultsWrapper [data-test='new-playlist-name"), getRandomString());
        return this;
    }
    //CLick submit btn
    public SearchPage clickSubmitBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
        return this;
    }
    String getRandomString () {
        UUID uuid = UUID. randomUUID();
        return uuid.toString();
    }
    public void checkMsg () {
        WebElement verifyMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alertify-logs")));
        Assert.assertTrue(verifyMessage.isDisplayed());
    }
}