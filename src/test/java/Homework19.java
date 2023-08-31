import org.testng.annotations.Test;
public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() {
        loginPage.loginWithCorrectCred();
        playlistPage.clickAddPlaylist();
        playlistPage.selectNewOption();
        String randomName = homePage.generateRandomName();
        playlistPage.newPlaylist(randomName);
        homePage.selectNewRandomPlaylist();
        homePage.clickDeleteBtn();
        homePage.verifyStringName();
    }
}