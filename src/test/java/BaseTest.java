import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import com.github.hemanthsridhar.CSVUtils;
import com.github.hemanthsridhar.lib.ExtUtils;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver = null;

    //public String url = "https://qa.koel.app/";
    public String url;
    @BeforeSuite
    static void setupClass() {

        WebDriverManager.chromedriver().setup();


    }

    @BeforeMethod
    @Parameters ("BaseURL")
    public void launchBrowser(String baseUrl) throws InterruptedException {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        url = baseUrl;
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().window().maximize();




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
        //passwordField.sendKeys("te$t$tudent");
    }

    public void clickSubmitButton() {
        WebElement submitButton = driver.findElement(By.cssSelector("[type = 'submit']"));
        submitButton.click();

    }

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