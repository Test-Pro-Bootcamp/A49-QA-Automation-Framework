import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework18 extends BaseTest {
    @Test
    public void playSong()  {
        //GIVEN
        loginToKoel();

        //WHEN
        clickNextSongButton();
        playSongButton().click(); // method returns WebElement
        //clickPlaySongButton2(); // void method

        //THEN
        Assert.assertTrue(soundbarElement().isDisplayed());
        //or
        Assert.assertTrue(pauseSongButton().isDisplayed());

    }

    public WebElement playSongButton() {
        WebElement playButton = driver.findElement(By.xpath("//*[@id=\"mainFooter\"]/div[1]/span/span[2]"));
        //playButton.click();
        return playButton;
    }

    public void clickPlaySongButton2() {
        WebElement playButton2 = driver.findElement(By.xpath("//*[@id=\"mainFooter\"]/div[1]/span/span[2]"));
        playButton2.click();
    }

    public void clickNextSongButton() {
        WebElement nextSongButton = driver.findElement(By.xpath("//footer[@id='mainFooter']//i[@class = 'next fa fa-step-forward control']"));
        nextSongButton.click();
    }

    public WebElement soundbarElement() {
        WebElement soundBar = driver.findElement(By.cssSelector(".wrapper .bars"));
        //WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(soundBar));
        //soundBar.isDisplayed();
        return soundBar;
    }

    public WebElement pauseSongButton() {
        WebElement pauseButton = driver.findElement(By.cssSelector("[title='Pause']"));
        //pauseButton.click();
        return pauseButton;
    }

}
