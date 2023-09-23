import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class New16 extends BaseTest {
 public WebDriver driver = "null";

 @Test
 public void registrationNavigation() {
//added chromeOptions argument to fix websocket error
  ChromeOptions = new ChromeOptions();
  options.addArguments("--remote-allow-orgins=*");


  WebDriver driver = new ChromeDriver(options);
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

  String url = "https://qa.koel.app/";
  driver.get(url);

  WebElement registrationLink = driver.findElement(By.CssSelector("[href ='registrationLink']"));
  registrationLink.click();

  String registrationUrl = "https://qa.koel.app/registration";
  Assert.assertEquals(driver.getCurrentUrl(), registrationLink);

  @AfterMethod
          driver.quit();
 }
}
