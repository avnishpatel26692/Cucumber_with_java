@Feature1
Feature: Check Age page functionality

  @Sample3.1
  Scenario Outline: Check Age page functionality for Adult
    When User navigates to Age page
    And User enter name "<name>"
    And User enter age "<age>"
    And User clicks on submit button
    Then User see message "<message>"
    @Examples1
    Examples:
    |name|age|message|
    |ABC|40|Hello, ABC, you are an adult|
    |ABC|16|Hello, ABC, you are a teenager |

    @Examples2
    Examples:
      |name|age|message|
      |ABC|1 |Hello, ABC, you are a kid    |
