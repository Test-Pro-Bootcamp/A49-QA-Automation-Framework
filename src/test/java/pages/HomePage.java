package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[class='playlist playlist']")
    private WebElement doubleClick;
    @FindBy(css = "[name='name']")
    private WebElement playListInputField;

    // @FindBy(css = "div.success.show")
   // private WebElement notification;

    //  private By choosePlayListName =  By.cssSelector(".playlist:nth-child(4)");
    //  private By playListInputField = By.cssSelector("[name='name']");
    //  private By notification = By.cssSelector("div.success.show");

    public HomePage doubleClickPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(doubleClick));
        actions.doubleClick(doubleClick).perform();
        return this;
    }
    public HomePage enterNewPlayListName(String playListName) {
        wait.until(ExpectedConditions.elementToBeClickable(playListInputField));
        playListInputField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playListInputField.sendKeys(playListName);
        playListInputField.sendKeys(Keys.ENTER);
        return this;
    }
   // public HomePage playListMessage() {
      //  notification.getText();
     //   return this;
    }
//}
