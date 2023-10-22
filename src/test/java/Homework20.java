import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException{
        String expectedPlaylistDeletedMessage = "Deleted playlist \"TestPro Playlist.\"";

        provideEmail("andrew.oleary@testpro.io");
        providePassword("te$t$tudent437");
        clickSubmit();
        //createPlaylist();
        openPlaylist();
        clickDeletePlaylistBtn();
        //System.out.println(getDeletedPlaylistMsg());
        getDeletedPlaylistMsg();
    }

    public void openPlaylist(){
        //WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        WebElement emptyPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        emptyPlaylist.click();
    }

    public void createPlaylist() throws InterruptedException{
        WebElement createPlaylist = driver.findElement(By.cssSelector(".fa-plus-circle create creating"));
        createPlaylist.click();
        WebElement createNewPlaylist = driver.findElement(By.cssSelector("playlist-context-menu-create-simple"));
        createNewPlaylist.click();
    }

    public void clickDeletePlaylistBtn() throws InterruptedException{
        //WebElement deletePlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        WebElement deletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".del.btn-delete-playlist")));
        deletePlaylist.click();
        //Thread.sleep(2000);
    }

    public void getDeletedPlaylistMsg(){
        WebElement notification = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.success.show")));
        Assert.assertTrue(notification.isDisplayed());
    }


}
