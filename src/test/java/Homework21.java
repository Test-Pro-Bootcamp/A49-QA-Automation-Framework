import com.github.dockerjava.api.command.RenameContainerCmd;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{

    @Test (description = "renamePlaylist")

    public void renamePlaylist () throws InterruptedException{

        logInWithRightCredentials();
        doubleClickPlaylist();
        enterNewPlaylistName();


    }

    private void enterNewPlaylistName() {
        WebElement enter = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]/nav/ul/li[1]"));
        enter.click();
        enter.clear();
        enter.sendKeys("newest");

            }



    private void doubleClickPlaylist() {
        WebElement doubleClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='playlist playlist']")));

        actions.contextClick(doubleClick).perform();




    }


}
