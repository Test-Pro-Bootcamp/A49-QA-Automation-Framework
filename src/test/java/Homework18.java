import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework18 extends BaseTest {

    @Test
    public void playSong() {
        openLoginUrl();
        loginWithCorrectCred();
        clickSongsTab();
        selectASong();
        playNextBtn();
        playBtn();

        WebElement verifySongState = driver.findElement(By.cssSelector("[data-test=\"soundbars\"]"));
        Assert.assertTrue(verifySongState.isDisplayed());
    }
    public void selectASong() {
        WebElement selectSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#songsWrapper tr.song-item")));
        selectSong.click();
    }
    public void playNextBtn() {
        WebElement playNextSong = driver.findElement(By.cssSelector("[data-testid='play-next-btn']"));
        playNextSong.click();
    }
    public void playBtn() {
        WebElement clickPlayBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        clickPlayBtn.click();
    }

}
