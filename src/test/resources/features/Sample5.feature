Feature: Two Column Data Table

  @Scenario1
  Scenario: Check Age Page Functionality for Kid
    When user navigates to Age Page
    When user enters details
    |name|ABC|
    |age |5  |
    And User clicks on Submit button
    Then User see message "Hello, ABC, you are a kid"
