package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.Base;
import utils.Helpers;

import java.io.IOException;

public class LoginPage extends Base {

    @FindBy(how = How.ID, using = "PartialLogin_Username")
    public static WebElement userName;
    @FindBy(how = How.ID, using = "PartialLogin_Password")
    public static WebElement passWord;
    @FindBy(how = How.XPATH, using = "//input[@value='Sign in']")
    public static WebElement signInButton;
    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Home')]")
    public static WebElement homePageLink;
    public LoginPage(WebDriver driver){
        super(driver);
        helpers = new Helpers(driver);
    }
    private Helpers helpers;

    public void userEntersTheLoginDetails() throws IOException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,240 )");
        userName.sendKeys(getUserName());
        passWord.sendKeys(getPassword());
        helpers.waitForSecs(5);
        signInButton.click();
    }
    public void userVerifiesTheTitleOfTheLoginPage(String expected_title){
        helpers.waitForSecs(2);
        String actual_title =driver.getTitle();
        System.out.println("Actual Title ============"+ actual_title);
        Assert.assertTrue(actual_title.contains(expected_title));
    }
    public void userClicksOnHomePageButton(){
        homePageLink.click();
    }
}
