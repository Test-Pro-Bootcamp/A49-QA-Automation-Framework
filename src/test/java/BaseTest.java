import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {

    public static WebDriver driver;
    public  String url = "https://qa.koel.app/";



    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void launchBrowser(){
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    public void navigateToLoginPage(){
        driver.get(url);
//        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    public  void provideEmail(){
        WebElement emailAddress= driver.findElement(By.cssSelector("input[type='email']"));
        emailAddress.clear();
        emailAddress.sendKeys("abisola.omotoso@testpro.io");
    }

    public void providePassword() {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
    }
public  void clickSubmit() {
    WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
    submitBtn.click();
}
 public  void searchTab(String song){
        WebElement searchTab = driver.findElement(By.cssSelector(" input[type='search']"));
        searchTab.clear();
        searchTab.sendKeys(song);
 }

public  void viewAllButton(){
        WebElement viewAll = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAll.click();
}
public void chosenSong(){
    WebElement chosenSong = driver.findElement(By.xpath("//section[@id='searchExcerptsWrapper']//article [@class='playing']//span[@class='details']"));
    chosenSong.click();
}
public void addToButton(){
    WebElement addTo = driver.findElement(By.cssSelector(".btn-add-to"));
    addTo.click();
}

public void bisolaPlayList(){
    WebElement bisolaPlayList = driver.findElement(By.cssSelector("[href='#!/playlist/66852']"));
    bisolaPlayList.click();
}

public void clickAvatar() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }
public void provideProfileName(String random){
    WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
    profileName.clear();
    profileName.sendKeys(random);
}
    public String generateRandom(){
        return UUID.randomUUID().toString().replace("","");
    }

public void provideCurrentPassword(String password){
     WebElement currentPassword= driver.findElement(By.cssSelector("[name='current_password']"));
     currentPassword.clear();
     currentPassword.sendKeys(password);
}
public void clickSaveButton(){
    WebElement clickSaveButton = driver.findElement(By.cssSelector("button.btn-submit"));
    clickSaveButton.click();
}
    @AfterMethod
    public void closeBowser(){
        driver.quit();
    }
}