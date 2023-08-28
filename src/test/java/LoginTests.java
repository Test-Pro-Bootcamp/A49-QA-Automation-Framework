import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {
        navigateToPage();
        provideEmail("merry.lordlie@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
    }
}
