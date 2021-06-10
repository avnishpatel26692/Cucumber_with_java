Feature: This is a feature to test functionality


@scenario1
Scenario Outline: Check Age page functionality for Adult
When user navigates to Age Page
And User enter name "<name>"
And User enter age <age>
And user clicks on submit button
Then User see message "<message>"
Examples:
|name  | age |    message                        |
| ABC  | 40  |  Hello, ABC, you are an adult     |
| ABC  |  5  |  Hello, ABC, you are a kid        |
| ABC  |  16 |   Hello, ABC, you are a teenager  |
| ABC  |  16 |   Hello, ABC, you are a teenager   |