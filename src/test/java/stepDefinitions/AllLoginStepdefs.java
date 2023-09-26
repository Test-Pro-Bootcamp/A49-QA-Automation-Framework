package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import pages.LoginPage;

import java.time.Duration;

public class AllLoginStepdefs {
    WebDriver theDriver;
    WebDriverWait wait;


        @Before
        public void openBrowser() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--remote-allow-origins=*");

            theDriver = new ChromeDriver(options);
            theDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        @After
        public void closeBroser() {
            theDriver.quit();
        }

        @Given("I open login page")
        public void openLoginPage() {
            theDriver.get("https://qa.koel.app/");
        }
        @When("I enter email {string}")
        public void i_enter_email(String email) {
            LoginPage loginPage = new LoginPage(theDriver);
            loginPage.enterEmail(email);
        }

        @And("I enter password {string}")
        public void i_enter_password(String password) {
            LoginPage loginPage = new LoginPage(theDriver);
            loginPage.enterPassword(password);
        }
        @And("I click submit button")
        public void clickSubmit() {
            LoginPage loginPage = new LoginPage(theDriver);
            loginPage.clickLogin();
        }

    @Then("I am logged in")
    public void userIsLoggedIn() {
        LoginPage homePage = new LoginPage(theDriver);
        Assert.assertTrue(homePage.isAvatarDisplayed());
    }
    }


