package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork22 extends BaseTest {

    @Test

    public void renamePlaylist() {
        String newPlaylistName = "Natalia Gorbunova";
        String updatedPlaylistMsg = "Updated playlist \"Natalia Gorbunova.\"";

        LoginPage loginPage = new LoginPage (BaseTest.driver);
        HomePage homePage = new HomePage (BaseTest.driver);

        loginPage.login();
        homePage.doubleClickPlayList();
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);

    }

}
