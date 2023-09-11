package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public void clickOnPlaylist(String playListName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + playListName + "')]"))).click();
    }

    public void clickAllSongs() {
        WebElement clickAllSongs = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(("li a.songs"))));
        actions.doubleClick(clickAllSongs).perform();
    }

    public void searchTab(String song) {
        WebElement searchTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='search']")));
        searchTab.clear();
        searchTab.sendKeys(song);
    }

    public void viewAllButton() {
        WebElement viewAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='view-all-songs-btn']")));
        actions.doubleClick(viewAll).perform();
    }

    public void clickAvatar() {
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        actions.doubleClick(avatarIcon).perform();
    }

    public void soundBarVisible() {
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainFooter .media-info-wrap .other-controls  button:nth-child(2)  img")));
        Assert.assertTrue(soundBar.isDisplayed());
    }
    public void clickOnAllSongs() {
        WebElement allSongs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sidebar section.music li:nth-child(3) a")));
        allSongs.click();
    }
    public void playASong() {
        WebElement panel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.side.player-controls")));
        WebElement hoverClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='play-btn']")));
        WebElement playButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-testid='play-btn']")));

        panel.click();
        hoverClick.click();
        playButton.click();
    }
}
