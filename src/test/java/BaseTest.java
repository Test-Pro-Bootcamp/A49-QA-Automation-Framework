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
import org.testng.annotations.*;
import pages.BasePage;
import pages.BasePage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    public WebDriver driver = null;
    public static Actions actions = null;
    public String url = "https://qa.koel.app/";
    WebDriverWait wait;
    public static final ThreadLocal<WebDriver> treadDriver = new ThreadLocal<>();
    BasePage basePage;

    @BeforeClass
    public void setup() throws MalformedURLException {
        String browser = System.getProperty("browser");
        treadDriver.set(pickBrowser(browser));
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {
        String browser = System.getProperty("browser");
        driver = pickBrowser(browser);
        treadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        url = BaseURL;
        navigateToPage();
        //  wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // actions = new Actions(driver);
        //  driver.get(url);
    }

    public static WebDriver getDriver() {
        return treadDriver.get();
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        // java -jar selenium-server-4.12.1.jar standalone --selenium-manager true
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://10.0.0.126:4444";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "Edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-edge":
                caps.setCapability("browserName", "Edge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "cloud":
                return setupLambda();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
        }
    }

    private WebDriver setupLambda() throws MalformedURLException {
        String hubURL = "https://hub.lambdatest.com/wd/hub";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("118.0");
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", "natalia.kim01");
        ltOptions.put("accessKey", "Sutj1EFceKAIKq1ObXjsTxF1Zma0KKxb0WKLFr8HSioYsaOuFE");
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }

    @AfterMethod
    public void closeBrowser() {
        treadDriver.get().close();
        treadDriver.remove();
        // driver.quit();
    }

    public void navigateToPage() {
        getDriver().get(url);
    }
}


