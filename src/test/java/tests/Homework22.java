package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class Homework22 extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    public String myNewPlaylist = "My New Playlist";
    //public  String myNewPlaylist;
    public String newPlaylistTitle = "Updated " + myNewPlaylist;

    @BeforeClass
    void login(){
        loginPage = new LoginPage(driver);
        basePage = new BasePage(driver);
        homePage = new HomePage(driver);

        loginPage.loginToKoel();
    }

    @Test (priority = 1)
    public void loginIntoKoelPage2() {
        loginPage.provideEmail("alina.nikolaienko@testpro.io");
        loginPage.providePassword("OPJKDUhA");
        loginPage.clickSubmitButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".menu .home")));
        String homepageUrl = "https://qa.koel.app/#!/home";
        Assert.assertEquals(driver.getCurrentUrl(), homepageUrl);
    }

    @Test(priority = 2, description = "Create new playlist with specific name")
    public void createPlaylist() {
        homePage.createPlaylist(myNewPlaylist);
        String expectedMessage = "Created playlist \"" + myNewPlaylist + ".\"";
        Assert.assertEquals(homePage.verifyNotificationMessage(), expectedMessage);

        basePage.waitForInvisibilityOfNotificationMessage();
    }

    @Test(priority = 3, description = "Add few songs to newly created playlist with specific name")
    public void addSongsPlaylist() {
        String expectedMsgForSongAdded = "Added 1 song into \"" + myNewPlaylist + ".\"";

        homePage.searchForSong("Song");
        homePage.clickViewAllButton();
        homePage.findFirstSongInResults();
        homePage.clickAddToButton();
        homePage.addSongToMyNewPlaylist();
        Assert.assertEquals(homePage.verifyNotificationMessage(), expectedMsgForSongAdded);

        basePage.waitForInvisibilityOfNotificationMessage();
    }

    @Test(priority = 4, description = "Update title of created playlist")
    public void renamePlaylist() {
        homePage.doubleClickOnPlaylist();
        homePage.updatePlaylistTitle(newPlaylistTitle);
        String expectedMessage = "Updated playlist \"" + newPlaylistTitle + ".\"";
        Assert.assertEquals(homePage.verifyNotificationMessage(), expectedMessage);

        basePage.waitForInvisibilityOfNotificationMessage();
    }

    @Test(priority = 5, description = "Delete playlist with updated title")
    public void deletePlaylist() {
        homePage.deleteCreatedPlaylist();
        String expectedMessage = "Deleted playlist \"" + newPlaylistTitle + ".\"";
        Assert.assertEquals(homePage.verifyNotificationMessage(), expectedMessage);

        basePage.waitForInvisibilityOfNotificationMessage();
    }
}
