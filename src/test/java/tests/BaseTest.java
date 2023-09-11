package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import pages.BasePage;

import java.net.MalformedURLException;
import java.net.URI;

public class BaseTest {
    public WebDriver driver;

    //public WebDriverWait wait;
    public String url = "https://qa.koel.app/";

    BasePage basePage;

    @BeforeSuite
    public void setupSuite() throws MalformedURLException {
        //was here before creating setupChrome and setupFirefox methods
        //WebDriverManager.chromedriver().setup();
        String browser = System.getProperty("browser");
        //String browser = "grid-chrome";
        driver=setupBrowser(browser);
    }

    WebDriver setupBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.198:4444";
        switch (browser){
            case "firefox":
                return setupFirefox();
            case "chrome":
                return setupChrome();
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            default:
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
        }
    }

  //  @BeforeClass
   // public void launchBrowser() {
        /*//moved to setupChrome method
        // Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //actions = new Actions(driver);*/

        //basePage = new BasePage(driver);
        //basePage.navigateToPage(url);
   // }



    @AfterClass
    public void quitBrowser(){
        //basePage.closeBrowser();
        driver.quit();
    }

    WebDriver setupFirefox(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return driver;
    }

    WebDriver setupChrome(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        return driver;

    }

    @DataProvider(name = "User Credentials")
    public static Object[][] getDataFromDataProviders() {
        return new Object[][]{
                {"alina.nikolaienko@testpro.io", "OPJKDUhA"},
                {"demo@testpro.io", "te$t$tudent"}
        };
    }


}