package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPage extends BasePage{
    public SearchPage(WebDriver givenDriver) {

        super(givenDriver);
    }

    @FindBy(css = "#songResultsWrapper > div > div > div.item-container > table")
    WebElement searchResultsTable;
    @FindBy(xpath = "//button[@data-test='view-all-songs-btn']")
    WebElement buttonViewAll;
    @FindBy(css = "#songResultsWrapper .btn-add-to")
    WebElement buttonAddToSearch;
    @FindBy(css = "#songResultsWrapper > header > div.song-list-controls > div > section.new-playlist > form > button")
    WebElement submitPlaylistButtonSearch;
    @FindBy(css = "#songResultsWrapper > header > div  form.form-new-playlist > input")
    WebElement playlistInputSearch;

    public SearchPage playlistCheckSearch(String playlistName, String song) {
        try {
            openPlaylist(playlistName);
        } catch (Exception e) {
            search(song);
            buttonViewAll.click();
            returnSearchSong(0, 1).click();
            buttonAddToSearch.click();
            createSimplePlaylistSearch(playlistName);


        }
        return this;
    }
    public SearchPage openPlaylist (String playlistName) {
        WebElement myPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + playlistName + "')]")));
        actions.click(myPlaylist).perform();
        return this;
    }
    public SearchPage contextClickSongByName(String songName)  {
        WebElement song = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//section[@id='songsWrapper']//td[text()='"+songName+"']"))));
        actions.contextClick(song).perform();
        return this;
    }
    public WebElement returnSearchSong(int songNo, int col) {
        List<WebElement> rows = searchResultsTable.findElements(By.tagName("tr"));
        WebElement r1 = rows.get(songNo);
        List<WebElement> cells = r1.findElements(By.tagName("td"));
        WebElement c1 = cells.get(col);
        return c1;
    }
    public void clickPlaylist(String playlistName) {
        WebElement myPlaylist = findElement(By.xpath("//*[@id='songResultsWrapper']//section/ul/li[@class='playlist' and contains(text(),'"+playlistName+"')]"));
        actions.click(myPlaylist).perform();
    }
    public void createSimplePlaylistSearch(String playlistName) {
        playlistInputSearch.click();
        playlistInputSearch.clear();
        playlistInputSearch.sendKeys(playlistName);
        submitPlaylistButtonSearch.click();
    }
    public SearchPage clickAddToSearch() {
        WebElement buttonAddToSearch = wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("#songResultsWrapper .btn-add-to"))));
        actions.click(buttonAddToSearch).perform();
        return this;
    }

}
