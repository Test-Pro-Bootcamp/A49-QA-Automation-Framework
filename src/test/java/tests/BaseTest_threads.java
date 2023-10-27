package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;


public class BaseTest_threads {

    private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();
    private WebDriver driver;

    public static WebDriver getThreadLocal() {
        return THREAD_LOCAL.get();
    }



    @BeforeMethod
    @Parameters({"baseURL"})
    public void setUpBrowser(@Optional String baseURL) throws MalformedURLException {
        THREAD_LOCAL.set(pickBrowser(System.getProperty("browser")));
        THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getThreadLocal().get(baseURL);
        System.out.println(
                "Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : " + getThreadLocal());
    }


    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.1.198:4444";

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--disable-notifications","--remote-allow-origins=*");
                optionsChrome.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                return driver = new ChromeDriver(optionsChrome);
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments("-private");
                return driver = new FirefoxDriver(optionsFirefox);
            case "edge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            default:
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);

        }
    }

    @AfterMethod
    public void tearDown() {
        WebDriver driver = THREAD_LOCAL.get();
        if (driver != null) {
            driver.quit();
            THREAD_LOCAL.remove();
        }
    }

}