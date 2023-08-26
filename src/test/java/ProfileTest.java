import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.UUID;

public class ProfileTest extends BaseTest {
    @Test
    public void changeProfileNameTest() {

        openLoginUrl();
        loginWithCorrectCred();
        clickAvatarIcon();
        provideCurrentPassword("te$t$tudent");

        String randomName = generateRandomName();

        provideProfileName(randomName);
        clickSaveBtn();

        WebElement verifyChangeProfile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alertify-logs")));
        Assert.assertEquals(verifyChangeProfile.getText(), "Profile updated.");

        WebElement actualProfileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.view-profile>span")));
        Assert.assertEquals(actualProfileName.getText(), randomName);
    }
    public void provideCurrentPassword (String password){
        WebElement currentPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='current_password']")));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }
    public void provideProfileName(String randomName) {
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(randomName);
    }
    public String generateRandomName () {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
