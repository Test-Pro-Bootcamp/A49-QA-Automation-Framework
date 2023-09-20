import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework22 extends BaseTest{

    @Test
    public void castRename(){
        String newScrollName ="Sword Battle Music";
        String updatedScrollMsg = "Updated playlist \"Sword Battle Music.\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.successfulPortalTest();
        homePage.doubleClickScrolllist();
        homePage.castRenameScroll(newScrollName);
        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), updatedScrollMsg);

    }

}
