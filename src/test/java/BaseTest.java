import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By

import java.time.Duration;

public class BaseTest {
 public webDriver = null;
 public String url = "https://qa.koel.app";
 driver.get(url);
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod
    public void addSongsToPlaylists(){
        chromeOptions options = new chromeOptions();
        optiens.addArguments("---remote-allow-origins");
    webDriver driver = new chromeDriver();
    driver.manage().timeouts.implicitlywaiit(Duration.ofSeconds(10));

    @AfterMethod
     public void closeBrowser(){
    driver.quit();
    }
}