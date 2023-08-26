import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void LoginValidEmailPasswordTest() {
        openLoginUrl();
        loginWithCorrectCred();

        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        Assert.assertTrue(avatar.isDisplayed());
    }
    @Test
    public void LoginInvalidEmailPasswordTest() {
        openLoginUrl();
        loginWithIncorrectCred();

        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}