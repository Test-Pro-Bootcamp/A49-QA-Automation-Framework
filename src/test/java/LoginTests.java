import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginValidEmailPassword(){
        navigateToPage();
        provideEmail("dagebeyehu@gmail.com");
        providePassword("yozca5uQiLxb!");
        clickSubmit();
        isAvatarDisplayed();
    }
    @Test
    public void loginInvalidEmailValidPassword(){
        navigateToPage();
        provideEmail("invalid@class.com");
        providePassword("yozca5uQiLxb!");
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public void loginValidEmailEmptyPassword(){
        navigateToPage();
        provideEmail("dagebeyehu@gmail.com");
        providePassword("");
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}
