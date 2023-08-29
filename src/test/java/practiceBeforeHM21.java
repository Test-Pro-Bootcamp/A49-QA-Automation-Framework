import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class practiceBeforeHM21 extends BaseTest {
    @Test (dataProvider = "User Credentials")
    public void playingSongFromMostPlayed(String email, String password) {
        loginToKoelWithDataProvider(email, password);

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement firstSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".top-song-list li:nth-child(1)")));
        actions.contextClick(firstSong).build().perform();

        WebElement playOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playback")));
        playOption.click();

        Assert.assertTrue(soundbarElement().isDisplayed());
    }

    @Test (dataProvider = "User Credentials")
    public void playingSongFromAllSongs(String email, String password) {
        loginToKoelWithDataProvider(email, password);
        chooseAllSongsList();
        contextClickFirstSong();
        choosePlayOption();
        Assert.assertTrue(soundbarElement().isDisplayed());
    }

    public void chooseAllSongsList() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement allSongsMenuItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".menu .songs")));
        allSongsMenuItem.click();
    }

    public void contextClickFirstSong() {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement firstSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".items .song-item")));
        actions.contextClick(firstSong).build().perform();
    }

    public void choosePlayOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement playOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playback")));
        playOption.click();
    }

    @Test (dataProvider = "User Credentials")
    public void hoverOverPlayButton(String email, String password){
        loginToKoelWithDataProvider(email, password);
        chooseAllSongsList();
        hoverPlay();
        Assert.assertTrue(hoverPlay().isDisplayed());

    }

    private WebElement hoverPlay() {
        WebElement playButton = driver.findElement(By.cssSelector(".play .fa.fa-play"));
        Actions actions = new Actions(driver); //should be somewhere in BaseTest???
        actions.moveToElement(playButton).perform();
        return driver.findElement(By.cssSelector(".play .fa.fa-play"));
        //return playButton;
    }

    public WebElement soundbarElement() {
        WebElement soundBar = driver.findElement(By.cssSelector(".wrapper .bars"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //should be somewhere in BaseTest???
        wait.until(ExpectedConditions.visibilityOf(soundBar));
        return soundBar;
    }

    @Test (dataProvider = "User Credentials")
    public void countSongsInPlaylist(String email, String password) throws InterruptedException {
        loginToKoelWithDataProvider(email, password);

        String myNewPlaylist = "My New Playlist";
        createPlaylist(myNewPlaylist);
        String expectedMessage = "Created playlist \"" + myNewPlaylist + ".\"";
        Assert.assertEquals(verifySuccessNotification(), expectedMessage);

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement notificationSuccess = driver.findElement(By.cssSelector("div.success.show"));
        wait.until(ExpectedConditions.invisibilityOf(notificationSuccess));


        addSongToPlayList("Song");
        String expectedMsgForSongAdded = "Added 1 song into \""+ myNewPlaylist +".\"";


        Assert.assertEquals(verifySongIsAddedToList(), expectedMsgForSongAdded);
        //WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        //wait.until(ExpectedConditions.invisibilityOf(notification));


        addSongToPlayList("Reactor");
        Assert.assertEquals(verifySongIsAddedToList(), expectedMsgForSongAdded);
        //wait.until(ExpectedConditions.invisibilityOf(notification));

        addSongToPlayList("Take");
        //Assert.assertEquals(verifySongIsAddedToList(), expectedMsgForSongAdded);
        //wait.until(ExpectedConditions.invisibilityOf(notification));

        WebElement homePage = driver.findElement(By.cssSelector(".menu .home"));
        homePage.click();

        choosePlaylistByName(myNewPlaylist);
        displayAllSongsInMyNewPlaylist();
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
    }

    public void addSongToPlayList(String song) throws InterruptedException {
        searchForSong(song);
        Thread.sleep(5000);
        clickViewAllButton();
        findFirstSongInResults();
        clickAddToButton();
        addSongToMyNewPlaylist();
    }

    public void searchForSong(String name) {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='search']")));
        searchField.clear();
        searchField.sendKeys(name);
    }

    public void clickViewAllButton(){
        //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        //WebElement viewAllButton = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        WebElement viewAllButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-test='view-all-songs-btn']")));
        viewAllButton.click();
    }
    public void findFirstSongInResults() {
        //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        //WebElement firstSongInList = driver.findElement(By.xpath("//div[@class='song-list-wrap main-scroll-wrap search-results']//table[@class='items']/tr[@class='song-item'][1]"));
        WebElement firstSongInList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='song-list-wrap main-scroll-wrap search-results']//table[@class='items']/tr[@class='song-item'][1]")));
        firstSongInList.click();
    }

    public void clickAddToButton() {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement addToButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/span/button[2]")));
        //WebElement addToButton = driver.findElement(By.xpath("//*[@id='songResultsWrapper']//li[contains(text(), 'Rock')]"));
        addToButton.click();
    }

    public void addSongToMyNewPlaylist() {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //WebElement rockButton = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/span/button[2]"));
        WebElement rockButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='songResultsWrapper']//li[contains(text(), 'My New Playlist')]")));
        Actions action = new Actions(driver);
        action.moveToElement(rockButton);
        rockButton.click();
    }



    public void createPlaylist(String myNewPlaylist) {
        //Added explicit waits for cssSelector
        String newPlaylistButton = "#playlists .fa.fa-plus-circle.create";
        clickOnElement(By.cssSelector(newPlaylistButton));

        String newPlaylistOption = ".menu.playlist-menu li:nth-child(1)";
        clickOnElement(By.cssSelector(newPlaylistOption));

        WebElement playlistTitleInput = driver.findElement(By.cssSelector("input[name='name']"));
        playlistTitleInput.sendKeys(myNewPlaylist);
        playlistTitleInput.sendKeys(Keys.RETURN);
    }

    public void clickOnElement(By locator){
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
    }

    public String verifySuccessNotification() {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        //WebElement notificationMessage = driver.findElement(By.cssSelector("div.success.show"));
        WebElement notificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMessage.getText();
    }

    public String verifySongIsAddedToList() {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        //WebElement notificationMessage = driver.findElement(By.cssSelector("div.success.show"));
        WebElement notificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMessage.getText();
    }

    public void choosePlaylistByName(String playlist){
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //WebElement myNewPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='songResultsWrapper']//li[contains(text(), 'My New Playlist')")));
        //WebElement myNewPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a")));
        WebElement myNewPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists li:nth-child(3)")));
        myNewPlaylist.click();
    }

    public int countSongs(){
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }
    public String getPlaylistDetails(){
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }

    public void displayAllSongsInMyNewPlaylist(){
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of songs found: " + countSongs());
        for (WebElement e: songList){
            System.out.println(e.getText());
        }

    }
}
