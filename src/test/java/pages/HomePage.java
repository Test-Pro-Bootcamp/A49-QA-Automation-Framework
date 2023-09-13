package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {

        super(driver);
    }
    public void avatarImgIsDisplayed(){
        WebElement avatarImg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='avatar']")));
        Assert.assertTrue(avatarImg.isDisplayed());
    }

    public void logoIsDisplayed(){
        WebElement avatarImg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@data-testid='login-form']")));
        Assert.assertTrue(avatarImg.isDisplayed());
    }
}
