import org.testng.annotations.Test;
public class Homework16 extends BaseTest {

    @Test
    public void Navigation() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicityWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement registrationlink = driver.findElement(By.cssSelector("[id='hel']"));
        registrationlink.click();

        String registrationUrl = "https://bbb.testpro.io/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);

        driver.quit();
    }
}