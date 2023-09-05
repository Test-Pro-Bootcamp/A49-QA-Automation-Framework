import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework20 extends BaseTest {
    @Test(description = "Homework 20 -  implementExplicitWaits")

    public void deletePlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.logInWithRightCredentials();
        homePage.clickPlaylist()
                .clickDeletePlaylist()
                .clickOKPopUP();







    }

}
