package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        PageFactory.initElements(driver,this);
    }

    public void navigateToPage(String url) {
        driver.get(url);
    }

    void clickOnElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }

    public void sendKeysElement(By locator, String s) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(s);
    }

    public void checkShowSuccess(By locator) {
        WebElement notificationEdit = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Assert.assertTrue(notificationEdit.isDisplayed());
    }

    public void quitBrowser() {
        driver.quit();
    }
}
