import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void loginValidEmailPassword() {
        loginWithCorrectCredentials();

    }

}
