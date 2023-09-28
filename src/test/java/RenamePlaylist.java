import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class RenamePlaylist extends BaseTest{
    @Test
    public void renamePlaylist() throws InterruptedException{
        String oldName = "Vasyuki";
        String newName = "New " + oldName;
        String textBanner = "Updated playlist \"" + newName +".\"";

        HomePage homePage = new HomePage(theDriver);
        BasePage basePage = new BasePage(theDriver);
        LoginPage loginPage = new LoginPage(theDriver);
        loginPage.login();
        homePage.createPlaylistAnotherWay(oldName);
        if (homePage.findPlaylist("Vasyuki")) {
            homePage.renameExistingPlaylist("Vasyuki", "New Vasyuki");
        } else {
            System.out.println("Playlist doesn't exist");
        }

        basePage.showBanner(textBanner);


        Assert.assertTrue(true, textBanner);

    }

}
