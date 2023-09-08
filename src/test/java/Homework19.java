import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework19 extends BaseTest {
    @Test(description = "Homework 19 -  deletePlaylist")

    public void deletePlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);


        loginPage.logInWithRightCredentials();
        homePage.clickPlaylist()
                .clickDeletePlaylist()
                .clickOKPopUP();
    }
}
