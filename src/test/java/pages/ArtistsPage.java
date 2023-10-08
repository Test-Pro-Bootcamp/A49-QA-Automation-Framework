package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ArtistsPage extends BasePage{


    @FindBy(xpath ="//li[text()='Play All']")
    WebElement playbAll;
    @FindBy(css = "li[data-test='shuffle']")
    WebElement shuffle;
    @FindBy(xpath = "//img[@alt='Sound bars']")
    WebElement sound;

    @FindBy(xpath = "//a[contains(text(),'Artists')]")
    WebElement artists;
    @FindBy(xpath = "//h1[text()[normalize-space()='Artists']]")
    WebElement title;
    public ArtistsPage(WebDriver driver) {
        super(driver);
    }
    public ArtistsPage clickRigthBtnPlay(){
        action.contextClick(wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Play all songs by the artist AKMV-18")))).perform();
        return this;
    }
    public ArtistsPage clickPlayAll(){
        wait.until(ExpectedConditions.elementToBeClickable(playbAll)).click();
        wait.until(ExpectedConditions.visibilityOf(sound));
        Assert.assertTrue(sound.isDisplayed());
        return this;
    }
    public ArtistsPage shufflePlay(){
        wait.until(ExpectedConditions.elementToBeClickable(shuffle)).click();
        wait.until(ExpectedConditions.visibilityOf(sound));
        Assert.assertTrue(sound.isDisplayed());
        return this;
    }
    public ArtistsPage checkIfTitleIsVisible(){
        wait.until(ExpectedConditions.visibilityOf(title));
        Assert.assertTrue(title.isDisplayed());
        return this;
    }
    public ArtistsPage clickArtists(){
        wait.until(ExpectedConditions.elementToBeClickable(artists)).click();
        return this;
    }
}
