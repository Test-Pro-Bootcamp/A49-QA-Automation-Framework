package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(xpath = "//*[@href='registration']")
    WebElement registrationBtn;
    public RegistrationPage registrationNavigation(){
        registrationBtn.click();

        String expectedUrl = "https://qa.koel.app/registration";
        Assert.assertTrue(true, expectedUrl);
        return this;
    }


}
