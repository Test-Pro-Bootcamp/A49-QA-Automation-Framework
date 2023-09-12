package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PlaylistPage extends BasePage {

    @FindBy(css = "[data-testid='sidebar-create-playlist-btn']")
    WebElement createNewPlaylistBtn;
    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    WebElement clickOnCreateNewPlaylist;
    @FindBy(xpath = "//*[contains(text(),'Created playlist')]")
    WebElement notification;
    @FindBy(css = "[name='name']")
    WebElement playlistInputField;

    public PlaylistPage(WebDriver driver) {

        super(driver);
    }

    public PlaylistPage enterNewPlayListName(String newPlaylistName) {
        wait.until(ExpectedConditions.visibilityOf(playlistInputField));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName, Keys.ENTER);
        return this;

    }

    public PlaylistPage playlistIsCreated(String playListName) {
        wait.until(ExpectedConditions.visibilityOf(notification));
        Assert.assertEquals("Created playlist \"" + playListName + ".\"", notification.getText());
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

}
