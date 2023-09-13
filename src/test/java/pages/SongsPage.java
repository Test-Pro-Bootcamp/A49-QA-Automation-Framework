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
    @FindBy(css = "#songResultsWrapper > div > div > div.item-container > table")
    WebElement searchResultsTable;
    @FindBy(xpath = "//button[@data-test='view-all-songs-btn']")
    WebElement buttonViewAll;
    @FindBy(css = "#songsWrapper > header > div.song-list-controls > span > button.btn-add-to")
    WebElement clickAddTo;
    @FindBy(css = "#songsWrapper > header > div.song-list-controls > div > section.new-playlist > form > button")
    WebElement submitPlaylistButton;
    @FindBy(css = "#songsWrapper > header > div  form.form-new-playlist > input")
    WebElement playlistInput;
    @FindBy(css = "div.alertify >div >div>nav >button.ok")
    WebElement popUpDeleteMessage;
    @FindBy(css = "[class='del btn-delete-playlist']")
    WebElement deletePlaylistButton;

    BasePage basePage;

    public SongsPage addSongToPlaylist(String callPlaylist) {
        String textBanner = "Created playlist \"" + callPlaylist + "\".";
        pageSongs.click();
        returnAnySong(4, songTable,1).click();
        wait.until(ExpectedConditions.elementToBeClickable(clickAddTo)).click();
        createSimplePlaylist(callPlaylist);
        showBanner(textBanner);

        Assert.assertTrue(true, textBanner);

        return this;
    }
    public SongsPage deletePlaylist() {
        deletePlaylistButton.click();
        popUpDeleteMessage.click();
        return this;
    }
    public void playlistCheck(String playlistName, String song) {
        try {
            openPlaylist(playlistName);
        } catch (Exception e) {
            search(song);
            buttonViewAll.click();
            returnAnySong(0, searchResultsTable, 1).click();
            wait.until(ExpectedConditions.elementToBeClickable(clickAddTo)).click();
            createSimplePlaylist(playlistName);

        }
    }
    public void openPlaylist (String playlistName) {
        WebElement myPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + playlistName + "')]")));
        myPlaylist.click();
    }
    public SongsPage contextClickSongByName(String songName)  {
        WebElement song = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//section[@id='songsWrapper']//td[text()='"+songName+"']"))));
        actions.contextClick(song).perform();
        return this;
    }
    public WebElement returnAnySong(int songNo, WebElement songTable, int col) {
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
    public void createSimplePlaylist (String playlistName) {
        playlistInput.click();
        playlistInput.clear();
        playlistInput.sendKeys(playlistName);
        submitPlaylistButton.click();
    }





}
