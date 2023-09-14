import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();
    private WebDriver driver;
    public static WebDriver getThreadLocal() {
        return THREAD_LOCAL.get();}
    @BeforeMethod
    @Parameters({"baseURL"})
    public void setUpBrowser(@Optional String baseURL) throws MalformedURLException {
        THREAD_LOCAL.set(pickBrowser(System.getProperty("browser")));
        THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        THREAD_LOCAL.get().manage().window().maximize();
        THREAD_LOCAL.get().manage().deleteAllCookies();
        getThreadLocal().get(baseURL);
        System.out.println(
                "Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : " + getThreadLocal());
    }
    public WebDriver lambdaTest() throws MalformedURLException {
        String username = "e8023240";
        String authkey = "tTQe1rEJHtZfTM5jAvbLFgPJy3BhjoQIyNV0U1QslR9sb9OoD1";
        String hub = "@hub.lambdatest.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "110.0");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("name", this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }
    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.68.55:4444";

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments("-private");
                return driver = new FirefoxDriver(optionsFirefox);
            case "edge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-edge":
                capabilities.setCapability("browserName", "edge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
                optionsChrome.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                return driver = new ChromeDriver(optionsChrome);
        }
    }
    @AfterMethod
    public void tearDown() {
        THREAD_LOCAL.get().close();
        THREAD_LOCAL.remove();
    }
//    public WebDriver setupFirefox(){
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
//        return driver;
//    }
//    public WebDriver setupSafari(){
//        WebDriverManager.safaridriver().setup();
//        driver = new SafariDriver();
//        return driver;
//    }
//    public WebDriver setupChrome(){
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--disable-notifications");
//        options.addArguments("--start-maximized");
//        driver = new ChromeDriver(options);
//        return driver;
//    }
}
