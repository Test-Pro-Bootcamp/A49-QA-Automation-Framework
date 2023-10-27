package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.UUID;
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    @FindBy(css = "div.success.show")
    WebElement notification;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);

    }
    public void navigateToPage(String url) {
        driver.get(url);
    }
    public String castRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    public void clickOnElement(By locator) {
        WebElement el= wait.until(ExpectedConditions.elementToBeClickable(locator));
        el.click();
    }
    public void enterText(By locator, String text) {
        WebElement el= wait.until(ExpectedConditions.elementToBeClickable(locator));
        el.click();
        el.clear();
        el.sendKeys(text);
    }
    public BasePage waitForSpellFade() {
        wait.until(ExpectedConditions.invisibilityOf(notification));
        return this;
    }

    /*public WebElement findElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void doubleClick (By locator){
        actions.doubleClick(findElement(locator)).perform();*/

    public void closeBrowser() {
        driver.quit();
    }
}
