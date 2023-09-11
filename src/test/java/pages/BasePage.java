package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class BasePage {
    WebDriver theDriver;
    WebDriverWait wait;
    Actions actions;

    public BasePage(WebDriver givenDriver) {
        theDriver = givenDriver;
        wait = new WebDriverWait(theDriver, Duration.ofSeconds(5));
        actions = new Actions(theDriver);
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> findElements(By locator) {
        return Collections.singletonList(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
    }

    public void contextClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.contextClick(element).perform();
    }

    public void doubleClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.doubleClick(element).perform();
    }

}