import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.TimeoutException;

public class Homework20 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        loginCorrectCred();
        clickSubmit();
        //Thread.sleep(5000);
        clickOnPlaylist();
        // Thread.sleep(1000); //
        clickOnDeletePlaylistBtn();
        //clickOnOk();
       // Thread.sleep(1000);
        checkShowSuccess();
    }
    private void clickOnPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        playlist.click();
    }

    private void clickOnDeletePlaylistBtn() {
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".del.btn-delete-playlist")));
        deletePlaylistBtn.click();
    }
    //private void clickOnOk() {
       // WebElement okBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ok")));
      //  okBtn.click();
    //}

    private void checkShowSuccess() {
        WebElement notification = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.success.show")));
        Assert.assertTrue(notification.isDisplayed());
    }

}