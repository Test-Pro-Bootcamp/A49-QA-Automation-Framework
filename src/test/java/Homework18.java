import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test

    public void playSong() {
        provideEmail("isisha.andrews@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        clickPlay();
        Assert.assertTrue(isSongPlaying());
    }


 public void clickPlay() {
    WebElement playNextButton = driver.findElement(By.xpath("//i[//*[@id=\"mainFooter\"]/div[1]/i[2]']"));
    WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']']"));

     playNextButton.click();
     playButton.click();
 }

public boolean isSongPlaying() {
    WebElement soundbar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
    return soundbar.isDisplayed();
}
}



