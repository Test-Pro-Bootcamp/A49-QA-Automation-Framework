import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    public  WebDriver driver ;
   public  String url = "https://qa.koel.app/";
//public static Actions actions=null;
//public String url;
public WebDriverWait wait;

//    Actions actions= new Actions(driver);
    BasePage basePage;
LoginPage loginPage;
HomePage homepage;
PlaylistPage playlistPage;
Profilepage profilePage;
    Actions actions;


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
//    @Parameters({"BaseURL"})
    public void launchBrowser(){
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
//        url= BaseURL;
        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.manage().window().maximize();
//instantiate Explicit wait
        wait= new WebDriverWait(driver,Duration.ofSeconds(10));
//        Actions actions= new Actions(driver);
        actions= new Actions(driver);
        basePage = new BasePage(driver,wait,actions);
        basePage.navigateToLoginPage(url);
        loginPage= new LoginPage(driver,wait,actions);
        homepage= new HomePage(driver,wait,actions);
        playlistPage =new PlaylistPage(driver,wait,actions);
        profilePage =new Profilepage(driver,wait,actions);

    }

//    public void navigateToLoginPage(){
//        driver.get(url);
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//    }
//    public  void provideEmail(){
//        WebElement emailAddress= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
//        emailAddress.clear();
//        emailAddress.sendKeys("abisola.omotoso@testpro.io");
//    }
//
//    public void providePassword() {
//        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
//        passwordField.clear();
//        passwordField.sendKeys("te$t$tudent");
//    }
//public  void clickSubmit() {
//    WebElement submitBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
//    submitBtn.click();
//}
// public  void searchTab(String song){
//        WebElement searchTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='search']")));
//        searchTab.clear();
//        searchTab.sendKeys(song);
// }

//public  void viewAllButton(){
//        WebElement viewAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='view-all-songs-btn']")));
//        viewAll.click();
//}
public void chosenSong(){
    WebElement chosenSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='searchExcerptsWrapper']//article [@class='playing']//span[@class='details']")));
    chosenSong.click();
}
//public void addToButton(){
//    WebElement addTo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-add-to")));
//    addTo.click();
//}

//public void bisolaPlayList(){
//    WebElement bisolaPlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='#!/playlist/66852']")));
//    bisolaPlayList.click();
//}

//public void clickAvatar() {
//        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
//        avatarIcon.click();
//    }
//public void provideProfileName(String random){
//    WebElement profileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
//    profileName.clear();
//    profileName.sendKeys(random);
//}
////    public String generateRandom(){
////        return UUID.randomUUID().toString().replace("","");
////    }
//
//public void provideCurrentPassword(String password){
//     WebElement currentPassword= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='current_password']")));
//     currentPassword.clear();
//     currentPassword.sendKeys(password);
//}
//public void clickSaveButton(){
//    WebElement clickSaveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn-submit")));
//    clickSaveButton.click();
//}
    @AfterMethod
    public void closeBowser(){
        basePage.quitBrowser();

    }

//    public void loginWithCorrectCredentials() {
//        navigateToLoginPage();
//        provideEmail();
//        providePassword( );
//        clickSubmit();
//    }
}