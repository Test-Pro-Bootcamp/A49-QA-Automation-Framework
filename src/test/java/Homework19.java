import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deleteScrolllist() throws InterruptedException{
        String expectedBanishmentMessage = "Deleted playlist \"First in first out.\"";
        String expectedSummonTitle = "Created playlist \"First in first out.\"";

        openPortal();
        castEmail("dirzo@gmail.com");
        castPassword("Te$ter1234");
        castSubmit();
        Thread.sleep(1500);
        createScroll("First in first out");
        summonScroll();
        Assert.assertEquals(getSummonresult(), expectedSummonTitle);
        Thread.sleep(5000);
        banishScroll();
        Assert.assertEquals(getBanishmentResult(), expectedBanishmentMessage);

    }

    private String getSummonresult() {
        WebElement spellSummon = driver.findElement(By.cssSelector("div.success.show"));
        return spellSummon.getText();
    }

    public void createScroll(String spell) throws InterruptedException {
        WebElement newScroll = driver.findElement(By.xpath("//i[@title='Create a new playlist']"));
        newScroll.click();
        Thread.sleep(1500);
        WebElement nameScroll = driver.findElement(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']"));
        nameScroll.click();
        Thread.sleep(2000);
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
        Thread.sleep(1500);
    }
    public String getBanishmentResult(){
        WebElement spellBanish = driver.findElement(By.cssSelector("div.success.show"));
        return spellBanish.getText();
    }

}
