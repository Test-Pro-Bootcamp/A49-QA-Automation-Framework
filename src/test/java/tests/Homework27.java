package tests;

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
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class Homework27 {

    LoginPage loginPage;
    HomePage homePage;

    WebDriver driver;
    WebDriverWait wait;
    String url = "https://qa.koel.app/";
    @Before
    public void iOpenBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
    @Given("I open Login Page")
    public void iOpenLoginPage() {
        driver.get(url);
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        loginPage.provideEmail(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        loginPage.providePassword(password);
    }

    @And("I click Submit")
    public void iClickSubmit() {
        loginPage.clickSubmit();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        homePage.avatarImgIsDisplayed();
    }
}
