import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.*;


import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;



public class BaseTest {
    public static WebDriver theDriver;
    public String baseUrl = "https://qa.koel.app/";

    @BeforeClass
    public void setupClass() throws MalformedURLException {
        String browser = System.getProperty("browser");
        theDriver = setupBrowser(browser);
        //theDriver.get(baseUrl);
    }
//

    @AfterClass
    public void closerBrowser() {
        theDriver.quit();
    }


//    @AfterClass
//    public void closerBrowser() {
//
//        theDriver.quit();
//    }
    public WebDriver setupBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.226:4444";
        switch (browser) {
            case "firefox":
                return setupFirefox();
            case "chrome":
                return setupChrome();
            case "edge":
                return setupEdge();
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return theDriver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-edge":
                caps.setCapability("browserName", "edge");
                return theDriver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            default:
                return setupChrome();
        }
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

}
