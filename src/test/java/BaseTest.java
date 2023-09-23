import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseTest {

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void ValidEmailPassword(){
        public void provideEmail(){
            WebElement provideEmail = driver.findElement(By.CssSelector"[type = 'email']"));
            provideEmail.clear();
            provideEmail.sendKeys("demo@class.com");
        }

            public void providePassword(){
                WebElement providePassword = driver.findElement(By.CssSelector"[type = 'password']"));
                providePassword.clear();
                providePassword.sendKeys("te$t$tudent");
        }

                public void clickSubmit();
                WebElement submit = driver.findElement(By.CssSelector"(button[type = 'submit']"));
                submit.click();
    }
    public void navigateToPage() {
        driver.get(url);
    }

    public void searchSong() throws InterruptedException {
        WebElement searchField = driver.findElement(By.CssSelector"divSearchForm input[type = 'search' ]"));
        searchField.sendKeys();
        Thread.sleep(millis:2000);
    }

    public void clickViewAllBtn() throws InterruptedException {
        WebElement viewAllBtn = driver.findElement(By.ByXPath(button"//[@data-test = 'view-all-songs-btn']"));
        viewAllBtn.click();
        Thread.sleep(2000);
    }
    public void selectFirstSongResult() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.ByXPath(xpathExpression:"//section[@id = 'songResultsWrapper']//tr[@class = 'song-item'][1]");
        firstSong.click();
        Thread.sleep(millis:2000);
)
        public void clickAddToBtn() throws InterruptedException {
            WebElement addToBtn = driver.findElement(By.XPath(xpathExpression:"//[]"));
            addToBtn.click();
            Thread.sleep(millis:2000);

            public void choosePlaylist() throws InterruptedException {
                WebElement playlist = driver.findElement(By.XPath(xpathExpression:"//section[@id = 'songResultsWrapper']//li[contains(text),'Test Pro Playlist']")
                playlist.click();
                Thread.sleep(millis:2000);

                public String getAddToSuccessMessage() throws InterruptedException {
                    WebElement addToPlaylistSuccessMessage = driver.findElement(By.cssSelector"[div.success.show]"));
                    return notification.getText();

                }
                Assert.assertEquals(getAddToSuccessMessage(),expectedSongAddedMessage);

    public void avatarIcon(){
                WebElement avatarIcon = driver.findElement(By.CssSelector"(ing[class = 'avatar']"));
                    Assert.assertTrue(avatarIcon.isDisplayed());
                }
}