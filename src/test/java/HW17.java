import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

// Homework17 class extending the BaseTest class for adding a song to a playlist
public class HW17 extends BaseTest {

    // Test method to add a song to a playlist
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        // Expected success message after adding a song to the playlist
        String expectedSongAddedMessage = "Added 1 song into \"Test Pro Playlist.\"";

        // Navigate to the application and log in
        navigateToPage();
        provideEmail("dagebeyehu@gmail.com");
        providePassword("yozca5uQiLxb!");
        clickSubmit();
        Thread.sleep(2000);

        // Search for a song, view all results, select the first song, and add it to a playlist
        searchSong("Reactor");
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlaylist();

        // Verify that the success message matches the expected message
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);
    }

    // Method to search for a song using the provided name
    public void searchSong(String name) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(name);
        Thread.sleep(2000);
    }

    // Method to click the "View All" button to see all search results
    public void clickViewAllBtn() throws InterruptedException {
        WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(2000);
    }

    // Method to select the first song from the search results
    public void selectFirstSongResult() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
        Thread.sleep(2000);
    }

    // Method to click the "Add to" button to add the selected song to a playlist
    public void clickAddToBtn() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToButton.click();
        Thread.sleep(2000);
    }

    // Method to choose a playlist (assuming a playlist named "Greatest Hits Playlist" is created)
    public void choosePlaylist() throws InterruptedException {
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test Pro Playlist')]"));
        playlist.click();
        Thread.sleep(2000);
    }

    // Method to get the success message after adding a song to a playlist
    public String getAddToPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }
}


