package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

 public class LoginPage extends BasePage {
 public LoginPage(WebDriver driver) {
   super(driver);
  }
   @FindBy(css = "[type='email']")
   private WebElement emailField;
    @FindBy(css = "[type='password']")
     private WebElement passwordField;
   @FindBy (css = "[type='submit']")
   private WebElement submit;

   // private By emailField = By.cssSelector("input[type='email']");
   // private By passwordField = By.cssSelector("input[type='password']");
   // private By submit = By.cssSelector("button[type='submit']");
  public LoginPage provideEmail(String email) {
     emailField.sendKeys(email);
      return this;
  }
  public LoginPage providePassword(String password) {
    passwordField.sendKeys(password);
   return this;
   }
   public LoginPage clickSubmit() {
   submit.click();
 return this;
  }
  //public LoginPage loginCorrectCred() {

  //  provideEmail("natalia.kim01@testpro.io");
   // providePassword("AxKrdBnS");
 // clickSubmit();
  // return this;
 // }
 }
