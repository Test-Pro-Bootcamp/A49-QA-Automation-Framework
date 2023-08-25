import org.testng.Assert;
import org.testng.annotations.Test;

public class practiceBeforeHM19 extends BaseTest {

    @Test (dataProvider = "IncorrectLoginData")
    public void loginInvalidCredentials(String email, String password) throws InterruptedException {
        navigateToPage();
        provideEmail(email);
        providePassword(password);
        clickSubmitButton();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test (dataProvider = "StaticIncorrectLoginData", dataProviderClass = BaseTest.class)
    public void loginInvalidCredentialsStatic(String email, String password) throws InterruptedException {
        navigateToPage();
        provideEmail(email);
        providePassword(password);
        clickSubmitButton();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test (dataProvider = "cvsData")
    public void loginInvalidCredentialsCSV(String email, String password) throws InterruptedException {
        navigateToPage();
        provideEmail(email);
        providePassword(password);
        clickSubmitButton();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginInvalidCredentialsOLD() throws InterruptedException {
        navigateToPage();
        provideEmail("invalidEmail@testpro.io");
        providePassword("invalidPassword");
        clickSubmitButton();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }



}
