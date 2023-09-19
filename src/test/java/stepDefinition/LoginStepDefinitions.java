package stepDefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginStepDefinitions {
    @Given("I open Login Page")
    public void openLoginPage() {
        BaseDefinition.getThreadLocal().get("https://qa.koel.app/");
    }

    @When("I enter email {string}")
    public void enterEmail(String email) {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.provideEmail(email);
    }

    @And("I enter password {string}")
    public void enterPassword(String password) {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.providePassword(password);
    }

    @And("I submit")
    public void clickSubmit() {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.clickSubmitButton();
    }

    @Then("I am logged in")
    public void userIsLoggedIn() {
        HomePage homePage = new HomePage(BaseDefinition.getThreadLocal());
        Assert.assertTrue(homePage.isAvatarDisplayed());
    }

    @And("I enter incorrect password {string}")
    public void enterIncorrectPassword(String password) {
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.providePassword(password);
    }

    @Then("I am still on Login page")
    public void stillOnLoginPage() {
        //LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        Assert.assertEquals(BaseDefinition.getThreadLocal().getCurrentUrl(), "https://qa.koel.app/");
    }

    /*WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Given("I open Login Page")
    public void openLoginPage() {
        driver.get("https://qa.koel.app/");
    }

    @When("I enter email {string}")
    public void enterEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }

    @And("I enter password {string}")
    public void enterPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }

    @And("I submit")
    public void clickSubmit() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmitButton();
    }

    @Then("I am logged in")
    public void userIsLoggedIn() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isAvatarDisplayed());
    }

    @And("I enter incorrect password {string}")
    public void enterIncorrectPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }

    @Then("I am still on Login page")
    public void stillOnLoginPage() {
        //LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/");
    }
     */
}
