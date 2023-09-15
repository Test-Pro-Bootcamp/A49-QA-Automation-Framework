package tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
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
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    public static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public int timeSeconds = 3;
    public static WebDriver driver = null;
    public static String url = null;

//    @BeforeSuite
//    static void setupClass() {
//
//        WebDriverManager.chromedriver().setup();
//    }

    protected static WebDriver getThreadLocal() {
        return threadDriver.get();
    }

    @Before
    public void setUpBrowser() throws MalformedURLException {
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        threadDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(timeSeconds));
    }

    @After
    public void tearDown() {
        threadDriver.get().close();
        threadDriver.remove();
    }

//    @BeforeMethod
//    @Parameters({"BaseURL"})
//    public void launchBrowser(String BaseURL) throws MalformedURLException {
//
//        threadDriver = pickBrowser(System.getProperty("browser"));
//        threadDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        threadDriver.manage().window().maximize();
//
//        url = BaseURL;
//        navigateToPage();
//    }

//    @AfterClass
//    public void closeBrowser() {
//
//        driver.quit();
//    }

//    public void navigateToPage() {
//
//        driver.get(url);
//    }


    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://10.0.0.243:4444";

        switch (browser) {

            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);

            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "cloud":
                return setupLambda();

            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
        }
    }

    WebDriver setupLambda() throws MalformedURLException {
        String hubURL = "https://hub.lambdatest.com/wd/hub";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("117.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "svitlana.shkribliak");
        ltOptions.put("accessKey", "wt1jP4TKJgDyO3qiokgxdT9EeRAx1UpeM2yIIJMzdTm5AVovHs");
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);
        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }

}
