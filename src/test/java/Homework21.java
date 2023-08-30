import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    String playListName = "Homework21";

    @Test
    public void renamePlayList() {

        String updatePLMsg = "Updated playlist \"Homework21.\"";

        navigateToPage();
        provideEmail("natalia.kim01@testpro.io");
        providePassword("AxKrdBnS");
        clickSubmit();
        doubleClickPlaylist();
        enterNewPlayListName(playListName);
        Assert.assertEquals(playListMessage(), updatePLMsg);
    }

    public void doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(4)")));
        actions.doubleClick(playlistElement).perform();
    }

    public void enterNewPlayListName(String newPlayListName) {
        WebElement playListInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playListInputField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playListInputField.sendKeys(playListName);
        playListInputField.sendKeys(Keys.ENTER);
    }

    public String playListMessage() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
}