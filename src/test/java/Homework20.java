
import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.testng.Assert;
        import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedPlaylistDeleteMessage = "Deleted playlist \"Isisha Playlist.\"";

        provideEmail("isisha.andrews@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        public void openPlaylist; openPlaylist();
        clickDeletePlaylistsBtn();
        public String getDeletedPlaylistMsg Assert.assertEquals(getDeletedPlaylistMsg(), expectedPlaylistDeleteMessage);

        By driver;
        {
            WebElement emptyPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".playlist:nthchild(3)")));
            emptyPlaylist.click();
        }
        public void clickDeletePlaylistBtn () throws InterruptedException {
            WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".btn-delete-playlist")));
            deletePlaylist.click();

        }

        () {
            WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("div.success.show")));
            return notificationMsg.getText();

        }
    }

    private byte[] getDeletedPlaylistMsg() {
        return new byte[0];
    }

    private void openPlaylist() {
    }

    private void clickDeletePlaylistsBtn() {