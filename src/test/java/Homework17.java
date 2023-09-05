import org.testng.annotations.Test;

import pages.LoginPage;
import pages.PlaylistPage;

public class Homework17 extends BaseTest {
        @Test (description = "Homework 17 -  addSongToPlaylist")

        public void addSongToPlaylist() {
                LoginPage loginPage = new LoginPage(driver);
                PlaylistPage playlistPage = new PlaylistPage(driver);

                loginPage.logInWithRightCredentials();
                playlistPage.enterSongIntoSearchField()
                            .clickViewAllBtn()
                            .clickSongTitle()
                            .clickAddToBtn()
                            .enterPlaylistName()
                            .clickSaveBtn();






}


}



