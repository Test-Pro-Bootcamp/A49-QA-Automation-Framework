import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{
    @Test
    public void addSongToPlaylist(){

        navigateToPage();
        provideEmail("svitlana.shkribliak@testpro.io");
        providePassword("te$t$tudent49");
        clickSubmit();

        WebElement search = this.getDriver().findElement(By.cssSelector("[name='q']"));
        search.click();
        search.sendKeys("dark days");

        WebElement viewAllSongs = this.getDriver().findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllSongs.click();

        WebElement firstSong = this.getDriver().findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr:nth-child(1) > td.title"));
        firstSong.click();

        WebElement addToPlaylistButton = this.getDriver().findElement(By.cssSelector("button[data-test='add-to-btn']"));
        addToPlaylistButton.click();

        WebElement choosePlaylist = this.getDriver().findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li:nth-child(6)"));
        choosePlaylist.click();

        WebElement songAddedMessage = this.getDriver().findElement(By.xpath("//*[contains(text(),'Added 1 song into \"sshkribliak.\"')]"));
        Assert.assertTrue(songAddedMessage.isDisplayed());
    }
}

