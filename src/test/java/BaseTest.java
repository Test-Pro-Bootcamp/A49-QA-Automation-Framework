import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.util.UUID;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;

    public String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser() {
        //    Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public void openLoginUrl() {
        driver.get(url);
    }

    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("input[type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("input[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickSubmit() {
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        submitBtn.click();
    }



    //Profile Test Helper Functions
    public void clickAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }
    public void provideCurrentPassword(String password) {
        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }
    public void clickSaveButton() {
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }
    public void provideProfileName(String randomName) {
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(randomName);
    }
    public String generateRandomName () {
        return UUID.randomUUID().toString().replace("-", "");
    }
    //Homework 17
    public void searchForSong (){
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys("Dark Days");
    }
    public void clickViewAll () {
        WebElement viewAllBtn = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > h1 > button"));
        viewAllBtn.click();
    }
    public void clickFirstSong () {
        WebElement firstSong = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/div/div/div[1]/table/tr[1]/td[2]"));
        firstSong.click();
    }
    public void addToo () {
        WebElement addTooBtn = driver.findElement(By.cssSelector("[title='Add selected songs to…']"));
        addTooBtn.click();
    }
    public void addToPlayList() {
        WebElement addToPlaylistNice = driver.findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li:nth-child(6)"));
        addToPlaylistNice.click();

    }

}