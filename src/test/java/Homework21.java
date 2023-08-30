import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.UUID;

public class Homework21 extends BaseTest {

    String newPlaylistName ="My new playlist name";
    String randomName = generateRandomName();
    @Test
    public void renamePlaylist() {
        openLoginUrl();
        loginWithCorrectCred();
        createPlaylist();
        doubleClickPlaylist(randomName);
        enterNewPlaylistName();
        playlistUpdatedMsg();
    }
    public void doubleClickPlaylist(String randomName) {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + randomName + "')]")));
        actions.doubleClick(playlistElement).perform();
    }
    public void createPlaylist() {
        clickAddPlaylist();
        selectNewOption();
        newPlaylist(randomName);
    }
    public void enterNewPlaylistName() {
        WebElement playListInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playListInputField.sendKeys(Keys.chord(Keys.COMMAND,"A", Keys.BACK_SPACE));
        playListInputField.sendKeys(newPlaylistName);
        playListInputField.sendKeys(Keys.ENTER);

        WebElement verifyString = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        Assert.assertTrue(verifyString.isDisplayed(), newPlaylistName);
    }
    public void playlistUpdatedMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Updated playlist')]")));
        Assert.assertEquals("Updated playlist \""+newPlaylistName+".\"",notification.getText());
    }
    public String generateRandomName () {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
