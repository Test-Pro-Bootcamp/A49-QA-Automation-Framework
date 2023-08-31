import org.testng.annotations.Test;
public class Homework16 extends BaseTest {

    @Test
    public void registrationNavigation() {
        basepage.openLoginUrl(url);
        registrationPage.clickRegistrationBtn();
        registrationPage.checkUrl();
    }
}


