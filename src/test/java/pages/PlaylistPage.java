package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class PlaylistPage extends BasePage{
    public PlaylistPage(WebDriver driver) {

        super(driver);
    }
    public PlaylistPage checkNumberOfSongsInPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".song-list-wrapper.main-scroll-wrap.playlist td.title")));
        List<WebElement> allSongsInPlaylist =driver.findElements(By.cssSelector(".song-list-wrap.main-scroll-wrap.playlist td.title"));
        for (WebElement element: allSongsInPlaylist)
        {
            System.out.println (element.getText());
        }
        Assert.assertEquals(allSongsInPlaylist.size(),3);
        return this;
    }
    public PlaylistPage summonScroll() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("data-testid='playlist-context-menu-create-simple']"))).click();
        return this;
    }
    public PlaylistPage castNewScroll() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sidebar-create-playlist-btn']"))).click();
        return this;
    }
    public PlaylistPage castNameScroll (String newScrollName) {
        WebElement scrollListField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        scrollListField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        scrollListField.sendKeys(newScrollName);
        scrollListField.sendKeys(Keys.ENTER);
        return this;
    }
    public PlaylistPage castBanishScroll() {
        WebElement banishScroll = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".del.btn-delete-playlist")));
        actions.click(banishScroll).perform();
        return this;
    }
    public PlaylistPage selectScroll (String scrollName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + scrollName + "')]"))).click();
        return this;
    }
    public PlaylistPage doubleClickOnScroll (String scrollName) {
        WebElement playlistElement= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//a[contains(text(),'" + scrollName + "')]"))));
        actions.doubleClick(playlistElement).perform();
        return this;
    }
    public PlaylistPage checkSpellMessage (String scrollName) {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Updated playlist')]")));
        Assert.assertEquals("Updated playlist \""+scrollName+".\"",notification.getText());
        return this;

    }
}
