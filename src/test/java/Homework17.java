import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{
    @Test
    public void addSongToPlaylist() throws InterruptedException{
        //Login Method
        loginWithCorrectCred();
        enterSongIntoSearchField();
        Thread.sleep(1000);
        clickViewAll();
        clickFirstSong();
        addToo();
        addToPlayList();

        WebElement verifyMessage = driver.findElement(By.cssSelector(".alertify-logs"));
        Assert.assertEquals(verifyMessage.getText(), "Added 1 song into \"NICE.\"");
        Thread.sleep(2000);
    }
}
