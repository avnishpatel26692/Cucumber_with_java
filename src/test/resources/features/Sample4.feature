@Feature1
Feature: Click checkboxes

  @Sample4.1
  Scenario: Click two checkboxes
    Given User navigates to Actions page
    When User clicks on
    |Option 1|
    |Option 2|
    And User clicks result button
    Then User see result message "You selected value(s): Option 1, Option 2"

  @Sample4.2
  Scenario: Click three checkboxes
    Given User navigates to Actions page
    When User clicks on
      |Option 1|
      |Option 2|
    |Option 3|
    And User clicks result button
    Then User see result message "You selected value(s): Option 1, Option 2, Option 3"