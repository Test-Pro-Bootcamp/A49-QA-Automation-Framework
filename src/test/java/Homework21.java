import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework21 extends BaseTest{
    @Test (description = "renamePlaylist")

    public void renamePlaylist () throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.logInWithRightCredentials();
        homePage.doubleClickPlaylist()
                .enterNewPlaylistName();



    }


}
