import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() {
        openLoginUrl();
        loginWithCorrectCred();
        enterSongIntoSearchField();
        clickViewAll();
        clickOnSongTitle();
        addTooBtn();
        enterUniquePlaylist();
        clickSubmitBtn();

        WebElement verifyMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alertify-logs")));
        Assert.assertTrue(verifyMessage.isDisplayed());
    }
    //This method takes the enterText method to search for inputText "Dark Days"
    public void enterSongIntoSearchField() {
        enterText(By.cssSelector("input[type='search']"), "Dark Days");
    }
    //Click view all btn
    public void clickViewAll () {
        WebElement viewAllBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='view-all-songs-btn']")));
        viewAllBtn.click();
    }
    //Method selects song Title
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
    private void clickSubmitBtn() {
        WebElement submitBtn = driver.findElement(By.cssSelector("#songResultsWrapper [type='submit']"));
        submitBtn.click();
    }
}
