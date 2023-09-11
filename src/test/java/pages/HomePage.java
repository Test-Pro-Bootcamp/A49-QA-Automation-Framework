package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.SearchContext;


import java.awt.*;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By playlistsHeaderLoc = By.cssSelector("#sidebar > #playlists");
    By editMenu = By.xpath("//li[contains(text(), 'Edit')]");
    By input = By.cssSelector("input[name='name']");
    By successMessage = By.cssSelector("div.success.show");
    By plusButton = By.cssSelector("i[class='fa fa-plus-circle create']");
    By playlistButton = By.cssSelector("li[data-testid='playlist-context-menu-create-simple']");
    By playlistField = By.cssSelector("#playlists > form.create > input");
    //By notification = By.cssSelector("body > div.alertify-logs.top.right > div");


    public void renameExistingPlaylist(String nameOld, String nameNew) throws InterruptedException{
        WebElement playlistsHeader = findElement(playlistsHeaderLoc);
        List<WebElement> existingPlaylists = playlistsHeader.findElements(By.cssSelector("a"));
        for (WebElement el : existingPlaylists) {
            if (el.getText().contains(nameOld)) {
                actions.doubleClick(el).perform();
                WebElement editElement = findElement(input);
                actions.doubleClick(editElement).perform();
                editElement.sendKeys(nameNew);
                editElement.sendKeys(Keys.chord(Keys.ENTER));
            }
        }
    }
    public String getRenamePlaylistSuccessMsg() {
        return findElement(successMessage).getText();
    }
        public void createPlaylistAnotherWay (String playlistName){
            findElement(plusButton).click();
            findElement(playlistButton).click();
            findElement(playlistField).click();
            findElement(playlistField).clear();
            findElement(playlistField).sendKeys(playlistName);
            findElement(playlistField).sendKeys(Keys.ENTER);
        }
        public String showBanner (String textBanner) throws NoSuchElementException {
            try {
                WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.alertify-logs.top.right > div")));

                while (!Objects.equals(notification.getText(), textBanner)) {
                    notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.alertify-logs.top.right > div")));
                }

                return notification.getText();
            } catch (Exception e) {
                return e.getMessage();
            }
        }
    public Boolean findPlaylist(String namePlaylist) {
        WebElement playlistsHeader = findElement(playlistsHeaderLoc);
        List<WebElement> existingPlaylists = playlistsHeader.findElements(By.cssSelector("li"));
        for (WebElement el : existingPlaylists) {
            if (el.getText().contains(namePlaylist)) {
                return true;
            }
        }
        return false;
    }

    }
