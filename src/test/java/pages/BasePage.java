package pages;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
    }
    public void navigateToPage(String url) {

        driver.get(url);
    }

    public String getRandomString(){
        String randomString = RandomStringUtils.randomAlphabetic(10);
        return randomString;
    }

    public void quitBrowser() {

        driver.quit();
    }

    public void enterText(By inputLocator, String inputText) {
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(inputLocator));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(inputText);
    }
}
