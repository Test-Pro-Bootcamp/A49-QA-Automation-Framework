import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Homework20 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        loginCorrectCred();
        clickSubmit();
        clickOnPlaylist();
        clickOnDeletePlaylistBtn();
        clickOnOk();
        checkShowSuccess();
    }

    private void clickOnOk() {
        WebElement okBtn = driver.findElement(By.cssSelector(".ok"));
        okBtn.click();
    }

    private void clickOnDeletePlaylistBtn() {

        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector(".del.btn-delete-playlist")));
        deletePlaylistBtn.click();
    }

    private void clickOnPlaylist() {

        WebElement playlist = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        playlist.click();
    }
    private void checkShowSuccess() {

        WebElement notification = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector("div.success.show")));
        Assert.assertTrue(notification.isDisplayed());

           }




}
