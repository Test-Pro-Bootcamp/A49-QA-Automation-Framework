package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.UUID;

public class Profilepage extends BasePage{
    public Profilepage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
        String random = generateRandom();
    }

    public void provideProfileName(String random){
        WebElement profileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        profileName.clear();
        profileName.sendKeys(random);
    }
    public String generateRandom(){
        return UUID.randomUUID().toString().replace("","");
    }

    public void provideCurrentPassword(String password){
        WebElement currentPassword= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='current_password']")));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }
    public void clickSaveButton(){
        WebElement clickSaveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn-submit")));
        clickSaveButton.click();
    }
//    WebElement actualProfileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.view-profile>span")));
//        Assert.assertEquals(actualProfileName.getText(),random);


}
