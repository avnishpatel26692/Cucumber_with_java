@Feature1
Feature: This is a feature to test Age Page functionality

  Background:
    When user navigates to Age Page
  @scenario1
  Scenario: Check Age page functionality for adult
    And User enter name "ABC"
    And User enter age 40
    And user clicks on submit button
    Then User see message "Hello, ABC, you are an adult"

  @scenario2 @Regression
  Scenario: Check Age page functionality for kid
    And User enter name "ABC"
    And User enter age 5
    And user clicks on submit button
    Then User see message "Hello, ABC, you are a kid"

  @scenario3 @Regression
  Scenario: Check Age page functionality for teenager
    And User enter name "ABC"
    And User enter age 16
    And user clicks on submit button
    Then User see message "Hello, ABC, you are a teenager"