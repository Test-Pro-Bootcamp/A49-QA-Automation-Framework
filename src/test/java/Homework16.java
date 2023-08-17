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
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver theDriver = new ChromeDriver(options);
        theDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://qa.koel.app/";
        theDriver.get(url);

        WebElement registrationButton = theDriver.findElement(By.cssSelector("a[href='registration']"));
        registrationButton.click();

        String expectedUrl = "https://qa.koel.app/registration";
        String actualUrl = theDriver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);

        theDriver.quit();


    }


}
