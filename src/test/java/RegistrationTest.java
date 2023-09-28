import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest {
    RegistrationPage registrationPage;
    @BeforeMethod
    void setupClass() {
        registrationPage = new RegistrationPage(theDriver);
        theDriver.get(baseUrl);
    }


    @Test
    public void registration() {
        registrationPage.registrationNavigation();
    }


}
