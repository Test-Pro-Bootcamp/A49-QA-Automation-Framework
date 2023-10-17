package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;

import java.time.Duration;

public class LoginStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;


    @Before
    public void iOpenBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

    @Given("I open Login page")
    public void iOpenLoginPage() {
        driver.get("https://qa.koel.app/");
    }

    @When("I cast email {string}")
    public void iCastEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.castEmail(email);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(email);
    }

    @And("I cast password {string}")
    public void iCastPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.castPassword(password);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']"))).sendKeys(password);
    }

    @And("I cast submit")
    public void iCastSubmit() {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.castSubmit();
        //wait.until((ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']")))).click();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.portalIn();
        //Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
    }
}
