import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework22 extends BaseTest{

    @Test
    public void castRename(){
        String newScrollName ="Sword Dancer Battle Music";
        String updatedScrollMsg = "Updated playlist \"Sword Dancer Battle Music.\"";

        LoginPage loginPage = new LoginPage(driver, wait, actions);
        HomePage homePage = new HomePage(driver, wait, actions);

        loginPage.SuccessfulPortalTest();
        homePage.doubleClickScrolllist();
        homePage.castRenameScroll(newScrollName);
        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), updatedScrollMsg);

    }

}
