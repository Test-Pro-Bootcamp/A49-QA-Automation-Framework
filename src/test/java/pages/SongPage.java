package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SongPage extends BasePage{

    public SongPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css =".playback")
    WebElement playbackBtn;

    public SongPage contextClickSongByName(String songName)  {
        WebElement song =wait.until(ExpectedConditions.
                elementToBeClickable(By.xpath("//section[@id='songsWrapper']//td[text()='"+songName+"']")));
        actions.contextClick(song).perform();
        return this;
    }
    public SongPage clickPlay() {
        wait.until(ExpectedConditions.elementToBeClickable(playbackBtn)).click();
        return this;
    }
}