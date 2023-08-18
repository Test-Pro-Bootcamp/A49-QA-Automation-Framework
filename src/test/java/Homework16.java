import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 {
    @Test
    public void registrationNavigation(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement registrationLink = driver.findElement(By.xpath("//a[contains(text(),'Registration')]"));
        registrationLink.click();

        WebElement registerMessage = driver.findElement(By.xpath("//h2[contains(text(),'Register new account')]"));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Assert.assertTrue(registerMessage.isDisplayed());
        driver.quit();
    }
}
