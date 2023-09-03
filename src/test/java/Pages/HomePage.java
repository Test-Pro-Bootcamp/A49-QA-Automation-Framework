package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    //Play a song
    By clickAvatarIcon = By.cssSelector("[data-testid='view-profile-link']");
    By clickSongsTab = By.cssSelector(".music .songs");
    By selectASong = By.cssSelector("#songsWrapper tr.song-item");
//    By playNextBtn = By.cssSelector("[data-testid='play-next-btn']");
    By playBtn = By.cssSelector("[data-testid='play-btn']");
    By clickDeleteBtn = By.cssSelector(".del");
    public void clickAvatarIcon(){
        findElement(clickAvatarIcon).click();
    }
    public void clickSongsTab(){
        findElement(clickSongsTab).click();
    }
    public void selectASong() {
        findElement(selectASong).click();
    }
    public WebElement playHover() {
        WebElement play = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".side.player-controls")));
        actions.moveToElement(play).perform();
        return driver.findElement(By.cssSelector(".side.player-controls"));
    }
    public void checkHover(){
        Assert.assertTrue(playHover().isDisplayed());
    }
    public void playBtn() {
        findElement(playBtn).click();
    }
    public void clickDeleteBtn() {
        findElement(clickDeleteBtn).click();
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
