@Feature
Feature: This is a feature to test Age Page functionality

  @scenario1
  Scenario: Check Age page functionality for Adult
    When user navigates to Age Page
    And User enter name "ABC"
    And User enter age 40
    And User clicks on submit button
    Then User see message "Hello, ABC, you are an adult"

    @scenario2 @regression
    Scenario: Check Age page functionality for kid
      When user navigates to Age Page
      And User enter name "ABC"
      And User enter age 5
      And User clicks on submit button
      Then User see message "Hello, ABC, you are a kid"

  @scenario3 @regression
  Scenario: Check Age page functionality for teenager
    When user navigates to Age Page
    And User enter name "ABC"
    And User enter age 15
    And User clicks on submit button
    Then User see message "Hello, ABC, you are a teenager"


