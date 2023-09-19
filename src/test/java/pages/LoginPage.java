package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = "[type='email']")
            WebElement emailField;
    @FindBy(css = "[type='password']")
            WebElement passwordField;
    @FindBy(css="button[type='submit']")
            WebElement submitBtn;

    protected void enterEmail(String email) {

        emailField.sendKeys(email);
    }

    protected void enterPassword(String password) {

        passwordField.sendKeys(password);
    }
    protected void clickLogin() {

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




}
