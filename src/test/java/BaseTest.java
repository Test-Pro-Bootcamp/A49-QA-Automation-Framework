import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import pages.BasePage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;

public class BaseTest {
    public WebDriver driver ;
    public String url = "https://qa.koel.app/";


    @BeforeClass
    public void setupClass() throws MalformedURLException {
        String browser = System.getProperty("browser");
        driver=setupBrowser(browser);
    }
    WebDriver setupLambda() throws MalformedURLException {
        String username="";
        String authkey = "";
        String hubURL ="@hub.lambdatest.com/wd/hub";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("117.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "ludachernyh");
        ltOptions.put("accessKey", "FlpKz6EP1REjfws08JSqIF6F2Q9q7b9oqaJllbbrYMs5lW5VPT");
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);


        return new RemoteWebDriver(new URL(hubURL), browserOptions);


    }
    WebDriver setupBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        String gridURL = "http://192.168.1.105:4444";
        switch(browser) {
            case "chrome":
                return setupChrome();
            case "safari":
                return setupSafari();
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "cloud":
                return setupLambda();

            default:
                return setupChrome();
        }
    }



    public WebDriver setupSafari(){
        WebDriverManager.safaridriver().setup();
        driver =new SafariDriver();
        return driver;
    }
    public WebDriver setupChrome(){
        WebDriverManager.chromedriver().setup();
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        return driver;
    }
    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}