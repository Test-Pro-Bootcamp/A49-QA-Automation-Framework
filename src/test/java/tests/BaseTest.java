package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import pages.BasePage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;

public class BaseTest {

    WebDriver driver;
    BasePage basePage;
    public String url = "https://qa.koel.app/";

    @BeforeClass
    //@Parameters({"baseURL"})
    public void setUpBrowser(@Optional String baseURL) throws MalformedURLException {
        String browser = System.getProperty("browser");
        driver=pickBrowser(browser);
        basePage = new BasePage(driver);
        basePage.navigateToPage(url);
    }
    @AfterClass
    public void closeBrowser() {
        driver.quit();
        //driver.close();
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.1.198:4444";

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsChrome = new ChromeOptions();
                //optionsChrome.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
                optionsChrome.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito");
                optionsChrome.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                return driver = new ChromeDriver(optionsChrome);
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments("-private");
                return driver = new FirefoxDriver(optionsFirefox);
            case "edge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-edge":
                capabilities.setCapability("browserName", "edge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "cloud":
                return setupLambda();
            default:
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
//                WebDriverManager.chromedriver().setup();
//                ChromeOptions optionChrome = new ChromeOptions();
//                //optionsChrome.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
//                optionChrome.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito");
//                optionChrome.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//                return driver = new ChromeDriver(optionChrome);
        }
    }

    public WebDriver setupLambda() throws MalformedURLException {
        String hubURL ="https://hub.lambdatest.com/wd/hub";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("117.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "alina.salnik");
        ltOptions.put("accessKey", "1RMqJHjZhPfrJM7hhUuIQRCLeSR1HuYtFMFC91fpwx3pcL0l7p");
        ltOptions.put("project", "TestPro");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        browserOptions.setCapability("LT:Options", ltOptions);
        return  new RemoteWebDriver(new URL(hubURL),browserOptions);
    }




}