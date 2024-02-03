import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.LoginPage;

public class InvalidLoginTests extends BaseTest{
    LoginPage loginPage;
    @BeforeMethod
    void setup(){
        loginPage= new LoginPage(getThreadDriver());
        getThreadDriver().get(url);
    }
    @Test
    public void invalidPassword() {
        loginPage.provideEmail("incorrectEmail")
                .providePassword("incotrerctPwd")
                .clickSubmit();
    }
    @Test
    public void emptyPassword(){
        loginPage.provideEmail("dagebeyehu@gmail.com")
                .providePassword("")
                .clickSubmit();
    }
    @Test
    public void emptyEmailPassword(){
        loginPage.provideEmail("")
                .providePassword("")
                .clickSubmit();
    }
}
