import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        navigateToPage();
        provideEmail("merry.lordlie@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        clickPlay();
        Assert.assertTrue(ifSongPlaying());
    }

    public void clickPlay() {
        WebElement playNextSong = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        playNextSong.click();
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playButton.click();
    }

    public boolean ifSongPlaying() {
        WebElement soundbarPlays = driver.findElement(By.xpath("//div[@data-test='soundbars']"));
        return soundbarPlays.isDisplayed();
    }
}
