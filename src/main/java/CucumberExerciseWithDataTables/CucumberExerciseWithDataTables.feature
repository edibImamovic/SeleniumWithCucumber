Feature: Check the page title

  Scenario: Check page title for Vijesti
    Given I am on the Klix website
    When I navigate to "tch_vijesti"
    Then I check page is "Vijesti"

  Scenario: Check page title for Biznis
    Given I am on the Klix website
    When I navigate to "tch_biznis"
    Then I check page is "Biznis"

  Scenario: Check page title for Sport
    Given I am on the Klix website
    When I navigate to "tch_sport"
    Then I check page is "Sport"

  Scenario: Check page title for Magazin
    Given I am on the Klix website
    When I navigate to "tch_magazin"
    Then I check page is "Magazin"

  Scenario: Check page title for Lifestyle
    Given I am on the Klix website
    When I navigate to "tch_lifestyle"
    Then I check page is "Lifestyle"

  Scenario: Check page title for Scitech
    Given I am on the Klix website
    When I navigate to "tch_scitech"
    Then I check page is "Scitech"


  Scenario: Check page title for Auto
    Given I am on the Klix website
    When I navigate to "tch_auto"
    Then I check page is "Auto"

