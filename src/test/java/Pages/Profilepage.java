package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.UUID;

public class Profilepage extends BasePage {

    @FindBy(css ="[ name='name']")
    WebElement provideProfileName;
    @FindBy(css ="[name='current_password']")
    WebElement currentPassword;
    @FindBy(css ="button.btn-submit")
    WebElement clickSaveButton;

   @FindBy(css = "div.success.show")
    WebElement popUpMessage;

    @FindBy(css ="a.view-profile>span")
    WebElement actualProfileName;

    public Profilepage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public Profilepage provideProfileName(String random) {
        wait.until(ExpectedConditions.visibilityOf(provideProfileName));
      provideProfileName.clear();
      provideProfileName.sendKeys(random);
        return this;
    }

    public String generateRandom() {
        return UUID.randomUUID().toString().replace("", "");
    }

    public Profilepage provideCurrentPassword(String password) {
       wait.until(ExpectedConditions.visibilityOf(currentPassword));
        currentPassword.clear();
        currentPassword.sendKeys(password);
        return this;
    }

    public Profilepage clickSaveButton() {
        wait.until(ExpectedConditions.visibilityOf(clickSaveButton));
        clickSaveButton.click();
        return this;
    }

    public Profilepage waitForPopUpMessage() {
        wait.until(ExpectedConditions.visibilityOf(popUpMessage));
        return this;
    }
    public String getActualProfileName() {
        wait.until(ExpectedConditions.visibilityOf(actualProfileName));
            return actualProfileName.getText();




        }
   }


