package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {

        super(driver);

    }

    @FindBy(css = "input[type='email']")
    WebElement emailField;
    @FindBy(css = "input[type='password']")
    WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    WebElement submit;
    @FindBy(css = "a#hel")
    WebElement registrationLink;

    public LoginPage loginWithCorrectCred() {
        provideEmail("svitlana.shkribliak@testpro.io");
        providePassword("te$t$tudent49");
        clickSubmit();
        return this;
    }

    public LoginPage provideEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).clear();
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).clear();
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
        return this;
    }

    public void compareURL() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/");
    }

//    public WebElement getRegistrationLink() {
//        return registrationLink;
//    }

}
