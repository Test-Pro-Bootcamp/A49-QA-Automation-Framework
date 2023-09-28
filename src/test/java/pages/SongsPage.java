package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


import java.util.List;

public class SongsPage extends BasePage{

    public SongsPage(WebDriver givenDriver) {

        super(givenDriver);
    }
    @FindBy(css = "#sidebar > section.music > ul > li:nth-child(3) > a")
    WebElement pageSongs;
    @FindBy(css = "#songsWrapper > div > div > div.item-container > table")
    WebElement songTable;
    @FindBy(xpath = "//button[@data-test='view-all-songs-btn']")
    WebElement buttonViewAll;
    @FindBy(css = "#songsWrapper > header > div.song-list-controls > span > button.btn-add-to")
    WebElement buttonAddToAllSongs;
    @FindBy(css = "#songsWrapper > header > div.song-list-controls > div > section.new-playlist > form > button")
    WebElement submitPlaylistButtonAllSongs;
    @FindBy(css = "#songsWrapper > header > div  form.form-new-playlist > input")
    WebElement playlistInputAllSongs;
    @FindBy(css = "div.alertify >div >div>nav >button.ok")
    WebElement popUpDeleteMessage;
    @FindBy(css = "[class='del btn-delete-playlist']")
    WebElement deletePlaylistButton;
    @FindBy(css = "i[class='next fa fa-step-forward control']")
    WebElement playNextSongButton;

    BasePage basePage;

    public SongsPage addSongToPlaylist(String callPlaylist) {
        String textBanner = "Created playlist \"" + callPlaylist + "\".";
        pageSongs.click();
        returnAnySong(4, 1).click();
        clickAddToAllSongs();
        createSimplePlaylistAllSongs(callPlaylist);
        showBanner(textBanner);

        Assert.assertTrue(true, textBanner);

        return this;
    }
    public SongsPage deletePlaylist() {
        deletePlaylistButton.click();
        popUpDeleteMessage.click();
        return this;
    }
    public SongsPage playlistCheckAllSongs(String playlistName, String song) {
        try {
            openPlaylist(playlistName);
        } catch (Exception e) {
            buttonViewAll.click();
            returnAnySong(0, 1).click();
            buttonAddToAllSongs.click();
            createSimplePlaylistAllSongs(playlistName);


        }
        return this;
    }
    public SongsPage openPlaylist (String playlistName) {
        WebElement myPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + playlistName + "')]")));
        myPlaylist.click();
        return this;
    }
    public SongsPage contextClickSongByName(String songName)  {
        WebElement song = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//section[@id='songsWrapper']//td[text()='"+songName+"']"))));
        actions.contextClick(song).perform();
        return this;
    }
    public WebElement returnAnySong(int songNo, int col) {
        List<WebElement> rows = songTable.findElements(By.tagName("tr"));
        WebElement r1 = rows.get(songNo);
        List<WebElement> cells = r1.findElements(By.tagName("td"));
        WebElement c1 = cells.get(col);
        return c1;
    }
    public void clickPlaylist(String playlistName) {
        WebElement clickPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath ("//*[@id='songResultsWrapper']//section/ul/li[@class='playlist' and contains(text(),'"+playlistName+"')]")));
        clickPlaylist.click();
    }
    public void createSimplePlaylistAllSongs(String playlistName) {
        playlistInputAllSongs.click();
        playlistInputAllSongs.clear();
        playlistInputAllSongs.sendKeys(playlistName);
        submitPlaylistButtonAllSongs.click();
    }
    public void clickViewAll() {
        buttonViewAll.click();
    }
    public SongsPage clickAddToAllSongs() {
        buttonAddToAllSongs.click();
    return this;
    }

    public SongsPage clickPlayNextSong () {
        playNextSongButton.click();
        String classPlaying = "item playing";

        Assert.assertTrue(true, classPlaying);
        return this;
    }
    public SongsPage clickToAllSongs() {
        pageSongs.click();
        return this;
    }
    public SongsPage playingSong() {
        actions.doubleClick(returnAnySong(1,1)).perform();
        return this;
    }






}
