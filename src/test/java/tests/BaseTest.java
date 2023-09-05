package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import pages.BasePage;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    public String url = "https://qa.koel.app/";
    //public String url;

    BasePage basePage;

    @BeforeSuite
    static void setupClass() {

        WebDriverManager.chromedriver().setup();
    }

    //@BeforeMethod

/*
    @Parameters ("BaseURL")
    public void launchBrowser(String baseUrl) {
        // Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        url = baseUrl;
        driver = new ChromeDriver(options);
        basePage = new BasePage(driver);
        basePage.navigateToPage(baseUrl);
    }*/

    //@BeforeTest
    @BeforeClass
    public void launchBrowser() {
        // Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);

        basePage = new BasePage(driver);
        basePage.navigateToPage(url);
    }

    //@AfterClass
    @AfterClass
    public void quitBrowser(){
        basePage.closeBrowser();
    }

    /*
    @DataProvider(name = "csvData")
    public Object[][] csvDataRead() throws Exception {
        String path ="src/test/resources/TestData.csv";
        ExtUtils ext = new CSVUtils(path,false);
        return ext.parseData();
    }*/

    @DataProvider(name = "User Credentials")
    public static Object[][] getDataFromDataProviders() {
        return new Object[][]{
                {"alina.nikolaienko@testpro.io", "OPJKDUhA"},
                {"demo@testpro.io", "te$t$tudent"}
        };
    }

    /*
    public void provideEmail(String email) {
        String emailFieldLocator = "[type = 'email']";
        WebElement emailField = driver.findElement(By.cssSelector(emailFieldLocator));
        findElementByLocator(By.cssSelector(emailFieldLocator));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        String passwordFieldLocator = "[type = 'password']";
        WebElement passwordField = driver.findElement(By.cssSelector(passwordFieldLocator));
        findElementByLocator(By.cssSelector(passwordFieldLocator));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmitButton() {
        String submitButtonLocator = "[type = 'submit']";
        WebElement submitButton = driver.findElement(By.cssSelector(submitButtonLocator));
        findElementByLocator(By.cssSelector(submitButtonLocator));
        submitButton.click();
    }

    void findElementByLocator(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    */


}