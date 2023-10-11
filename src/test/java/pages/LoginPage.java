package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPage extends BasePage{

    public LoginPage (WebDriver driver){
        super(driver);
       wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @FindBy (css="input[type='email']")
    WebElement emailField;
    @FindBy (css="input[type='password']")
    WebElement passwordField;
    @FindBy (css ="[type='submit']")
    WebElement submitButtonLocator;
    @FindBy(xpath = "//a[@href='registration']")
    private WebElement wizReg;



    public LoginPage castEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).clear();
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage castPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).clear();
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage castSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        submitButtonLocator.click();
        return this;
    }
    public WebElement getWizReg() {
        return wizReg;
    }

    public LoginPage successfulPortalTest(){

        LoginPage portalPage = new LoginPage(driver);
        HomePage towerPage = new HomePage(driver);

        portalPage.castEmail("dirzo@gmail.com");
        portalPage.castPassword("Te$ter1234");
        portalPage.castSubmit();

        //Assert.assertTrue(towerPage.getUserAvatar().isDisplayed());
    return this;
    }

}
