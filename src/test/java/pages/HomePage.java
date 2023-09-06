package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage (WebDriver driver) {
        super(driver);
    }
    public String myNewPlaylist;
    public String newPlaylistTitle;

    public void updatePlaylistTitle(String newPlaylistTitle) {
        WebElement inputFieldWithTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        inputFieldWithTitle.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        inputFieldWithTitle.sendKeys(Keys.DELETE);
        inputFieldWithTitle.sendKeys(newPlaylistTitle);
        inputFieldWithTitle.sendKeys(Keys.ENTER);
    }

    public void doubleClickOnPlaylist() {
        //WebElement listToUpdate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//*[contains(text(), '" + myNewPlaylist + "')]")));
        WebElement listToUpdate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//li[@class='playlist playlist']")));
        //*[@id="playlists"]/ul/li[3]/a
        Actions actions = new Actions(driver);
        actions.doubleClick(listToUpdate).perform();
    }

    public void deleteCreatedPlaylist() {
        //WebElement listToDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//*[contains(text(), '" + newPlaylistTitle + "')]")));
        WebElement listToDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//li[@class='playlist playlist']")));
        //WebElement listToDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists li:nth-child(3)")));
        listToDelete.click();
        WebElement deletePlaylistButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".del.btn-delete-playlist")));
        deletePlaylistButton.click();
        WebElement okButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.alertify > div > div > nav > button.ok")));
        okButton.click();
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
        //WebElement listButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='songResultsWrapper']//li[contains(text(), '" + myNewPlaylist + "')]")));
        //WebElement listButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlistWrapper\"]/header/div[3]/div/section[1]/ul/li[5]")));
        ////*[@id="playlistWrapper"]/header/div[3]/div/section[1]/ul/li[5]
        WebElement listButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section #songResultsWrapper section.existing-playlists li.playlist")));
        //#songResultsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li.playlist
        Actions action = new Actions(driver);
        action.moveToElement(listButton);
        listButton.click();
    }


    public void addSongToPlayList(String song) {
        searchForSong(song);
        clickViewAllButton();
        findFirstSongInResults();
        clickAddToButton();
        addSongToMyNewPlaylist();
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
        //WebElement notificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        WebElement notificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        //WebElement notificationMessage = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMessage.getText();
    }
}
