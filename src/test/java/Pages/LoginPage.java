package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private By submitButtonLocator = By.cssSelector("[type='submit']");
    private By emailField = By.cssSelector("input[type='email']");
    private By passwordField = By.cssSelector("input[type='password']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginCorrectCred() {
        provideEmail("dagebeyehu@gmail.com");
        providePassword("yozca5uQiLxb!");
        clickSubmit();
    }


    public LoginPage provideEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password){
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit() {
        driver.findElement(submitButtonLocator).click();
        return this;
    }
}