import org.testng.annotations.Test;
import pages.AlbumPage;
import pages.ArtistsPage;
import pages.LoginPage;

public class ArtistsTest extends BaseTest{
    @Test
    public void clickArtistsPage(){
        ArtistsPage art = new ArtistsPage(driver);
        LoginPage log = new LoginPage(driver);
        log.loginValidEmailPass();
        art.clickArtists();
        art.checkIfTitleIsVisible();
        art.clickRigthBtnPlay();
        art.clickPlayAll();





    }
}
