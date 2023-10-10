package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "li a.songs")
    private WebElement allSongsBtn;
    @FindBy(css = "[data-testid='sound-bar-play']")
    private WebElement manaBar;
    @FindBy(css = "[data-testid='play-btn']")
    private WebElement playBtn;
    @FindBy(css = "side.player-controls")
    private WebElement controlPanel;
    @FindBy(css = "[title='Create a new playlist']")
    private WebElement newRitual;
    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    private WebElement createScroll;
    @FindBy(css = "[.playlist:nth-child(3)']")
    private WebElement firstScroll;





  /*  private By firstScroll = By.cssSelector(".playlist:nth-child(3)");
    private By spellTarget = By.cssSelector("[name='name']");*/
    private By getRenamedScrollAch = By.cssSelector("div.success.show");

    public HomePage clickAllSongs() {
        wait.until(ExpectedConditions.elementToBeClickable(allSongsBtn)).click();
        return this;
    }

    public void doubleClickScrolllist() {
        actions.doubleClick();
    }

    public HomePage checkSongIsPlaying() {
        wait.until(ExpectedConditions.visibilityOf(manaBar));
        Assert.assertTrue(manaBar.isDisplayed());
        return this;
    }

    public HomePage checkIfPlayBtnIsVisible() {
        wait.until(ExpectedConditions.visibilityOf(playBtn));
        Assert.assertTrue(playBtn.isDisplayed());
        return this;
    }

    public HomePage mouseMoveToPlayBtn() {
        wait.until(ExpectedConditions.visibilityOf(controlPanel));
        actions.moveToElement(controlPanel).click(controlPanel).perform();
        return this;
    }


    public HomePage newRitual() {
        wait.until(ExpectedConditions.elementToBeClickable(newRitual));
        newRitual.click();
        return this;
    }

    public HomePage createScroll() {
        wait.until(ExpectedConditions.elementToBeClickable(createScroll));
        createScroll.click();
        return this;
    }
    public HomePage firstScroll() {
        wait.until(ExpectedConditions.elementToBeClickable(firstScroll));
        firstScroll.click();
        return this;
    }


    public String getRenamePlaylistSuccessMsg() {
        return findElement(getRenamedScrollAch).getText();
    }


    By userAvatarIcon = By.cssSelector("img.avatar");

    public WebElement getUserAvatar() {

        return findElement(userAvatarIcon);

    }
}

    /*public void castRenameScroll(String newScrollName) {
        findElement(spellTarget).sendKeys(Keys.chord(Keys.LEFT_CONTROL,"A", Keys.BACK_SPACE));
        findElement(spellTarget).sendKeys(newScrollName);
        findElement(spellTarget).sendKeys(Keys.RETURN);
        *//*WebElement nameTarget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[id='playlists'] li:nth-child(3)")));
        actions.doubleClick(nameTarget).perform();
        WebElement spellTarget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        spellTarget.sendKeys(Keys.chord(Keys.LEFT_CONTROL,"A", Keys.BACK_SPACE));
        spellTarget.sendKeys(newScrollName);
        spellTarget.sendKeys(Keys.RETURN);*//*
    }*/


