import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest{
    @Test
    public void updateUsername() throws InterruptedException {
        
        loginToKoel();
        clickAvatarIcon();

        /*
        public void loginToKoel() {
            navigateToPage();
            provideEmail("demo@testpro.io");
            providePassword("te$t$tudent");
            clickSubmitButton();
        }
        */

        Thread.sleep(2000);

        provideCurrentPassword("te$t$tudent");

        String randomName = RandomStringUtils.randomAlphabetic(8);
        provideProfileName(randomName);
        clickSaveButton();

        Thread.sleep(2000);

        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(), randomName);



    }

    public void clickAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }


    public void provideCurrentPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        //WebElement passwordField = driver.findElement(By.xpath("//input[@id='inputProfileCurrentPassword']"));
        //WebElement passwordField = driver.findElement(By.cssSelector("[name = 'current_password']"));
        //WebElement passwordField = driver.findElement(By.cssSelector("input[id = 'inputProfileCurrentPassword']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    private void provideProfileName(String randomName) {
        WebElement profileName = driver.findElement(By.cssSelector("[name='name]"));
        profileName.clear();
        profileName.sendKeys(randomName);

    }


    private void clickSaveButton() {
        WebElement saveButton = driver.findElement(By.cssSelector(".btn-submit"));
        saveButton.click();
    }


}
