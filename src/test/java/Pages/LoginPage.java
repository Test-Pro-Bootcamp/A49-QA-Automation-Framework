package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

//    public void loginValidEmailPassword() {
//        loginWithCorrectCredentials();
//    }

    public void loginWithCorrectCredentials() {
//        navigateToLoginPage(url);
        provideEmail();
        providePassword( );
        clickSubmit();
    }

    public  void provideEmail(){
        WebElement emailAddress= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailAddress.clear();
        emailAddress.sendKeys("abisola.omotoso@testpro.io");
    }

    public void providePassword() {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
    }
    public  void clickSubmit() {
        WebElement submitBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submitBtn.click();
    }
}