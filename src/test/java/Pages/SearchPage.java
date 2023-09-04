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
    public void enterSongIntoSearchField() {
        enterText(By.cssSelector("input[type='search']"), "Dark Days");
    }
    public  void clickViewAll () {
        wait.until(ExpectedConditions.elementToBeClickable(viewAllBtn)).click();
    }
    public void clickOnSongTitle () {
        wait.until(ExpectedConditions.elementToBeClickable(clickSong)).click();
    }
    //Method clicks on ADDToo Btn
    public void addTooBtn () {
        wait.until(ExpectedConditions.elementToBeClickable(addBtn)).click();
    }
    //Creates a Unique playlist for every test
    public void enterUniquePlaylist() {
        enterText(By.cssSelector("#songResultsWrapper [data-test='new-playlist-name"), getRandomString());
    }
    //CLick submit btn
    public void clickSubmitBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
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