import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework18 extends BaseTest {
    @Test(description = "Homework 18 - playSong")

    public void playSong()  {

        LoginPage.logInWithRightCredentials();
        HomePage.clickNextSongBtn();
        HomePage.clickPlaySong();
        HomePage.verifySongIsPlaying();




    }

}
