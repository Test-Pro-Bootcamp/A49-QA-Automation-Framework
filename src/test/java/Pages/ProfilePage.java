package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    By clickSaveBtn = By.cssSelector("button.btn-submit");
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
    //Click save Btn
    public void clickSaveBtn() {
        findElement(clickSaveBtn).click();
    }
    public void verifyProfileUpdated() {
        WebElement verifyChangeProfile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alertify-logs")));
        Assert.assertEquals(verifyChangeProfile.getText(), "Profile updated.");
    }
}
