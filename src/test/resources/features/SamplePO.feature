@Feature1
Feature: This is a feature to test Age Page functionality


  @Scenario1
  Scenario: check Age page functionality for Adult
    When I am on Age Page using PO
    And I enter name "ABC" using PO
    And I enter age 40 using PO
    And I click on Submit button using PO
    Then I see message "Hello, ABC, you are an adult" using PO