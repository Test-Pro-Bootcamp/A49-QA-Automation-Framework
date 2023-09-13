package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage (WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[name='name']")
    WebElement inputFieldWithTitle;
    @FindBy(xpath = "//section[@id='playlists']//li[@class='playlist playlist']")
    WebElement listToUpdate;

    @FindBy (xpath = "//section[@id='playlists']//li[@class='playlist playlist']" )
    WebElement listToDelete;
    @FindBy (css = ".del.btn-delete-playlist")
    WebElement deletePlaylistButton;
    @FindBy (css = "body > div.alertify > div > div > nav > button.ok")
    WebElement okButton;

    @FindBy (css = "[type='search']")
    WebElement searchField;

    @FindBy (css = "button[data-test='view-all-songs-btn']")
    WebElement viewAllButton;

    @FindBy (css = "section #songResultsWrapper section.existing-playlists li.playlist")
    WebElement listButton;

    @FindBy (xpath = "//*[@id='songResultsWrapper']//*[@class='song-list-controls']//*[@class='existing-playlists']//li[contains(text(), 'TestPro Playlist')]")
    WebElement testProPlaylist;

    @FindBy (xpath = "//div[@class='song-list-wrap main-scroll-wrap search-results']//table[@class='items']/tr[@class='song-item'][1]")
    WebElement firstSongInList;

    @FindBy (xpath = "//*[@id='songResultsWrapper']/header/div[3]/span/button[2]")
    WebElement addToButton;


    @FindBy (css = "div.success.show")
    WebElement notificationMessage;

    @FindBy (css = ".menu .songs")
    WebElement allSongsButton;

    @FindBy (css = "input[name='name']")
    WebElement playlistTitleInput;



    public HomePage updatePlaylistTitle(String newPlaylistTitle) {
        wait.until(ExpectedConditions.visibilityOf(inputFieldWithTitle));
        inputFieldWithTitle.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        inputFieldWithTitle.sendKeys(Keys.DELETE);
        inputFieldWithTitle.sendKeys(newPlaylistTitle);
        inputFieldWithTitle.sendKeys(Keys.ENTER);
        return this;
    }

    public HomePage doubleClickOnPlaylist() {
        wait.until(ExpectedConditions.visibilityOf(listToUpdate));
        Actions actions = new Actions(driver);
        actions.doubleClick(listToUpdate).perform();
        return this;
    }

    public HomePage deleteCreatedPlaylist() {

        wait.until(ExpectedConditions.visibilityOf(listToDelete));
        listToDelete.click();
        wait.until(ExpectedConditions.visibilityOf(deletePlaylistButton));
        deletePlaylistButton.click();
        wait.until(ExpectedConditions.visibilityOf(okButton));
        okButton.click();
        return this;
    }

    public HomePage searchForSong(String name) {
        wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.clear();
        searchField.sendKeys(name);
        return this;
    }

    public HomePage clickViewAllButton() {
        wait.until(ExpectedConditions.visibilityOf(viewAllButton));
        viewAllButton.click();
        return this;
    }

    public HomePage findFirstSongInResults() {
        wait.until(ExpectedConditions.visibilityOf(firstSongInList));
        firstSongInList.click();
        return this;
    }

    public HomePage clickAddToButton() {
        wait.until(ExpectedConditions.visibilityOf(addToButton));
        addToButton.click();
        return this;
    }

    public HomePage addSongToMyNewPlaylist() {
        wait.until(ExpectedConditions.visibilityOf(listButton));
        Actions action = new Actions(driver);
        action.moveToElement(listButton);
        listButton.click();
        return this;
    }

    public HomePage addSongToTestProPlaylist() {
        wait.until(ExpectedConditions.visibilityOf(listButton));
        Actions action = new Actions(driver);
        action.moveToElement(testProPlaylist);
        testProPlaylist.click();
        return this;
    }





    public HomePage createPlaylist(String myNewPlaylist) {
        String newPlaylistButton = "#playlists .fa.fa-plus-circle.create";
        clickOnElement(By.cssSelector(newPlaylistButton));

        //String newPlaylistOption = ".menu.playlist-menu li:nth-child(1)";
        clickOnElement(By.cssSelector(".menu.playlist-menu li:nth-child(1)"));

        playlistTitleInput.sendKeys(myNewPlaylist);
        playlistTitleInput.sendKeys(Keys.RETURN);
        return this;
    }

    public HomePage clickOnElement(By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        return this;
    }

    public String verifyNotificationMessage() {
        wait.until(ExpectedConditions.visibilityOf(notificationMessage));
        return notificationMessage.getText();
    }

    public HomePage clickAllSongs(){
        wait.until(ExpectedConditions.visibilityOf(allSongsButton));
        allSongsButton.click();
        return this;
    }









/*//without Page Factory
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
        WebElement listButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section #songResultsWrapper section.existing-playlists li.playlist")));
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
        WebElement notificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMessage.getText();
    }

    public void clickAllSongs(){
        WebElement allSongsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".menu .songs")));
        allSongsButton.click();
    }

 */


    /*public HomePage checkSongIsPlaying() {
        wait.until(ExpectedConditions.visibilityOf(soundBar));
        Assert.assertTrue(soundBar.isDisplayed());
        return this;
    }*/


}
