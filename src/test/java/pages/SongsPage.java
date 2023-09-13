package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SongsPage extends BasePage{

    public SongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "#songsWrapper > div > div > div.item-container > table")
        WebElement songTable;
    @FindBy(css = "#songResultsWrapper > div > div > div.item-container > table")
        WebElement searchResultsTable;
    @FindBy(xpath = "//button[@data-test='view-all-songs-btn']")
        WebElement buttonViewAll;
    @FindBy(css = "#songResultsWrapper > header > div.song-list-controls > span > button.btn-add-to")
        WebElement clickAddTo;
    @FindBy(css = "#songResultsWrapper > header > div.song-list-controls > div > section.new-playlist > form > button")
        WebElement submitPlaylistButton;
    @FindBy(css = "#songResultsWrapper > header > div  form.form-new-playlist > input")
        WebElement playlistInput;


    public void addSongToPlaylist(String callPlaylist, String song) throws InterruptedException{
        playlistCheck(callPlaylist, song);
        search(song);
        buttonViewAll.click();
        returnAnySong(4, searchResultsTable,1).click();
        wait.until(ExpectedConditions.elementToBeClickable(clickAddTo)).click();
        clickPlaylist("Lambs");



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
    public WebElement returnAnySong(int songNo, WebElement searchResultsTable, int col) {
        List<WebElement> rows = searchResultsTable.findElements(By.tagName("tr"));
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
