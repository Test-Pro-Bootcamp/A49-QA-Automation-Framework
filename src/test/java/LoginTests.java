import org.apache.commons.compress.archivers.zip.ExtraFieldUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

    private void isAvatarDisplayed() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test(dataProvider = "IncorrectLoginData", dataProviderClass = BaseTest.class)
    public void loginInvalidCredentials(String email, String Password) throws InterruptedException{
        navigateToPage();
        provideEmail(email);
        providePassword(Password);
        clickSubmit();
        //Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {
        navigateToPage();
        provideEmail("notExisting@email.com");
        providePassword("yozca5uQiLxb!");
        clickSubmit();
        //Thread.sleep(3000);
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