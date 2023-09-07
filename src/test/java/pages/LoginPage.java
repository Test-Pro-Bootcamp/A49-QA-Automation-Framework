package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void loginWithCorrectCred(){
        provideEmail("svitlana.shkribliak@testpro.io");
        providePassword("te$t$tudent49");
        clickSubmit();
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submit.click();
    }
}
