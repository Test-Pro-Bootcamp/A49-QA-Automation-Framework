//import Pages.BasePage;
//import Pages.HomePage;
//import Pages.LoginPage;
//import Pages.ProfilePage;
//import org.testng.annotations.Test;
//public class ProfileTest extends BaseTest {
//    LoginPage loginPage;
//    HomePage homePage;
//    ProfilePage profilePage;
//    BasePage basepage;
//
//    @Test
//    public void changeProfileNameTest() throws InterruptedException {
//        loginPage = new LoginPage(driver);
//        homePage = new HomePage(driver);
//        profilePage = new ProfilePage(driver);
//        basepage = new BasePage(driver);
//        String randomName = basepage.generateRandomName();
//
//        loginPage.loginWithCorrectCred();
//        Thread.sleep(3000);
//        homePage.clickAvatarIcon();
//        profilePage.provideCurrentPassword("te$t$tudent")
//                   .provideProfileName(randomName)
//                   .clickSaveBtn()
//                   .verifyProfileUpdated();
//    }
//}