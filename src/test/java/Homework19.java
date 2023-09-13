import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Parameters({"BaseURL"})
    @Test
    public void deletePlaylist(String baseUrl) {
        driver.get(baseUrl);
        loginValideEmailPassowrd("momo.carlos5@gmail.com", "te$t$tudent");
        //clickPlayList();
        //clickDeletePlaylist();
    }

    private void clickDeletePlaylist() {
        driver.findElement(By.cssSelector("[title='Delete this playlist']")).click();
        WebElement notificationDeleted = driver.findElement(By.xpath("/html/body/div[2]/div"));
        Assert.assertTrue(notificationDeleted.isDisplayed());
    }

    private void clickPlayList() {
        driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[4]/a")).click();
        WebElement xPlaylist = driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        Assert.assertTrue(xPlaylist.isDisplayed());
    }

    private void loginValideEmailPassowrd(String e, String p) {
        WebElement email = driver.findElement(By.cssSelector("input[placeholder=\"Email Address\"]"));
        email.clear();
        email.sendKeys(e);
        driver.findElement(By.cssSelector("[placeholder=\"Password\"] ")).sendKeys(p);
        driver.findElement(By.cssSelector("[type=submit]")).click();
    }

}
