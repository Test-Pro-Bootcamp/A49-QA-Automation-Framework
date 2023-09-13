import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.SongsPage;

import java.util.List;

public class Homework23 extends BaseTest{
    @Test
    public void fillingPlaylist() throws InterruptedException{
        BasePage basePage = new BasePage(theDriver);
        String callPlaylist = "Lambs";
        String song = "HoliznaCC";
        String textBanner = "Added 1 song into \"Lambs.\"";


//        HomePage homePage = new HomePage(theDriver);
        SongsPage songsPage = new SongsPage(theDriver);

        loginWithValidCredential();
        //homePage.createPlaylistAnotherWay("Lambs");
        songsPage.addSongToPlaylist("Lambs", "HoliznaCC");


        String result = basePage.showBanner(textBanner);


        Assert.assertEquals(result, textBanner);

    }

}

