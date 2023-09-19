package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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



    public void renameExistingPlaylist(String nameOld, String nameNew) throws InterruptedException{
        //String url = "https://qa.koel.app/";
        WebElement playlistsHeader = findElement(playlistsHeaderLoc);
        List<WebElement> existingPlaylists = playlistsHeader.findElements(By.cssSelector("a"));
        for (WebElement el : existingPlaylists) {
            if (el.getText().equals(nameOld)) {
                Thread.sleep(3000);
                actions.contextClick(el).perform();
                wait.until(ExpectedConditions.visibilityOfElementLocated(editMenu)).click();
                WebElement editElement = wait.until(ExpectedConditions.visibilityOfElementLocated(input));
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
