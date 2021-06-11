Feature: Two Column Data Table

  @Scenario1
  Scenario: Check Age Page Functionality for Kid
    Given user navigates to Age Page
    When user enters details
      | name| ABC|
      |age  | 5  |
    And User clicks on submit button
    Then User see message "Hello, ABC, you are a kid"

  @Scenario2
  Scenario Outline: Check Age Page Functionality for Kid
    Given user navigates to Age Page
    When user enters details
      | name| <name>|
      |age  | <age>  |
    And User clicks on submit button
    Then User see message "<message>"
    Examples:
      |name| age| message|
      |ABC | 29 | Hello, ABC, you are an adult  |
      |Iva | 16 | Hello, Iva, you are a teenager|
      |Jack| 5  | Hello, Jack, you are a kid    |

    @Scenario3
    Scenario: 3 Column Data table example
      Given I have the following order
      |vegetable|quantity| cost| Availability|
      |cucumber |4       | 10  | yes         |
      |carrot   |5       | 6   | no          |
      |potato   |6       | 4   | yes         |