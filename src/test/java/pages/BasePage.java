package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    protected WebDriverWait wait;

    protected Actions actions;

    //constructor
    /*public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }*/
    //constructor
    public BasePage(WebDriver givenDriver){
        this.driver = givenDriver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "div.success.show")
    WebElement notification;

    public void navigateToPage(String url){
        driver.get(url);
    }

    public void closeBrowser(){
        driver.quit();
    }

    public BasePage waitForInvisibilityOfNotificationMessage(){
        //WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        wait.until(ExpectedConditions.invisibilityOf(notification));
        return this;
    }



    /*
    //without Page Factory
    public void waitForInvisibilityOfNotificationMessage(){
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        wait.until(ExpectedConditions.invisibilityOf(notification));
    }
    public void checkIfSongIsPlaying(){
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
    }

    public void checkIfSongIsNOTPlaying(){
        WebElement soundbar = driver.findElement(By.cssSelector("[data-testid='sound-bar-play']"));
        wait.until(ExpectedConditions.invisibilityOf(soundbar));
    }
     */

}
