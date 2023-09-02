import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{

    String playlistName = getRandomString(10);
    String newPlaylistName = "New" + playlistName;
    @Test
    public void renamePlaylist(){
        navigateToPage();
        provideEmail("svitlana.shkribliak@testpro.io");
        providePassword("te$t$tudent49");
        clickSubmit();
        clickPlusBtn();
        clickNewPlayListBtn();
        enterText(By.cssSelector("[name='name']"), playlistName);
        clickPlayList();
        doubleClickPlayList();
        enterNewPlayListName();
        playlistIsRenamed();
    }



    private void enterText(By inputLocator, String inputText) {
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(inputLocator));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(inputText, Keys.ENTER);
    }
    private void clickNewPlayListBtn() {
        WebElement newPlayListBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
        newPlayListBtn.click();
    }

    private void clickPlusBtn() {
        WebElement plusBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='sidebar-create-playlist-btn']")));
        plusBtn.click();
    }


}
