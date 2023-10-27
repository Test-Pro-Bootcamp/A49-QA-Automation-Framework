package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "li a.songs")
    WebElement allSongsBtn;
    @FindBy(css = "[data-testid='sound-bar-play']")
    WebElement manaBar;
    @FindBy(css = "[data-testid='play-btn']")
    WebElement playBtn;
    @FindBy(css = "side.player-controls")
    WebElement controlPanel;
    @FindBy(css = "[title='Create a new playlist']")
    WebElement newRitual;
    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    WebElement createScroll;
    @FindBy(css = "section[id='playlists'] li:nth-child(3)")
    WebElement firstScroll;
    @FindBy(css ="div.show.success")
    WebElement spellResult;
    @FindBy(xpath = "//section[@id='playlists']//li[@class='playlist playlist']")
    WebElement updatePlaylist;
    @FindBy(xpath = "//section[@id='playlists']//li[@class='playlist playlist']")
    WebElement deletePlaylist;
    @FindBy(css = ".del.btn-delete-playlist")
    WebElement banishPlaylist;
    @FindBy (css = "body > div.alertify > div > div > nav > button.ok")
    WebElement okButton;
    @FindBy (css = "[type='search']")
    WebElement ritualField;
    @FindBy(css = "button[data-test='view-all-songs-btn']")
    WebElement viewAll;
    @FindBy (css = "section #songResultsWrapper section.existing-playlists li.playlist")
    WebElement listButton;
    @FindBy (xpath = "//*[@id='songResultsWrapper']//*[@class='song-list-controls']//*[@class='existing-playlists']//li[contains(text(), 'Crios Spellbook')]")
    WebElement criosSpellBook;
    @FindBy(css = ".search-results .song-item .title")
    WebElement firstSong;
    @FindBy(css = ".btn-add-to")
    WebElement addTo;
    @FindBy (css = ".menu .songs")
    WebElement allSongsButton;
    @FindBy(css = "input[name='name']")
    WebElement spellbookTitle;
    @FindBy(css = "img[class='avatar']")
    WebElement wizardIcon;

    public boolean isWizardDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(wizardIcon));
        return wizardIcon.isDisplayed();
    }
    public HomePage searchForRitual(String name) {
        wait.until(ExpectedConditions.visibilityOf(ritualField));
        ritualField.clear();
        ritualField.sendKeys(name);
        return this;
    }
    public HomePage allResults() {
        wait.until(ExpectedConditions.visibilityOf(viewAll));
        viewAll.click();
        return this;
    }
    public HomePage firstSongInList(){
        wait.until(ExpectedConditions.visibilityOf(firstSong));
        firstSong.click();
        return this;
    }
    public HomePage clickAddToBtn(){
        wait.until(ExpectedConditions.visibilityOf(addTo));
        addTo.click();
        return this;
    }
    public HomePage addSongToPlaylist() {
        wait.until(ExpectedConditions.visibilityOf(listButton));
        Actions action = new Actions(driver);
        action.moveToElement(listButton);
        listButton.click();
        return this;
    }
    public HomePage addSongToCriosPlaylist() {
        wait.until(ExpectedConditions.visibilityOf(listButton));
        Actions action = new Actions(driver);
        action.moveToElement(criosSpellBook);
        criosSpellBook.click();
        return this;
    }
    public HomePage clickAllSongs() {
        wait.until(ExpectedConditions.elementToBeClickable(allSongsBtn)).click();
        return this;
    }
    public HomePage createNewSpellBook(String myNewSpellbook){
        String newSpellBook = "#playlists .fa.fa-plus-circle.create";
        clickOnElement(By.cssSelector(newSpellBook));
        wait.until(ExpectedConditions.visibilityOf(createScroll)).click();
        spellbookTitle.sendKeys(myNewSpellbook);
        spellbookTitle.sendKeys(Keys.RETURN);
        return this;
    }
    public HomePage banishCreatedSpellbook() {
        wait.until(ExpectedConditions.visibilityOf(deletePlaylist));
        deletePlaylist.click();
        wait.until(ExpectedConditions.visibilityOf(banishPlaylist));
        banishPlaylist.click();
        wait.until(ExpectedConditions.visibilityOf(okButton));
        okButton.click();
        return this;
    }
    public HomePage updateSpellBookTitle(String newSpellbookTitle) {
        wait.until(ExpectedConditions.visibilityOf(spellbookTitle));
        spellbookTitle.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        spellbookTitle.sendKeys(Keys.DELETE);
        spellbookTitle.sendKeys(newSpellbookTitle);
        spellbookTitle.sendKeys(Keys.ENTER);
        return this;
    }
    public HomePage doubleClickSpellBook() {
        wait.until(ExpectedConditions.visibilityOf(updatePlaylist));
        actions.doubleClick(updatePlaylist).perform();
        return this;

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


    public HomePage newRitual(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(newRitual));
        newRitual.clear();
        newRitual.sendKeys(name);
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
    public String verifySpellResult() {
        wait.until(ExpectedConditions.visibilityOf(spellResult));
        return spellResult.getText();
    }

}




