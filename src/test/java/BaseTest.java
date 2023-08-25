import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void setUpBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDownBrowser(){
    driver.quit();
    }
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    public void navigateToPage() {
        driver.get("https://qa.koel.app/");
    }

    public void provideEmail() {
        WebElement loginInput = driver.findElement(By.cssSelector("[type='email']"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("xu_moua@hotmail.com");

    }

    public void providePassword() {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("TestStudent!1");

    }

    public void clickSubmit() {
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
    }

    protected void clickSaveBtn() {
            WebElement saveBtn = driver.findElement(By.cssSelector("section[id='songResultsWrapper'] button[title='Save']"));
            saveBtn.click();
    }

    protected void verifySuccessMessage() {
            WebElement popUpNotification = driver.findElement(By.cssSelector(".success.show"));
            Assert.assertTrue(popUpNotification.isDisplayed());
    }

    protected void enterPlaylistName() {
            WebElement newPlaylist = driver.findElement(By.cssSelector("section[id='songResultsWrapper'] input[placeholder='Playlist name']"));
            newPlaylist.click();
            newPlaylist.clear();
            newPlaylist.sendKeys("Greatest Hits");
    }

    protected void clickAddToBtn() {
            WebElement addToBtn = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
            addToBtn.click();
    }

    protected void clickSongTitle() {
            WebElement clickSong = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/div/div/div[1]/table/tr[1]/td[2]"));
            clickSong.click();
    }

    protected void clickViewAllBtn() {
            WebElement viewAllBtn = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
            viewAllBtn.click();
    }

    protected void enterSongIntoSearchField() {
            WebElement searchInput = driver.findElement(By.cssSelector("input[placeholder='Press F to search']"));
            searchInput.click();
            searchInput.clear();
            searchInput.sendKeys("Dark Days");
    }
    public void logInWithRightCredentials(){
        navigateToPage();
        provideEmail();
        providePassword();
        clickSubmit();
    }

}