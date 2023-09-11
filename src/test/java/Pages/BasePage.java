package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.UUID;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    public String url;

    public BasePage(WebDriver driver, WebDriverWait wait,Actions actions){
        this.driver =driver;
        this.wait =wait;
        this.actions =actions;
    }

    public void navigateToLoginPage(String url) {
        driver.get(this.url);
        Assert.assertEquals(driver.getCurrentUrl(), this.url);
    }

    public String generateRandom(){
        return UUID.randomUUID().toString().replace("","");
    }
    public void quitBrowser(){
        driver.quit();
    }
}
