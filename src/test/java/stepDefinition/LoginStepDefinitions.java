package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;


public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());

    @Given("I open Login page")
    public void iOpenLoginPage() {
        BaseDefinition.getThreadLocal().get("https://qa.koel.app/");
    }

    @When("I cast email {string}")
    public void iCastEmail(String email) {
        loginPage.castEmail(email);
    }

    @And("I cast password {string}")
    public void iCastPassword(String password) {
        loginPage.castPassword(password);
    }

    @And("I cast submit")
    public void iCastSubmit() {
        loginPage.castSubmit();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        loginPage.portalIn();
    }
}
