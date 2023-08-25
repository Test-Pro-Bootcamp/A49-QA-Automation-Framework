import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {


        String expectedSongAddedMessage = "Added 1 Song into \"Test Pro Playlist.\"";

        //navigateTopage();
        castEmail("dirzo@gmail.com");
        castPassword("Te$ter1234");
        castSubmit();
        Thread.sleep(2000);
        searchASong("Way Of The Samurai");
        clickViewAll();
        selectFirstSong();
        clickAddtoBtn();
        selectPlaylist();
        Assert.assertEquals(getAddtoListMsg(), expectedSongAddedMessage);
    }

    private String getAddtoListMsg() {
        WebElement messageFlash = driver.findElement(By.cssSelector("div.success.show"));
        return messageFlash.getText();
    }

    private void selectPlaylist() throws InterruptedException {
        WebElement playlist = driver.findElement(By.xpath("//a[normalize-space()='Prepare for battle']"));
        playlist.click();
        Thread.sleep(2000);
    }

    private void clickAddtoBtn() throws InterruptedException {
        WebElement addToBtn = driver.findElement(By.cssSelector("button[title='Add selected songs to…']"));
        addToBtn.click();
        Thread.sleep(2000);
    }

    private void selectFirstSong() {
        WebElement firstUp = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item selected']"));
        firstUp.click();
    }

    private void clickViewAll() throws InterruptedException {
        WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(1500);
    }

    private void searchASong(String name) throws InterruptedException {
        WebElement searchBar = driver.findElement(By.cssSelector("div#searchForm>input[type='search]"));
        searchBar.sendKeys(name);
        Thread.sleep(1500);
    }
}
/*

    */
/*public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);*//*

    }

  */
/*  private void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email'"));
        emailField.click();
        emailField.sendKeys(email);
    }*//*


   */
/* private void navigateTopage() {
        driver.get(url);*//*

    }
    */
/*public void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();*//*


    }
}
*/
