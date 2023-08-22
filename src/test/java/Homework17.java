import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{
    @Test
    public void addSongToPlaylist() throws InterruptedException{
        //Login Method
        openLoginUrl();
        enterEmail("emiliano.castillo@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();

        searchForSong();
        Thread.sleep(1000);
        clickViewAll();
        clickFirstSong();
        addToo();
        addToPlayList();

        Thread.sleep(2000);
        WebElement verifyMessage = driver.findElement(By.cssSelector(".alertify-logs"));
        Assert.assertEquals(verifyMessage.getText(), "Added 1 song into \"NICE.\"");
        Thread.sleep(2000);
    }
}
