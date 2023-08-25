import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong() {

        castEmail("dirzo@gmail.com");
        castPassword("Te$ter1234");
        castSubmit();
        castPlay();
        Assert.assertTrue(summonSong());
    }

    private void castPlay() {
        WebElement nextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

        nextButton.click();
        playButton.click();
    }
    public boolean summonSong(){
        WebElement manaBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return manaBar.isDisplayed();
    }

}
