import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        navigateToPage();
        ProvideEmail("Demo@testpro.io");
        ProvidePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(3000);
        clickPlay();
        checkSongIsPlaying();

    }
        public void clickPlay() throws InterruptedException {

            WebElement playNextButton = driver.findElement(By.cssSelector("[data-testid ='play-nxt-btn']"));
            playNextButton.click();
            WebElement playButton = driver.findElement(By.cssSelector("[data-testid ='play-btn']"));
            playButton.click();
            Thread.sleep(5000);

        }

        public void checkSongIsPlaying() {
            WebElement soundBar = driver.findElement(By.cssSelector("[data-testid='sound-bar-play']"));
            Assert.assertTrue(soundBar.isDisplayed());
        }
    }
