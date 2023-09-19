package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest_threads{
    //LoginPage loginPage;
    //WebDriverWait wait = new WebDriverWait(getThreadLocal(), Duration.ofSeconds(5));;



    @Test
    public void validEmailValidPassword()  {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        //getThreadLocal().get(url);
        loginPage.loginToKoel();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".view-profile")));
    }
}
