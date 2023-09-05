package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;

    WebDriverWait wait;

    Actions actions;

    //constructor
    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    public void navigateToPage(String url){
        driver.get(url);
    }

    public void closeBrowser(){
        driver.quit();
    }

    public void waitForInvisibilityOfNotificationMessage(){
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        wait.until(ExpectedConditions.invisibilityOf(notification));
    }

}
