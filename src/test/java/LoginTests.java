import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void LoginValidEmailPasswordTest() {
        //Test Case Scenario
        //Given I have set and opened the browser
        openLoginUrl();
        enterEmail("emiliano.castillo@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();

        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatar.isDisplayed());

    }
    @Test
    public void LoginInvalidEmailPasswordTest() throws InterruptedException {
        //Test Case Scenario
        //Given I have set and opened the browser
        openLoginUrl();
        enterEmail("invalidemail@class.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}
