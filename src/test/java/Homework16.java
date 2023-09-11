import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Homework16 extends BaseTest {
    @Test
    public  void registrationNavigation() {
//Adding chromeOptions arguments below to fix websocket

        chromeOptions options = new chromeOptions();
        options.addArguments("--remote-allow-origins");
        options.addArguments("---starts maximize");


        webDriver driver = new webDriver(options);
        driver.manager().timeout().implicitelyWait(duration.ofseconds(10));
    }

    //WHEN: user opens url
    String url = "https://qa.koel.app/";
    driver.get(url);

    //AND: user searches element
    webElement registrationLink = driver.findElement(By.cssSelector("[href = 'registration']"));
    registrationLink.click;

//THEN: Koel app should redirect
    String.registrationurl ="https://qa.koel.app/registration";
    Assert.assertEquals(driver.getcurrenturl(),registration);

    @AfterMethod
            driver.quit();

}
}