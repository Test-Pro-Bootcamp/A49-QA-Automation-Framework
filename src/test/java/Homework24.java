import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;

public class Homework24 extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void login() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.loginWithCorrectCred();
        homePage.avatarImgIsDisplayed();
    }

}
