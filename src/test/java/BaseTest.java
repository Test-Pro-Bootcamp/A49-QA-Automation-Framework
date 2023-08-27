import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.util.UUID;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver = null;

//    public String url = "https://qa.koel.app/";
    public String url;

    WebDriverWait wait;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        url=baseURL;
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    //After all methods. Close the browser
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
    //Open "https://qa.koel.app/"
    public void openLoginUrl() {
        driver.get(url);
    }
    //Enter Email as a string
    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("input[type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }
    //Enter password as a string
    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("input[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
    //Click Login Btn
    public void clickSubmit() {
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        submitBtn.click();
    }

    //Login method for "Valid credentials"
    public void loginWithCorrectCred() {
        enterEmail("emiliano.castillo@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();
    }
    //Login method for "Invalid credentials"
    public void loginWithIncorrectCred() {
        enterEmail("invalidemail@class.com");
        enterPassword("te$t$tudent");
        clickSubmit();
    }
    //Profile Test Helper Functions
    //Click avatar profile logo
    public void clickAvatarIcon() {
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='view-profile-link']")));
        avatarIcon.click();
    }
    //Click save Btn
    public void clickSaveBtn() {
        WebElement saveBtn = driver.findElement(By.cssSelector("button.btn-submit"));
        saveBtn.click();
    }

    //Homework 17
    //This method will take in (By inputLocator, String inText)
    //Ex. enterText(By.cssSelector("input[type='search']"), "Dark Days");
    //Ex. enterText(By.cssSelector("#songResultsWrapper [data-test='new-playlist-name"), getRandomString());
    public void enterText (By inputLocator, String inputText) {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(inputLocator));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(inputText);
    }
    String getRandomString () {
        UUID uuid = UUID. randomUUID();
        return uuid.toString();
    }

    //Homework18
    //Method clicks on all songs tab
    public void clickSongsTab() {
        WebElement clickAllSongsTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".music .songs")));
        clickAllSongsTab.click();
    }

    //Homework19
    //Clicks the "+" btn to add a new playlist
    public void clickAddPlaylist() {
        WebElement newPlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid=\"sidebar-create-playlist-btn\"]")));
        newPlaylistBtn.click();
    }
    //Selects new playlist option
    public void selectNewOption () {
        WebElement selectNewPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
        selectNewPlaylist.click();
    }
    //Inputs random string as new playlist name, So when I delete it this test will function everytime no matter what
    public void newPlaylist (String randomName) {
        WebElement inputNewPlaylist = driver.findElement(By.cssSelector("#mainWrapper [name='name']"));
        inputNewPlaylist.clear();
        inputNewPlaylist.sendKeys(randomName);
        inputNewPlaylist.sendKeys(Keys.ENTER);
    }

}