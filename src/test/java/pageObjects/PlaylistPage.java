//package pageObjects;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.Assert;
//public class PlaylistPage extends BasePage{
//    public PlaylistPage(WebDriver driver) {
//        super(driver);
//    }
//    String newPlaylistName ="My new playlist name";
//    private By selectNewOption = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");
//    private By clickAddPlaylist = By.cssSelector("#playlists .fa");
//    public PlaylistPage createPlaylist() {
//        clickAddPlaylist();
//        selectNewOption();
//        newPlaylist(randomName);
//        return this;
//    }
//    public void clickAddPlaylist() {
//        WebElement addPlaylist = wait.until(ExpectedConditions.elementToBeClickable(clickAddPlaylist));
//        actions.doubleClick(addPlaylist).perform();
//    }
//    public void selectNewOption () {
//        WebElement selectNew = wait.until(ExpectedConditions.elementToBeClickable(selectNewOption));
//        actions.doubleClick(selectNew).perform();
//    }
//    public void newPlaylist (String randomName) {
//        WebElement inputNewPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainWrapper [name='name']")));
//        inputNewPlaylist.clear();
//        inputNewPlaylist.sendKeys(randomName);
//        inputNewPlaylist.sendKeys(Keys.ENTER);
//    }
//    public PlaylistPage doubleClickPlaylist() {
//        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + randomName + "')]")));
//        actions.doubleClick(playlistElement).perform();
//        return this;
//    }
//    public PlaylistPage enterNewPlaylistName() {
//        WebElement playListInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
//        playListInputField.sendKeys(Keys.chord(Keys.COMMAND,"A", Keys.BACK_SPACE));
//        playListInputField.sendKeys(newPlaylistName);
//        playListInputField.sendKeys(Keys.ENTER);
//        return this;
//    }
//    public void playlistUpdatedMsg(){
//        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Updated playlist')]")));
//        Assert.assertEquals("Updated playlist \""+newPlaylistName+".\"",notification.getText());
//    }
//}