import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.SearchPage;
import pages.SongsPage;

import java.awt.*;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist() {
        BasePage basePage = new BasePage(theDriver);
        LoginPage loginPage = new LoginPage(theDriver);
        SongsPage songsPage = new SongsPage(theDriver);
        SearchPage searchPage = new SearchPage(theDriver);
        String callPlaylist = "test";
        String song = "HoliznaCC";
        String textBanner = "Added 1 song into \"" + callPlaylist + "\".";
        loginPage.login();
        searchPage.playlistCheckSearch(callPlaylist, song);
        basePage.search(song);
        songsPage.clickViewAll();
        searchPage.returnSearchSong(3, 1).click();
        searchPage.clickAddToSearch().clickPlaylist("test");

        basePage.showBanner(textBanner);

        Assert.assertTrue(true, textBanner);

    }


}
