import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import pages.BasePage;
import pages.BasePage;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver = null;
    public static Actions actions = null;
    public String url = "https://qa.koel.app/";
    WebDriverWait wait;
   // private static final ThreadLocal<WebDriver> treadDriver = new ThreadLocal<>();
    BasePage basePage;

    // @BeforeSuite
    // public void setupSuite() throws MalformedURLException {
    // String browser = System.getProperty("browser");
    // String browser = "grid_chrome";
    // driver = setupBrowser(browser);
    // setupChrome();
    //setupFirefox();
    // setupEdge();
    // }

    public WebDriver setupBrowser(String browser) throws MalformedURLException {
        // java -jar selenium-server-4.12.1.jar standalone --selenium-manager true
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://10.0.0.126:4444";
        switch (browser) {
            case "firefox":
                return setupFirefox();
            case "chrome":
                return setupChrome();
            case "edge":
                return setupEdge();
            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-edge":
                capabilities.setCapability("browserName", "edge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            default:
                // return setupChrome();
                //return setupEdge();
                return setupFirefox();
        }
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
public void launchBrowser (String BaseURL) throws MalformedURLException {
        String browser = System.getProperty("browser");
        driver = setupBrowser(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        url = BaseURL;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        actions = new Actions(driver);
        driver.get(url);
        basePage = new BasePage(driver);
        basePage.navigateToPage(url);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public WebDriver setupFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return driver;
    }

    public WebDriver setupEdge() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--remote-allow-origins=*");
        return driver = new EdgeDriver(edgeOptions);

    }

    public WebDriver setupChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        return driver = new ChromeDriver(options);
    }
}


