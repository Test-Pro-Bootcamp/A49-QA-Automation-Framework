import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong(){

        navigateToPage();

    provideEmail("elena.min@testpro.io");
    providePassword("te$t$tudent");
    clickSubmit();
    //Thread.sleep(3000);
    clickPlay();
    Assert.assertTrue(isSongPlaying());
}
public void clickPlay(){
        WebElement playNextButton = driver.findElement(By.cssSelector("[data-testid='play-next-btn']"));
        //WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn"));
        WebElement playButton = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        playNextButton.click();
        playButton.click();
}
public boolean isSongPlaying(){
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
}
}