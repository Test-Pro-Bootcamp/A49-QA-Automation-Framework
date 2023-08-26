import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void LoginValidEmailPasswordTest() {
        openLoginUrl();
        loginWithCorrectCred();

        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatar.isDisplayed());

    }
    @Test
    public void LoginInvalidEmailPasswordTest() {
        openLoginUrl();
        loginWithIncorrectCred();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}
