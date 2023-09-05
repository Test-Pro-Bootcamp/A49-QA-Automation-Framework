package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    //Navigate to and login with valid credentials

    @FindBy (css ="[type='email']" )
    WebElement loginInput;
    @FindBy (css = "[type='password']")
    WebElement passwordInput;
    @FindBy (css = "button[type='submit']")
    WebElement loginBtn;

    public LoginPage logInWithRightCredentials(){
        navigateToPage();
        provideEmail();
        providePassword();
        clickSubmit();
        return this;
    }
    //navigate to URL
    public LoginPage navigateToPage() {
        driver.get("https://qa.koel.app/");
        return this;
    }

    //enter a Valid Email
    public LoginPage provideEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(loginInput));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("xu_moua@hotmail.com");
        return this;

    }
    //enter a Valid Password
    public LoginPage providePassword() {
        wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("TestStudent!1");
        return this;

    }
    //click on Submit Button
    public LoginPage clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
        return this;
    }
}
