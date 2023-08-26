import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework16 extends BaseTest {

    @Test
    public void registrationNavigation() {
        openLoginUrl();
        clickRegistrationBtn();

        String registrationUrl = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);
    }
    private void clickRegistrationBtn() {
        WebElement registrationLink = driver.findElement(By.cssSelector("a[href='registration']"));
        registrationLink.click();
    }
}


