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
    private void playlistIsRenamed() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Updated playlist \""+ newPlaylistName +".\"']")));
        Assert.assertTrue(notification.isDisplayed());
    }

    private void enterNewPlayListName() {
        WebElement playlistInputField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName, Keys.ENTER);

    }

    private void doubleClickPlayList() {
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text() = '" + playlistName + "']")));
        actions.doubleClick(playlist).perform();
    }

    private void clickPlayList() {
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text() = '" + playlistName + "']")));
        actions.contextClick(playlist).perform();
    }
}
