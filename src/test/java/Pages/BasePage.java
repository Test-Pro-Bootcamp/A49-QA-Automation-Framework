package Pages;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.UUID;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }
    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void openLoginUrl(String url) {
        driver.get(url);
    }
    public void quitBrowser() {
        driver.quit();
    }
    public String generateRandomName () {
        return UUID.randomUUID().toString().replace("-", "");
    }
    String randomName = generateRandomName();
    public void clickOnElement(By locator) {
        WebElement el= wait.until(ExpectedConditions.elementToBeClickable(locator));
        el.click();
    }
    public void enterText (By locator, String text) {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);
    }
//    public void clickOk(){
//        WebElement okBtn = driver.findElement(By.cssSelector(".ok"));
//        okBtn.click();
//    }
    public void selectNewRandomPlaylist() {
        WebElement selectPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alertify-logs")));
        selectPlaylist.click();
    }
}
