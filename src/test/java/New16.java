import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class New16 extends BaseTest {
 public webDriver driver = "null";

 @Test
 public void registrationNavigation() {
//added chromeOptions argument to fix websocket error
  chromeOptions = new chromeOptions();
  options.addArguments("--remote-allow-orgins=*");


  webDriver driver = new chromeDriver(options);
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

  String url = "https://qa.koel.app/";
  driver.get(url);

  webElement registrationLink = driver.findElement(By.CssSelector("[href ='registrationLink']"));
  registrationLink.click();

  String registrationUrl = "https://qa.koel.app/registration";
  Assert.assertEquals(driver.getCurrentUrl(), registrationLink);

  @AfterMethod
          driver.quit();
 }
}
