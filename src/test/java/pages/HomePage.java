package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver, WebDriverWait wait, Actions actions){
        super(driver, wait, actions);
    }
    By userAvatarIcon = By.cssSelector("img.avatar");
    public WebElement getUserAvatar () {

        //return findElement(userAvatarIcon);

        return null;
    }
}

