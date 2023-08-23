import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework18 extends BaseTest {
    @Test
    public void playSong()  {
        loginToKoel();
        clickNextSongButton();
        clickPlaySongButton();
        verifySoundbarIsVisible();
        clickPauseSongButton();
    }

    public void clickPlaySongButton() {
        WebElement playButton = driver.findElement(By.xpath("//*[@id=\"mainFooter\"]/div[1]/span/span[2]"));
        playButton.click();
    }

    public void clickNextSongButton() {
        WebElement nextSongButton = driver.findElement(By.xpath("//footer[@id='mainFooter']//i[@class = 'next fa fa-step-forward control']"));
        nextSongButton.click();
    }

    public void verifySoundbarIsVisible() {
        WebElement soundBar = driver.findElement(By.cssSelector(".wrapper .bars"));
        //WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(soundBar));
        soundBar.isDisplayed();
    }

    public void clickPauseSongButton() {
        WebElement pauseButton = driver.findElement(By.cssSelector("[title='Pause']"));
        pauseButton.click();
    }

}
