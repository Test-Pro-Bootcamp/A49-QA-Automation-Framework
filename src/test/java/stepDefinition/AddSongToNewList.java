package stepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.BasePage;
import pages.LoginPage;
import pages.SongsPage;
import tests.BaseTest;

import java.time.Duration;

public class AddSongToNewList {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    SongsPage songsPage;


    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @Given("I have entered the portal")
    public void iHaveEnteredThePortal() {
        loginPage= new LoginPage(driver);

        (driver).get("https://qa.koel.app/");
        loginPage.successfulPortalTest();
    }

    @When("I search for the song BossStatus")
    public void iSearchForTheSong() {
        songsPage= new SongsPage(driver);
        songsPage.enterTitleIntoSearch();
    }

    @And("I view all the songs with BossStatus")
    public void iViewAllTheSongsWithBossStatus() {
        songsPage= new SongsPage(driver);
        songsPage.allResults();

    }

    @And("I select BossStatus")
    public void iSelectBossStatus() {
        songsPage= new SongsPage(driver);
        songsPage.songResult();
    }

    @And("I click add to...")
    public void iClickAddTo() {
        songsPage=new SongsPage(driver);
        songsPage.addButton();
    }

    @Then("I create a new Playlist")
    public void iCreateANewPlaylist() {
        songsPage = new SongsPage(driver);
        songsPage.createPlaylist();
    }
}
