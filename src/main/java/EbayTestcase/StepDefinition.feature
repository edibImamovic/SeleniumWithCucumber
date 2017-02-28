Feature: Ebay page with eg phone selection

  Scenario: Search category on ebay and select product with valid price and country of origin
    Given Navigate to ebay page
    When I click on All Categories dropdown ,select product and I want to search for it
    And we validate that we are on a rigt page and click on link for Cell phone and smartphone
    And we select brand apple
    Then validate that we are on right tab
    When we are on apple page select by sorting higest price from first page
    When find selected price from given country
    Then validate that we are on right tab

