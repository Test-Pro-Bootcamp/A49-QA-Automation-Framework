import org.testng.annotations.Test;

public class Homework17 extends BaseTest {




        @Test (description = "Homework 17 -  addSongToPlaylist")

        public void addSongToPlaylist() {

                logInWithRightCredentials();
                enterSongIntoSearchField();
                clickViewAllBtn();
                clickSongTitle();
                clickAddToBtn();
                enterPlaylistName();
                clickSaveBtn();
                verifySuccessMessage();





}


}



