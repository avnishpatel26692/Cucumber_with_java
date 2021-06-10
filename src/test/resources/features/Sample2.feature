
Feature: This is a feature to test Age Page functionality


  @scenario1
  Scenario: Check Age page functionality for Adult
    When user navigates to Age Page
    And User enter name : "ABC"
    And User enter age 40
    And User clicks on submit button
    Then User see message "Hello, ABC, you are an adult"




  @scenario2 @Regression
  Scenario: Check Age page functionality for Kid
    When user navigates to Age Page
    And User enter name : "ABC"
    And User enter age 5
    And User clicks on submit button
    Then User see message "Hello, ABC, you are a kid"

  @scenario3 @Regression
  Scenario: Check Age page functionality for Teenager
    When user navigates to Age Page
    And User enter name : "ABC"
    And User enter age 16
    And User clicks on submit button
    Then User see message "Hello, ABC, you are a teenager"

    @scenario4
    Scenario: Check search
      When  user navigates to kinozal
      And user enters a name field "Saw"
      And User submits
      Then user checks results