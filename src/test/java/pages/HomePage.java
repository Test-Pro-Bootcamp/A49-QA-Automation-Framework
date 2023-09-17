package pages;

import org.openqa.selenium.Keys;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver){
        super(givenDriver);

    }
    By firstPlaylist = By cssSelector(".playlist:nth-child(3)");
    By playlistNameField = By cssSelector("[name='name']");
    By renamePlaylistSuccessMsg = By.cssSelector("div.success.show");

    public void doubleClickPlaylist(){
        doubleClick(firstPLaylist);
    }
    public void enterNewPlaylistName(StringplaylistName){
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
    }
    public String getRenamePlaylistSuccessMessage(){
        return findElement(renamePlaylistSuccessMsg).getText();
    }

}
