import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
   public void addSongToPlayList() throws InterruptedException {
        loginWithCorrectCredentials();
        Thread.sleep(2000);
        searchTab("somewhere in the dark");
        viewAllButton();
        clickOnSong();
        addToButton();
        bisolaPlayList();


    }

    public void clickOnSong() {
        WebElement clickOnSong= driver.findElement(By.cssSelector("#songResultsWrapper tr:nth-child(1) td.title"));
        clickOnSong.click();
    }

}
