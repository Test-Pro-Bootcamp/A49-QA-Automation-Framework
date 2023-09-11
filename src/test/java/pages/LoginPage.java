package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    String email;
    String password;
    public LoginPage(WebDriver givenDriver, String email, String password) {
        super(givenDriver);
        this.email = email;
        this.password = password;
    }

    By emailField = By.cssSelector ("[type='email']");
    By passwordField = By.cssSelector("[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");

    protected void enterEmail(String email) {
        findElement(emailField).sendKeys(email);
    }

    protected void enterPassword(String password) {
        findElement(passwordField).sendKeys(password);
    }
    protected void clickLogin() {
        findElement(submitBtn).click();
    }

    public void login() {
        enterEmail(this.email);
        enterPassword(this.password);
        clickLogin();
    }




}
