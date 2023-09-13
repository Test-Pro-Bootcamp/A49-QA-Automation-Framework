
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homework17 extends BaseTest {

    @Test
    public void AddSongToPlaylist() throws InterruptedException {
        String ExpectedSongAddedMessage = "Added 1 song into Test playlist";

        navigateToPage();
        provideEmail("demo@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        searchSong("Dark Days");
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlayList();
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), ExpectedSongAddedMessage);
    }
    public void searchSong(String darkDays) throws InterruptedException{
        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
                searchField.sendKeys("Dark Days");
        Thread.sleep(2000);
    }
    public void clickViewAllBtn() throws InterruptedException{
        WebElement viewAll = driver.findElement(By.cssSelector("[data-test=view-all-songs-btn]"));

viewAll.click();
Thread.sleep(2000);
    }
    public void selectFirstSongResult() throws InterruptedException{
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr(@class='song-item')(1)"));
                firstSong.click();
                Thread.sleep(2000);
    }
    public void clickAddToBtn() throws InterruptedException{
        WebElement AddToBtn = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        AddToBtn.click();
        Thread.sleep(2000);
    }
    public void choosePlayList() throws InterruptedException {
        //create new playlist 'test'
        WebElement playList = driver.findElement(By.xpath("//section[@id 'playlistWrapper']//h1[contains (text(),'Test Pro Playlist ')]"));
        playList.click();
        Thread.sleep(2000);
    }
    public String getAddToPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }


}
