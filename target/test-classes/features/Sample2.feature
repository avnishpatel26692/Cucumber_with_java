@Feature1
Feature: This is a feature to test Age Page functionality

  @scenario1
  Scenario: Check Age page functionality for Adult
    When user navigates to Age Page
    And user enter name "ABC"
    And user enter age "40"
    And user clicks on submit button
    Then user see message "Hello, ABC, you are an adult"


    @scenario2 @Regression
    Scenario: Check Age page functionality for Kid
      When user navigates to Age Page
      And user enter name "ABC"
      And user enter age "5"
      And user clicks on submit button
      Then user see message "Hello, ABC, you are a kid"

      @scenario3 @Regression
      Scenario: Check Age page functionality for Teenager
        When user navigates to Age Page
        And user enter name "ABC"
        And user enter age "16"
        And user clicks on submit button
        Then user see message "Hello, ABC, you are a teenager"