//package stepDefinitions;
//import io.cucumber.java.After;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.testng.annotations.BeforeMethod;
//import pageObjects.LoginPage;
//public class LoginSteps {
//    @BeforeMethod
//    public static void iOpenBrowser() {
//        LoginPage.iOpenLogin();
//    }
//    @After
//    public static void closeBrowser(){
//        LoginPage.closeBrowser();
//    }
//    @Given("I open Login")
//    public void iOpenLogin() {
//        LoginPage.iOpenLogin();
//    }
//    @When("I enter email {string}")
//    public void iEnterEmail(String email) {
//        LoginPage.iEnterEmail(email);
//    }
//    @And("I enter password {string}")
//    public void iEnterPassword(String password) {
//        LoginPage.iEnterPassword(password);
//    }
//    @And("I submit")
//    public void iSubmit() {
//        LoginPage.iSubmit();
//    }
//    @Then("I aam logged in")
//    public void iAamLoggedIn() {
//        LoginPage.iAamLoggedIn();
//    }
//}