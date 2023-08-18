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
    public void registrationNavigation() {

        //GIVEN I have set and opened the browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //WHEN I open my url
        String url = "https://qa.koel.app/";
        driver.get(url);

        //AND I click on Registration/Forgot password
        WebElement registrationLink = driver.findElement(By.cssSelector("[href='registration']"));
        registrationLink.click();

        //THEN I am redirected to registration page
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/registration");
        driver.quit();

    }
}
