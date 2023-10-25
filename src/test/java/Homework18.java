import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() {
        openLoginUrl("https://qa.koel.app/");
        loginValideEmailPassowrd("andrew.oleary@testpro.io", "te$t$tudent437");
        playNextSong();
        clickPlaySong();
        validateSongIsPlaying();
    }

    private void validateSongIsPlaying() {
        WebElement pause = driver.findElement(By.cssSelector("[title='Pause']"));
        Assert.assertTrue(pause.isDisplayed());
    }

    private void clickPlaySong() {
        driver.findElement(By.cssSelector("[title='Play or resume']")).click();
    }

    private void playNextSong() {
        driver.findElement(By.xpath("//*[@id='mainFooter']/div[1]/i[2]")).click();
    }

    private void loginValideEmailPassowrd(String e, String p) {
        WebElement email = driver.findElement(By.cssSelector("input[placeholder=\"Email Address\"]"));
        email.clear();
        email.sendKeys(e);
        driver.findElement(By.cssSelector("[placeholder=\"Password\"] ")).sendKeys(p);
        driver.findElement(By.cssSelector("[type=submit]")).click();
    }

    private void openLoginUrl(String url) {
        driver.get(url);
    }
}