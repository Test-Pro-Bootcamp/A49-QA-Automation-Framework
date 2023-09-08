import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;

public class BaseTest {
    WebDriver driver;
    public String url = "https://qa.koel.app/";
//    BasePage basepage;

    @BeforeClass
    public void setupSuite() throws MalformedURLException {
//        driver = setupBrowser(System.getProperty("browser"));
        String browser = System.getProperty("browser");
        driver = setupBrowser(browser);
//        driver.get(url);
//        setupFirefox();
//        setupSafari();
//        setupChrome();
    }
//    @BeforeClass
//    public void launchBrowser() {
//
//        basepage = new BasePage(driver);
//        basepage.openLoginUrl(url);
//    }
    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
    WebDriver setupBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.68.53:4444";
        switch (browser){
            case "firefox":
                return setupFirefox();
            case "chrome":
                return setupChrome();
            case "safari":
                return setupSafari();
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-safari":
                caps.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            default:
                return setupChrome();
        }
    }
    public WebDriver setupFirefox(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return driver;
    }
    public WebDriver setupSafari(){
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        return driver;
    }
    public WebDriver setupChrome(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        return driver;
    }
}
