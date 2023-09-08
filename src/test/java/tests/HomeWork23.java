package tests;

import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork23 extends BaseTest {

    @Test
    public void renamePlaylist() {
        String newPlaylistName = "Natalia Gorbunova+";
        String updatedPlaylistMsg = "Updated playlist \"Natalia Gorbunova+.\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage (driver);

        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);

    }

}