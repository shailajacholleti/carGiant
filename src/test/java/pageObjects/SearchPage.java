package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.Base;
import utils.Helpers;

public class SearchPage extends Base {
    public SearchPage(WebDriver driver){
        super(driver);
        helpers = new Helpers(driver);
    }
    public static Helpers helpers;

    @FindBy (how = How.XPATH, using = "//a[contains(text(), 'Make')]")
    public static WebElement makeDropDown;

    @FindBy (how = How.XPATH, using = "//div[@class='list show']//a[@data-value='audi']")
    public static WebElement audiCheckbox;

    @FindBy(how = How.XPATH,using = "//button[contains(text(), 'SEARCH')]")
    public WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//div//h1[contains(text(), 'Used Audi for Sale in London')]")
    public WebElement title;

    @FindBy(how = How.XPATH, using = "//a[@data-value='bmw']")
    public static WebElement bmwCheckbox;

    public void userClicksOnMakeDropDown(){
        helpers.waitForSecs(2);
        makeDropDown.click();
        helpers.waitForSecs(3);
    }
    public void userSelectsWishedCars(String car1){
        if (car1.equals("Audi")) {
            audiCheckbox.click();
            helpers.waitForSecs(5);
            System.out.println("*********** Audi Checkbox is Clicked");
        }else {
            bmwCheckbox.click();
            helpers.waitForSecs(5);
            System.out.println("************ BMW Checkbox is clicked");
        }
    }
    public void userClicksOnSearchButton(){
        searchButton.click();
    }
    public void userVerifiesTheTitleOnThePage(String expected_title){
        helpers.waitForSecs(3);
        String actual_title =title.getText();
        Assert.assertTrue(actual_title.contains(expected_title));
    }
}
