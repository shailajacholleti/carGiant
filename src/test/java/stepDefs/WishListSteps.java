package stepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.*;

import java.io.IOException;

public class WishListSteps {
    public static WebDriver driver;
    public MyCarGiantHomepage myCarGiantHomepage;
    public LoginPage loginPage;
    public SearchPage searchPage;
    public SearchResultsPage searchResultsPage;
    public MyGaragePage myGaragePage;
    public WishListSteps(){
        driver = Hooks.driver;
        myCarGiantHomepage = new MyCarGiantHomepage(driver);
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        myGaragePage = new MyGaragePage(driver);
    }

    @Given("^User is on car giant homepage$")
    public void userIsOnCarGiantHomepage() throws IOException {
        myCarGiantHomepage.userIsOnCarGiantHomePage();
        myCarGiantHomepage.userVerifiesTheHomePageTitle();
    }
    @When("^User clicks on login button on homepage$")
    public void userClicksOnLoginButtonOnHomepage(){
        myCarGiantHomepage.userClicksOnLoginButton();
    }
    @And("^User login with username and password$")
    public void userLoginWithUsernameAndPassword() throws IOException {
        loginPage.userEntersTheLoginDetails();
    }
    @Then("^User verifies the title of the page as \"(.*)\"$")
    public void userVerifiesTheTitleOfTheLoginPage(String expected_title){
        loginPage.userVerifiesTheTitleOfTheLoginPage(expected_title);
    }
    @When("^User clicks on home button link$")
    public void userClicksOnHomeButtonLink(){
        loginPage.userClicksOnHomePageButton();
    }
    @And("^User search for first car \"(.*)\"$")
    public void userSearchForDifferentCars(String wishedCar1){
        searchPage.userClicksOnMakeDropDown();
        searchPage.userSelectsWishedCars(wishedCar1);
    }
    @And("^User search for second car \"(.*)\"$")
    public void userSearchForSecondCar(String wishedCar2){
        searchPage.userSelectsWishedCars(wishedCar2);
        searchPage.userClicksOnSearchButton();
    }
    @Then("^User verifies the Sort filter and select the result by \"(.*)\" from sort filter$")
    public void userVerifiesTheSortFilterAndSelectTheResultHighToLowFromSortFilter(String filter){
        searchResultsPage.userVerifiesTheSortFilter();
        searchResultsPage.userSelectsOptionFromSortBy(filter);
    }
    @When("^User adds \"(.*)\" into watch list$")
    public void userAddsWishedCarIntoWatchList(String wishedCar1){
        searchResultsPage.userAddsWishedCarIntoWatchList(wishedCar1);
    }
    @And("^User navigates to my watch list page by clicking on my garage link$")
    public void userNavigatesToMyWatchListPageByClickingOnMyGarage(){
        searchResultsPage.userNavigatesToWatchList();
    }
    @Then("^User verifies whether added \"(.*)\" is displaying in my watchlist or not$")
    public void userVerifiesWhetherAddedWishedCarIsDisplayingInMyWatchlistOrNot(String wishedCar){
        myGaragePage.userVerifiesAddedWishedCarInWatchList(wishedCar);
    }
    @When("^User removes the added cars from watchlist$")
    public void userRemovesTheAddedCarsFromWatchlist(){
        myGaragePage.userRemoveFirstCarFromWatchLit();
        myGaragePage.userRemovesSecondCarFromWatchList();
    }
    @Then("^User verifies whether the cars are removed successfully or not$")
    public void userVerifiesWhetherTheCarsAreRemovedSuccessfullyOrNot(){
        myGaragePage.userVerifiesCarIsRemovedFromTheWatchList();
    }
    @And("^User log out$")
    public void userLogOut(){
        myGaragePage.userLogOut();
    }
}
