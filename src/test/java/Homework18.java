import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong(){
        loginWithCorrectCredentials();
        clickOnAllSongs();
        playASong();
        soundBarVisible();
    }




    public void soundBarVisible() {
        WebElement soundBar = driver.findElement(By.cssSelector("#mainFooter .media-info-wrap .other-controls  button:nth-child(2)  img"));
        Assert.assertTrue(soundBar.isDisplayed());
    }
    public void playASong() {
        WebElement hoverClick = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

        hoverClick.click();
        playButton.click();
    }

    public void clickOnAllSongs() {
        WebElement allSongs = driver.findElement(By.cssSelector("#sidebar section.music li:nth-child(3) a"));
        allSongs.click();
    }
}
