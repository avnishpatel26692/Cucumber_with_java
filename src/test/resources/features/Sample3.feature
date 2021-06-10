@Feature1
Feature: This is a feature to test Age Page functionality

  //scenario outline - scenārija paraugs, ko izpilda ar parametriem, kas zemāk

  @Scenario1
  Scenario Outline: check Age page functionality for Adult
    When user navigates to Age Page
    And User enter name "<name>"
    And User enter age <age>
    And User clicks on Submit button
    Then User see message "<message>"

    @Working
    Examples:
    |name|age|message|
    |ABC |40 |Hello, ABC, you are an adult  |
    |ABC |5  |Hello, ABC, you are a kid     |
    |ABC |16 |Hello, ABC, you are a teenager|

    @NotWorking
    Examples:
      |name|age|message|
      |ABC |40 |Hello, ABC, you are an adult  |
      |ABC |0  |Hello, ABC, you are a kid     |
      |ABC |150 |Hello, ABC, you are an immortal|