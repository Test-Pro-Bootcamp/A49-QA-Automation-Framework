import com.github.dockerjava.api.command.RenameContainerCmd;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{

    @Test (description = "renamePlaylist")

    public void renamePlaylist () throws InterruptedException{

        logInWithRightCredentials();
        doubleClickPlaylist();
        enterNewPlaylistName();
        verifySuccessMessage();


    }

    private void enterNewPlaylistName() {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL + "a", Keys.BACK_SPACE));
        playlistInputField.sendKeys("Newest Playlist");
        playlistInputField.sendKeys(Keys.ENTER);

            }



    private void doubleClickPlaylist() {
        WebElement doubleClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='playlist playlist']")));

        actions.doubleClick(doubleClick).perform();




    }


}
