package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    String email;
    String password;
    public LoginPage(WebDriver givenDriver, String email, String password) {
        super(givenDriver);
        this.email = email;
        this.password = password;
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

    public void login() {
        enterEmail(this.email);
        enterPassword(this.password);
        clickLogin();
    }




}
