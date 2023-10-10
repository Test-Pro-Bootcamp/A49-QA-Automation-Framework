import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    @Test

    public void addSongToPlaylist() throws InterruptedException {

        String expectedSongAddedMessage = "Added 1 song into\"Isisha Playlist.\"";

        navigateToPage();
        provideEmail("isisha.andrews@testpro.io");
        providePassword('test$tudent');
        clickSumit();
        long millis;
        Thread.sleep(millis:2000);
        Object clone = clone(name:"Ketsa");
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlaylist();
        Assert.assertEquals(getAddToPlaylistASuccessMsg(), expectedSongAddedMessage);
}

    private String getAddToPlaylistASuccessMsg() {
        return null;
    }

    private void choosePlaylist() {

    }

    private void clickAddToBtn() {

    }

    private void selectFirstSongResult() {
    }

    private void clickViewAllBtn() {
    }

    private void clickSumit() {

    }

    private void providePassword(char test$tudent) {
    }

    private void provideEmail(String mail) {
    }

    private void navigateToPage() {

    }
}