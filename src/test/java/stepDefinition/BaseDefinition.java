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
    private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();
    private int timeSeconds = 3;


    // This method returns the WebDriver instance stored in the ThreadLocal variable.
    public static WebDriver getThreadLocal() {
        return THREAD_LOCAL.get();
    }

    @Before
    public void setUpBrowser() throws MalformedURLException {
        String browserType = System.getProperty("browser", "chrome");
        WebDriver driver = pickBrowser(browserType); // Use pickBrowser to create the WebDriver instance
        //WebDriver driver = pickBrowser(System.getProperty("browser")); // Always use Chrome
        THREAD_LOCAL.set(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeSeconds));

        System.out.println("Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : " + driver);
    }

    // This method selects the browser based on the provided input and returns the corresponding WebDriver instance.
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
            driver.quit(); // Use quit() to ensure proper cleanup
            THREAD_LOCAL.remove();
        }
    }

//    @After
//    public void tearDown() {
//        THREAD_LOCAL.get().close();
//        THREAD_LOCAL.remove();
//    }
}