import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test(description = "Homework 18 - playSong")

    public void playSong() {

        logInWithRightCredentials();
        clickNextSongBtn();
        clickPlaySong();
        verifySongIsPlaying();




    }

}
