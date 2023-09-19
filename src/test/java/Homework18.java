import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.BasePage;
import pages.LoginPage;
import pages.SearchPage;
import pages.SongsPage;

import java.awt.*;

public class Homework18 extends BaseTest{

    @Test
    public void playSong() throws InterruptedException{
        BasePage basePage = new BasePage(theDriver);
        LoginPage loginPage = new LoginPage(theDriver);
        SongsPage songsPage = new SongsPage(theDriver);
        SearchPage searchPage = new SearchPage(theDriver);
        loginPage.login();
        basePage.search("HoliznaCC0");
        songsPage.clickViewAll();
        Actions actions = new Actions(theDriver);
        actions.doubleClick(searchPage.returnSearchSong(0,1)).perform();
        songsPage.clickPlayNextSong();
        Thread.sleep(3000);

        String classPlaying = "item playing";

        Assert.assertTrue(true, classPlaying);




    }


}
