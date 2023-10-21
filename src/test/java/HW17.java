import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HW17 extends BaseTest {
    public void addSongsToPlaylist() {
        loginWithCorrectCredentials();
        isAvatarDisplayed();

        enterText(By.cssSelector("[type='search']"), "Reactor");
        //click View all button
        WebElement viewAllBtn = driver.findElement(By.cssSelector("data-test=['view-all-songs-btn']");
        viewAllBtn.click();
        //click Search result
        WebElement clickOnSearchIcon = driver.findElement(By.cssSelector(".search-results .song-item .title"));
        clickOnSearchIcon.click();
        //click add to
        WebElement addToBtn = driver.findElement(By.cssSelector("#songResultsWrapper .btn-add-to");
        addToBtn.click();
        enterNewPlaylist();
        clickOnCreateBtn();

    }

    private void clickOnCreateBtn() {
        WebElement clickOnCreateBtn = driver.findElement(By.cssSelector("#songsWrapper [type='submit");
        clickOnCreateBtn.click();

    }

    private void enterNewPlaylist() {
        enterText(By.cssSelector("#playlistWrapper [type='text']"), getRandomString());
    }


    public void clickAddToButton() {
        WebElement clickAddToButton = driver.findElement(By.cssSelector("[class='btn-add-to']"));
        clickAddToButton.click();
    }

}
