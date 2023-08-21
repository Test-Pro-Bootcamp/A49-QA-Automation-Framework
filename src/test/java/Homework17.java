import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String textBanner = "Added 1 song into \"first playlist.\"";

        enterEmail("anna.dudnik@testpro.io");
        enterPassword("GulyalaKorova4milk!");
        clickLogin();
        Thread.sleep(1000);
        //clearMyPlaylist();
        Thread.sleep(1000);
        searchSong("dark");
        Thread.sleep(1000);
        clickViewAll();
        Thread.sleep(1000);
        clickSong();
        Thread.sleep(1000);
        clickAddTo();
        Thread.sleep(1000);
        clickPlaylist();
        Thread.sleep(500);

        Assert.assertEquals(showBanner(), textBanner);

    }
}
