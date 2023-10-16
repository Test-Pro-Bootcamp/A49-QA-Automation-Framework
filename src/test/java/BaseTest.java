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

public class BaseTest {
       public WebDriver driver = null;
       public String url = "https://qa.koel.app/";
        @BeforeSuite
        static void setupClass() {
            WebDriverManager.chromedriver().setup();
        }
        @BeforeMethod
        public void launchBrowser() {
        //Added ChromeOptions argument below to fix websocket error
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-notifications");
            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

        @AfterMethod
        public void closeBrowser() {
            driver.quit();
    }

        public void navigateToPage() {
            driver.get(url);
    }
        public void provideEmail(String email) {
            WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
            emailField.clear();
            emailField.sendKeys(email);
    }

        public void providePassword(String password) {
             WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
             passwordField.clear();
             passwordField.sendKeys(password);
    }

        public void clickSubmit() {
            WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
            submit.click();
    }

        public void clickAvatarIcon() {
             WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
             avatarIcon.click();
    }

        public void isAvatarDisplayed() {
            WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
            Assert.assertTrue(avatarIcon.isDisplayed());
    }

        public String generateRandomName() {
            return UUID.randomUUID().toString().replace("-", "");
    }


        public void loginWithCorrectCreds() {
            navigateToPage();
            provideEmail("andrew.oleary@testpro.io");
            providePassword("te$t$tudent437");
            clickSubmit();

    }
        public void enterText(By inputLocator, String inputText) {
            WebElement searchInput = driver.findElement(inputLocator);
            searchInput.click();
            searchInput.clear();
            searchInput.sendKeys(inputText);
    }

}
