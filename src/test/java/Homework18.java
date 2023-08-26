import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test(description = "Homework 17 -  addSongToPlaylist")

    public void playSong() {

        logInWithRightCredentials();
        clickNextSongBtn();
        clickPlaySong();
        verifySongIsPlaying();
        



    }

}
