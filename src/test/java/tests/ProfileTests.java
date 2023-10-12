package tests;

import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;
public class ProfileTests extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    ProfilePage profilePage;
    BasePage basepage;

    @Test
    public void changeProfileName() {
        loginPage = new LoginPage(getThreadLocal());
        homePage = new HomePage(getThreadLocal());
        profilePage = new ProfilePage(getThreadLocal());
        basepage = new BasePage(getThreadLocal());
        String randomName = basepage.generateRandomName();

        loginPage.loginWithCorrectCred();
        homePage.waitForLoadingBarToDisappear()
                .clickAvatarIcon();
        profilePage.provideCurrentPassword("te$t$tudent")
                .provideProfileName(randomName)
                .clickSaveBtn()
                .verifyProfileUpdated();
    }
    @Test
    public void changeTheme(){
        loginPage = new LoginPage(getThreadLocal());
        homePage = new HomePage(getThreadLocal());
        profilePage = new ProfilePage(getThreadLocal());

        loginPage.loginWithCorrectCred();
        homePage.waitForLoadingBarToDisappear()
                .clickAvatarIcon();
        profilePage.provideCurrentPassword("te$t$tudent")
                   .selectTheme()
                   .clickSaveBtn()
                   .verifyProfileUpdated();
    }
}