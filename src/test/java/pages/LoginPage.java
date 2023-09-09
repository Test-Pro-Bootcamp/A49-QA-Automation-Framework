package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPage extends BasePage{
    //locators
    By submitButtonLocator = By.cssSelector("type='submit']");
    By emailField = By.cssSelector("type='email']");
    By passwordField = By.cssSelector("type='password']");

    public LoginPage (WebDriver driver, WebDriverWait wait, Actions actions){

        super(driver, wait, actions);
    }

    public void castSubmit() {
        driver.findElement(submitButtonLocator).click();
    }
    public void castEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.sendKeys(email);
    }
    public void castPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.click();
        passwordElement.sendKeys(password);
    }
    @Test
    public void SuccessfulPortalTest (){

        LoginPage portalPage = new LoginPage(driver, wait, actions);
        HomePage towerPage = new HomePage(driver, wait, actions);

        portalPage.castEmail("dirzo@gmail.com");
        portalPage.castPassword("Te$ter1234");
        portalPage.castSubmit();

        Assert.assertTrue(towerPage.getUserAvatar().isDisplayed());
    }
}
