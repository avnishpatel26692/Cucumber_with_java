Feature: Two Column Data table

  @Scenario1
  Scenario: Check Age Page Functionality for Kid
    Given user navigates to Age Page
    When User enters details
    |name|ABC|
    |age |5  |
    And User clicks on submit button
    Then User see message "Hello, ABC, you are a kid"

    @Scenario2
    Scenario Outline: Check Age Page Functionality for Kid
      Given user navigates to Age Page
      When User enters details
        |name|<name>|
        |age |<age> |
      And User clicks on submit button
      Then User see message "<message>"
      Examples:
      |name|age|message|
      |Kris|29  |Hello, Kris, you are an adult |
      |Eve |5   |Hello, Eve, you are a kid     |
      |Bob |16  |Hello, Bob, you are a teenager|

      @Scenario3
      Scenario: 3 or more Column Data table example
        Given I have the following order
          |Vegetable |Quantity  |Cost   |Availability|
          |tomato    |5         | 34    |yes         |
          |kale      |7         | 12    |yes         |
          |carrots   |13        | 5     |yes         |
          |cucumber  |27        | 6.90  |no          |

