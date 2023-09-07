//package Pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.Assert;
//
//public class ProfilePage extends BasePage{
//    public ProfilePage(WebDriver driver) {
//        super(driver);
//    }
//
//    @FindBy (css ="button.btn-submit")
//    private WebElement saveBtn;
////    By clickSaveBtn = By.cssSelector("button.btn-submit");
//    public ProfilePage provideCurrentPassword (String password){
//        WebElement currentPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='current_password']")));
//        currentPassword.clear();
//        currentPassword.sendKeys(password);
//        return this;
//    }
//    public ProfilePage provideProfileName(String randomName) {
//        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
//        profileName.clear();
//        profileName.sendKeys(randomName);
//        return this;
//    }
//    //Click save Btn
//    public ProfilePage clickSaveBtn() {
//        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
//        return this;
//    }
//    public void verifyProfileUpdated() {
//        WebElement verifyChangeProfile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alertify-logs")));
//        Assert.assertEquals(verifyChangeProfile.getText(), "Profile updated.");
//    }
//}
