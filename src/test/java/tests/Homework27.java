package tests;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class Homework27 {

    LoginPage loginPage;
    HomePage homePage;

    @Before
    public void setUp(){
        loginPage = new LoginPage(BaseTest.getThreadLocal());
        homePage = new HomePage(BaseTest.getThreadLocal());
    }

    @Given("I open Login Page")
    public void openLoginPage() {
        BaseTest.getThreadLocal().get("https://qa.koel.app/");
    }

    @When("I enter email {string}")
    public void enterEmail(String email) {
        loginPage.provideEmail(email);
    }

    @And("I enter password {string}")
    public void enterPassword(String password) {
        loginPage.providePassword(password);
    }

    @And("I click Submit")
    public void clickSubmit() {
        loginPage.clickSubmit();
    }

    @Then("I am logged in")
    public void loggedIn() {
        homePage.avatarImgIsDisplayed();
    }

    @And("I enter incorrect password {string}")
    public void enterIncorrectPassword(String password) {
        loginPage.providePassword(password);
    }

    @Then("I still Login page")
    public void stillLoginPage() {
        LoginPage loginPage = new LoginPage(BaseTest.getThreadLocal());
        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    @When("I enter Not existing email {string}")
    public void enterNotExistingEmail(String email) {
        loginPage.provideEmail(email);
    }

    @When("I enter Empty email {string}")
    public void enterEmptyEmail(String email) {
        loginPage.provideEmail(email);
    }

    @And("I enter Empty password {string}")
    public void enterEmptyPassword(String password) {
        loginPage.providePassword(password);
    }
}
