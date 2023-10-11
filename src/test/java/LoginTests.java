import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public static void loginEmptyEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadDriver());

        loginPage.castEmail("")
                .castPassword("Te$ter1234")
                .castSubmit();

        Assert.assertTrue(loginPage.getWizReg().isDisplayed());
    }

    @Test
    public static void loginWrongPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadDriver());

        loginPage.castEmail("demo@class.com")
                .castPassword("te$t123")
                .castSubmit();

        Assert.assertTrue(loginPage.getWizReg().isDisplayed());
    }

    @Test
    public static void loginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadDriver());

        loginPage.castEmail("demo@class.com")
                .castPassword("")
                .castSubmit();

        Assert.assertTrue(loginPage.getWizReg().isDisplayed());
    }

    @Test
    public static void loginWrongEmailTest() {
        LoginPage loginPage = new LoginPage(getThreadDriver());

        loginPage.castEmail("demo@class.com")
                .castPassword("te$t$tudent")
                .castSubmit();

        Assert.assertTrue(loginPage.getWizReg().isDisplayed());
    }

    @Test
    public void loginSucceedTest() {
        LoginPage loginPage = new LoginPage(getThreadDriver());
        HomePage homePage = new HomePage(getThreadDriver());

        loginPage.successfulPortalTest();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}
/*import org.testng.Assert;
        import org.testng.annotations.Test;

        import pages.HomePage;
        import pages.LoginPage;


    LoginPage loginPage;
    @BeforeMethod
    public void setup(){
        loginPage = new LoginPage(getThreadDriver());
        getThreadDriver().get(url);
    }

    @Test
    public void loginValidEmailPassword() {
        loginPage.successfulPortalTest();
    }
    @Test
    public void castPortal() {
        loginPage.successfulPortalTest();
    }

}*/

