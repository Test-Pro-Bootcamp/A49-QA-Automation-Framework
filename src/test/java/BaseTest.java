import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import java.time.Duration;

public class BaseTest {
    public static WebDriver theDriver = null;
    public static String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        theDriver = new ChromeDriver(options);
        theDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        theDriver.manage().window().maximize();
        String url = "https://qa.koel.app/";
        theDriver.get(url);
    }

    @AfterMethod
    public void closerBrowser() {
        theDriver.quit();
    }


    public void clickLogin() {
        WebElement submitLogin = theDriver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
    }

    public void enterPassword(String password) {
        WebElement passwordInput = theDriver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void enterEmail(String email) {
        WebElement emailInput = theDriver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void searchSong(String song) {
        WebElement searchField = theDriver.findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(song);
    }

    public void clickViewAll() {
        WebElement buttonViewAll = theDriver.findElement(new By.ByXPath("//button[@data-test='view-all-songs-btn']"));
        buttonViewAll.click();
    }

    public void clickSong() {
        WebElement clickFirstSong = theDriver.findElement(new By.ByXPath("//tr[@class='song-item']//td[text()='HoliznaCC0 - SomeWhere In The Dark']"));
        clickFirstSong.click();
    }

    public void clickAddTo() {
        WebElement clickAddTo = theDriver.findElement(By.cssSelector("[class='btn-add-to']"));
        clickAddTo.click();
    }

    public void clickPlaylist() {
        WebElement clickPlaylist = theDriver.findElement(new By.ByXPath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
        clickPlaylist.click();
    }


    public String showBanner() throws NoSuchElementException {
        WebElement notification = theDriver.findElement(By.cssSelector("body > div.alertify-logs.top.right > div"));
        return notification.getText();
    }
}
