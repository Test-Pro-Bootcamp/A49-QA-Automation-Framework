import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong(){

        navigateToPage();
        provideEmail("svitlana.shkribliak@testpro.io");
        providePassword("te$t$tudent49");
        clickSubmit();
        clickNextSongBtn();
        clickPlayBtn();
        songIsPlaying();

    }

    private void songIsPlaying() {
        WebElement soundbar = this.getDriver().findElement(By.cssSelector("[data-testid='sound-bar-play']"));
        Assert.assertTrue(soundbar.isDisplayed());
    }

    private void clickPlayBtn() {
        WebElement playBtn = this.getDriver().findElement(By.cssSelector("[data-testid='play-btn']"));
        playBtn.click();
    }

    private void clickNextSongBtn() {
        WebElement NextSongBtn = this.getDriver().findElement(By.cssSelector("[data-testid='play-next-btn']"));
        NextSongBtn.click();
    }


}
