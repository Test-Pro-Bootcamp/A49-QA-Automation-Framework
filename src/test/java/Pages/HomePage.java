package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends BasePage {


    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public HomePage clickOnPlaylist(String playListName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + playListName + "')]"))).click();
        return this;
    }

    public HomePage clickAllSongs() {
        WebElement clickAllSongs = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(("li a.songs"))));
        actions.doubleClick(clickAllSongs).perform();
        return this;
    }

    public HomePage searchTab(String song) {
        WebElement searchTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='search']")));
        searchTab.clear();
        searchTab.sendKeys(song);
        return this;
    }

    public HomePage viewAllButton() {
        WebElement viewAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='view-all-songs-btn']")));
        actions.doubleClick(viewAll).perform();
        return this;
    }

    public HomePage clickAvatar() {
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        actions.doubleClick(avatarIcon).perform();
        return this;
    }

    public HomePage soundBarVisible() {
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainFooter .media-info-wrap .other-controls  button:nth-child(2)  img")));
        Assert.assertTrue(soundBar.isDisplayed());
        return this;
    }
    public HomePage clickOnAllSongs() {
        WebElement allSongs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sidebar section.music li:nth-child(3) a")));
        allSongs.click();
        return this;
    }
    public HomePage playASong() {
        WebElement panel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.side.player-controls")));
        actions.moveToElement(panel).perform();
        WebElement hoverClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='play-btn']")));
        actions.moveToElement(hoverClick).perform();
        WebElement playButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-testid='play-btn']")));
        actions.click(playButton).perform();
        return this;

    }
}
