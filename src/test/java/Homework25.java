import org.testng.annotations.Test;
import pages.LoginPage;

public class Homework25 extends BaseTest {
    @Test
            public void loginValid(){
    LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("natalia.kim01@testpro.io");
        loginPage.providePassword("WyYVUKJl2j5v");
        loginPage.clickSubmit();
    }

    @Test
    public void loginInvalidEmail(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("invalid@mail.io");
        loginPage.providePassword("WyYVUKJl2j5v");
        loginPage.clickSubmit();
    }

}