Feature: This is a feature to test Age Page functionality

  @Sample2
  Scenario: Check Age page functionality for Adult
    When user navigates to Age Page
    And User enter name "ABC"
    And User enter age 40
    And User clicks on submit button
    Then User see message "Hello, ABC, you are an adult"