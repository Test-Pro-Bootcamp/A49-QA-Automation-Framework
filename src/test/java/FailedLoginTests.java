import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;

public class FailedLoginTests extends BaseTest {
    LoginPage loginPage;
    @BeforeSuite
    public void setup(){
        loginPage = new LoginPage(driver);
        driver.get(url);
    }


    @Test
    public void invalidPasswordEmail() {
        loginPage.castEmail("spellFail").castPassword("notEnoughmana").castSubmit();
    }
    @Test
    public void emptyEmail(){
        loginPage.castEmail("").castPassword("Te$ter1234").castSubmit();
    }




        /*@Test (enabled = false)
        public void loginInvalidEmailValidPassword () {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            WebDriver driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = "https://qa.koel.app/";
            driver.get(url);

            WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
            emailField.clear();
            emailField.sendKeys("invalid@gmail.com");

            WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
            passwordField.clear();
            passwordField.sendKeys("Te$ter1234");

            WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
            submit.click();

            Assert.assertEquals(driver.getCurrentUrl(), url);

            driver.quit();
        }


    @Test (enabled = false)
    public void loginValidEmailInvalidPassword () {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("dirzo@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("Te$ter");

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

        Assert.assertEquals(driver.getCurrentUrl(), url);

        driver.quit();*/
}

