import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import pages.*;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;


public class BaseTest {
    private ThreadLocal<WebDriver> threadDriver = null;
//    public static WebDriver getThreadDriver() {
//        return threadDriver.get();
//    }
    public WebDriver theDriver = null;
    public String baseUrl = "https://qa.koel.app/";


    @BeforeClass
    public void setup() throws MalformedURLException {
//        threadDriver.set(setupBrowser(!(System.getProperty("browser")==null)?System.getProperty("browser"):"chrome"));
//        System.out.println("Browser setup by Thread " + Thread.currrentThread().getId() + " and Driver reference is : " + getThreadDriver());
        String browser = System.getProperty("browser");
        theDriver = setupBrowser(browser);
        theDriver.get(baseUrl);
    }
    private WebDriver setupBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.226:4444";
        switch (browser) {
            case "firefox":
                return setupFirefox();
            case "chrome":
                return setupChrome();
            case "edge":
                return setupEdge();
            case "cloud":
                return setupLambda();
            default:
                return setupChrome();
        }
    }
    WebDriver setupLambda() throws MalformedURLException {
        String hubURL = "https://hub.lambdatest.com/wd/hub";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("116.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "6699055");
        ltOptions.put("accessKey", "pin9R5f8o5Rk8tyJWRdzxheCGsVsESIjKPHQhxMRG7Q4bVpkW1");
        ltOptions.put("project", "Untitled");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        browserOptions.setCapability("LT:Options", ltOptions);
        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }




    public WebDriver setupEdge() {
        WebDriverManager.edgedriver().setup();
        theDriver = new EdgeDriver();
        theDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        theDriver.manage().window().maximize();
        theDriver.get(baseUrl);
        return theDriver;
    }
    public WebDriver setupChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");

        theDriver = new ChromeDriver(options);
        theDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        theDriver.manage().window().maximize();
        theDriver.get(baseUrl);

        return theDriver;
    }
    public WebDriver setupFirefox() {
        WebDriverManager.firefoxdriver().setup();
        theDriver = new FirefoxDriver();
        theDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        theDriver.manage().window().maximize();
        theDriver.get(baseUrl);
        return theDriver;
    }
    public WebDriver setupSafari() {
        WebDriverManager.safaridriver().setup();
        theDriver = new SafariDriver();
        theDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        theDriver.manage().window().maximize();
        theDriver.get(baseUrl);
        return theDriver;
    }
    @AfterClass
//    public void tearDown(){
//        threadDriver.get().close();
//        threadDriver.remove();
//    }
    public void closerBrowser() {
        theDriver.quit();
    }


}
