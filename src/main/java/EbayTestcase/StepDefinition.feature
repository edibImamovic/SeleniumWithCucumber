Feature: Ebay stranica odabiranje mobitela

  Scenario: Search category on ebay and selecting lowest apple phone from Canada
    Given I want to go to ebay page
    When I click on All Categories dropdown ,select product and I want to search for it
    And we validate that we are on a rigt page and click on link for Cell phone and smartphone
    And we select brand apple
    Then validate that we are on right tab
    When we are on apple page select by sorting higest price from first page
    When find lowest price from Canada
    And select country

