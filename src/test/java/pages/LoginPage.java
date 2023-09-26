package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void enterEmail(String email) {

        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {

        passwordField.sendKeys(password);
    }
    public void clickLogin() {

        submitBtn.click();
    }

    public LoginPage login() {
        String email = "anna.dudnik@testpro.io";
        String password = "GulyalaKorova4milk!";
        enterEmail(email);
        enterPassword(password);
        clickLogin();
        return this;
    }
    public boolean isAvatarDisplayed() {
        return avatarIcon.isDisplayed();
    }



}
