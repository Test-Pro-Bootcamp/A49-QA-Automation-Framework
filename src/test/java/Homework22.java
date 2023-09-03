import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework22 extends BaseTest {


    @Test
    public void renamePlayList() {
        String newPlayList = "Homework22";

        String updatePLMsg = "Updated playlist \"Homework22.\"";

        LoginPage loginPage = new LoginPage(driver, wait, actions);
        HomePage homePage = new HomePage(driver,wait,actions);

        loginPage.loginCorrectCred();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlayListName(newPlayList);
        Assert.assertEquals(homePage.playListMessage(), updatePLMsg);

    }

}