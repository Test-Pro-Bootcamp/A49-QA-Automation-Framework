import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.LoginPage;

public class LoginTests extends BaseTest{
    LoginPage loginPage;
    @BeforeMethod
    void setup(){
        loginPage= new LoginPage(getThreadDriver());
        getThreadDriver().get(url);
    }
    @Test
    public void validLoginPassword(){
        loginPage.loginCorrectCred();
    }
}
