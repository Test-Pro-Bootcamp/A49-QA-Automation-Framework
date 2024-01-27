package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }
    public void loginCorrectCred() {
        provideEmail("dagebeyehu@gmail.com");
        providePassword("yozca5uQiLxb!");
        clickSubmit();
    }
    public void navigateToPage(String url) {
        driver.get(url);
    }

    public void provideEmail(String email) {
        enterText(By.cssSelector("input[type='email']"),email);
    }

    public void providePassword(String password) {
        enterText(By.cssSelector("input[type='password']"),password);
    }

    public void clickSubmit() {
        clickOnElement(By.cssSelector("[type='submit']"));
    }

}

