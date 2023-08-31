import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    @Parameters({"BaseURL"})
    @Test
    public void deletePlaylist(String baseUrl) {
        driver.get(baseUrl);
        loginValideEmailPassowrd("momo.carlos5@gmail.com", "te$t$tudent");
        clickPlayList();
        clickDeletePlaylist();
    }

    private void clickDeletePlaylist() {
        //driver.findElement(By.cssSelector("[title='Delete this playlist']")).click();
        clickOnElement(By.cssSelector("[title='Delete this playlist']"));
        //WebElement notificationDeleted = driver.findElement(By.xpath("/html/body/div[2]/div"));
        WebElement notificationDeleted = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div")));
        Assert.assertTrue(notificationDeleted.isDisplayed());
    }

    private void clickPlayList() {
        // driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[4]/a")).click();
        clickOnElement(By.xpath("//*[@id=\"playlists\"]/ul/li[4]/a"));
        // WebElement xPlaylist = driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        WebElement xPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Delete this playlist']")));
        Assert.assertTrue(xPlaylist.isDisplayed());
    }

    private void loginValideEmailPassowrd(String e, String p) {
        // WebElement email = driver.findElement(By.cssSelector("input[placeholder=\"Email Address\"]"));
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder=\"Email Address\"]")));
        email.clear();
        email.sendKeys(e);
        // driver.findElement(By.cssSelector("[placeholder=\"Password\"] ")).sendKeys(p);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder=\"Password\"] "))).sendKeys(p);
        // driver.findElement(By.cssSelector("[type=submit]")).click();
        clickOnElement(By.cssSelector("[type=submit]"));
    }

    void clickOnElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();

    }
}
