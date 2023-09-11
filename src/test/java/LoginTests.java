import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
public class LoginTests extends BaseTest {
    LoginPage loginPage;
    @BeforeMethod
    void setup() {
        loginPage = new LoginPage(driver);
        driver.get(url);
    }
    @Test
    public void validLogin() {
        WebElement loginInput = driver.findElement(By.cssSelector("[type='email']"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("xu_moua@hotmail.com");
//      AND I Enter valid password
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("TestStudent!1");
//      AND I click Log in
        WebElement loginBtn = driver.findElement(By.cssSelector("[type='submit']"));
        loginBtn.click();
//      THEN Avatar is Displayed
        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());
//        loginPage.loginCorrectCred();
//        WebElement avatar = driver.findElement(By.cssSelector("[class='music']"));
//        Assert.assertTrue(avatar.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "www.qa.qoel.app/#!/");
    }
    @Test
    public void invalidPasswordEmail() {
        loginPage.provideEmail("incorrectEmail")
                .providePassword("incotrerctPwd")
                .clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public void emptyEmail() {
        loginPage.provideEmail("")
                .providePassword("incotrerctPwd")
                .clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public void emptyEmailPassword() {
        loginPage.provideEmail("")
                .providePassword("")
                .clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);



    }
}