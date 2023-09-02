import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deleteScrolllist() throws InterruptedException{
        String expectedBanishmentMessage = "Deleted playlist \"First in first out.\"";
        String expectedSummonTitle = "Created playlist \"First in first out.\"";

        castPortal();
        createScroll("First in first out");
        summonScroll();
        //Assert.assertEquals(getSummonresult(), expectedSummonTitle);
        banishScroll();
        Assert.assertEquals(getBanishmentResult(), expectedBanishmentMessage);

    }

    private String getSummonresult() {
        WebElement spellSummon = driver.findElement(By.cssSelector("div.success.show"));
        return spellSummon.getText();
    }

    public void createScroll(String spell) throws InterruptedException {
        WebElement neScroll = driver.findElement(By.xpath("//i[@title='Create a new playlist']"));
        neScroll.click();
        WebElement newScroll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@title='Create a new playlist']")));
        newScroll.click();
        WebElement nameScroll = driver.findElement(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']"));
        nameScroll.click();
        WebElement scrollName = driver.findElement(By.cssSelector("input[name='name']"));
        scrollName.click();
        scrollName.sendKeys(spell);
        scrollName.sendKeys(Keys.RETURN);
    }
    public void summonScroll() {
        WebElement openScroll = driver.findElement(By.cssSelector("a[class='active']"));
        openScroll.click();
    }
    public void banishScroll() throws InterruptedException{
        WebElement banishSpell = driver.findElement(By.cssSelector("button[title='Delete this playlist']"));
        banishSpell.click();
    }
    public String getBanishmentResult(){
        WebElement spellBanish = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return spellBanish.getText();
    }

}
