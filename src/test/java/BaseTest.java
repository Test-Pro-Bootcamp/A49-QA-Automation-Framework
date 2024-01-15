import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.UUID;

// BaseTest class for common test setup and reusable methods
public class BaseTest {

    // WebDriver instance and base URL for the application
    public WebDriver driver = null;
    public String url = "https://qa.koel.app/";

    // Setup WebDriverManager for Chrome before the test suite starts
    @BeforeSuite
    void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    // Method to launch the Chrome browser with necessary options
    @BeforeMethod
    public void launchBrowser() {
        // Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Initialize ChromeDriver with options and set timeouts
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    // Method to close the browser after each test method
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    // Method to navigate to the specified application URL
    public void navigateToPage() {
        driver.get(url);
    }

    // Method to input email in the login form
    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    // Method to input password in the login form
    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    // Method to click the submit button in the login form
    public void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }

    // Method to check if the avatar icon is displayed
    public void isAvatarDisplayed() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    // Method to click the save button in a form
    public void clickSaveButton() {
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

    // Method to input profile name in a form
    public void provideProfileName(String randomName) {
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    // Method to input current password in a form
    public void provideCurrentPassword(String password) {
        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    // Method to generate a random name using UUID
    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    // Method to click the avatar icon on the page
    public void clickAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }
}