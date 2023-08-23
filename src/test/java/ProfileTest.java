import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest {
    @Test
    public void changeProfileNameTest() throws InterruptedException {

        openLoginUrl();
        enterEmail("emiliano.castillo@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();

        Thread.sleep(2000);
        clickAvatarIcon();

        String randomName = generateRandomName();

        provideCurrentPassword("te$t$tudent");
        provideProfileName(randomName);
        clickSaveButton();

        //Check if the username has changed
        Thread.sleep(2000);
        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(), randomName);
    }

}
