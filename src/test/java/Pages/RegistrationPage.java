package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    By clickRegistrationBtn = By.cssSelector("a[href='registration']");
    public void clickRegistrationBtn() {
        findElement(clickRegistrationBtn).click();
    }
    public void checkUrl(){
        String registrationUrl = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);
    }
}
