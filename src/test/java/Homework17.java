import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test(description = "Homework 17 - addSongToPlaylist")
    public void addSongToPlaylist() {
        loginWithCorrectCreds();
        enterSongIntoSearchInput();
        clickViewAllBtn();
        clickOnSongTitle();
        clickOnAddToBtn();
        enterNewUniquePlaylistName();
        verifySuccessMessage();
        getAddToPlaylistMessage();
    }

    public void verifySuccessMessage() {
        WebElement successBanner = driver.findElement(By.cssSelector(".success"));
        Assert.assertTrue(successBanner.isDisplayed());
    }

    public void enterNewUniquePlaylistName() {
        enterText(By.cssSelector("#songResultsWrapper [data-test='new-playlist-name']"), generateRandomName());
        WebElement submitBtn =  driver.findElement(By.cssSelector("#songResultsWrapper [type='submit']"));
        submitBtn.click();
    }

    public void clickOnAddToBtn() {
        WebElement addToBtn = driver.findElement(By.cssSelector(".btn-add-to"));
        addToBtn.click();
    }

    public void clickOnSongTitle() {
        WebElement songTitle = driver.findElement(By.cssSelector(".search-results .song-item .title"));
        songTitle.click();
    }

    public void enterSongIntoSearchInput() {
        enterText(By.cssSelector("[type='search']"), "Reactor");
    }

    public void clickViewAllBtn() {
        WebElement viewAllBtn = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }

    public void getAddToPlaylistMessage(){
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
    }

}
