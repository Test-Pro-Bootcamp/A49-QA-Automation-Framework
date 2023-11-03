import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public String url = "https://qa.koel.app/";

    @BeforeSuite
    public void setupSuite() throws MalformedURLException {
       String browser =System.getProperty("browser");

        driver=setupBrowser(browser);

//        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    public void launchBrowser() {
//        //      Added ChromeOptions argument below to fix websocket error
////        ChromeOptions options = new ChromeOptions();
////        options.addArguments("--remote-allow-origins=*");
////        options.addArguments("--disable-notifications");
////        options.addArguments("--start-maximized");
////        driver = new ChromeDriver(options);
//        driver= new FirefoxDriver();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);

    }

    @AfterMethod
    public void closeBowser() {
        driver.quit();
    }
WebDriver setupBrowser(String browser) throws MalformedURLException {
    DesiredCapabilities caps =new DesiredCapabilities();
    String gridURL=" http://192.168.1.196:4444 ";
        switch(browser){
            case"firefox":
                return setupFirefox();
            case "chrome":
                return setupChrome();

            case"grid-chrome":
                caps.setCapability("browserName","chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case"grid-firefox":
                caps.setCapability("browserName","firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
//            case "edge":
//                return setEdge();
            default:
                return setupChrome();
        }
}
    WebDriver setupFirefox(){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        return driver;
    }
   WebDriver setupChrome(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        return driver;
    }
}

