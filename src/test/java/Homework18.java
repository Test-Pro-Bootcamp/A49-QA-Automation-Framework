import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework18 extends BaseTest {


    @Test
    public void playSong() {
        navigateToPage();
        provideEmail("natalia.kim01@testpro.io");
        providePassword("AxKrdBnS");
        clickSubmit();
        clickPlay();
        validateSong();
    }

    private void clickPlay() {
        clickOnElement(By.cssSelector("div.side.player-controls"));
        clickOnElement (By.cssSelector("[data-testid='play-next-btn']"));
        clickOnElement(By.cssSelector("[data-testid='play-btn']"));


    }
    void clickOnElement(By locator){
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        el.click();
    }

    public void validateSong() {
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        Assert.assertTrue(soundBar.isDisplayed());
    }

}





