import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import java.net.MalformedURLException;
import java.net.URI;

public class BaseTest {
    public WebDriver driver ;
    public String url = "https://qa.koel.app/";
    @BeforeSuite
    public void setupSuit() throws MalformedURLException {
        String browser = System.getProperty("browser");
        driver=setupBrowser(browser);
    }
    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
    WebDriver setupBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.105:4444";
        switch (browser) {
            case "edge" -> {
                return setupEdge();
            }
            case "grid-chrome" -> {
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            }
            case "grid-edge" -> {
                caps.setCapability("browserName", "edge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            }
            default -> {
                return setupChrome();
            }
        }
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
    public WebDriver setupEdge(){
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver =new EdgeDriver(options);
        return driver;
    }
}