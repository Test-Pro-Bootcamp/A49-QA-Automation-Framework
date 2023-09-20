import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import pages.*;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver = null;
    public String url = "https://qa.koel.app/";
    public WebDriverWait wait;
    public Actions actions;
    BasePage basePage;
    LoginPage loginPage;
    HomePage homePage;
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
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
        basePage = new BasePage(driver);
        basePage.navigateToPage(url);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        playlistPage = new PlaylistPage(driver);
        }

    @AfterMethod
    public void closeBrowser() {
        basePage.closeBrowser();
    }

}
