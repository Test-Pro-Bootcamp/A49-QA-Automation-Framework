import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    @Test
    public void Playlist(){
        String expectedPlaylistDeletedMessage = "Deleted playlist \"TestPro Playlist.\"";

        provideEmail("andrew.oleary@testpro.io");
        providePassword("te$t$tudent437");
        clickSubmit();
        //createPlaylist();
        renamePlaylist();
        openPlaylist();
        //clickDeletePlaylistBtn();
        //System.out.println(getDeletedPlaylistMsg());
        //getDeletedPlaylistMsg();
    }

    public void renamePlaylist(){
        Actions action = new Actions(driver);
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        action.moveToElement(playlist).doubleClick().perform();
        WebElement newPlaylistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        newPlaylistName.sendKeys(Keys.chord(Keys.LEFT_CONTROL,"A", Keys.BACK_SPACE));
        newPlaylistName.sendKeys("Test");
        newPlaylistName.sendKeys(Keys.RETURN);
    }

    public void openPlaylist(){
        WebElement emptyPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        emptyPlaylist.click();
    }

    public void createPlaylist(){
        WebElement createPlaylist = driver.findElement(By.cssSelector(".fa-plus-circle create creating"));
        createPlaylist.click();
        WebElement createNewPlaylist = driver.findElement(By.cssSelector("playlist-context-menu-create-simple"));
        createNewPlaylist.click();
    }

    public void clickDeletePlaylistBtn(){
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
