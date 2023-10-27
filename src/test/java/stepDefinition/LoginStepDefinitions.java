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


    @Given("I open Login page")
    public void iOpenLoginPage() {
        BaseDefinition.getThreadLocal().get("https://qa.koel.app/");
    }

    @When("I cast email {string}")
    public void iCastEmail(String email) {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.castEmail(email);
    }

    @And("I cast password {string}")
    public void iCastPassword(String password) {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.castPassword(password);
    }

    @And("I cast submit")
    public void iCastSubmit() {
        LoginPage loginPage= new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.castSubmit();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        LoginPage loginPage= new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.portalIn();
    }
}
