public class Homework18 extends BaseTest {

    @Test()
    public void playSong () {
        navigateToPage();
        provideEmail("dagebeyehu@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        clickPlay();
        Assert.assertTrue(isSongPlaying());
    }
    private void clickPlayNextBtn() {
        WebElement playNextBtn = driver.findElement(By.cssSelector("//[@data-testid='play-next-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

        playNextButton.click();
        playNextBtn.click();

    }
    public boolean isSongPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
    }
}
