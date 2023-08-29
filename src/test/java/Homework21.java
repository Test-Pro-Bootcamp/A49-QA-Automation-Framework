import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    String myNewPlaylist = "My New Playlist";
    String newPlaylistTitle = "Updated " + myNewPlaylist;

    @Test(priority = 1, dataProvider = "User Credentials", description = "Create new playlist with specific name")
    public void createPlaylist(String email, String password) {
        loginToKoelWithDataProvider(email, password);

        createPlaylist(myNewPlaylist);
        String expectedMessage = "Created playlist \"" + myNewPlaylist + ".\"";
        Assert.assertEquals(verifyNotificationMessage(), expectedMessage);
    }

    @Test(priority = 2, dataProvider = "User Credentials", description = "Add few songs to newly created playlist with specific name")
    public void addSongsPlaylist(String email, String password) {
        loginToKoelWithDataProvider(email, password);

        String expectedMsgForSongAdded = "Added 1 song into \"" + myNewPlaylist + ".\"";

        addSongToPlayList("Song");
        Assert.assertEquals(verifyNotificationMessage(), expectedMsgForSongAdded);

        addSongToPlayList("Reactor");
        Assert.assertEquals(verifyNotificationMessage(), expectedMsgForSongAdded);
        //addSongToPlayList("Take");
        //Assert.assertEquals(verifyNotificationMessage(), expectedMsgForSongAdded);
        //wait.until(ExpectedConditions.visibilityOf(notification));
    }

    @Test(priority = 2, dataProvider = "User Credentials", description = "Update title of created playlist")
    public void renamePlaylist(String email, String password) {
        loginToKoelWithDataProvider(email, password);
        doubleClickOnPlaylist();
        updatePlaylistTitle(newPlaylistTitle);
        String expectedMessage = "Updated playlist \"" + newPlaylistTitle + ".\"";
        Assert.assertEquals(verifyNotificationMessage(), expectedMessage);
    }


    @Test(priority = 3, dataProvider = "User Credentials", description = "Delete playlist with updated title")
    public void deletePlaylist(String email, String password) {
        loginToKoelWithDataProvider(email, password);
        deleteCreatedPlaylist();
        String expectedMessage = "Deleted playlist \"" + newPlaylistTitle + ".\"";
        Assert.assertEquals(verifyNotificationMessage(), expectedMessage);
    }

    public void updatePlaylistTitle(String newPlaylistTitle) {
        WebElement inputFieldWithTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        inputFieldWithTitle.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        inputFieldWithTitle.sendKeys(Keys.DELETE);
        inputFieldWithTitle.sendKeys(newPlaylistTitle);
        inputFieldWithTitle.sendKeys(Keys.ENTER);
    }

    public void doubleClickOnPlaylist() {
        WebElement listToUpdate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//*[contains(text(), '" + myNewPlaylist + "')]")));
        Actions actions = new Actions(driver);
        actions.doubleClick(listToUpdate).perform();
    }

    public void deleteCreatedPlaylist() {
        WebElement listToDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//*[contains(text(), '" + newPlaylistTitle + "')]")));
        //WebElement listToDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists li:nth-child(3)")));
        listToDelete.click();
        WebElement deletePlaylistButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".del.btn-delete-playlist")));
        deletePlaylistButton.click();
        WebElement okButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.alertify > div > div > nav > button.ok")));
        okButton.click();
    }

    public void addSongToPlayList(String song) {
        searchForSong(song);
        clickViewAllButton();
        findFirstSongInResults();
        clickAddToButton();
        addSongToMyNewPlaylist();
    }

    public void searchForSong(String name) {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='search']")));
        searchField.clear();
        searchField.sendKeys(name);
    }

    public void clickViewAllButton() {
        WebElement viewAllButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-test='view-all-songs-btn']")));
        viewAllButton.click();
    }

    public void findFirstSongInResults() {
        WebElement firstSongInList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='song-list-wrap main-scroll-wrap search-results']//table[@class='items']/tr[@class='song-item'][1]")));
        firstSongInList.click();
    }

    public void clickAddToButton() {
        WebElement addToButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/span/button[2]")));
        addToButton.click();
    }

    public void addSongToMyNewPlaylist() {
        WebElement listButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='songResultsWrapper']//li[contains(text(), '" + myNewPlaylist + "')]")));
        Actions action = new Actions(driver);
        action.moveToElement(listButton);
        listButton.click();
    }

    public void createPlaylist(String myNewPlaylist) {
        String newPlaylistButton = "#playlists .fa.fa-plus-circle.create";
        clickOnElement(By.cssSelector(newPlaylistButton));

        String newPlaylistOption = ".menu.playlist-menu li:nth-child(1)";
        clickOnElement(By.cssSelector(newPlaylistOption));

        WebElement playlistTitleInput = driver.findElement(By.cssSelector("input[name='name']"));
        playlistTitleInput.sendKeys(myNewPlaylist);
        playlistTitleInput.sendKeys(Keys.RETURN);
    }


    public void clickOnElement(By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
    }

    public String verifyNotificationMessage() {
        WebElement notificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMessage.getText();
    }

}
