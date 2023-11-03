package tests;

import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class HomeWork24 extends BaseTest {

    // Generate a unique playlist name
    private String generateUniquePlaylistName() {
        String uniqueId = UUID.randomUUID().toString();
        return "Playlist_" + uniqueId;
    }

    @Test
    public void renamePlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();

        // Generate a unique playlist name
        String newPlaylistName = generateUniquePlaylistName();
        String updatedPlaylistMsg = "Updated playlist \"" + newPlaylistName + ".\"";

        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);
    }
}
