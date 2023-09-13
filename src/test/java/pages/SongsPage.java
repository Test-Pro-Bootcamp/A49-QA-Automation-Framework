package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SongsPage extends BasePage{

    public SongsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".playback")
    WebElement playbutton;

    @FindBy (css = "[data-testid='sound-bar-play']")
    WebElement soundBar;

    public SongsPage findSong(String songName){
        WebElement song =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songsWrapper']//td[text()='"+songName+"']")));
        actions.contextClick(song).perform();
        return this;
    }

    public SongsPage doubleclickOnSong(String songName){
        WebElement song =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songsWrapper']//td[text()='"+songName+"']")));
        actions.doubleClick(song).perform();
        return this;
    }

    public SongsPage clickPlayOption() {
        wait.until(ExpectedConditions.elementToBeClickable(playbutton));
        playbutton.click();
        return this;
    }

    public SongsPage checkIfSongIsPlaying(){
        wait.until(ExpectedConditions.visibilityOf(soundBar));
        return this;
    }
}
