Feature: Two Column Data Table

  @Scenario1
  Scenario:
    Given user navigates to Age Page
    When user inputs details
      |name|ABC|
      |age |5  |
    And User clicks on submit button
    Then User see message "Hello, ABC, you are a kid"

  @Scenario2
  Scenario Outline: Check Age Page Functionality For All
    Given user navigates to Age Page
    When user inputs details
    |name|<name>|
    |age |<age> |
    And User clicks on submit button
    Then User see message "<message>"
    Examples:
    |name |age|message                       |
    |Jack |40 |Hello, Jack, you are an adult |
    |Iva  |16 |Hello, Iva, you are a teenager|
    |ABC  |5  |Hello, ABC, you are a kid     |

  @Scenario3
  Scenario: 3 Or More Column Data Table Example
    Given i have the following order
    |vegetable|quantity|cost|availability|
    |cucumber |4       |10  |yes         |
    |carrot   |4       |6   |yes         |
    |potato   | 6      |4   |yes         |