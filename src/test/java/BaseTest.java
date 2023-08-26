import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver = null;
//    public String url = "https://qa.koel.app/";
    public String url;
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        url = baseURL;
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDownBrowser(){
    driver.quit();
    }
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
//navigate to URL
    public void navigateToPage() {
        driver.get("https://qa.koel.app/");
    }
//enter a Valid Email
    public void provideEmail() {
        WebElement loginInput = driver.findElement(By.cssSelector("[type='email']"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("xu_moua@hotmail.com");

    }
//enter a Valid Password
    public void providePassword() {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("TestStudent!1");

    }
//click on Submit Button
    public void clickSubmit() {
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
    }
//click on save button
    public void clickSaveBtn() {
            WebElement saveBtn = driver.findElement(By.cssSelector("section[id='songResultsWrapper'] button[title='Save']"));
            saveBtn.click();
    }
//verify song is added to playlist
    public void verifySuccessMessage() {
            WebElement popUpNotification = driver.findElement(By.cssSelector(".success.show"));
            Assert.assertTrue(popUpNotification.isDisplayed());
    }
//enter a playlist name
    public void enterPlaylistName() {
            WebElement newPlaylist = driver.findElement(By.cssSelector("section[id='songResultsWrapper'] input[placeholder='Playlist name']"));
            newPlaylist.click();
            newPlaylist.clear();
            newPlaylist.sendKeys("Greatest Hits");
    }
//add a song to a location
    public void clickAddToBtn() {
            WebElement addToBtn = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
            addToBtn.click();
    }
//click and highlight a song
    public void clickSongTitle() {
            WebElement clickSong = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/div/div/div[1]/table/tr[1]/td[2]"));
            clickSong.click();
    }
//click on view all button
    public void clickViewAllBtn() {
            WebElement viewAllBtn = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
            viewAllBtn.click();
    }
//click on Search Field and enter a song title
    public void enterSongIntoSearchField() {
            WebElement searchInput = driver.findElement(By.cssSelector("input[placeholder='Press F to search']"));
            searchInput.click();
            searchInput.clear();
            searchInput.sendKeys("Dark Days");
    }
//Navigate to and login with valid credentials
    public void logInWithRightCredentials(){
        navigateToPage();
        provideEmail();
        providePassword();
        clickSubmit();
    }
//Verify that the song is playing and the sound bar is moving
    public void verifySongIsPlaying() {
        WebElement soundBars = driver.findElement(By.cssSelector("[data-testid='sound-bar-play']"));
        Assert.assertTrue(soundBars.isDisplayed());
    }
//Click on Play Button on Player Control
    public void clickPlaySong() {
        WebElement playSong = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        playSong.click();
    }
//Click on the Next Song on Player Control
    public void clickNextSongBtn() {
        WebElement playNextSong = driver.findElement(By.cssSelector("[data-testid='play-next-btn']"));
        playNextSong.click();
    }
//Enter a Song Name into Search Field
    protected void enterSongTitle(By inputLocator, String inputText) {
        WebElement searchInput = driver.findElement(inputLocator);
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(inputText);
    }
//Click on OK when deleting a Playlist
    protected void clickOKPopUP() {
        WebElement clickOk = driver.findElement(By.cssSelector(".ok"));
        clickOk.click();
    }
//Click on the X Playlist to delete playlist
    protected void clickDeletePlaylist() {
        WebElement deletePlaylist = driver.findElement(By.cssSelector("button[title='Delete this playlist']"));
        deletePlaylist.click();
    }
//Select a Playlist if there is one available
    protected void clickPlaylist() {
        WebElement selectPlaylist = driver.findElement(By.cssSelector("[class='playlist playlist']"));
        selectPlaylist.click();
    }
}