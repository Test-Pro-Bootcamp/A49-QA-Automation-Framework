import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.testng.annotations.Test;
public class ProfileTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    ProfilePage profilePage;
    @Test
    public void changeProfileNameTest() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        profilePage = new ProfilePage(driver);

        homePage.openLoginUrl(url);
        loginPage.loginWithCorrectCred();
        homePage.clickAvatarIcon();
        profilePage.provideCurrentPassword("te$t$tudent");
        String randomName = basepage.generateRandomName();
        profilePage.provideProfileName(randomName);
        profilePage.clickSaveBtn();
        profilePage.verifyProfileUpdated();
    }
}
