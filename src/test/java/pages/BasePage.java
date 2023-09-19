package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BasePage {
    WebDriver theDriver;
    WebDriverWait wait;
    Actions actions;

    public BasePage(WebDriver givenDriver) {
        theDriver = givenDriver;
        wait = new WebDriverWait(theDriver, Duration.ofSeconds(5));
        actions = new Actions(theDriver);
        PageFactory.initElements(theDriver, this);
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> findElements(By locator) {
        return Collections.singletonList(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
    }

    public BasePage contextClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.contextClick(element).perform();
        return this;
    }

    public BasePage doubleClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.doubleClick(element).perform();
        return this;
    }
    public BasePage navigateToPage(String baseUrl) {
        theDriver.get(baseUrl);
        return this;
    }

    public String showBanner (String textBanner) throws NoSuchElementException {
        try {
            WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.alertify-logs.top.right > div")));

            while (!Objects.equals(notification.getText(), textBanner)) {
                notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.alertify-logs.top.right > div")));
            }

            return notification.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    public BasePage search(String song) {
        WebElement searchField = findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(song);
        return this;
    }

}