import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;
public class BaseTest {
    public WebDriver driver;
    public Actions actions;
    public String url = "https://qa.koel.app/";
    WebDriverWait wait;
    BasePage basepage;
    LoginPage loginPage;
    HomePage homePage;
    ProfilePage profilePage;
    RegistrationPage registrationPage;
    SearchPage searchPage;
    PlaylistPage playlistPage;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void launchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        actions = new Actions(driver);
        basepage = new BasePage(driver, wait, actions);
        basepage.openLoginUrl(url);
        loginPage = new LoginPage(driver, wait, actions);
        homePage = new HomePage(driver, wait, actions);
        profilePage = new ProfilePage(driver, wait, actions);
        registrationPage = new RegistrationPage(driver, wait, actions);
        searchPage = new SearchPage(driver, wait, actions);
        playlistPage = new PlaylistPage(driver, wait, actions);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @AfterMethod
    public void closeBrowser() {
        basepage.quitBrowser();
    }
}