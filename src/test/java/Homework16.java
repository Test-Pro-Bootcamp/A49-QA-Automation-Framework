import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework16 extends BaseTest {
    @Test
    public void registrationNavigation(){
//Adding chromeOptions arguments below to fix websocket

        chromeOptions options = new chromeOptions();
        options.addArguments("--remote-allow-origins");
        //GIVEN: url is set and opened with valid credentials
        webdriver driver= new webdriver(options);
        driver.manager().timeout().implicitelyWait(duration.ofseconds(10));
    }
    //WHEN: user opens url
    String url = "https://qa.koel.app/";
    driver.get(url);
    //AND: user searches element
    webElement registrationLink = driver.findElement(By.cssSelector("[href = 'registration']"));
    registrationLink.click;

//THEN: Koel app should redirect
    String.registrationurl = "https://qa.koel.app/registration";
    Assert.assertEquals(driver.getcurrenturl(), registration);
 driver.quit();


