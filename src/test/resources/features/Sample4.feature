Feature: Data Table Examples

  @Scenario1
  Scenario: Check 2 checkbxes
    Given user navigates to action page
    When user clicks on checkboxes
    |Option 1|
    |Option 2|
    And user clicked on result checkbox button
    Then message should be displayed "You selected value(s): Option 1, Option 2"

    @Scenario2
  Scenario: Check 3 checkbxes
    Given user navigates to action page
    When user clicks on checkboxes
      |Option 1|
      |Option 2|
      |Option 3|
    And user clicked on result checkbox button
    Then message should be displayed "You selected value(s): Option 1, Option 2, Option 3"