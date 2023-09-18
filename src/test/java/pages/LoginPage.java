package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    By emailField = By.cssSelector("inout[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");
    public void provideEmail(String email){
        findElement(emailField).sendKeys(email);

    }
    public void providePassword(String password){
        findElement(passwordField).sendKeys(password);

    }
    public void clickSubmit(){
        findElement(submitBtn).click();

    }

    public void login(){
        provideEmail("elena.min@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
    }

}
