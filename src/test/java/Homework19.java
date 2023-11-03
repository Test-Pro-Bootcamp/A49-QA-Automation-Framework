import Pages.LoginPage;
import Pages.PlaylistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);

        loginPage.loginWithCorrectCredentials();

        playlistPage.newPlayList()
                    .deleteNewPlayList()
                    .notificationDeleteNewPlaylist();

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
//
//    }
//    public void notificationDeleteNewPlaylist(){
//        WebElement notificationDeleteNewPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
//        Assert.assertTrue(notificationDeleteNewPlaylist.isDisplayed());
//
//    }
}
