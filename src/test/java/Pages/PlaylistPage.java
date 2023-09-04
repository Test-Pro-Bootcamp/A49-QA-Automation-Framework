package Pages;

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
    String newPlaylistName ="My new playlist name";

//    By clickAddPlaylist = By.xpath("//*[@id='playlists']//*[@class=\"fa fa-plus-circle create\"]");
    By selectNewOption = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");
    public void createPlaylist() {
        clickAddPlaylist();
        selectNewOption();
        newPlaylist(randomName);
    }
    public void clickAddPlaylist() {
//        findElement(clickAddPlaylist).click();
        WebElement addPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid=\"sidebar-create-playlist-btn\"]")));
        actions.click(addPlaylist).perform();
    }
    public void selectNewOption () {
        findElement(selectNewOption).click();
//        WebElement selectNewPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
//        selectNewPlaylist.click();
    }
    public void newPlaylist (String randomName) {
        WebElement inputNewPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainWrapper [name='name']")));
        inputNewPlaylist.clear();
        inputNewPlaylist.sendKeys(randomName);
        inputNewPlaylist.sendKeys(Keys.ENTER);
    }
    public void doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + randomName + "')]")));
        actions.doubleClick(playlistElement).perform();
    }
    public void enterNewPlaylistName() {
        WebElement playListInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playListInputField.sendKeys(Keys.chord(Keys.COMMAND,"A", Keys.BACK_SPACE));
        playListInputField.sendKeys(newPlaylistName);
        playListInputField.sendKeys(Keys.ENTER);

        WebElement verifyString = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        Assert.assertTrue(verifyString.isDisplayed(), newPlaylistName);
    }
    public void playlistUpdatedMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Updated playlist')]")));
        Assert.assertEquals("Updated playlist \""+newPlaylistName+".\"",notification.getText());
    }
}
