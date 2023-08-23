import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework18 extends BaseTest {

    @Test
    public void playSong () throws InterruptedException {
        loginWithCorrectCred();
        clickSong();
        selectASong();
        playNextBtn();
        playBtn();

        WebElement verifySongState = driver.findElement(By.cssSelector("[data-test=\"soundbars\"]"));
        Assert.assertTrue(verifySongState.isDisplayed());
    }
}
