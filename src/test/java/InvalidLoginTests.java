import Pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InvalidLoginTests extends BaseTest {
    LoginPage loginPage;
    @BeforeMethod
    void setup(){
        loginPage = new LoginPage(driver);
        driver.get(url);
    }
    @Test
    public void invalidPasswordEmail(){
        loginPage.provideEmail("incorrectEmail")
                 .providePassword("incorrectPassword")
                 .clickSubmit();
    }
    @Test
    public void emptyEmail(){
        loginPage.provideEmail("")
                 .providePassword("incorrectPassword")
                 .clickSubmit();
    }
    @Test
    public void emptyEmailPassword(){
        loginPage.provideEmail("")
                 .providePassword("")
                 .clickSubmit();
    }
}