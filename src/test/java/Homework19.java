import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException{
        loginWithCorrectCred();
        clickPlaylist();
        clickDeleteBtn();

        Thread.sleep(3000);
        WebElement verifyMessage = driver.findElement(By.cssSelector(".alertify-logs"));
        Assert.assertEquals(verifyMessage.getText(), "Deleted playlist \"Cool.\"");

    }

    private void clickPlaylist() {
        WebElement clickAPlaylist = driver.findElement(By.xpath("//*[@id='playlists']//*[text()='Cool']"));
        clickAPlaylist.click();
    }
    private void clickDeleteBtn() {
        WebElement deleteBtn = driver.findElement(By.cssSelector(".del"));
        deleteBtn.click();
    }
}
