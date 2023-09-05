import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PlaylistPage;

public class Homework17 extends BaseTest {
        @Test (description = "Homework 17 -  addSongToPlaylist")

        public void addSongToPlaylist() {

                LoginPage.logInWithRightCredentials();
                PlaylistPage.enterSongIntoSearchField();
                PlaylistPage.clickViewAllBtn();
                PlaylistPage.clickSongTitle();
                PlaylistPage.clickAddToBtn();
                PlaylistPage.enterPlaylistName();
                PlaylistPage.clickSaveBtn();






}


}



