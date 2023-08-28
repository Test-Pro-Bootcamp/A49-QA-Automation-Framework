import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {


    @Test
    public void deletePlaylist() throws InterruptedException {
        String deletedMessage = "Deleted playlist \"homework19.\"";

        navigateToPage();
        provideEmail("natalia.kim01@testpro.io");
        providePassword("AxKrdBnS");
        clickSubmit();
        clickPlaylist();
        clickDeletePlayList();
        deletePlayListMessage();
        Assert.assertEquals(deletePlayListMessage(), deletedMessage);

    }

    private void clickPlaylist() {
        WebElement playList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(4)")));
        playList.click();

    }

    private void clickDeletePlayList()  {
        WebElement deleteList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
        deleteList.click();

    }

    private String deletePlayListMessage() {
        WebElement deleteMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return deleteMsg.getText();

    }

}