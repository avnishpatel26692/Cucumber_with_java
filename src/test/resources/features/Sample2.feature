@Feature1
Feature: This is feature to test Age page func.

  @scenario1
  Scenario: Check Age page functionality for Adult
    When user navigates to Age Page
    And User enter name "ABC"
    And User enter age 40
    And User clicks on submit button
    Then User see message "Hello, ABC, you are an adult"

  @scenario2 @Regression
  Scenario: Check Age page functionality for Adult
    When user navigates to Age Page
    And User enter name "ABC"
    And User enter age 5
    And User clicks on submit button
    Then User see message "Hello, ABC, you are a kid"

  @scenario3
  Scenario: Check Age page functionality for Adult
    When user navigates to Age Page
    And User enter name "ABC"
    And User enter age 16
    And User clicks on submit button
    Then User see message "Hello, ABC, you are a teenager"