package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    //constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By emailFieldLocator = By.cssSelector("[type = 'email']");
    By passwordFieldLocator = By.cssSelector("[type = 'password']");
    By submitButtonFieldLocator = By.cssSelector("[type = 'submit']");



    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmitButton() {
        WebElement submitButton = driver.findElement(submitButtonFieldLocator);
        submitButton.click();
    }

    public void loginToKoelWithDataProvider(String email, String password){
        //navigateToPage();
        provideEmail(email);
        providePassword(password);
        clickSubmitButton();
    }

    public void loginToKoel() {
        //navigateToPage();
        provideEmail("alina.nikolaienko@testpro.io");
        //provideEmail("demo@testpro.io");
        providePassword("OPJKDUhA");
        //providePassword("te$t$tudent");
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type = 'submit']")));
        clickSubmitButton();
    }
}
