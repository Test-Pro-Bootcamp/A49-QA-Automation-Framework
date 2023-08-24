import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist(){

        navigateToPage();
        provideEmail("svitlana.shkribliak@testpro.io");
        providePassword("te$t$tudent49");
        clickSubmit();
        clickPlaylist();
        if(!deleteButtonExists()){
            clickPlusIcon();
            clickNewPlaylistBtn();
            clickInputPlaylistName();

        }
        clickDeletePlaylistBtn();


    }

    private void clickInputPlaylistName() {
        WebElement inputField = driver.findElement(By.cssSelector("[name='name']"));
        inputField.click();
    }

    private void clickNewPlaylistBtn() {
        WebElement newPlaylist = driver.findElement(By.cssSelector("playlist-context-menu-create-simple"));
        newPlaylist.click();
    }

    private void clickPlusIcon() {
        WebElement plusIcon = driver.findElement(By.cssSelector("[data-testid='sidebar-create-playlist-btn']"));
        plusIcon.click();
    }

    private Boolean deleteButtonExists() {
        WebElement deleteBtn = driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        Assert.assertTrue(deleteBtn.isDisplayed());
        return true;
    }

    private void clickDeletePlaylistBtn() {
        WebElement deletePlaylist = driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        deletePlaylist.click();
    }

    private void clickPlaylist() {
        WebElement playlist = driver.findElement(By.cssSelector("#playlists li:nth-child(3)"));
        playlist.click();
    }

}
