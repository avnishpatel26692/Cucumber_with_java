Feature: Two Column Data Table

  // ja ir 2 kolonnas, tad izmanto Map
  // ja ir 3 un vairāk kolonnas, tad izmanto DataTable

  @Scenario1
  Scenario: Check Age Page Functionality for Kid
    When user navigates to Age Page
    When user enters details
      | name | ABC |
      | age  | 5   |
    And User clicks on Submit button
    Then User see message "Hello, ABC, you are a kid"

  @Scenario2
  Scenario Outline: Check Age Page Functionality for Kid
    When user navigates to Age Page
    When user enters details
      | name | <name> |
      | age  | <age>  |
    And User clicks on Submit button
    Then User see message "<message>"
    Examples:
      | name | age | message                        |
      | ABC  | 29  | Hello, ABC, you are an adult   |
      | Eva  | 16  | Hello, Eva, you are a teenager |
      | John | 5   | Hello, John, you are a kid     |

  @Scenario3
  Scenario: 3 column data table
    Given I have the following order
      | vegetable | quantity | cost | availability |
      | cucumber  | 4        | 10   | yes          |
      | carrot    | 5        | 6    | no           |
      | potato    | 6        | 4    | yes          |
















