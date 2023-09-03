import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    @Parameters({"BaseURL"})
    @Test
    public void renamePlaylist(String baseUrl) {
        driver.get(baseUrl);
        loginValideEmailPassowrd("momo.carlos5@gmail.com", "te$t$tudent");
        // findPlayList("//a[text()=\"carlos\"]");
        rightClickEdit("//a[text()=\"carlos\"]");
    }

    private void rightClickEdit(String c) {
        action.contextClick(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(c)))).perform();
        clickOnElement(By.xpath("//li[text()='Edit']"));
        WebElement edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));

        String value = edit.getAttribute("value");
        if (value != null) {

            for (int i = 0; i < value.length(); i++) {
                edit.sendKeys(Keys.BACK_SPACE);
            }
        }
        edit.sendKeys("diakite");
        edit.sendKeys(Keys.ENTER);

        WebElement notificationDeleted = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div")));
        Assert.assertTrue(notificationDeleted.isDisplayed());

    }

  /*  private void findPlayList(String f) {
        clickOnElement(By.xpath(f));

    }**/

    private void loginValideEmailPassowrd(String e, String p) {
        // WebElement email = driver.findElement(By.cssSelector("input[placeholder=\"Email Address\"]"));
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder=\"Email Address\"]")));
        email.clear();
        email.sendKeys(e);
        // driver.findElement(By.cssSelector("[placeholder=\"Password\"] ")).sendKeys(p);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder=\"Password\"] "))).sendKeys(p);
        // driver.findElement(By.cssSelector("[type=submit]")).click();
        clickOnElement(By.cssSelector("[type=submit]"));
    }

    void clickOnElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();

    }
}
