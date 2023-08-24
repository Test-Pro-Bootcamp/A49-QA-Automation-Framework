import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Test

public class LoginTests extends BaseTest {

    public void loginWithValidEmailPassword() {
        loginWithCorrectCreds();
        isAvatarDisplayed();
    }


//    public void loginEmptyEmailPassword() {
////      Added ChromeOptions argument below to fix websocket error
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        String url = "https://qa.koel.app/";
//        driver.get(url);
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//        driver.quit();
//    }

//        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/#!/home");
//        driver.quit();


    }


