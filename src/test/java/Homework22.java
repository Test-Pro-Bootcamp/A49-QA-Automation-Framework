import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
public class Homework22 extends BaseTest{
    @Test
    public void renamePlaylist() throws InterruptedException{
        String oldName = "Vasyuki";
        String newName = "New " + oldName;
        String textBanner = "Updated playlist \"" + newName +".\"";

        HomePage homePage = new HomePage(theDriver);
        BasePage basePage = new BasePage(theDriver);
        loginWithValidCredential();
        homePage.createPlaylistAnotherWay(oldName);
        if (homePage.findPlaylist("Vasyuki")) {
            homePage.renameExistingPlaylist("Vasyuki", "New Vasyuki");
        } else {
            System.out.println("Playlist doesn't exist");
        }

        String result = basePage.showBanner(textBanner);


        Assert.assertEquals(result, textBanner);

    }

}
