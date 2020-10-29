package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.Base;
import utils.Helpers;

import java.io.IOException;

public class MyCarGiantHomepage extends Base {

    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Log in')]")
    public static WebElement loginButton;

    private static Helpers helpers;
    public MyCarGiantHomepage(WebDriver driver){
       super(driver);
        helpers = new Helpers(driver);
    }

    public void userIsOnCarGiantHomePage() throws IOException {
        driver.get(Base.getUrl());
    }
    public void userVerifiesTheHomePageTitle(){
        helpers.waitForSecs(2);
        String actual_title = driver.getTitle();
        System.out.println("ActualTitle is ==========="+ actual_title);
        String expected_title = "Cargiant - London's Largest Car Dealership";
        Assert.assertTrue(expected_title.contains(actual_title));
    }
    public void userClicksOnLoginButton(){
        helpers.waitForSecs(2);
        loginButton.click();
    }

}
