//import org.testng.Assert;
//import org.testng.annotations.Test;
//import pages.HomePage;
//
//import java.awt.*;
//
//public class Homework21 extends BaseTest{
//    @Test
//    public void renamePlaylist() throws InterruptedException {
//        String oldName = "Vasyuki";
//        String newName = "New " + oldName;
//        String textBanner = ("Updated playlist " + newName +".");
//
//        HomePage homePage = new HomePage(theDriver);
//        loginWithValidCredential();
//        homePage.renameExistingPlaylist("Vasyuki", "NewVasyuki");
//
//        String result = homePage.showBanner(textBanner);
//
//        Assert.assertTrue(result.equals(textBanner));
//
//
//    }
//}
