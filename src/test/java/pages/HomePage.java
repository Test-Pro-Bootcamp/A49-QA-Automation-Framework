package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void clickOnPlayList(String playlistName) {
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = '" + playlistName + "']")));
        actions.contextClick(playlist).perform();
    }
}
