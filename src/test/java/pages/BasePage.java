package pages;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    public String getRandomString(){
        String randomString = RandomStringUtils.randomAlphabetic(10);
        return randomString;
    }

    public WebElement findElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement click(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
