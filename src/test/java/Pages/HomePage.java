//package Pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.Assert;
//
//public class HomePage extends BasePage{
//    public HomePage(WebDriver driver) {
//        super(driver);
//    }
//
//    @FindBy (css = ".music .songs")
//    private WebElement songsTab;
//    @FindBy (css = "#songsWrapper tr.song-item")
//    private WebElement select;
//    @FindBy (css = "[data-testid='play-btn']")
//    private WebElement play;
//    //Play a song
//    By clickAvatarIcon = By.cssSelector("[data-testid='view-profile-link']");
////    By clickSongsTab = By.cssSelector(".music .songs");
////    By selectASong = By.cssSelector("#songsWrapper tr.song-item");
////    By playBtn = By.cssSelector("[data-testid='play-btn']");
//    private By clickDeleteBtn = By.cssSelector(".del");
//    public void clickAvatarIcon(){
//        wait.until(ExpectedConditions.elementToBeClickable(clickAvatarIcon)).click();
//    }
//    public HomePage clickSongsTab(){
//        wait.until(ExpectedConditions.elementToBeClickable(songsTab)).click();
//        return this;
//    }
//    public HomePage selectASong() {
//        wait.until(ExpectedConditions.elementToBeClickable(select)).click();
//        return this;
//    }
//    public WebElement playHover() {
//        WebElement play = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".side.player-controls")));
//        actions.moveToElement(play).perform();
//        return driver.findElement(By.cssSelector(".side.player-controls"));
//    }
//    public HomePage checkHover(){
//        Assert.assertTrue(playHover().isDisplayed());
//        return this;
//    }
//    public HomePage playBtn() {
//        wait.until(ExpectedConditions.elementToBeClickable(play)).click();
//        return this;
//    }
//    public void clickDeleteBtn() {
//        findElement(clickDeleteBtn).click();
//    }
//    public void checkSoundbars() {
//        WebElement verifySongState = driver.findElement(By.cssSelector("[data-test=\"soundbars\"]"));
//        Assert.assertTrue(verifySongState.isDisplayed());
//    }
//    public void verifyStringName(){
//        WebElement verifyString = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
//        Assert.assertTrue(verifyString.isDisplayed(), randomName);
//    }
//}
