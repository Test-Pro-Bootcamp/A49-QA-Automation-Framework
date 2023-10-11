/*
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;

public class FailedLoginTests extends BaseTest {
    LoginPage loginPage;
    @BeforeMethod
    public void setup(){
        loginPage = new LoginPage(getThreadDriver());
    }


    @Test
    public void invalidPasswordEmail() {
        loginPage.castEmail("spellFail").castPassword("notEnoughmana").castSubmit();
    }
    @Test
    public void emptyEmail(){
        loginPage.castEmail("").castPassword("Te$ter1234").castSubmit();
    }

}

*/
