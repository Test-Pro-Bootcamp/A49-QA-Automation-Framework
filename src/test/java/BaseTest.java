import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

//    @BeforeMethod
//    public void launchBrowser(){
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--disable-notifications");
//
//    }

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
}