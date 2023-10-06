package stepDefinition;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.signature.qual.CanonicalNameAndBinaryName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.time.Duration;

public class LoginStepDefinitions {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    @Given ("I open browser")
    public void openBrowser () {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @And ("I open Login page")
    public void openLoginPage() {
        driver.get("https://qa.koel.app/");
    }

    @When ("I enter email {string}")
    public void iEnterEmail (String email) {
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.CssSelector("[type='email']"))).sendKeys(email);
    }

    @And ("I enter email {password}")
    public void iEnterPassword (String password) {
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.CssSelector("[type='password']"))).sendKeys(password);
    }

    @And ("I submit")
    public void clickSubmit () {
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.CssSelector("[type='submit']"))).click();
    }

    @Then ("I am logged in")
    public void userIsLoggedIn () {
        () -> Assert.assertTrue(wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.CssSelector("img.avatar"))).isDisplayed();
    }

    @AfterClass
    public void closeBrowser();
}
