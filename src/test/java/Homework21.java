import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;



public class Homework21 extends BaseTest{
    String newPlaylistName = "Sample Playlist";
    public void renamePlaylist(){
        String updatedPlaylistMsg = "Updated playlist \"Sample Edited Playlist.\"";

        provideEmail("andrew.oleary@testpro.io");
        providePassword("te$t$tudent437");
        clickSubmit();
        doubleClickPlaylist();
        enterNewPlaylistName();
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);
    }

    private void doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }

    private void enterNewPlaylistName() {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    private String getRenamePlaylistSuccessMsg() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
}
