Feature: Car Giant Test

  @carGiant
  Scenario Outline: User to verify whether the wish list is getting added and deleted successfully or not
    Given User is on car giant homepage
    When  User clicks on login button on homepage
    And   User login with username and password
    Then  User verifies the title of the page as "<Page Title>"
    When  User clicks on home button link
    And   User search for first car "<Wished Car1>"
    And   User search for second car "<Wished Car2>"
    Then  User verifies the Sort filter and select the result by "high to low" from sort filter
    And   User adds "<Wished Car1>" into watch list
    And   User adds "<Wished Car2>" into watch list
    When  User navigates to my watch list page by clicking on my garage link
    Then  User verifies whether added "<Wished Car1>" is displaying in my watchlist or not
    And   User verifies whether added "<Wished Car2>" is displaying in my watchlist or not
    When  User removes the added cars from watchlist
    Then  User verifies whether the cars are removed successfully or not
    And   User log out
    Examples:
      | Page Title           | Wished Car1 | Wished Car2 |
      | My Garage - Cargiant | Audi        | BMW         |




