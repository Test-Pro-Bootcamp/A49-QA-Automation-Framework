import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    public void playSong(){
        navigateToPage();
        provideEmail("camden.bertrand@testpro.io");
        providePassword("te$t$tudent");
        playNext();
        clickPlayBtn();

    }

    public void clickPlayBtn() {
        WebElement playBtn = driver.findElement(By.cssSelector("footer span i[class='fa fa-play']"));
        playBtn.click();
    }

    public void playNext() {
        WebElement playNext = driver.findElement(By.cssSelector("[data-testid='play-next-btn']"));
        playNext.click();
    }
}
