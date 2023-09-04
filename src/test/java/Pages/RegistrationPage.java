package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    private By clickRegistrationBtn = By.cssSelector("a[href='registration']");
    public RegistrationPage clickRegistrationBtn() {
        findElement(clickRegistrationBtn).click();
        return this;
    }
    public void checkUrl(){
        String registrationUrl = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);
    }
}
