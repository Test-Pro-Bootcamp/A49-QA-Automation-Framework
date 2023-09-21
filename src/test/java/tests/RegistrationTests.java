package tests;

import org.testng.annotations.Test;
import pageObjects.RegistrationPage;

public class RegistrationTests extends BaseTest {
    RegistrationPage registrationPage;
    @Test
    public void registrationNavigation() {
        registrationPage = new RegistrationPage(getThreadLocal());

        registrationPage.clickRegistrationBtn()
                        .checkUrl();
    }
}
