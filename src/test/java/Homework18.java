import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong(){
        loginPage.loginWithCorrectCredentials();
        homepage.clickAllSongs();
        homepage.playASong();
        homepage. soundBarVisible();
    }




//    public void soundBarVisible() {
//        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainFooter .media-info-wrap .other-controls  button:nth-child(2)  img")));
//        Assert.assertTrue(soundBar.isDisplayed());
//    }
//    public void playASong() {
//        WebElement panel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.side.player-controls")));
//        WebElement hoverClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='play-btn']")));
//        WebElement playButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-testid='play-btn']")));
//
//        panel.click();
//        hoverClick.click();
//        playButton.click();
//    }

//    public void clickOnAllSongs() {
//        WebElement allSongs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sidebar section.music li:nth-child(3) a")));
//        allSongs.click();
//    }
}
