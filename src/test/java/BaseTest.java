import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;


public class BaseTest {

    public static WebDriver driver = null;

    @BeforeSuite

    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod

    public static void launchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

// Helper Methods
    public static void navigateToPage() {
        String url = "https://qa.koel.app/";
        driver.get(url);

    }
    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public static void clickSubmit() throws InterruptedException {
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
        Thread.sleep(2000);

    }
    public void searchSong(String song) throws InterruptedException {
        WebElement searchField = driver.findElement(By.xpath("//input[@type='search']"));
        searchField.sendKeys(song);
        searchField.click();
        Thread.sleep(2000);
    }

    public void clickViewAllButton() throws InterruptedException {
        WebElement viewAllWebelement = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAllWebelement.click();
        Thread.sleep(2000);
    }

    public static void selectFirstSong() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        firstSong.click();
        Thread.sleep(2000);
    }

    public void clickAddToButton() throws InterruptedException {

        WebElement addToButton = driver.findElement(By.xpath("//button[@data-test='add-to-btn']"));

        addToButton.click();
        Thread.sleep(2000);
    }

    public void choosePlaylist() throws InterruptedException {

        WebElement addToPlaylist = driver.findElement(By.xpath("*//section[@id='songResultsWrapper']//li[contains(text(),'Old Songs')]"));
        addToPlaylist.click();
        Thread.sleep(2000);

    }

    public String getNotification() {

        WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
        return notificationElement.getText();

    }

    @AfterMethod

    public static void closeBrowser() {

        driver.quit();
    }


}
