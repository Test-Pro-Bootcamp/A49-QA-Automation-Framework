package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {

    public HomePage (WebDriver givenDriver) {

        super(givenDriver);
    }

    @FindBy (css = ".playlist:nth-child(3)")
    private WebElement firstPlaylist;
    @FindBy (css = "[name='name']")
    private WebElement playlistNameField;
    @FindBy (css = "div.success.show")
    private WebElement renamePlaylistSuccessMsg;

     public HomePage doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.elementToBeClickable(firstPlaylist));
        actions.doubleClick(playlistElement).build().perform();
        return this;
     }

    public HomePage enterNewPlaylistName (String playlistName) {
        playlistNameField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistNameField.sendKeys(playlistName);
        playlistNameField.sendKeys(Keys.ENTER);
        return this;
    }

    public String getRenamePlaylistSuccessMsg(){
         findElement(renamePlaylistSuccessMsg);
        return renamePlaylistSuccessMsg.getText();

    }
}