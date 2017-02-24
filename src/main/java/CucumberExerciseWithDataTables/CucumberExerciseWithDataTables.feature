Feature: Check the page title


  Background:
    Given I am on the Klix website


  @Vijesti
  Scenario: Check page title for Vijesti
    When I navigate to "tch_vijesti"
    Then I check page is "Vijesti"

  @Biznis
  Scenario: Check page title for Biznis
    When I navigate to "tch_biznis"
    Then I check page is "Biznis"

  Scenario: Check page title for Sport
    When I navigate to "tch_sport"
    Then I check page is "Sport"

  Scenario: Check page title for Magazin
    When I navigate to "tch_magazin"
    Then I check page is "Magazin"

  Scenario: Check page title for Lifestyle
    When I navigate to "tch_lifestyle"
    Then I check page is "Lifestyle"

  Scenario: Check page title for Scitech
    When I navigate to "tch_scitech"
    Then I check page is "Scitech"

  Scenario: Check page title for Auto
    When I navigate to "tch_auto"
    Then I check page is "Auto"

