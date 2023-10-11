import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    public WebDriver driver = null;
    public String url = "https://qa.koel.app/";
    public ThreadLocal<WebDriver> threadLocal = null;

    @BeforeSuite
    static void setupClass() {
//        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser() throws MalformedURLException {
        threadLocal.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        navigateToPage();
    }

    public WebDriver getDriver() {
        return threadLocal.get();
    }
    @AfterMethod
    public void closeBrowser() {
        getDriver().quit();
        threadLocal.remove();
    }

    //public WebDriver lambdaTest() throws MalformedURLException {
       // String hubURL = "https://hub.lambdatest.com/wd/hub";

        //DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("browserName", "Firefox");
        //capabilities.setCapability("browserVersion", "107.0");
       // HashMap<String, Object> ltOptions = new HashMap<>();
       // ltOptions.put("user", "");
       // ltOptions.put("accessKey", "");
       // ltOptions.put("build", "Selenium 4");
        //ltOptions.put("name", this.getClass().getName());
        //ltOptions.put("platformName", "Windows 10");
        //ltOptions.put("seCdp", true);
        //ltOptions.put("selenium_version", "4.0.0");
        //capabilities.setCapability("LT:Options", ltOptions);


        public WebDriver setupLambda() throws MalformedURLException {
            String hubURL ="https://hub.lambdatest.com/wd/hub";
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName("Windows 10");
            browserOptions.setBrowserVersion("118.0");
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("username", "pchelka2403");
            ltOptions.put("accessKey", "iWoJQtVRhbISVR6VF8HEpM9EQhjYcjYW9zyhr1ITcBu1Us9K7n");
            ltOptions.put("project", "Untitled");
            ltOptions.put("selenium_version", "4.0.0");
            ltOptions.put("w3c", true);
            browserOptions.setCapability("LT:Options", ltOptions);
            return  new RemoteWebDriver(new URL(hubURL),browserOptions);

           }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.55.103:4444";//replace with your grid url

        switch (browser) {
            case "firefox": // gradle clean test -Dbrowser=firefox
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();

            case "MicrosoftEdge": // gradle clean test -Dbrowser=MicrosoftEdge
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);

            case "grid-edge": // gradle clean test -Dbrowser=grid-edge
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-firefox": // gradle clean test -Dbrowser=grid-firefox
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-chrome": // gradle clean test -Dbrowser=grid-chrome
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "cloud": // gradle clean test -Dbrowser=cloud
                return lambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
        }
    }

    private WebDriver lambdaTest() {
        return null;
    }


    public void navigateToPage() {
        getDriver().get(url);

    }
}