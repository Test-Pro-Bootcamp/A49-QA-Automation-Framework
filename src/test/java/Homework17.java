import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    @Test

    public void addSongToPlaylist() throws InterruptedException {

        // Expected success message when adding a song to a playlist
        String expectedSongAddedMessage = "Added 1 song into \"Isisha Playlist.\"";

        // Navigate to the page
        navigateToPage();

        // Provide email and password
        provideEmail("isisha.andrews@testpro.io.");
        providePassword("te$t$tudent");

        // Click submit button
        clickSubmit();

        // Wait for page to load
        Thread.sleep(2000);

        // Search for the song "Ketsa"
        searchSong("Ketsa");

        // Click the "View All" button
        clickViewAllBtn();

        // Select the first song in the search results
        selectFirstSongResult();

        // Click the "Add to" button
        clickAddToBtn();

        // Choose the playlist
        choosePlaylist();

        // Assert that the success message matches the expected message
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);
    }

    // Method to search for a song
    public void searchSong(String name) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(name);

        // Wait for search results to load
        Thread.sleep(2000);
    }

    // Method to click the "View All" button
    public void clickViewAllBtn() throws InterruptedException {
        WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();

        // Wait for page to load
        Thread.sleep(2000);
    }

    // Method to select the first song in the search results
    public void selectFirstSongResult() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();

        // Wait for page to load
        Thread.sleep(2000);
    }

    // Method to click the "Add to" button
    public void clickAddToBtn() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToButton.click();

        // Wait for page to load
        Thread.sleep(2000);
    }

    // Method to choose the playlist
    public void choosePlaylist() throws InterruptedException {
        // We created a playlist named "Test Pro Playlist"
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test Pro Playlist')]"));
        playlist.click();

        // Wait for page to load
        Thread.sleep(2000);
    }

    // Method to get the success message when adding a song to a playlist
    public String getAddToPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }
}