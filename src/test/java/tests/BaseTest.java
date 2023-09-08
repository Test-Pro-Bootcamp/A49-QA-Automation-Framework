package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import pages.BasePage;

public class BaseTest {
    public WebDriver driver;

    public String url = "https://qa.koel.app/";

    BasePage basePage;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void launchBrowser() {
        // Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //actions = new Actions(driver);

        basePage = new BasePage(driver);
        basePage.navigateToPage(url);
    }

    @AfterClass
    public void quitBrowser(){
        basePage.closeBrowser();
    }

    @DataProvider(name = "User Credentials")
    public static Object[][] getDataFromDataProviders() {
        return new Object[][]{
                {"alina.nikolaienko@testpro.io", "OPJKDUhA"},
                {"demo@testpro.io", "te$t$tudent"}
        };
    }


}