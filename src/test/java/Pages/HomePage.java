package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }
    public void clickAvatarIcon() {
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='view-profile-link']")));
        avatarIcon.click();
    }
    //Homework18
    //Method clicks on all songs tab
    public void clickSongsTab() {
        WebElement clickAllSongsTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".music .songs")));
        clickAllSongsTab.click();
    }
    //Inputs random string as new playlist name, So when I delete it this test will function everytime no matter what
    public void selectASong() {
        WebElement selectSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#songsWrapper tr.song-item")));
        selectSong.click();
    }
    public void playNextBtn() {
        WebElement playNextSong = driver.findElement(By.cssSelector("[data-testid='play-next-btn']"));
        playNextSong.click();
    }
    public void playBtn() {
        WebElement clickPlayBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        clickPlayBtn.click();
    }
    public void clickDeleteBtn() {
        WebElement deleteBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".del")));
        deleteBtn.click();
    }
    public void checkSoundbars() {
        WebElement verifySongState = driver.findElement(By.cssSelector("[data-test=\"soundbars\"]"));
        Assert.assertTrue(verifySongState.isDisplayed());
    }
    public void verifyStringName(){
        WebElement verifyString = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        Assert.assertTrue(verifyString.isDisplayed(), randomName);
    }
}
