@Feature1
Feature: Check Age page functionality
  Background:
    When User navigates to Age page

@Sample2.1
Scenario: Check Age page functionality for Adult
  And User enter name "ABC"
  And User enter age "40"
  And User clicks on submit button
Then User see message "Hello, ABC, you are an adult"

  @Sample2.2 @Regression
  Scenario: Check Age page functionality for Kid
    And User enter name "ABC"
    And User enter age "1"
    And User clicks on submit button
    Then User see message "Hello, ABC, you are a kid"

  @Sample2.2
  Scenario: Check Age page functionality for Teenager
    And User enter name "ABC"
    And User enter age "16"
    And User clicks on submit button
    Then User see message "Hello, ABC, you are a teenager"