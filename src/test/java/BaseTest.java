import com.github.hemanthsridhar.CSVUtils;
import com.github.hemanthsridhar.lib.ExtUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver = null;
    //public static Actions actions = null;

    //public String url = "https://qa.koel.app/";
    public String url;

    WebDriverWait wait;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters ("BaseURL")
    public void launchBrowser(String baseUrl) {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        url = baseUrl;
        driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    public void navigateToPage() {
        driver.get(url);
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector( "[type = 'password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmitButton() {
        WebElement submitButton = driver.findElement(By.cssSelector("[type = 'submit']"));
        submitButton.click();
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

    @DataProvider(name = "csvData")
    public Object[][] csvDataRead() throws Exception {
        String path ="src/test/resources/TestData.csv";
        ExtUtils ext = new CSVUtils(path,false);
        return ext.parseData();
    }

    public void loginToKoel() {
        navigateToPage();
        provideEmail("alina.nikolaienko@testpro.io");
        //provideEmail("demo@testpro.io");
        providePassword("OPJKDUhA");
        //providePassword("te$t$tudent");
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type = 'submit']")));
        clickSubmitButton();
    }

    @DataProvider (name = "User Credentials")
    public static Object[][] getDataFromDataProviders() {
        return new Object[][]{
                {"alina.nikolaienko@testpro.io", "OPJKDUhA"},
                {"demo@testpro.io", "te$t$tudent"}
        };
    }

    public void loginToKoelWithDataProvider(String email, String password){
        navigateToPage();
        provideEmail(email);
        providePassword(password);
        clickSubmitButton();
    }


}