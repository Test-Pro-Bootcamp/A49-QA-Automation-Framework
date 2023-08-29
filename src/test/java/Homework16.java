import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class Homework16 extends BaseTest {

    @Test
    public void registrationNavigation(){

        WebElement registrationButton = theDriver.findElement(new By.ByXPath("//*[@href='registration']"));
        registrationButton.click();

        String expectedUrl = "https://qa.koel.app/registration";
        //String actualUrl = theDriver.getCurrentUrl();

        Assert.assertTrue(true, expectedUrl);




    }


}
