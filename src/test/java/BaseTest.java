import com.github.hemanthsridhar.CSVUtils;
import com.github.hemanthsridhar.lib.ExtUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {
    public WebDriver driver = null;


    public String url;
    //public String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters ("BaseURL")
    public void launchBrowser(String baseURL) throws InterruptedException {
        // Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        url=baseURL;
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().window().maximize();
    }


    @DataProvider(name="IncorrectLoginData")
    public Object[][] getDataFromDataProvider(){
        return new Object[][]{
                {"invalidEmail@testpro.io", "invalidPassword"},
                {"demo@testpro.io", ""},
                {"", ""}
        };
    }

    @DataProvider(name="StaticIncorrectLoginData")
    public static Object[][] getDataFromDataProviderStatic(){
        return new Object[][]{
                {"invalidEmail@testpro.io", "invalidPassword"},
                {"demo@testpro.io", ""},
                {"", ""}
        };
    }

    @DataProvider(name="cvsData")
    public Object[][] csvDataRead() throws Exception{
        String path= "src/test/resources/TestData.csv";
        ExtUtils ext = new CSVUtils(path, false);
        return ext.parseData();
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
        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmitButton() {
        WebElement submitButton = driver.findElement(By.cssSelector("[type = 'submit']"));
        submitButton.click();
    }


    public void loginToKoel() {
        navigateToPage();
        //provideEmail("alina.nikolaienko@testpro.io");
        provideEmail("demo@testpro.io");
        //providePassword("OPJKDUhA");
        providePassword("te$t$tudent");
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type = 'submit']")));
        clickSubmitButton();
    }

    public void loginToKoelWithDataProvider(String email, String password) {
        navigateToPage();
        provideEmail(email);
        providePassword(password);
        clickSubmitButton();
    }
    @DataProvider (name = "User Credentials")
    public static Object[][] userCredentials(){
        return new Object[][]{
                {"alina.nikolaienko@testpro.io", "OPJKDUhA"},
                {"demo@testpro.io", "te$t$tudent"}
        };
    }


}