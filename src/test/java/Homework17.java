import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    //String newPlaylistName = getRandomString(10);
    @Test
    public void addSongToPlaylist() {

        navigateToPage();
        provideEmail("svitlana.shkribliak@testpro.io");
        providePassword("te$t$tudent49");
        clickSubmit();
        //createNewPlaylist();
        searchSongInSearchField("dark days");
        clickViewAllBtn();
        clickFirstSongInList();
        clickAddSongToPlaylistBtn();
        enterNewPlaylistName();
        clickSaveNewPlaylistBtn();
        validateCreatedPlaylist();

    }

    private void validateCreatedPlaylist() {
        WebElement playlistAddedMsg = this.getDriver().findElement(By.xpath("//*[contains(text(),'Created playlist')]"));
                // xpath("//*[contains(text(),'Created playlist')]"));
        Assert.assertTrue(playlistAddedMsg.isDisplayed());
    }

    private void clickSaveNewPlaylistBtn() {
        WebElement savePlaylistBtn = this.getDriver().findElement(By.cssSelector("#songResultsWrapper [title='Save']"));
        savePlaylistBtn.click();
    }

    private void enterNewPlaylistName() {
        enterText(By.cssSelector("#songResultsWrapper [data-test='new-playlist-name']"), getRandomString(10));
    }

    private void clickNewPlaylistField() {
        WebElement playListField = this.getDriver().findElement(By.cssSelector("#songResultsWrapper [data-test='new-playlist-name']"));
        playListField.click();
    }

    private void createNewPlaylist() {
        WebElement plusButton = this.getDriver().findElement(By.cssSelector("[data-testid='sidebar-create-playlist-btn']"));
        plusButton.click();
        WebElement newPlaylistBtn = this.getDriver().findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
        newPlaylistBtn.click();
        WebElement playlistNameInput = this.getDriver().findElement(By.cssSelector("[name='name']"));
        playlistNameInput.click();
        playlistNameInput.clear();
        //enterText(By.cssSelector("[name='name']"), newPlaylistName);
        playlistNameInput.sendKeys(getRandomString(10), Keys.ENTER);
    }

    private void clickAddSongToPlaylistBtn() {
        WebElement addToPlaylistButton = this.getDriver().findElement(By.cssSelector("button[data-test='add-to-btn']"));
        addToPlaylistButton.click();
    }

    private void clickFirstSongInList() {
        WebElement firstSong = this.getDriver().findElement(By.cssSelector(".search-results .song-item .title"));
        firstSong.click();
    }

    private void clickViewAllBtn() {
        WebElement viewAllSongs = this.getDriver().findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllSongs.click();
    }

    private void searchSongInSearchField(String songName) {
        WebElement search = this.getDriver().findElement(By.cssSelector("[name='q']"));
        search.click();
        search.clear();
        search.sendKeys(songName);
    }

    private void enterText(By inputLocator, String inputText) {
        WebElement searchInput = this.getDriver().findElement(inputLocator);
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(inputText);
    }

    private String getRandomString(int amountOfLetters) {
        String randomString = RandomStringUtils.randomAlphabetic(amountOfLetters);
        return randomString;

    }
}

