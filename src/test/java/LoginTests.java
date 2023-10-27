/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import tests.BaseTest_threads;

import java.time.Duration;

public class LoginTests extends BaseTest_threads {
    static LoginPage loginPage = new LoginPage(getThreadLocal());

    @Test
    public static void loginEmptyEmailPasswordTest() {

        loginPage.castEmail("")
                .castPassword("Te$ter1234")
                .castSubmit();

        Assert.assertTrue(loginPage.getWizReg().isDisplayed());
    }

    @Test
    public static void loginWrongPasswordTest() {

        loginPage.castEmail("demo@class.com")
                .castPassword("te$t123")
                .castSubmit();

        Assert.assertTrue(loginPage.getWizReg().isDisplayed());
    }

    @Test
    public static void loginEmptyPasswordTest() {

        loginPage.castEmail("demo@class.com")
                .castPassword("")
                .castSubmit();

        Assert.assertTrue(loginPage.getWizReg().isDisplayed());
    }

    @Test
    public static void loginWrongEmailTest() {

        loginPage.castEmail("demo@class.com")
                .castPassword("te$t$tudent")
                .castSubmit();

        Assert.assertTrue(loginPage.getWizReg().isDisplayed());
    }

    @Test
    public void loginSucceedTest() {

        loginPage.successfulPortalTest();


    }
}*/
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

