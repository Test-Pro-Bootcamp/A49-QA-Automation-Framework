import Pages.RegistrationPage;
import org.testng.annotations.Test;
public class Homework16 extends BaseTest {
    RegistrationPage registrationPage;
    @Test
    public void registrationNavigation() {
        registrationPage = new RegistrationPage(driver);

        basepage.openLoginUrl(url);
        registrationPage.clickRegistrationBtn()
                        .checkUrl();
    }
}


