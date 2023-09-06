package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork22  {

    @Test
    public void renamePlaylist() {
        String newPlaylistName = "Natalia Gorbunova+";
        String updatedPlaylistMsg = "Updated playlist \"Natalia Gorbunova+.\"";

        WebDriver driver = null;
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage (driver);

        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);

    }

}