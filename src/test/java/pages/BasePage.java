package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.UUID;

public class BasePage {

    public static WebDriver driver = null;
    WebDriverWait wait;
    Actions actions;

    public BasePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        this.driver = driver;
        this.wait = wait;
        this.actions = actions;
        //wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //actions = new Actions(driver);
    }

    public void navigateToPage(String url) {
        driver.get(url);
    }

    ;

    public String castRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public void clickOnElement(By locator) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
        el.click();
    }

    public void enterText(By locator, String text) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    public void clickOnOk() {
        WebElement okBtn = driver.findElement(By.cssSelector((".ok")));
        okBtn.click();
    }

    public void checkSpellSuccess() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        Assert.assertTrue(notification.isDisplayed());
    }

    /*public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public WebElement findElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }*/
    public void closeBrowser() {
        driver.quit();
    }
}
