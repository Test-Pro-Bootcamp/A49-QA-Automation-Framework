package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    //Navigate to and login with valid credentials
    public static void logInWithRightCredentials(){
        navigateToPage();
        provideEmail();
        providePassword();
        clickSubmit();
    }
    //navigate to URL
    public static void navigateToPage() {
        driver.get("https://qa.koel.app/");
    }
    //enter a Valid Email
    public static void provideEmail() {
        WebElement loginInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']")));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("xu_moua@hotmail.com");

    }
    //enter a Valid Password
    public static void providePassword() {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("TestStudent!1");

    }
    //click on Submit Button
    public static void clickSubmit() {
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        loginBtn.click();
    }
}
