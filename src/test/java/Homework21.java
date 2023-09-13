import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    String newPlaylistName = "Sample Edited Playlist2";//we may need to change the new playlist name (when running the test multiple times)

    @Test
    public void renamePlaylist()   {

        String updatedPlaylistMsg = "Updated playlist \"Sample Edited Playlist2.\""; // we may need to update the expected message too

        provideEmail("eric.stetson@testpro.io");
        providePassword("Testpro@2023");
        clickSubmit();
        doubleClickPlaylist();
        try{
            enterNewPlaylistName();
        }
        catch (Exception e){
            //Prints the error message
            System.out.println("Double click failed with the exception: " +e.getMessage());
            //Retry action
            System.out.println("Retrying...");
            doubleClickPlaylist();
            enterNewPlaylistName();
        }

        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);


    }

    public void doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));//added closing parenthesis
        actions.doubleClick(playlistElement).perform();


    }

    public void enterNewPlaylistName() {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"A", Keys.BACK_SPACE));

        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();

    }
}


