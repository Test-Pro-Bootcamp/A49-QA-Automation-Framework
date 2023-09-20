import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PlaylistPage;

public class PlaylistTests extends BaseTest{

    LoginPage loginPage;
    PlaylistPage playlistPage;
    public String scrollListName;

    @BeforeClass
    void login(){
        loginPage = new LoginPage(driver);
        playlistPage = new PlaylistPage(driver);
        loginPage.successfulPortalTest();
        scrollListName ="Crios Scrolls" +basePage.castRandomName();
    }
    @Test(priority = 1)
    public void createScrolllist() {
        playlistPage.summonScroll()
                    .castNewScroll()
                    .castNameScroll(scrollListName);
        basePage.checkSpellSuccess();
    }
    @Test(priority = 2)
    public void renameScrolllist() {
        playlistPage.doubleClickOnScroll(scrollListName);
        scrollListName ="Updated"+ scrollListName;
        playlistPage.castNameScroll(scrollListName)
                    .checkSpellMessage(scrollListName);
    }
    @Test(priority = 3)
    public void banishPlaylist() {
        playlistPage.selectScroll(scrollListName).castBanishScroll();
        basePage.checkSpellSuccess();
    }
}
