/*
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

        loginPage.successfulPortalTest();
        try {
            createScroll("First in first out");
            summonScroll();
            Assert.assertEquals(getSummonresult(), expectedSummonTitle);
        }
        catch (Exception e){
            System.out.println("An error occurred during playlist creation: " + e.getMessage());
            createScroll("First in first out");
        }

        banishScroll();
        Assert.assertEquals(getBanishmentResult(), expectedBanishmentMessage);

    }

    private String getSummonresult() {
        WebElement spellSummon = driver.findElement(By.cssSelector("div.success.show"));
        return spellSummon.getText();
    }

    public void createScroll(String spell) {

        WebElement newScroll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sidebar-create-playlist-btn']")));
        newScroll.click();
        WebElement nameScroll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
        nameScroll.click();
        WebElement scrollName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
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
        WebElement spellBanish = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Deleted playlist')]")));
        return spellBanish.getText();
    }

}
*/
