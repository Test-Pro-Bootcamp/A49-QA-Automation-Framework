/*
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;

public class Homework22 extends BaseTest{

    @Test
    public void castRename(){
        String scrollName ="Sword";
        String newScrollName ="Sword Battle Music";
        String updatedScrollMsg = "Updated playlist \"Sword Battle Music.\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        PlaylistPage playListpage = new PlaylistPage(driver);

        loginPage.successfulPortalTest();
        playListpage.doubleClickOnScroll(scrollName)
                    .castNameScroll(newScrollName);
        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), updatedScrollMsg);

    }

}
*/
