import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SongsTest extends BaseTest {
    @Test
    public void playSong () throws InterruptedException {
        navigateToPage();
        provideEmail("dagebeyehu@gmail.com");
        providePassword("yozca5uQiLxb!");
        clickSubmit();
        //Thread.sleep(3000);
        clickPlayNextBtn();
        checkSongIsPlaying();
    }

    private void checkSongIsPlaying() {
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        Assert.assertTrue(soundBar.isDisplayed());
    }

    private void clickPlayNextBtn(){
        ClickOnElement(By.cssSelector("div.side.player-controls"));
        ClickOnElement(By.cssSelector("[data-testid='play-next-btn']"));
        ClickOnElement(By.cssSelector("[data-testid='play-btn']"));
    }
    void ClickOnElement(By locator){
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        el.click();

    }
}
