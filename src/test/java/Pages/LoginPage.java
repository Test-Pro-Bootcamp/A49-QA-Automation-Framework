package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    By enterEmail = By.cssSelector("input[type='email']");
    By enterPassword = By.cssSelector("input[type='password']");
    By clickSubmit = By.cssSelector("button[type='submit']");
//    public void enterEmail(String email) { enterText(By.cssSelector("input[type='email']"),email); }
    public void enterEmail(String email) {
        findElement(enterEmail).sendKeys(email);
    }
//    public void enterPassword(String password) { enterText(By.cssSelector("input[type='password']"), password);}
    public void enterPassword(String password) {
        findElement(enterPassword).sendKeys(password);
    }
//    public void clickSubmit() { clickOnElement(By.cssSelector("button[type='submit']"));}
    public void clickSubmit() {
        findElement(clickSubmit).click();
}
    public void loginWithCorrectCred() {
        enterEmail("emiliano.castillo@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();
    }
    public void loginWithIncorrectCred() {
        enterEmail("dlkfjglj@class.com");
        enterPassword("te$t$tudent");
        clickSubmit();
    }
    public void checkAvatarDisplay() {
        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        Assert.assertTrue(avatar.isDisplayed());
    }
    public void checkUrlIsTheSame(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/");
    }
}