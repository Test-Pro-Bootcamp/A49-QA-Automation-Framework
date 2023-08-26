import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test(description = "Homework 19 -  deletePlaylist")

    public void deletePlaylist() {

        logInWithRightCredentials();
        clickPlaylist();
        clickDeletePlaylist();
        clickOKPopUP();
        verifySuccessMessage();




    }

}
