import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlbumPage;
import pages.LoginPage;

public class AlbumTest extends BaseTest{
    @Test
    public void clickAlbumPage(){
        AlbumPage al = new AlbumPage(driver);
        LoginPage log = new LoginPage(driver);
        log.loginValidEmailPass();
        al.clickAlbums();
        al.checkIfTitleIsVisible();
        al.clickRigthBtnPlay();
        al.clickPlayAll();
    }

}
