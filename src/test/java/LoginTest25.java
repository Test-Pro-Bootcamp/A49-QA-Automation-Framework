import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest25 extends BaseTest {
    LoginPage loginPage;

    //@BeforeMethod
//void setup(){
    //loginPage = new LoginPage(driver);
    //driver.get(url);
//}
    @Test
    public void invalidEmailPassword() {
        loginPage = new LoginPage(driver);
        loginPage.provideEmail("incorrectEmail").providePassword("incorrectPwd").clickSubmit();
    }
    @Test
    public void emptyEmail() {
        loginPage = new LoginPage(driver);
        loginPage.provideEmail("").providePassword("incorrectPwd").clickSubmit();
    }
    @Test
    public void emptyEmailPassword() {
        loginPage = new LoginPage(driver);
        loginPage.provideEmail("").providePassword("").clickSubmit();
    }
//@AfterClass
    // public void closeBrowser(){
    // driver.quit();
}
//}
