@Feature1
Feature: This is a feature to test Age Page functionality

  @scenario1
  Scenario: Check Age page functionality for Adult
    When user navigates to Age Page
    And User enter name "ABC"
    And User enter age 40
    And User clicks on submit button
    Then User see message "Hello, ABC, you are an adult"

  @scenario2
  Scenario: Check Age page functionality for Kid
    When user navigates to Age Page
    And User enter name "ABC"
    And User enter age 5
    And User clicks on submit button
    Then User see message "Hello, ABC, you are a kid"
    
    @scenario3
    Scenario: Check Age page functionality for Teenager
      When user navigates to Age Page
      And User enter name "ABC"
      And User enter age 15
      And User clicks on submit button
      And User see message "Hello, ABC, you are a teenager"