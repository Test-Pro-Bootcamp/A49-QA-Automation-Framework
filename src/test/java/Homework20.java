import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework20 extends BaseTest {
    @Test (dataProvider = "User Credentials")
    public void deletePlaylist(String email, String password) {
        loginToKoelWithDataProvider(email, password);

        String myNewPlaylist = "My New Playlist";
        createPlaylist(myNewPlaylist);
        String expectedMessage = "Created playlist \"" + myNewPlaylist + ".\"";
        Assert.assertEquals(verifySuccessNotification(), expectedMessage);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        wait.until(ExpectedConditions.invisibilityOf(notification));

        deleteCreatedPlaylist();

        WebElement notificationMessage = driver.findElement(By.cssSelector("div.success.show"));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.visibilityOf(notificationMessage));

        String expectedMsg = "Deleted playlist \"" + myNewPlaylist + ".\"";
        Assert.assertEquals(verifySuccessNotification(), expectedMsg);
    }


    public void createPlaylist(String myNewPlaylist) {
        //Added explicit waits for cssSelector
        String newPlaylistButton = "#playlists .fa.fa-plus-circle.create";
        clickOnElement(By.cssSelector(newPlaylistButton));

        String newPlaylistOption = ".menu.playlist-menu li:nth-child(1)";
        clickOnElement(By.cssSelector(newPlaylistOption));

        WebElement playlistTitleInput = driver.findElement(By.cssSelector("input[name='name']"));
        playlistTitleInput.sendKeys(myNewPlaylist);
        playlistTitleInput.sendKeys(Keys.RETURN);
    }

    public void clickOnElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
    }

    public String verifySuccessNotification() {
        WebElement notificationMessage = driver.findElement(By.cssSelector("div.success.show"));
        return notificationMessage.getText();
    }

    public void deleteCreatedPlaylist() {
        WebElement playlistToDelete = driver.findElement(By.cssSelector("#playlists li:nth-child(3)"));
        playlistToDelete.click();
        WebElement deletePlaylistButton = driver.findElement(By.cssSelector(".del.btn-delete-playlist"));
        deletePlaylistButton.click();
    }
}
