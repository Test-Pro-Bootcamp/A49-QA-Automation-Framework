import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class profilePage extends BaseTest {
    @Test(enabled = false)
    public void changeProfileName() {
        loginPage.loginWithCorrectCredentials();
        homepage.clickAvatar();

        String random = profilePage.generateRandom();

        profilePage.provideCurrentPassword("te$t$tudent");
        profilePage.provideProfileName(random);
        profilePage.clickSaveButton();

        WebElement actualProfileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.view-profile>span")));
        Assert.assertEquals(actualProfileName.getText(),random);

    }


    }


