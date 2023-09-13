import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Logintest1 extends BaseTest {

    @Test
    public void loginValideEmailPassword() {
        LoginPage page = new LoginPage(driver);
        page.setEmail("momo.carlos5@gmail.com");
        page.setPassword("te$t$tudent");
        page.clickLogin();

    }

}
