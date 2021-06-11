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

  @Sample5.2
  Scenario Outline: Check Age page functionality
    When User navigates to Age page
    And User enter name and age
      |name|<name>|
      |age |<age>  |
    And User clicks on submit button
    Then User see message "<message>"
    Examples:
    |name|age|message|
    |ABC |5  |Hello, ABC, you are a kid|
    |ABC |16 |Hello, ABC, you are a teenager|
    |ABC |40 |Hello, ABC, you are an adult  |

