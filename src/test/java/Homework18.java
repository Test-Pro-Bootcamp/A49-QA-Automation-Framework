import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework18 extends BaseTest {
    @Test
    public void playSong() {

        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        clickPlaySong();
      Assert.assertTrue(isSongPlaying());
    }

    public void clickPlaySong() {
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));


        playNextButton.click();
        playButton.click();
    }
    public boolean isSongPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
        //Thread.sleep(2000);
    }
}

/*   Added ChromeOptions argument below to fix websocket error
 ChromeOptions options = new ChromeOptions();
options.addArguments("--remote-allow-origins=*");

WebDriver driver = new ChromeDriver(options);
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

String url = "https://qa.koel.app/";
driver.get(url);


Assert.assertEquals(driver.getCurrentUrl(), url);
  driver.quit(); */
