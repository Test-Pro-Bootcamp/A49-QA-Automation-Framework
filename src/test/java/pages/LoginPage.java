package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = "[type='password']")
    WebElement passwordField;
    @FindBy(css = "[type='email']")
    WebElement emailField;
    @FindBy(css="button[type='submit']")
    WebElement submitBtn;
    @FindBy(css = "img[class='avatar']")
    WebElement avatarIcon;


    public LoginPage enterEmail(String email) {

        emailField.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {

        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickLogin() {

        submitBtn.click();
        return this;
    }
    public boolean isAvatarDisplayed() {
        return avatarIcon.isDisplayed();

    }

    public LoginPage login() {
        String email = "anna.dudnik@testpro.io";
        String password = "GulyalaKorova4milk!";
        enterEmail(email);
        enterPassword(password);
        clickLogin();
        //wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("img[class='avatar']"))));

        Assert.assertTrue(isAvatarDisplayed());
        return this;
    }







}
