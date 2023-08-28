import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
            public void loginValid(){
        
        navigateToPage();
        provideEmail("natalia.kim01@testpro.io");
        providePassword("AxKrdBnS");
        clickSubmit();

    }


}
