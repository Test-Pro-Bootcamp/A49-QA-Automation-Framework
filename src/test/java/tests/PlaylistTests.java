package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;

public class PlaylistTests extends BaseTest{

        LoginPage loginPage = new LoginPage(getThreadDriver());
        HomePage homePage = new HomePage(getThreadDriver());
        PlaylistPage playlistPage = new PlaylistPage(getThreadDriver());
        BasePage basePage = new BasePage(getThreadDriver());
        String scrollListName;

        @BeforeClass
        void login(){
        loginPage = new LoginPage(getThreadDriver());
        playlistPage = new PlaylistPage(getThreadDriver());
        loginPage.successfulPortalTest();
        scrollListName ="Crios Scrolls" +basePage.castRandomName();
    }

    @Test(priority = 1)
    public void createScrolllist() {
        playlistPage.summonScroll()
                    .castNewScroll()
                    .castNameScroll(scrollListName);
        basePage.checkSpellSuccess();
    }
    @Test(priority = 2)
    public void renameScrolllist() {
        playlistPage.doubleClickOnScroll(scrollListName);
        scrollListName ="Updated"+ scrollListName;
        playlistPage.castNameScroll(scrollListName)
                    .checkSpellMessage(scrollListName);
    }
    @Test(priority = 3)
    public void banishPlaylist() {
        playlistPage.selectScroll(scrollListName).castBanishScroll();
        basePage.checkSpellSuccess();
    }
}
