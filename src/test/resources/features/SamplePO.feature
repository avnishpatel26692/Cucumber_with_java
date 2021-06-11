@Feature1
Feature: Check Age page functionality

  @SamplePO.1
  Scenario Outline: Check Age page functionality
    When User navigates to Age page using PO
    And User enter name and age using PO
      |name|<name>|
      |age |<age>  |
    And User clicks on submit button using PO
    Then User see message using PO "<message>"
    Examples:
      |name|age|message|
      |ABC |5  |Hello, ABC, you are a kid|
      |ABC |16 |Hello, ABC, you are a teenager|
      |ABC |40 |Hello, ABC, you are an adult  |

