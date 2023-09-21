package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

    public class LoginPage extends BasePage {
        public LoginPage(WebDriver driver) {
            super(driver);
        }
        private By enterEmail = By.cssSelector("input[type='email']");
        private By enterPassword = By.cssSelector("input[type='password']");
        private By clickSubmit = By.cssSelector("button[type='submit']");
        public void enterEmail(String email) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(enterEmail)).sendKeys(email);
        }
        public void enterPassword(String password) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(enterPassword)).sendKeys(password);
        }
        public void clickSubmit() {
            wait.until(ExpectedConditions.elementToBeClickable(clickSubmit)).click();
        }
        public LoginPage loginWithCorrectCred() {
            enterEmail("emiliano.castillo@testpro.io");
            enterPassword("te$t$tudent");
            clickSubmit();
            return this;
        }
        public LoginPage loginWithIncorrectCred() {
            enterEmail("dlkfjglj@class.com");
            enterPassword("te$t$tudent");
            clickSubmit();
            return this;
        }
        public LoginPage loginEmptyEmailField() {
            enterEmail("");
            enterPassword("te$t$tudent");
            clickSubmit();
            return this;
        }
        public LoginPage loginEmptyPasswordField() {
            enterEmail("emiliano.castillo@testpro.io");
            enterPassword("");
            clickSubmit();
            return this;
        }
        public void checkAvatarDisplay() {
            WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
            Assert.assertTrue(avatar.isDisplayed());
        }
        public void checkUrlIsTheSame(){
            Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/");
        }
    }
// Using @FindBy annotation examples

//        @FindBy (css = "input[type='email']")
//        private WebElement emailField;

//        @FindBy (css = "input[type='password']")
//        private WebElement passwordField;

//        @FindBy (css = "button[type='submit']")
//        private WebElement submitBtn;

//        public void enterEmail(String email) {
//            wait.until(ExpectedConditions.elementToBeClickable(emailField)).clear();
//            emailField.sendKeys(email);
//        }
//        public void enterPassword(String password) {
//            wait.until(ExpectedConditions.elementToBeClickable(passwordField)).clear();
//            passwordField.sendKeys(password);
//        }


