import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW18New extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {
        navigateToPage();
        provideEmail("dagebeyehu@gmail.com");
        providePassword("yozca5uQiLxb!");
        clickSubmit();
        Thread.sleep(3000);
        clickPlayNextBtn();
        checkSongIsPlaying();
    }

    private void checkSongIsPlaying() {
        WebElement soundBar = driver.findElement(By.cssSelector("[data-testid='sound-bar-play']"));
        Assert.assertTrue(soundBar.isDisplayed());
    }

    private void clickPlayNextBtn() throws InterruptedException {
        WebElement PlayNextBtn = driver.findElement(By.cssSelector("[data-testid='play-next-btn']"));
        PlayNextBtn.click();
        WebElement playBtn= driver.findElement(By.cssSelector("[data-testid='play-btn"));
        playBtn.click();
        Thread.sleep(5000);
    }
}
