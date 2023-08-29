import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class profilePage extends BaseTest {
    @Test (enabled=false)
    public void changeProfileName() throws InterruptedException {
        navigateToLoginPage();
        provideEmail();
        providePassword();
        clickSubmit();
        clickAvatar();

        String random = generateRandom();

        provideCurrentPassword("te$t$tudent");
        provideProfileName(random);
        clickSaveButton();

        WebElement actualProfileName =driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(),random);

    }


}