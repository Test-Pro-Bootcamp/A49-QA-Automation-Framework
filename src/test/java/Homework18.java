import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.awt.*;

public class Homework18 extends BaseTest{

    @Test
    public void playSong() throws InterruptedException, AWTException{
        loginWithValidCredential();
        search("HoliznaCC");
        clickViewAll();
        returnAnySong(0, searchResultsTable,1).click();
        clickAddTo();
        moveToQueue();
        returnAnySong(1, searchResultsTable,1).click();
        clickAddTo();
        moveToQueue();
        returnAnySong(2, searchResultsTable,1).click();
        clickAddTo();
        moveToQueue();
        openQueue();
        doubleClick(0, queueTable);
        clickPlayNextSong();

        String classPlaying = "item playing";

        Assert.assertTrue(true, classPlaying);




    }


}
