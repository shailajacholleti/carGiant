package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.Base;
import utils.Helpers;

public class SearchResultsPage extends Base {

    public static Helpers helpers;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        helpers = new Helpers(driver);
    }

    @FindBy(how = How.XPATH, using = "//a[@title='Price (low to high)']")
    public static WebElement sortByFilter;

    @FindBy(how = How.XPATH,using = "//section[1]/header//a[text()='My Garage']")
    public WebElement myGarageLink;

    public void userVerifiesTheSortFilter() {
        Assert.assertTrue(sortByFilter.isDisplayed());
    }

    public void userSelectsOptionFromSortBy(String option) {
        sortByFilter.click();
        WebElement sortBy = driver.findElement(By.xpath("//a[contains(text(), 'Price (" + option + ")')]"));
        sortBy.click();
        helpers.waitForSecs(5);
        driver.findElement(By.xpath("//a[@class='list-view open']")).click();
        helpers.waitForSecs(5);
        Assert.assertTrue(driver.findElement(By.xpath("//section[@class='search-results__header']//a[@class='value'][contains(text(),'Price (" + option + ")')]")).isDisplayed());
    }
    public void userAddsWishedCarIntoWatchList(String wishedCar) {
        String beforeXpath = "//*[@id='vehicle-results-panel']/ul/li[";
        String afterXpath = "]//h3/a";
        for (int i = 1; i <= 27; i++) {
            String carModel = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
            System.out.println("value of i: " + i);
            System.out.println(carModel);
            if (carModel.contains(wishedCar)) {
                helpers.waitForSecs(5);
                WebElement watchlist = driver.findElement(By.xpath("//*[@id='vehicle-results-panel']/ul/li[" + i + "]//div[1]/div/a[1][@data-action='Add to Watchlist']"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView()", watchlist);
                JavascriptExecutor js1 = (JavascriptExecutor) driver;
                js1.executeScript("window.scrollBy(0,240)");
                js1.executeScript("arguments[0].click();", watchlist);
                break;
            }
        }
    }
    public void userNavigatesToWatchList(){
        helpers.waitForSecs(5);
        myGarageLink.click();
    }

}
