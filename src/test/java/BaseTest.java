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
import pages.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;

public class BaseTest {
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static WebDriver getThreadDriver() {
        return threadDriver.get();
    }

    public WebDriver driver;
    public String url = "https://qa.koel.app/";
    public WebDriverWait wait;
    public Actions actions;
    BasePage basePage;
    LoginPage loginPage;
    HomePage homePage;
    PlaylistPage playlistPage;



    @BeforeClass
    public void setUp() throws MalformedURLException {
        threadDriver.set(setupBrowser(!(System.getProperty("browser")==null)?System.getProperty("browser"):"chrome"));
        System.out.println("Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : " + getThreadDriver());
    }

    private WebDriver setupBrowser(String browser) throws MalformedURLException {
        switch (browser){
            case "firefox":
                return setupFireFox();
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
        String hubURL ="https://hub.lambdatest.com/wd/hub";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("118.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "rijoal1987");
        ltOptions.put("accessKey", "ajyxRGi1nb6NJtmmbg70g3khx6Uj1AIQnLndw7HjUVpvaGwtQH");
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);
        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }

    public WebDriver setupFireFox(){
        WebDriverManager.firefoxdriver().setup();
        driver =new FirefoxDriver();
        return driver;
    }
    public WebDriver setupEdge() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--remote-allow-origins=*");
        return driver = new EdgeDriver(edgeOptions);

    }
    public WebDriver setupChrome(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        return driver;
    }
    @AfterClass
    public void closeBrowser() {
        threadDriver.get().close();
        threadDriver.remove();
    }
}
