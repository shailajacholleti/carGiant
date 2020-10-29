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

public class MyGaragePage extends Base {

    public static Helpers helpers;
    public static SearchResultsPage searchResultsPage;
    public MyGaragePage(WebDriver driver){
        super(driver);
        helpers = new Helpers(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }
    @FindBy(how = How.XPATH, using = "//*[@id='slick-slide00']//span[text()='Remove from watchlist']")
    public static WebElement firstRemoveButton;

    @FindBy(how = How.XPATH, using = "//*[@id='whatchlist_slider']//div[1]//a/span")
    public static WebElement secondRemoveButton;

    @FindBy(how = How.XPATH,using = "//button[@class='logout-button']")
    public WebElement logoutButton;


    public void userVerifiesAddedWishedCarInWatchList(String wishedCar){
        helpers.waitForSecs(3);
        String beforeXpath = "//*[@id='slick-slide0";
        String afterXpath = "']/div[2]/h3";
        for(int i=0 ;i<=1;i++){
            String carTitle = driver.findElement(By.xpath(beforeXpath+ i + afterXpath)).getText();
            System.out.println();
            if(carTitle.contains(wishedCar)){
                Assert.assertTrue(carTitle.contains(wishedCar));
            }else{
                WebElement nextButton = driver.findElement(By.xpath("//span[@class='watch-next slick-arrow']"));
                JavascriptExecutor js = (JavascriptExecutor)driver;
                JavascriptExecutor js1 = (JavascriptExecutor)driver;
                js1.executeScript("window.scrollBy(0,240)");
                js.executeScript("arguments[0].click();", nextButton);
            }
        }
    }
    public void userRemoveFirstCarFromWatchLit(){
        searchResultsPage.userNavigatesToWatchList();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,240)");
        firstRemoveButton.click();
    }
    public void userRemovesSecondCarFromWatchList(){
        searchResultsPage.userNavigatesToWatchList();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,240)");
        secondRemoveButton.click();
    }
    public boolean userVerifiesCarIsRemovedFromTheWatchList(){
        try {
            driver.findElement(By.xpath("//*[@id='slick-slide00']//span[text()='Remove from watchlist']"));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public void userLogOut(){
        helpers.waitForSecs(2);
        logoutButton.click();
    }
}
