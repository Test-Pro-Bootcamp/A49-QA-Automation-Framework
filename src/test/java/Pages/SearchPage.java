package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.UUID;

public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }
    public void enterSongIntoSearchField() {
        enterText(By.cssSelector("input[type='search']"), "Dark Days");
    }
    public void clickViewAll () {
        WebElement viewAllBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='view-all-songs-btn']")));
        viewAllBtn.click();
    }
    public void clickOnSongTitle () {
        WebElement songTitle = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".search-results .song-item .title")));
        songTitle.click();
    }
    //Method clicks on ADDToo Btn
    public void addTooBtn () {
        WebElement addTooBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-add-to")));
        addTooBtn.click();
    }
    //Creates a Unique playlist for every test
    public void enterUniquePlaylist() {
        enterText(By.cssSelector("#songResultsWrapper [data-test='new-playlist-name"), getRandomString());
    }
    //CLick submit btn
    public void clickSubmitBtn() {
        WebElement submitBtn = driver.findElement(By.cssSelector("#songResultsWrapper [type='submit']"));
        submitBtn.click();
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