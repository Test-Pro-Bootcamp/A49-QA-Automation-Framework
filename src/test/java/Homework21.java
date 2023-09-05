import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework21 extends BaseTest{
    @Test (description = "renamePlaylist")

    public void renamePlaylist () throws InterruptedException{

        LoginPage.logInWithRightCredentials();
        HomePage.doubleClickPlaylist();
        HomePage.enterNewPlaylistName();



    }


}
