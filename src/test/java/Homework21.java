import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    //homework21-rename playlist
    String newPlaylistName = "New Playlist Name";

    @Test
    public void renamePlaylist(){
        String updatedPlaylistMsg = "Updated Playlist \"New Playlist Name.\"";
        provideEmail("elena.min@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        doubleClickPlaylist();
        enterNewPlaylistName();
        getRenamePlaylistSuccessMsg();

        //Assert.assertEquals(getDeletedPlaylistMsg(),updatedPlaylistMsg);
    }

    public void doubleClickPlaylist(){
        WebElement playlistElement =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }

    public void enterNewPlaylistName(){
        WebElement playlistInputField =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"A", Keys.BACK_SPACE));

        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg(){
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show"))); //HW20
        return notificationMsg.getText();
    }




//    //Homework 20
//    @Test
//    public void deletePlaylist() {
//
//        String expectedPlaylistDeleteMessage = "Deleted playlist \"Playlist PUT.\"";
//
//        provideEmail("elena.min@testpro.io");
//        providePassword("te$t$tudent");
//        clickSubmit();
//        openPlaylist();
//        clickDeletePlaylistBtn();
//        Assert.assertEquals(getDeletedPlaylistMsg(),expectedPlaylistDeleteMessage);
//    }
//
//    public void openPlaylist(){
//        //WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
//        WebElement emptyPlaylist =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)"))); //HW20
//        emptyPlaylist.click();
//    }
//
//    public void  clickDeletePlaylistBtn(){
//        //WebElement deletePlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
//        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist"))); //HW20
//        deletePlaylist.click();
//        //Thread.sleep((2000));
//    }
//
//    public String getDeletedPlaylistMsg(){
//        //WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
//        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show"))); //HW20
//        return notificationMsg.getText();
//    }
}
