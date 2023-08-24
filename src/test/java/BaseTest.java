import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;



import java.time.Duration;

public class BaseTest {

    @BeforeMethod
    public void launchBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlywait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
}