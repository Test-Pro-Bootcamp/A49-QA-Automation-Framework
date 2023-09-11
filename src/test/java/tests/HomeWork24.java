package tests;

import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork24 extends BaseTest {


    @Test
    public void renamePlaylist() {
        String newPlaylistName = "Natalia Gorbunova24+";
        String updatedPlaylistMsg = "Updated playlist \"Natalia Gorbunova24+.\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage (driver);

        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);

    }

}