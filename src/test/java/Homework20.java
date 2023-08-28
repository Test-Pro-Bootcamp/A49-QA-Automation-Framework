import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homework20 extends BaseTest {
    @Test(description = "Homework 20 -  implementExplicitWaits")

    public void deletePlaylist() {




        logInWithRightCredentials();

        clickPlaylist();
        clickDeletePlaylist();
        clickOKPopUP();
        verifySuccessMessage();






    }

}
