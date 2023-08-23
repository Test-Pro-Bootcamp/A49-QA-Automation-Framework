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

    //Login method
    public void loginWithCorrectCred() {
        openLoginUrl();
        enterEmail("emiliano.castillo@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();
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

    //This method will click on search field and search whatever inputText we choose
    public void searchForSong (By inputLocator, String inputText) {
        WebElement searchField = driver.findElement(inputLocator);
        searchField.click();
        searchField.clear();
        searchField.sendKeys(inputText);
    }
    public void enterSongIntoSearchField() {
        searchForSong(By.cssSelector("input[type='search']"), "Dark Days");
    }
    //Click view all btn
    public void clickViewAll () {
        WebElement viewAllBtn = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }
    public void clickFirstSong () {
        WebElement firstSong = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/div/div/div[1]/table/tr[1]/td[2]"));
        firstSong.click();
    }
    public void addToo () {
        WebElement addTooBtn = driver.findElement(By.cssSelector("#songResultsWrapper [data-test='add-to-btn']"));
        addTooBtn.click();
    }
    public void addToPlayList() {
        WebElement addToPlaylistNice = driver.findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li:nth-child(6)"));
        addToPlaylistNice.click();

    }

    //Homework18
    public void clickSong() {
        WebElement clickAllSongsTab = driver.findElement(By.cssSelector(".music .songs"));
        clickAllSongsTab.click();
    }
    public void selectASong() throws InterruptedException {
        WebElement selectSong = driver.findElement(By.cssSelector("#songsWrapper tr.song-item"));
        selectSong.click();
        Thread.sleep(3000);
    }
    public void playNextBtn() throws InterruptedException{
        WebElement playNextSong = driver.findElement(By.cssSelector("[data-testid='play-next-btn']"));
        playNextSong.click();
        Thread.sleep(3000);
    }
    public void playBtn() throws InterruptedException {
        WebElement clickPlayBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        clickPlayBtn.click();
        Thread.sleep(3000);
    }
}