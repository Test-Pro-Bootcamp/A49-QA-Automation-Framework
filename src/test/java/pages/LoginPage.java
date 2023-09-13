package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@type='email']")
    WebElement email;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;
    @FindBy(css = "button[type='submit']")
    WebElement submit;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void loginEmailValide(){
        setEmail("momo.carlos5@gmail.com");
        setPassword("te$t$tudent");
        clickLogin();

    }

    public LoginPage setEmail(String emai) {
        wait.until(ExpectedConditions.elementToBeClickable(email)).clear();
        email.sendKeys(emai);
        return this;
    }

    public LoginPage setPassword(String pass) {
        wait.until(ExpectedConditions.elementToBeClickable(password)).clear();
        password.sendKeys(pass);
        return this;
    }

    public LoginPage clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
        return this;
    }

}
