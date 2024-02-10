import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.LoginPage;


public class LoginTests extends BaseTest{
    @Test
    public void validPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginCorrectCred();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public void validLoginPassword(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginCorrectCred();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}

