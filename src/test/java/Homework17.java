import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collection;

public class Homework17 extends BaseTest {


    @Test
    public void addSongToPlaylist()  {

        String newSongNotification = "Added 1 song into";


        navigateToPage();
        provideEmail("natalia.kim01@testpro.io");
        providePassword("AxKrdBnS");
        clickSubmit();
        searchSong("Lament");
        clickViewAllBtn();
        clickFirstSong();
        clickAddTo();
        choosePlaylist();
        Assert.assertTrue(getNotificationText().contains(newSongNotification));


    }
    public void searchSong(String name)  {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#searchForm input[type= 'search']")));
        searchField.sendKeys(name);

    }

    public void clickViewAllBtn()  {
        WebElement viewAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test='view-all-songs-btn']")));
        viewAll.click();

    }
    public void clickFirstSong()  {
        WebElement firstSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]")));
        firstSong.click();

    }


    public void clickAddTo()  {
        WebElement addTo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']")));
        addTo.click();
    }


    public void choosePlaylist()  {
        WebElement playList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Homework')]")));
        playList.click();
    }


    public String getNotificationText() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        System.out.println(notification.getText());
        return notification.getText();

    }
}