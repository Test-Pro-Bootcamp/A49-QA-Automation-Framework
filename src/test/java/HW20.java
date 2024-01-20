import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW20 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedPlaylistDeleteMessage = "Deleted playlist \"Test Pro Playlist\"";
        navigateToPage();
        provideEmail("dagebeyehu@gmail.com");
        providePassword("yozca5uQiLxb!");
        clickSubmit();
        clickonPlaylist();
        clickonDeletePlaylistBtn();
        checkShowSuccess();

    }

    private void checkShowSuccess() {
        ClickOnElement(By.cssSelector("div.show.success"));
    }

    private void clickonDeletePlaylistBtn() {
        ClickOnElement(By.cssSelector(".btn-delete-playlist"));
    }

    private void clickonPlaylist() {
        ClickOnElement(By.cssSelector("[href='#!/playlist/85974']"));
    }

    void ClickOnElement(By locator){
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        el.click();
    }
    
}
