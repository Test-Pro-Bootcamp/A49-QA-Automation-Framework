package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }
    public void loginWithCorrectCred() {
        enterEmail("emiliano.castillo@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();
    }
    public void loginWithIncorrectCred() {
        enterEmail("dlkfjglj@class.com");
        enterPassword("te$t$tudent");
        clickSubmit();
    }
    //Enter Email as a string
    public void enterEmail(String email) { enterText(By.cssSelector("input[type='email']"),email); }
    //Enter password as a string
    public void enterPassword(String password) { enterText(By.cssSelector("input[type='password']"), password);}
    //Click Login Btn
    public void clickSubmit() { clickOnElement(By.cssSelector("button[type='submit']"));}

    public void checkAvatarDisplay() {
        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        Assert.assertTrue(avatar.isDisplayed());
    }
    public void checkUrlIsTheSame(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/");
    }
}
