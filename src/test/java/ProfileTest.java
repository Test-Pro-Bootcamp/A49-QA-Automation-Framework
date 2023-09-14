import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.testng.annotations.Test;
public class ProfileTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    ProfilePage profilePage;
    BasePage basepage;

    @Test
    public void changeProfileNameTest() throws InterruptedException {
        loginPage = new LoginPage(getThreadLocal());
        homePage = new HomePage(getThreadLocal());
        profilePage = new ProfilePage(getThreadLocal());
        basepage = new BasePage(getThreadLocal());
        String randomName = basepage.generateRandomName();

        loginPage.loginWithCorrectCred();
        homePage.waitForLoadingBarToDisappear();
        homePage.clickAvatarIcon();
        profilePage.provideCurrentPassword("te$t$tudent")
                   .provideProfileName(randomName)
                   .clickSaveBtn()
                   .verifyProfileUpdated();
    }
}