package pages;

public class BasePage {
    WebDriver driver;

    WebDriverWait wait;

    Actions actions;

    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    public void WebElement;

    findElement (By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator) {
        findElement(locator).click();
    }

    public void doubleClick(By locator) {
        actions.doubleClick(findElement(locator)).perform();

    }
}

