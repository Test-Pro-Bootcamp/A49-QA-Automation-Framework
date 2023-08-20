import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {
//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

    WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    String url = "https://qa.koel.app/";
        driver.get(url);


    WebElement loginInput = driver.findElement(By.cssSelector("[type='email']"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("natalia.gorbunova@testpro.io");

    WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("tester2023");

    WebElement loginBtn = driver.findElement(By.cssSelector("[type='submit']"));
        loginBtn.click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(),"00");
        driver.quit();


}