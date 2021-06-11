Feature: Data Table Examples

  Background:
    Given user navigates to Action Page


  @Scenario1
  Scenario: Check 2 checkboxes
    When user clicks on checkboxes
      | Option 1 |
      | Option 2 |
    And user clicks on Result checkbox button
    Then message should be displayed "You selected value(s): Option 1, Option 2"

  @Scenario2
  Scenario: Check 3 checkboxes
    When user clicks on checkboxes
      | Option 1 |
      | Option 2 |
      | Option 3 |
    And user clicks on Result checkbox button
    Then message should be displayed "You selected value(s): Option 1, Option 2, Option 3"