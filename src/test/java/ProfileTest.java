import org.testng.annotations.Test;
public class ProfileTest extends BaseTest {
    @Test
    public void changeProfileNameTest() {

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
