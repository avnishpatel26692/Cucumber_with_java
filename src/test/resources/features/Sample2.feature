@Feature1
Feature: This is a feature to test Age Page functionality

  @Scenario1
  Scenario: check Age page functionality for Adult
    When user navigates to Age Page
    And User enter name "ABC"
    And User enter age 40
    And User clicks on Submit button
    Then User see message "Hello, ABC, you are an adult"

  @Scenario2 @Regression
  Scenario: check Age page functionality for Kid
    When user navigates to Age Page
    And User enter name "ABC"
    And User enter age 5
    And User clicks on Submit button
    Then User see message "Hello, ABC, you are a kid"

  @Scenario1 @Regression
  Scenario: check Age page functionality for Kid
    When user navigates to Age Page
    And User enter name "ABC"
    And User enter age 16
    And User clicks on Submit button
    Then User see message "Hello, ABC, you are a teenager"