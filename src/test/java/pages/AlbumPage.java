package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openxmlformats.schemas.drawingml.x2006.chart.STHPercentUShort;
import org.testng.Assert;

public class AlbumPage extends BasePage{


    @FindBy(xpath ="//li[text()='Play All']")
    WebElement playbAll;
    @FindBy(css = "li[data-test='shuffle']")
    WebElement shuffle;
    @FindBy(linkText = "Play all songs in the album Airbit")
    WebElement btn;
    @FindBy(css = "a.albums")
    WebElement albums;
    @FindBy(css = "section[id='albumsWrapper'] h1")
    WebElement title;
    @FindBy(xpath = "//img[@alt='Sound bars']")
    WebElement sound;

    public AlbumPage(WebDriver driver) {
        super(driver);
    }
    public AlbumPage clickAlbums(){
        wait.until(ExpectedConditions.elementToBeClickable(albums)).click();
        return this;
    }

    public AlbumPage clickPlayAll(){
        wait.until(ExpectedConditions.elementToBeClickable(playbAll)).click();
        wait.until(ExpectedConditions.visibilityOf(sound));
        Assert.assertTrue(sound.isDisplayed());
        return this;
    }
    public AlbumPage shufflePlay(){
        wait.until(ExpectedConditions.elementToBeClickable(shuffle)).click();
        wait.until(ExpectedConditions.visibilityOf(sound));
        Assert.assertTrue(sound.isDisplayed());
        return this;
    }
    public AlbumPage clickRigthBtnPlay(){
        action.contextClick(wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Play all songs in the album Airbit")))).perform();
        return this;
    }
    public AlbumPage checkIfTitleIsVisible(){
        wait.until(ExpectedConditions.visibilityOf(title));
        Assert.assertTrue(title.isDisplayed());
        return this;
    }
}
