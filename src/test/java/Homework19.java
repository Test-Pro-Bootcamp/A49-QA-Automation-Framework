import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework19 extends BaseTest {
    @Test(description = "Homework 19 -  deletePlaylist")

    public void deletePlaylist() {

        LoginPage.logInWithRightCredentials();
        HomePage.clickPlaylist();
        HomePage.clickDeletePlaylist();
        HomePage.clickOKPopUP();





    }

}
