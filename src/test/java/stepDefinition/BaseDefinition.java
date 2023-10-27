package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseDefinition {
    public static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();
    private int timeSeconds = 3;

    public static WebDriver getThreadLocal() {
        return THREAD_LOCAL.get();
    }

    @Before
    public void setUpBrowser() throws MalformedURLException {
        String browserType = System.getProperty("browser", "chrome");
        WebDriver driver = pickBrowser(browserType);
        THREAD_LOCAL.set(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeSeconds));

        System.out.println("Browser setup by Thread" + Thread.currentThread().getId() + " and Driver reference is : " + driver);
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.1.198:4444";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments("-private");
                return new FirefoxDriver(optionsFirefox);
            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-edge":
                capabilities.setCapability("browserName", "edge");
                return new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                return new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito");
                optionsChrome.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                return new ChromeDriver(optionsChrome);
        }
    }

    @After
    public void tearDown() {
        WebDriver driver = THREAD_LOCAL.get();
        if (driver != null) {
            driver.quit();
            THREAD_LOCAL.remove();
        }
    }
}