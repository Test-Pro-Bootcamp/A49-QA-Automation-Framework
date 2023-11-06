import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Instant;

public class Homework21 extends BaseTest {

String newPlaylistName = "Isisha Edited Playlist";

@Test
public void renamePlaylist() {

    String updatedPlaylistMsg = "Isisha playlist\ Isisha Edited Playlist.\"";

    provideEmail("isisha.andrews@testpro.io");
    providePassword("te$t$tudent");
    clickSubmit();
    doubleClickPlaylist();
    enterNewPlaylistName();
    public String getRenamePlaylistSuccessMsg Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);


    public void doubleCLickPlaylist () Instant wait = null;
    {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("playlist:nth-child(3)")));
        actions.doubleclick(playlistElement).perform();
    }

    public void enterNewPlaylistName () {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));

        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }


    () {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }


}

    private void enterNewPlaylistName() {

    }

    private void doubleClickPlaylist() {

    }


}
