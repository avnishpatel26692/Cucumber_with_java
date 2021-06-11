@Feature1
Feature: Check Age page functionality

  @Sample5.1
  Scenario: Check Age page functionality for a kid
    When User navigates to Age page
    And User enter name and age
    |name|ABC|
    |age |5  |
    And User clicks on submit button
    Then User see message "Hello, ABC, you are a kid"