import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

class Homework17 extends BaseTest {
WebDriver driver;

    @Test
    public void addSongToPlaylist() {
        openLoginUrl("https://qa.koel.app/");
        provideEmail("momo.carlos5@gmail.com");
        providePassword("te$t$tudent");
        cliquesubmit();
        SearchSongs("Herre Jorna");
        clickViewAll();
        addSongToMyPlaylist();


    }

    private void addSongToMyPlaylist() {
        driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/div/div/div[1]/table/tr")).click();
        driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/span/button[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[1]/ul/li[5]")).click();
        WebElement addSong = driver.findElement(By.xpath("/html/body/div[2]/div"));
        Assert.assertTrue(addSong.isDisplayed());


    }

    private void clickViewAll() {
        driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div/div/section[1]/h1/button")).click();
    }

    private void SearchSongs(String s) {
        WebElement search = driver.findElement(By.xpath("//*[@id=\"searchForm\"]/input"));
        search.clear();
        search.sendKeys(s);
    }

    private void cliquesubmit() {
        driver.findElement(By.cssSelector("[type=submit]")).click();
    }

    private void openLoginUrl(String url) {
        driver.get(url);
    }


    public void providePassword(String p) {
        driver.findElement(By.cssSelector("input[placeholder=\"Password\"]")).sendKeys(p);

    }

    public void provideEmail(String e) {
        WebElement email = driver.findElement(By.cssSelector("input[placeholder=\"Email Address\"]"));
        email.clear();
        email.sendKeys(e);
    }

}
