import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;


import java.net.MalformedURLException;
import java.net.URI;

public class BaseTest {
    private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();
    private WebDriver driver;

    public static WebDriver getThreadLocal() {
        return THREAD_LOCAL.get();
    }
    //public WebDriver driver ;
    public String url = "https://qa.koel.app/";

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        THREAD_LOCAL.set(setupBrowser(System.getProperty("browser")));
        System.out.println(
                "Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : " + getThreadLocal());
            getThreadLocal().get(url);
    }

    private WebDriver setupBrowser(String browser) throws MalformedURLException {
        switch(browser) {
            case "firefox":
                return setupFirefox();
            case "chrome":
                return setupChrome();
            case "safari":
                return setupSafari();
            case "cloud":
                return setupLambda();
            default:
                return setupChrome();
        }
    }

    WebDriver setupLambda() throws MalformedURLException {
        String hubURL ="https://hub.lambdatest.com/wd/hub";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("118.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "amx2044");
        ltOptions.put("accessKey", "uRYSrUiTBAvwnEDAsKWg1Bjhd9gq2DjccjRHUE8NdMRv5jlSvV");
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);
        return  new RemoteWebDriver(new URL(hubURL),browserOptions);
    }
    WebDriver setupChrome(){
        WebDriverManager.chromedriver().setup();
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        return driver;
    }
    WebDriver setupFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return driver;
    }

    WebDriver setupSafari(){
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        return driver;
    }
    @AfterMethod
    public void tearDown() {
        THREAD_LOCAL.get().close();
        THREAD_LOCAL.remove();
    }
}