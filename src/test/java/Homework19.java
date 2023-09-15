import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {


@Test
public void deletePlaylist() throws InterruptedException {

    String expectedPlaylistDeletedMessage = "Deleted playlist \"Test music.\"";
    provideEmail("eric.stetson@testpro.io");
    providePassword("Testpro@2023");
    clickSubmit();
    openPlaylist();
    clickDeletePlaylistBtn();
    Assert.assertEquals(getDeletedPlaylistMsg(), expectedPlaylistDeletedMessage);

}


    public void openPlaylist() {
    WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
    emptyPlaylist.click();

}

public void  clickDeletePlaylistBtn() throws InterruptedException {
    WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
    deletePlaylist.click();


}
public String getDeletedPlaylistMsg() {
    WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
    return notificationMsg.getText();
}







}