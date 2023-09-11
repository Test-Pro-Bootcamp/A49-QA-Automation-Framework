import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CreatePlaylist extends BaseTest {


    @Test
    public void createPlaylist() {
        loginPage.loginWithCorrectCredentials();
        playlistPage.clickCreatePlaylistBtn();
       playlistPage. doubleClickPlayList();
       playlistPage. enterNewPlaylist();
        playlistPage.clickOnNewPlayList();


    }
//    public void doubleClickPlayList() {
//        WebElement doubleClickPlayList=  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists nav ul li:nth-child(1)")));
//        actions.doubleClick(doubleClickPlayList).perform();
//    }
//
//    public void clickCreatePlaylistBtn() {
//        WebElement clickCreatePlaylistBtn =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sidebar-create-playlist-btn']")));
//        actions.moveToElement(clickCreatePlaylistBtn).perform();
//        actions.doubleClick(clickCreatePlaylistBtn).perform();
//
//    }
//    public void enterNewPlaylist() {
//        WebElement newPlayListName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ name='name']")));
//        newPlayListName.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
//        newPlayListName.sendKeys("GreatPlaylist");
//        newPlayListName.sendKeys(Keys.ENTER);
//
//    }
//
//    public void clickOnNewPlayList() {
//        WebElement newPlayList =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists  li:nth-child(3) a")));
//        actions.moveToElement(newPlayList).perform();
//    }
    }

