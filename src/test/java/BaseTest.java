import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {

    BasePage basePage;
    LoginPage loginPage;
    HomePage homePage;
    PlaylistPage playlistPage;
    public WebDriver driver ;
    public String url = "https://qa.koel.app/";


    @BeforeSuite
    static void setupClass() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void launchBrowser() {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        basePage = new BasePage(driver);
        basePage.navigateToPage(url);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        playlistPage = new PlaylistPage(driver);
    }

    @AfterClass
    public void closeBrowser() {
        basePage.quitBrowser();
    }
}
