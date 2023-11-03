

import io.github.bonigarcia.wdm.WebDriverManager;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.BeforeSuite;
        import org.testng.annotations.Parameters;

        import java.time.Duration;

public class BaseTest {

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-orgins=*");

        ChromeDriver driver;
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        url = BaseURL;
        navigateToPage();
    }



    public void navigateToPage() {
        driver.get(url);
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("button[type='submit']")));
        submit.click();
    }