package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class FailedLoginTest extends BaseTest_threads {
    LoginPage loginPage = new LoginPage(getThreadLocal());

    @Test
    public void validEmailNoPassword() {
        loginPage.castEmail("dirzo@gmail.com")
                .castPassword("")
                .castSubmit();
    }
    @Test
    public void noEmailValidPassword() {
        loginPage.castEmail("")
                .castPassword("Te$ter1234")
                .castSubmit();
    }
    @Test
    public void invalidEmailInvalidPassword() {
        loginPage.castEmail("dir@gmail.com")
                .castPassword("Te$tr1234")
                .castSubmit();
    }
    @Test
    public void noEmailNoPassword() {
        loginPage.castEmail("")
                .castPassword("")
                .castSubmit();
    }
}


