import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    String playListName ;
    @BeforeClass
    void login() {
        loginCorrectCred();
        playListName = "TestPro";
    }
    @Test
    public void renamePlaylist()  {
        doubleClickOnPlaylist(playListName);
        playListName ="Updated"+ playListName;
        enterNewPlaylistName(playListName);
        checkMessage();
    }
    private void clickOnPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        playlist.click();
    }

    private void doubleClickOnPlaylist(String playlistName) {
        WebElement playlistElement =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + playlistName + "')]")));
        actions.doubleClick(playlistElement).perform();
    }
    private void enterNewPlaylistName(String newPlayListName) {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlayListName);
        playlistInputField.sendKeys(Keys.ENTER);
    }
    private void checkMessage() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Updated playlist')]")));
        Assert.assertEquals("Updated playlist \""+playListName+".\"",notification.getText());
    }
}