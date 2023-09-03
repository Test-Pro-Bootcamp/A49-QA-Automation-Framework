package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }


    private By choosePlayListName =  By.cssSelector(".playlist:nth-child(4)");
    private By playListInputField = By.cssSelector("[name='name']");
    private By notification = By.cssSelector("div.success.show");



    public void doubleClickPlaylist() {
        doubleClick(choosePlayListName);
    }

    public void enterNewPlayListName(String playListName) {
        findElement(playListInputField).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.BACK_SPACE));
        findElement(playListInputField).sendKeys(playListName);
        findElement(playListInputField).sendKeys(Keys.ENTER);
    }

    public String playListMessage() {
        return findElement(notification).getText();
    }
}
