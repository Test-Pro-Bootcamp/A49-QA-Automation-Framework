import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void setup(){
    loginPage = new LoginPage(getDriver());
    driver.get(url);
}
    @Test
    public void invalidEmailPassword() {
        loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("incorrectEmail").providePassword("incorrectPwd").clickSubmit();
    }
  //  @Test
   // public void emptyEmail() {
     //   loginPage = new LoginPage(getDriver());
      //  loginPage.provideEmail("").providePassword("incorrectPwd").clickSubmit();
   // }
   // @Test
    //public void emptyEmailPassword() {
      //  loginPage = new LoginPage(getDriver());
       // loginPage.provideEmail("").providePassword("").clickSubmit();
   // }
    @AfterMethod
    public void closeBrowser() {
        treadDriver.get().close();
        treadDriver.remove();
}
}
