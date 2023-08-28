import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Objects;
import java.util.List;

public class BaseTest {
    public static WebDriver theDriver = null;
    public static String url = "https://qa.koel.app/";
    public static  String searchResultsTable = "#songResultsWrapper > div > div > div.item-container > table";
    public static  String playListResultsTable = "#playlistWrapper > div > div > div.item-container > table";
    public static  String queueTable = "#queueWrapper > div > div > div.item-container > table";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        theDriver = new ChromeDriver(options);
        theDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        theDriver.manage().window().maximize();
        //String url = "https://qa.koel.app/";
        theDriver.get(url);
    }

    @AfterMethod
    public void closerBrowser() {
        theDriver.quit();
    }


    public void clickLogin() {
        WebElement submitLogin = theDriver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
    }

    public void enterPassword(String password) {
        WebElement passwordInput = theDriver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void enterEmail(String email) {
        WebElement emailInput = theDriver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }
    public void clearMyPlaylist() throws AWTException {
        openPlaylist();

        try {
            returnAnySong(0, playListResultsTable,1).click();
            Robot deleteKey = new Robot();
            deleteKey.keyPress(KeyEvent.VK_DELETE);
            deleteKey.keyRelease(KeyEvent.VK_DELETE);

        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }

    public void search(String song)  {
        WebElement searchField = theDriver.findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(song);

    }

    public void clickViewAll() {
        WebElement buttonViewAll = theDriver.findElement(new By.ByXPath("//button[@data-test='view-all-songs-btn']"));
        buttonViewAll.click();
    }

    public WebElement returnAnySong(int songNo, String tableName, int col) {
        WebElement table = theDriver.findElement(By.cssSelector(tableName));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        WebElement r1 = rows.get(songNo);
        List<WebElement> cells = r1.findElements(By.tagName("td"));
        WebElement c1 = cells.get(col);
        return c1;
    }

    public WebElement returnClass(int songNo, String tableName) {
        WebElement table = theDriver.findElement(By.cssSelector(tableName));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        WebElement r1 = rows.get(songNo);
        return r1;
    }

    public void clickAddTo() {
        try {
            WebDriverWait wait = new WebDriverWait(theDriver, Duration.ofSeconds(5));
            WebElement clickAddTo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > span > button.btn-add-to")));
            clickAddTo.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void clickPlaylist() {
        WebElement clickPlaylist = theDriver.findElement(new By.ByXPath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
        clickPlaylist.click();
    }
    public void moveToQueue() {
        WebElement clickPlaylist = theDriver.findElement(new By.ByXPath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[3]"));
        clickPlaylist.click();
    }


    public String showBanner(String textBanner) throws NoSuchElementException {
        try {
            WebDriverWait wait = new WebDriverWait(theDriver, Duration.ofSeconds(3));
            WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.alertify-logs.top.right > div")));

            while (!Objects.equals(notification.getText(), textBanner)){
                notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.alertify-logs.top.right > div")));
            }

            return notification.getText();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    protected void loginWithValidCredential() {
        enterEmail("anna.dudnik@testpro.io");
        enterPassword("GulyalaKorova4milk!");
        clickLogin();
    }
    public void doubleClick(int songNo, String sourceTable) {
        Actions actions = new Actions(theDriver);
        actions.doubleClick(returnAnySong(songNo, sourceTable,1)).perform();
    }
    public void clickPlayButton () {
        WebElement playButton = theDriver.findElement(By.cssSelector("span[class='play']"));
        playButton.click();
    }
    public void clickPlayNextSong () {
        WebElement playNextSongButton = theDriver.findElement(By.cssSelector("i[class='next fa fa-step-forward control']"));
        playNextSongButton.click();
    }
    public void clickShuffleButton () {
        WebElement shuffleButton = theDriver.findElement(By.cssSelector("#playlistWrapper > header > div.song-list-controls > span > button.btn-shuffle-all"));

        shuffleButton.click();
    }
    public void openPlaylist () {
        WebElement clearMyPlaylist = theDriver.findElement(By.cssSelector("a[href*='#!/playlist/67352']"));
        clearMyPlaylist.click();
    }
    public void openQueue() {
        WebElement currentQueue = theDriver.findElement(By.cssSelector("a[href*='#!/queue']"));
        currentQueue.click();
    }

}
