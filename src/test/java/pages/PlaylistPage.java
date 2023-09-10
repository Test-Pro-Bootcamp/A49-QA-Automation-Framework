package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PlaylistPage extends BasePage{

    @FindBy(css = "[data-testid='sidebar-create-playlist-btn']")
    WebElement createNewPlaylistBtn;
    @FindBy (css = "[data-testid='playlist-context-menu-create-simple']")
    WebElement clickOnCreateNewPlaylist;
    @FindBy (xpath = "//*[contains(text(),'Created playlist')]")
    WebElement notification;
    @FindBy(css = "[name='name']")
    WebElement playlistInputField;
    public PlaylistPage(WebDriver driver) {

        super(driver);
    }

    public PlaylistPage playlistIsRenamed(String newPlaylistName) {
        WebElement notification = findElement(By.xpath("//*[contains(text(),'Updated playlist')]"));
        Assert.assertEquals("Updated playlist \""+newPlaylistName+".\"",notification.getText());
        return this;
    }

    public PlaylistPage enterNewPlayListName(String newPlaylistName) {
        wait.until(ExpectedConditions.visibilityOf(playlistInputField));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName, Keys.ENTER);
        return this;

    }

    public PlaylistPage playlistIsCreated(String playListName){
        wait.until(ExpectedConditions.visibilityOf(notification));
        Assert.assertEquals("Created playlist \""+playListName+".\"",notification.getText());
        return this;
    }

    public PlaylistPage doubleClickPlayList(String playlistName) {
        WebElement playlist = findElement(By.xpath("//*[text() = '" + playlistName + "']"));
        actions.doubleClick(playlist).perform();
        return this;
    }

public PlaylistPage clickOnCreateNewPlaylist() {
    wait.until(ExpectedConditions.visibilityOf(clickOnCreateNewPlaylist)).click();
    return this;
}

    public PlaylistPage clickOnNewPlaylistBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(createNewPlaylistBtn)).click();
        return this;
    }

    public PlaylistPage clickOnPlayList(String playlistName) {
        WebElement playlist = click(By.xpath("//*[text() = '" + playlistName + "']"));
        actions.click(playlist).perform();
        return this;
    }

    public PlaylistPage clickOnDeletePlaylistBtn(String playlistName){
        WebElement deletePlaylist = click(By.xpath("//button[@title='Delete this playlist']"));
        deletePlaylist.click();
        return this;
    }

    public PlaylistPage playlistIsDeleted(String playlistName){
        WebElement notification = findElement(By.xpath("//*[contains(text(),'Deleted playlist')]"));
        Assert.assertEquals("Deleted playlist \""+playlistName+".\"",notification.getText());
        return this;
    }

}
