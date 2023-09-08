import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist(){
        navigateToPage();
        provideEmail("dagebeyehu@gmail.com");
        providePassword(te$tStudent);
        clickSubmit();
        clickOnPlaylist();
        clickonDeletePlaylistBtn();
        checkShowSuccess();
        

    }

    private void clickonDeletePlaylistBtn() {
        WebElement deletePlaylistBtn = driver.findElement(By.cssSelector(".del.btn-delete-playlist"));
        deletePlaylistBtn.click();
    }

    private void clickOnPlaylist() {
        WebElement playlist = driver.findElement(By.cssSelector("playlist:nth-child(3)"));
        playlist.click();
    }

    private void checkShowSuccess() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        Assert.assertTrue(notification.isDisplayed())