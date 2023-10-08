package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
//    public HomePage(WebDriver driver) {
//        super(driver);
//    }

    public void clickOnPlaylist(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + playlistName + "')]"))).click();
    }
    public void clickDeletePlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Delete this playlist']"))).click();
        WebElement notificationDeleted = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div")));
        Assert.assertTrue(notificationDeleted.isDisplayed());
    }
    public void clickViewAll() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-test='view-all-songs-btn']"))).click();
    }

    public void clickAllSongs() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li a.songs"))).click();
    }
    public void clickPlay() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playback"))).click();
    }
    public  void checkSongIsPlaying() {
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        Assert.assertTrue(soundBar.isDisplayed());
    }
    public void checkIAvataIsVisible() {
        WebElement playBtn =   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Avatar of student']")));
        Assert.assertTrue(playBtn.isDisplayed());
    }
    public void checkIfPlayBtnIsVisible() {
        WebElement playBtn =   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='play-btn']")));
        Assert.assertTrue(playBtn.isDisplayed());
    }

    public void mouseMoveToPlayBtn(){
        WebElement playPanel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".side.player-controls")));
        action.moveToElement(playPanel).click(playPanel).perform();
    }
    public void contextClickSongByName(String songName)  {
        WebElement song =wait.until(ExpectedConditions.
                elementToBeClickable(By.xpath("//section[@id='songsWrapper']//td[text()='"+songName+"']")));
        action.contextClick(song).perform();
    }
    public void SearchSongs(String s) {
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchForm\"]/input")));
        search.clear();
        search.sendKeys(s);
    }
    public void playNextSong() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mainFooter']/div[1]/i[2]"))).click();

    }
    public void addSongToMyPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"songResultsWrapper\"]/div/div/div[1]/table/tr"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/span/button[2]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[1]/ul/li[5]"))).click();
        WebElement addSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div")));
        Assert.assertTrue(addSong.isDisplayed());
    }
    public void rightClickEditPlaylist(String c) {
        action.contextClick(wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(c)))).perform();
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
        WebElement notificationEdit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div")));
        Assert.assertTrue(notificationEdit.isDisplayed());

    }
    public void clickLogout(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i.fa.fa-sign-out"))).click();
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Registration / Forgot password")));
        Assert.assertTrue(soundBar.isDisplayed());
    }
}