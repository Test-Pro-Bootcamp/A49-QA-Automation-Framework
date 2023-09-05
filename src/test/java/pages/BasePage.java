package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {
    static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
    }
    public void quitBrowser(){
        driver.quit();
    }
    //verify song is added to playlist
    public void verifySuccessMessage() {
        WebElement popUpNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show")));
        Assert.assertTrue(popUpNotification.isDisplayed());
    }

    public void navigateToPage(String url) {
    }
}
