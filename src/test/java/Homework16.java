
public class Homework16 extends BaseTest {
    @Test
    public void registrationNavigation() {
//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement registrationlink = driver.findElement(By.cssSelector("[href='registration']" +));
        registrationlink.click();

        String registrationUrl = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentURl(), registrationUrl);
        driver.quit();
    }}
}
