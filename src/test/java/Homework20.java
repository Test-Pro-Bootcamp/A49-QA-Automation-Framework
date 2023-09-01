import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework20 extends BaseTest {
    @Test(description = "Homework 20 -  implementExplicitWaits")

    public void deletePlaylist() {

        LoginPage.logInWithRightCredentials();
        HomePage.clickPlaylist();
        HomePage.clickDeletePlaylist();
        HomePage.clickOKPopUP();







    }

}
