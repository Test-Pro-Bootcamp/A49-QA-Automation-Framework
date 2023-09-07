package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PlaylistPage extends BasePage{
    public PlaylistPage(WebDriver driver) {

        super(driver);
    }

    public void playlistIsRenamed(String newPlaylistName) {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Updated playlist')]")));
        Assert.assertEquals("Updated playlist \""+newPlaylistName+".\"",notification.getText());
    }

    public void enterNewPlayListName(String newPlaylistName) {
        //String newPlaylistName = getRandomString(10);
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName, Keys.ENTER);

    }

    public void playlistIsCreated(String playListName){

        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Created playlist')]")));
        Assert.assertEquals("Created playlist \""+playListName+".\"",notification.getText());
    }

    public void doubleClickPlayList(String playlistName) {
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text() = '" + playlistName + "']")));
        actions.doubleClick(playlist).perform();
    }

public void clickOnCreateNewPlaylist() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"))).click();
}

    public void clickOnNewPlaylistBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sidebar-create-playlist-btn']"))).click();
    }

    public void clickOnPlayList(String playlistName) {
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text() = '" + playlistName + "']")));
        actions.click(playlist).perform();
    }

    public void clickOnDeletePlaylistBtn(String playlistName){
        WebElement deletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Delete this playlist']")));
        deletePlaylist.click();
    }

    public void playlistIsDeleted(String playlistName){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Deleted playlist')]")));
        Assert.assertEquals("Deleted playlist \""+playlistName+".\"",notification.getText());
    }

}
