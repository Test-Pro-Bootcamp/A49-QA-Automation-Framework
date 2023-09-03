package Pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (css = "input[type='email']")
    WebElement emailField;
    @FindBy (css = "input[type='password']")
    WebElement passwordField;
    @FindBy (css = "button[type='submit']")
    WebElement submitBtn;

//    By enterEmail = By.cssSelector("input[type='email']");
//    By enterPassword = By.cssSelector("input[type='password']");
//    By clickSubmit = By.cssSelector("button[type='submit']");
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).clear();
        emailField.sendKeys(email);
//        return this;
    }
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).clear();
        passwordField.sendKeys(password);
//        return this;
    }
    public void clickSubmit() {
//        findElement(clickSubmit).click();
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
//        return this;
}
    public LoginPage loginWithCorrectCred() {
        enterEmail("emiliano.castillo@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();
        return this;
    }
    public LoginPage loginWithIncorrectCred() {
        enterEmail("dlkfjglj@class.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        return this;
    }
    public void checkAvatarDisplay() {
        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        Assert.assertTrue(avatar.isDisplayed());
//        return this;
    }
    public void checkUrlIsTheSame(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/");
//        return this;
    }
}