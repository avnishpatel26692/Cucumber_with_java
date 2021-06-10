@Feature2
Feature: This is a feature to test Age Page functionality

  @scenario1
  Scenario Outline: Check Age page functionality for Adult
    When user navigates to Age Page
    And user enter name "<name>"
    And user enter age "<age>"
    And user clicks on submit button
    Then user see message "<message>"
    @Working
    Examples:
    | name | age | message                        |
    | ABC  | 40  | Hello, ABC, you are an adult   |
    | ABC  | 5   | Hello, ABC, you are a kid      |
    | ABC  | 16  | Hello, ABC, you are a teenager |

    @Working2
    Examples:
    | name | age | message |
    | ABC  | 16  | Hello, ABC, you are a teenager |

    @Working3
    Examples:
      | name | age | message                        |
      | ABC  | 16  | Hello, ABC, you are an adult   |
