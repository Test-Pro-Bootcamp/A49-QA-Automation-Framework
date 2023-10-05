import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.*;

import java.net.MalformedURLException;
import java.net.URI;

public class BaseTest {

    public WebDriver driver;
    public String url = "https://qa.koel.app/";
    public WebDriverWait wait;
    public Actions actions;
    BasePage basePage;
    LoginPage loginPage;
    HomePage homePage;
    PlaylistPage playlistPage;



    @BeforeSuite
    public void setupSuite() throws MalformedURLException {
        //String browser = System.getProperty("browser");
        String browser="grid-chrome";
        driver=setupBrowser(browser);
    }

   /* @BeforeMethod
    public void launchBrowser() {
       *//* ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);*//**//*
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        basePage = new BasePage(driver);
        basePage.navigateToPage(url);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        playlistPage = new PlaylistPage(driver);*//*
        }*/

    @AfterClass
    public void closeBrowser() {
        driver.quit();
        //basePage.closeBrowser();
    }
    WebDriver setupBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.0.235:4444";
        switch (browser){
            case "firefox":
                return setupFireFox();
            case "chrome":
                return setupChrome();
            case "edge":
                return setupEdge();
            case "grid-firefox":
                caps.setCapability("browserName","firefox");
                return driver =new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-edge":
                caps.setCapability("browserName","edge");
                return driver =new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            default:
                caps.setCapability("browserName","chrome");
                return driver =new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
        }
    }

    public WebDriver setupFireFox(){
        WebDriverManager.firefoxdriver().setup();
        driver =new FirefoxDriver();
        return driver;
    }
    public WebDriver setupEdge() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--remote-allow-origins=*");
        return driver = new EdgeDriver(edgeOptions);

    }
    public WebDriver setupChrome(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        return driver;
    }
}
