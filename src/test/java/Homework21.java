import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {


    String newScrollName ="Sword Dancer Playlist";

    @Test
    public void renameScroll() {

        String updatedScrollMsg = "Updated playlist \"Sword Dancer Playlist.\"";
        loginPage.successfulPortalTest();
        castRename();
        //Assert.assertEquals(getRenamedScrollAch(), updatedScrollMsg);



    }

    public void castRename() {
        WebElement nameTarget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[id='playlists'] li:nth-child(3)")));
        actions.doubleClick(nameTarget).perform();
        WebElement spellTarget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        spellTarget.sendKeys(Keys.chord(Keys.LEFT_CONTROL,"A", Keys.BACK_SPACE));
        spellTarget.sendKeys(newScrollName);
        spellTarget.sendKeys(Keys.RETURN);
    }

    public String getRenamedScrollAch() {
        WebElement achievement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return achievement.getText();
    }

}
