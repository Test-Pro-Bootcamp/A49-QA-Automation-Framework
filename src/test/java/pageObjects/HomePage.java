package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    By clickAvatarIcon = By.cssSelector("[data-testid='view-profile-link']");
    By clickSongsTab = By.cssSelector(".music .songs");
    By selectASong = By.cssSelector("#songsWrapper tr.song-item");
    By playBtn = By.cssSelector("[data-testid='play-btn']");
    private By clickDeleteBtn = By.cssSelector(".del");
    private By clickOk = By.cssSelector(".ok");
    public void clickAvatarIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(clickAvatarIcon)).click();
    }
    public HomePage waitForLoadingBarToDisappear(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".overlay")));
        return this;
    }
    public HomePage clickSongsTab(){
        wait.until(ExpectedConditions.elementToBeClickable(clickSongsTab)).click();
        return this;
    }
    public HomePage selectASong() {
        WebElement selectSong = wait.until(ExpectedConditions.elementToBeClickable(selectASong));
        actions.moveToElement(selectSong).perform();
        return this;
    }
    public WebElement playHover() {
        WebElement play = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".side.player-controls")));
        actions.moveToElement(play).perform();
        return driver.findElement(By.cssSelector(".side.player-controls"));
    }
    public HomePage checkHover(){
        Assert.assertTrue(playHover().isDisplayed());
        return this;
    }
    public HomePage playBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(playBtn)).click();
        return this;
    }
    public void clickDeleteBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickDeleteBtn)).click();
    }
        public void clickOk(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickOk)).click();
    }
    public void checkSoundbars() {
        WebElement verifySongState = driver.findElement(By.cssSelector("[data-test=\"soundbars\"]"));
        Assert.assertTrue(verifySongState.isDisplayed());
    }
    public void verifyStringName(){
        WebElement verifyString = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        Assert.assertTrue(verifyString.isDisplayed());
    }
}