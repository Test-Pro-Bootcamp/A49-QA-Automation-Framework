import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;




import java.time.Duration;

public class Homework17 extends BaseTest {
    @Test

    public void addSongToPlaylist() {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement loginInput = driver.findElement(By.cssSelector("[type='email']"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("xu_moua@hotmail.com");

        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("TestStudent!1");

        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();

        WebElement searchInput = driver.findElement(By.cssSelector("input[placeholder='Press F to search']"));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys("Dark Days");

        WebElement viewAllBtn = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllBtn.click();


        WebElement clickSong = driver.findElement(By.xpath("//*[@id='playlistWrapper']/div[3]/table/tr/td[2]"));
        clickSong.click();

        WebElement addToBtn = driver.findElement(By.cssSelector("button[title='Add selected songs to…']"));
        addToBtn.click();

        WebElement newPlaylist = driver.findElement(By.cssSelector("section[id='songResultsWrapper'] input[placeholder='Playlist name']"));
        newPlaylist.click();
        newPlaylist.clear();
        newPlaylist.sendKeys("Greatest Hits");

        WebElement saveBtn = driver.findElement(By.cssSelector("section[id='songResultsWrapper'] button[title='Save']"));
        saveBtn.click();

        WebElement popUpNotification = driver.findElement(By.cssSelector(".success.show"));
        Assert.assertTrue(popUpNotification.isDisplayed());









//        String registrationNavigationUrl = "https://qa.koel.app/registration";
//
//        Assert.assertEquals(driver.getCurrentUrl(), registrationNavigationUrl);
        driver.quit();
}

}

