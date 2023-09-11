import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        loginPage.loginWithCorrectCredentials();
//        Thread.sleep(3000);
       playlistPage. newPlayList();
//        Thread.sleep(3000);
       playlistPage. deleteNewPlayList();
//        Thread.sleep(3000);
       playlistPage. notificationDeleteNewPlaylist();

    }

//    public void newPlayList(){
//        WebElement newPlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
//        newPlayList.click();
//
//    }
//    public void deleteNewPlayList(){
//        WebElement deletePlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".del.btn-delete-playlist")));
////        WebElement confirmDeleteCommand = driver.findElement(By.cssSelector(" body  :nth-child(7)  button.ok"));
//
//        deletePlayList.click();
////        confirmDeleteCommand.click();
//    }
//    public void notificationDeleteNewPlaylist(){
//        WebElement notificationDeleteNewPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
//        Assert.assertTrue(notificationDeleteNewPlaylist.isDisplayed());

    }



