import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.UUID;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() {
        openLoginUrl();
        loginWithCorrectCred();
        clickAddPlaylist();
        selectNewOption();

        String randomName = generateRandomName();

        newPlaylist(randomName);
        selectNewRandomPlaylist();
        clickDeleteBtn();

        WebElement verifyMessage = driver.findElement(By.cssSelector(".alertify-logs"));
        Assert.assertTrue(verifyMessage.isDisplayed(), randomName);

        WebElement verifyString = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        Assert.assertTrue(verifyString.isDisplayed(), randomName);

    }
    public void selectNewRandomPlaylist() {
        WebElement selectPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alertify-logs")));
        selectPlaylist.click();
    }

    private void clickDeleteBtn() {
        WebElement deleteBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".del")));
        deleteBtn.click();
    }
    public String generateRandomName () {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
