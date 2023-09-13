package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BaseTest {

    private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();
    private WebDriver driver;

    public static WebDriver getThreadLocal() {
        return THREAD_LOCAL.get();
    }

    public String url = "https://qa.koel.app/"; ///???


    @BeforeMethod
    public void setUpBrowser(String browser) throws MalformedURLException {
        THREAD_LOCAL.set(setupBrowser(browser));

        //THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //THREAD_LOCAL.get().manage().window().maximize();
        //THREAD_LOCAL.get().manage().deleteAllCookies();
        getThreadLocal().get(url);
        System.out.println(
                "Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : " + getThreadLocal());

    }
    /*
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    public String url = "https://qa.koel.app/";

    BasePage basePage;


    @BeforeClass
    public void setupSuite() throws MalformedURLException {

        String browser = System.getProperty("browser");
        driver = setupBrowser(browser);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        driver.get(url);
    }*/

    private WebDriver setupBrowser(String browser) throws MalformedURLException {
        //DesiredCapabilities capabilities = new DesiredCapabilities();
        //String gridURL = "http://10.2.127.17:4444";

        switch (browser){
            case "chrome":
                return setupChrome();
            case "cloud":
                return setupLambda();
            case "firefox":
                return setupFirefox();
            default:
                return setupChrome();
        }
    }

    public WebDriver setupChrome(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        return driver;
    }

    public WebDriver setupFirefox(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return driver;
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

    @AfterMethod
    public void tearDown() {
        THREAD_LOCAL.get().close();
        THREAD_LOCAL.remove();
    }

    /*@AfterClass
    public void quitBrowser(){
        driver.quit();
    }

    @DataProvider(name = "User Credentials")
    public static Object[][] getDataFromDataProviders() {
        return new Object[][]{
                {"alina.nikolaienko@testpro.io", "OPJKDUhA"},
                {"demo@testpro.io", "te$t$tudent"}
        };
    }*/


}